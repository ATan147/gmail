package com.fiberhome.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.fiberhome.gmall.bean.PmsSkuInfo;
import com.fiberhome.gmall.manage.mapper.PmsSkuAttrValueMapper;
import com.fiberhome.gmall.manage.mapper.PmsSkuImageMapper;
import com.fiberhome.gmall.manage.mapper.PmsSkuInfoMapper;
import com.fiberhome.gmall.manage.mapper.PmsSkuSaleAttrValueMapper;
import com.fiberhome.gmall.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ATan147
 * @create 2020-08-29 21:51
 */
@Service
public class SkuServiceImpl implements SkuService {


    @Autowired
    PmsSkuInfoMapper pmsSkuInfoMapper;

    @Autowired
    PmsSkuAttrValueMapper pmsSkuAttrValueMapper;

    @Autowired
    PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;

    @Autowired
    PmsSkuImageMapper pmsSkuImageMapper;




    @Override
    public void saveSkuInfo(PmsSkuInfo pmsSkuInfo) {
        int i = pmsSkuInfoMapper.insertSelective(pmsSkuInfo);

    }
}