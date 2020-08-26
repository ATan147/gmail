package com.fiberhome.gmall.service;

import com.fiberhome.gmall.bean.PmsProductInfo;

import java.util.List;

/**
 * @author ATan147
 * @create 2020-08-24 21:08
 */
public interface SpuService {
    List<PmsProductInfo> spuList(String catalog3Id);

    void saveSpuList(PmsProductInfo pmsProductInfo);
}
