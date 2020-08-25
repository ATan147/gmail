package com.fiberhome.gmall.service;

import com.fiberhome.gmall.bean.PmsBaseAttrInfo;
import com.fiberhome.gmall.bean.PmsBaseAttrValue;
import com.fiberhome.gmall.bean.PmsBaseSaleAttr;

import java.util.List;

/**
 * @author ATan147
 * @create 2020-08-23 20:31
 */
public interface AttrService {
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    List<PmsBaseSaleAttr> baseSaleAttrList();
}
