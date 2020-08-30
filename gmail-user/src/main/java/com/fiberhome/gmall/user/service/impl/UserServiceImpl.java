package com.fiberhome.gmall.user.service.impl;

import com.fiberhome.gmall.bean.UmsMember;
import com.fiberhome.gmall.service.UserService;
import com.fiberhome.gmall.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ATan147
 * @create 2020-08-17 21:56
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<UmsMember> getAllUser() {
        List<UmsMember> umsMemberList = userMapper.selectAll();
        return umsMemberList;
    }
}
