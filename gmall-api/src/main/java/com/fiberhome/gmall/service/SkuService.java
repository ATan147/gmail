package com.fiberhome.gmall.service;

import com.fiberhome.gmall.bean.PmsSkuInfo;

import java.util.List;

/**
 * @author ATan147
 * @create 2020-08-29 21:49
 */
public interface SkuService {
    void saveSkuInfo(PmsSkuInfo pmsSkuInfo);

    PmsSkuInfo getSkuById(String skuId);

    List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(String productId);
}
