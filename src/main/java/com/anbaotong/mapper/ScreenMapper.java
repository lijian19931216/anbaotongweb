package com.anbaotong.mapper;

import com.anbaotong.bean.ProductScreen;

import java.util.List;
import java.util.Map;

public interface ScreenMapper {

    List<Map> getProductList();

    ProductScreen getProductDetail(String id);
}
