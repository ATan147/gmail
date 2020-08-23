package com.fiberhome.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.fiberhome.gmall.bean.PmsBaseAttrInfo;
import com.fiberhome.gmall.manage.mapper.PmsBaseAttrInfoMapper;
import com.fiberhome.gmall.manage.mapper.PmsBaseAttrValueMapper;
import com.fiberhome.gmall.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author ATan147
 * @create 2020-08-23 20:35
 */
@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;

    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;



    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = pmsBaseAttrInfoMapper.select(pmsBaseAttrInfo);
        return pmsBaseAttrInfos;
    }
}
