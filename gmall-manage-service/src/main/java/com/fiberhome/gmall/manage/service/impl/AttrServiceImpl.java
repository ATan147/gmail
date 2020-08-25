package com.fiberhome.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.fiberhome.gmall.bean.PmsBaseAttrInfo;
import com.fiberhome.gmall.bean.PmsBaseAttrValue;
import com.fiberhome.gmall.bean.PmsBaseSaleAttr;
import com.fiberhome.gmall.manage.mapper.PmsBaseAttrInfoMapper;
import com.fiberhome.gmall.manage.mapper.PmsBaseAttrValueMapper;
import com.fiberhome.gmall.manage.mapper.PmsBaseSaleAttrMapper;
import com.fiberhome.gmall.service.AttrService;
import org.apache.commons.lang3.StringUtils;
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

    @Autowired
    PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;


    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = pmsBaseAttrInfoMapper.select(pmsBaseAttrInfo);
        return pmsBaseAttrInfos;
    }

    @Override
    public String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        if (!StringUtils.isBlank(pmsBaseAttrInfo.getId())) {
            return updateAttrInfo(pmsBaseAttrInfo);
        }
        if (StringUtils.isBlank(pmsBaseAttrInfo.getAttrName())) {
            return "属性值为空，无法添加";
        }
        pmsBaseAttrInfoMapper.insertSelective(pmsBaseAttrInfo);
        List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
        for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {
            pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
            pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);
        }
        return "success";
    }

    private String updateAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        if (StringUtils.isBlank(pmsBaseAttrInfo.getAttrName())) {
            return "属性值为空，无法添加";
        }
        pmsBaseAttrInfoMapper.updateByPrimaryKey(pmsBaseAttrInfo);
        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
        pmsBaseAttrValueMapper.delete(pmsBaseAttrValue);
        return saveAttrValue(pmsBaseAttrInfo.getAttrValueList(), pmsBaseAttrInfo.getId());
    }

    private String saveAttrValue(List<PmsBaseAttrValue> attrValueList, String attrId) {
        if (attrValueList != null) {
            for (int j = 0; j < attrValueList.size(); j++) {
                PmsBaseAttrValue pmsBaseAttrValue = attrValueList.get(j);
                pmsBaseAttrValue.setAttrId(attrId);
                pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);
            }
        }
        return "success";
    }


    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);
        List<PmsBaseAttrValue> pmsBaseAttrValues = pmsBaseAttrValueMapper.select(pmsBaseAttrValue);
        return pmsBaseAttrValues;
    }

    @Override
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        return pmsBaseSaleAttrMapper.selectAll();
    }
}
