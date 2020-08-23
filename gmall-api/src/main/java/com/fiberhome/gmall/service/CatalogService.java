package com.fiberhome.gmall.service;

import com.fiberhome.gmall.bean.PmsBaseCatalog1;
import com.fiberhome.gmall.bean.PmsBaseCatalog2;
import com.fiberhome.gmall.bean.PmsBaseCatalog3;

import java.util.List;

/**
 * @author ATan147
 * @create 2020-08-23 13:50
 */
public interface CatalogService {
    List<PmsBaseCatalog1> getCatalog1();

    List<PmsBaseCatalog2> getCatalog2(String catalog1Id);

    List<PmsBaseCatalog3> getCatalog3(String catalog2Id);
}
