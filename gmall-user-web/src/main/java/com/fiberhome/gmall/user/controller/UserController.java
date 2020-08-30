package com.fiberhome.gmall.user.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.fiberhome.gmall.bean.UmsMember;
import com.fiberhome.gmall.bean.UmsMemberReceiveAddress;
import com.fiberhome.gmall.service.UmsMemberReceiveAddressService;
import com.fiberhome.gmall.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ATan147
 * @create 2020-08-17 21:56
 */
@Controller
public class UserController {

    @Reference
    UserService userService;

    @Reference
    UmsMemberReceiveAddressService umsMemberReceiveAddressService;

    @RequestMapping("index")
    @ResponseBody
    public String index() {
        return "hello user";
    }

    @RequestMapping("getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser() {
        List<UmsMember> umsMembers = userService.getAllUser();
        return umsMembers;
    }

    @RequestMapping("getAllUmsMemberReceiveAddress")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getAllUmsMenberReceiveAddress() {
        List<UmsMemberReceiveAddress> allUmsMemberReceiveAddress = umsMemberReceiveAddressService.getAllUmsMemberReceiveAddress();
        return allUmsMemberReceiveAddress;
    }
}
