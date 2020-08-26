package com.fiberhome.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fiberhome.gmall.bean.PmsProductInfo;
import com.fiberhome.gmall.manage.util.PmsUploadUtil;
import com.fiberhome.gmall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author ATan147
 * @create 2020-08-24 21:04
 */
@Controller
@CrossOrigin
public class SpuController {

    @Reference
    SpuService spuService;

    @RequestMapping("spuList")
    @ResponseBody
    public List<PmsProductInfo> spuList(String catalog3Id){
        List<PmsProductInfo> pmsProductInfos =  spuService.spuList(catalog3Id);
        return pmsProductInfos;
    }

    @RequestMapping("saveSpuInfo")
    @ResponseBody
    public String saveSpuList(@RequestBody PmsProductInfo pmsProductInfo){
        System.out.println(pmsProductInfo);
        spuService.saveSpuList(pmsProductInfo);
        return "success";
    }

    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile){
        // 上传分布式文件存储系统
        String url = PmsUploadUtil.uploadImage(multipartFile);
        // 返回图片地址到前端
        System.out.println(url);
        return url;
    }
}
