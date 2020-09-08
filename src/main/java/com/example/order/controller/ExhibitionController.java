package com.example.order.controller;

import com.example.order.common.Constant;
import com.example.order.service.ExhibitionService;
import com.example.order.utils.ServletUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 展示内容Controller
 */
@Controller
@RequestMapping("/api/rich")
public class ExhibitionController {

    protected static final Logger logger = LoggerFactory.getLogger(ExhibitionController.class);

    @Autowired
    ExhibitionService exhibitionService;

    @RequestMapping(value = "/addRich",method = RequestMethod.POST)
    public void addRich(HttpServletRequest request, HttpServletResponse response,
                            @RequestParam("content") String content,
                            @RequestParam("sort") Integer sort){

        Map<String, Object> res = new HashMap<String, Object>();
        boolean b = exhibitionService.addRich(content, sort);
        if(b){
            res.put(Constant.RESPONSE_DATA, "新增成功");
            res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            ServletUtils.writeToResponse(response,res);
        }else {
            res.put(Constant.RESPONSE_DATA, "新增失败");
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            ServletUtils.writeToResponse(response,res);
        }

    }

        @RequestMapping(value = "/uploadImg",method = RequestMethod.POST)
        public void uploadPicture(@RequestParam(value="file",required=false) MultipartFile file,
                                    HttpServletRequest request,HttpServletResponse response){

            Map<String, Object> res = new HashMap<String, Object>();
            Map<String, Object> map = new HashMap<String, Object>();
            File targetFile=null;
            //返回存储路径
            String url="";
            System.out.println(file);
            //获取文件名加后缀
            String fileName=file.getOriginalFilename();
            if(fileName!=null&&fileName!=""){
                //存储路径
                String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() ;
                //文件存储位置
                String path = request.getSession().getServletContext().getRealPath("/");
                //文件后缀
                String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());
                //新的文件名
                fileName=new Date().getTime()+"_"+new Random().nextInt(1000)+fileF;
                //先判断文件是否存在
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String fileAdd = sdf.format(new Date());
                //获取文件夹路径
                File file1 =new File(path+"/"+fileAdd);
                //如果文件夹不存在则创建
                if(!file1 .exists()  && !file1 .isDirectory()){
                    file1 .mkdir();
                }
                //将图片存入文件夹
                targetFile = new File(file1, fileName);
                try {
                    //将上传的文件写到服务器上指定的文件。
                    file.transferTo(targetFile);
                    url=returnUrl+"/"+fileAdd+"/"+fileName;
                    map.put("url", url);
                    res.put(Constant.RESPONSE_DATA, map);
                    res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
                    ServletUtils.writeToResponse(response,res);
                } catch (Exception e) {
                    res.put(Constant.RESPONSE_DATA, "图片上传失败");
                    res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
                    ServletUtils.writeToResponse(response,res);
                }
            }
        }

}
