package com.myspring.bookshop01.goods.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.bookshop01.goods.dao.GoodsDAO;
import com.myspring.bookshop01.goods.vo.GoodsVO;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsDAO goodsDAO;
	
	@Override
	public Map<String, List<GoodsVO>> listGoods() throws Exception {
		Map<String,List<GoodsVO>> goodsMap = new HashMap<String, List<GoodsVO>>();
		List<GoodsVO> goodsList = goodsDAO.selectGoodsList("bestseller");
		goodsMap.put("bestseller", goodsList);
		
		goodsList = goodsDAO.selectGoodsList("newbook");
		goodsMap.put("newbook", goodsList);
		
		goodsList = goodsDAO.selectGoodsList("steadysellet");
		goodsMap.put("steadyseller", goodsList);
		return goodsMap;
	}

}
