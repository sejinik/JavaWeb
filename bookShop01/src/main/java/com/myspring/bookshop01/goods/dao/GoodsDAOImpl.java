package com.myspring.bookshop01.goods.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.bookshop01.goods.vo.GoodsVO;

@Repository("goodsDAO")
public class GoodsDAOImpl implements GoodsDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<GoodsVO> selectGoodsList(String goodsStatus) throws DataAccessException {
		return sqlSession.selectList("mapper.goods.selectGoodsList", goodsStatus);
	}

}
