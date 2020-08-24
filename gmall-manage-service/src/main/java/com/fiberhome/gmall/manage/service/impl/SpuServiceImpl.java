package com.fiberhome.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.fiberhome.gmall.bean.PmsProductInfo;
import com.fiberhome.gmall.manage.mapper.PmsProductInfoMapper;
import com.fiberhome.gmall.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author ATan147
 * @create 2020-08-24 21:12
 */
@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    PmsProductInfoMapper pmsProductInfoMapper;

    @Override
    public List<PmsProductInfo> spuList(String catalog3Id) {
        PmsProductInfo pmsProductInfo = new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);
        List<PmsProductInfo> pmsProductInfos = pmsProductInfoMapper.select(pmsProductInfo);
        return pmsProductInfos;
    }
}
