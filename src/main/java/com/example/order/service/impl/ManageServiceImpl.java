package com.example.order.service.impl;

import com.example.order.entity.GSysEvaluate;
import com.example.order.entity.GSysOrder;
import com.example.order.entity.GSysOrderProgress;
import com.example.order.exception.AddUserException;
import com.example.order.mapper.GSysEvaluateMapper;
import com.example.order.mapper.GSysManageMapper;
import com.example.order.mapper.GSysOrderMapper;
import com.example.order.mapper.GSysOrderProgressMapper;
import com.example.order.service.ManageService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.order.entity.GSysManage;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ManageServiceImpl implements ManageService {

    protected static final Logger logger = LoggerFactory.getLogger(ManageServiceImpl.class);

    @Autowired
    private GSysManageMapper  gSysManageMapper;

    @Autowired
    private GSysOrderMapper gSysOrderMapper;

    @Autowired
    private GSysEvaluateMapper gSysEvaluateMapper;

    @Autowired
    private GSysOrderProgressMapper gSysOrderProgressMapper;

    @Override
    public GSysManage getInfo(@Param("objId")Long objId,@Param("type")String type) {
        GSysManage gSysManage = null;
        try {
            gSysManage = gSysManageMapper.getInfo(objId, type);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return gSysManage;
    }

    @Override
    public List<GSysManage> getList(@Param("type")String type,@Param("searchContent")String searchContent) {
        return gSysManageMapper.getList(type,searchContent);

    }

    @Override
    public void addInfo(GSysManage gSysManage) throws AddUserException {
        try {
            gSysManageMapper.insertSelective(gSysManage);
        } catch (Exception e) {
            logger.error("新增失败!");
            throw new AddUserException("新增失败");
        }
    }

    @Override
    public void updateList(GSysManage gSysManage) {
        try {
            gSysManageMapper.updateByPrimaryKeySelective(gSysManage);
        } catch (Exception e) {
            logger.error("修改失败!");
            throw new AddUserException("修改失败");
        }
    }


    @Override
    public void doDelete(String objId) {
        try {
            gSysManageMapper.updateIsdelByOId(objId);
        } catch (Exception e) {
            logger.error("修改失败!");
            throw new AddUserException("修改失败");
        }
    }

    @Override
    public List<GSysManage> getManageList(String type, String tableId,String searchContent) {
        return gSysManageMapper.getManageList(type,tableId,searchContent);
    }

    @Override
    public GSysManage getManageInfo(Long objId, String type) {
        GSysManage gSysManage = null;
        try {
            gSysManage = gSysManageMapper.getManageByTypeAndObjId(objId, type);
            Long readNum = gSysManage.getReadnum();
            gSysManage.setReadnum(readNum + 1);
            gSysManageMapper.updateByPrimaryKeySelective(gSysManage);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return gSysManage;
    }

    @Override
    public boolean reviewById(Long objId,String exaId,String remark) {
        try {
            GSysManage gSysManage = gSysManageMapper.selectByPrimaryKey(objId);

            gSysManage.setExamineStatus(exaId);
            gSysManage.setRemark(remark);
            gSysManageMapper.updateByPrimaryKeySelective(gSysManage);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
        return true;
    }
    @Override
    public boolean releaseById(Long objId) {
        try {
            GSysManage gSysManage = gSysManageMapper.selectByPrimaryKey(objId);
            Date date = new Date();
            gSysManage.setReleasetime(date);
            gSysManage.setReleaseStatus("1");
            gSysManageMapper.updateByPrimaryKeySelective(gSysManage);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<Map<String, Object>> getTableList() {
        return gSysManageMapper.getTableList("news");
    }

    @Override
    public List<Map<String, Object>> getFailTypeList() {
        return gSysManageMapper.getTableList("failType");
    }

    @Override
    public List<Map<String, Object>> getUnitList() {
        return gSysManageMapper.getUnitList();
    }

    @Override
    public void addOrder(GSysOrder gSysOrder) {
        try {
            //上报维修订单,生成订单表数据
            gSysOrderMapper.insertSelective(gSysOrder);
            //生成订单进度表记录
            GSysOrderProgress gSysOrderProgress = new GSysOrderProgress();
            gSysOrderProgress.setOrderId(gSysOrder.getOrderId());
            gSysOrderProgress.setStatus("01");
            gSysOrderProgress.setCreatTime(new Date());
            gSysOrderProgressMapper.insertSelective(gSysOrderProgress);
            //todo 判断是否开启上报订单后自动发短信功能

        } catch (Exception e) {
            logger.error("故障上报失败{}",e.getMessage());
            //手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw new RuntimeException("故障上报失败");
        }
    }

    @Override
    public List<Map<String,Object>> getOrderListForOwner(String openId) {
        return gSysOrderMapper.getOrderListForOwner(openId);
    }

    @Override
    public void orderEvaluate(GSysEvaluate gSysEvaluate) {
        try {
            //查询该笔订单信息
            GSysOrder gSysOrder = gSysOrderMapper.selectByPrimaryKey(gSysEvaluate.getOrderId());
            //评价订单
            gSysEvaluateMapper.insertSelective(gSysEvaluate);
            //评价订单后把该订单状态置为已完成
            gSysOrder.setOrderStatus("04");
            gSysOrderMapper.updateByPrimaryKeySelective(gSysOrder);
            //生成订单进度表记录
            GSysOrderProgress gSysOrderProgress = new GSysOrderProgress();
            gSysOrderProgress.setOrderId(gSysOrder.getOrderId());
            gSysOrderProgress.setStatus("04");
            gSysOrderProgress.setCreatTime(new Date());
            gSysOrderProgressMapper.insertSelective(gSysOrderProgress);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException("订单评价失败");
        }
    }

    @Override
    public void reportAgain(Long orderId) {
        try {
            //查询该笔订单信息
            GSysOrder gSysOrder = gSysOrderMapper.selectByPrimaryKey(orderId);
            //把该笔订单状态置为待维修
            gSysOrder.setOrderStatus("02");
            gSysOrderMapper.updateByPrimaryKeySelective(gSysOrder);
            //生成订单进度表记录
            GSysOrderProgress gSysOrderProgress = new GSysOrderProgress();
            gSysOrderProgress.setOrderId(orderId);
            gSysOrderProgress.setStatus("02");
            gSysOrderProgress.setCreatTime(new Date());
            gSysOrderProgressMapper.insertSelective(gSysOrderProgress);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException("订单重新上报失败");
        }
    }

    @Override
    public List<Map<String, Object>> getOrderProgress(Long orderId) {
        return gSysOrderProgressMapper.getOrderProgress(orderId);
    }

    @Override
    public List<Map<String, Object>> getOrderListForManager(String managerId) {
        return gSysOrderMapper.getOrderListForManager(managerId);
    }

    @Override
    public GSysEvaluate checkEvaluationDetail(Long orderId) {
        return gSysEvaluateMapper.checkEvaluationDetail(orderId);
    }

    @Override
    public List<Map<String, Object>> getOrderListForWorker(String workerId) {
        return gSysOrderMapper.getOrderListForWorker(workerId);
    }

    @Override
    public List<Map<String, Object>> getWorkerArray(String workerId) {
        //根据workerId查询该维修工的基本信息,判断该维修工的等级
        return null;
    }


}
