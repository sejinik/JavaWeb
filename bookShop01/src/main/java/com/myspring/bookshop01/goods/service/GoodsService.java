package com.myspring.bookshop01.goods.service;

import java.util.List;
import java.util.Map;

import com.myspring.bookshop01.goods.vo.GoodsVO;

public interface GoodsService {
	public Map<String, List<GoodsVO>> listGoods() throws Exception;
}
