package com.fiberhome.gmall.service;

import com.fiberhome.gmall.bean.PmsBaseAttrInfo;

import java.util.List;

/**
 * @author ATan147
 * @create 2020-08-23 20:31
 */
public interface AttrService {
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);
}
