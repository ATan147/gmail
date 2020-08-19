package com.fiberhome.gmall.user.service.impl;

import com.fiberhome.gmall.bean.UmsMemberReceiveAddress;
import com.fiberhome.gmall.service.UmsMemberReceiveAddressService;
import com.fiberhome.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ATan147
 * @create 2020-08-19 20:47
 */
@Service
public class UmsMemberReceiveAddressServiceImpl implements UmsMemberReceiveAddressService {

    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public List<UmsMemberReceiveAddress> getAllUmsMemberReceiveAddress() {
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressMapper.selectAll();
        return umsMemberReceiveAddresses;
    }
}
