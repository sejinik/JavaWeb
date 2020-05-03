package com.myspring.bookshop01.main;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.bookshop01.common.base.BaseController;
import com.myspring.bookshop01.goods.service.GoodsService;
import com.myspring.bookshop01.goods.vo.GoodsVO;

@Controller("mainController")
@EnableAspectJAutoProxy
public class MainController extends BaseController {

	@Autowired
	private GoodsService goodService;
	
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		HttpSession session = request.getSession();
		//side_menu의 값에 따라 다르게 표시한다
		session.setAttribute("side_menu", "user");
		
		Map<String, List<GoodsVO>> goodsMap = goodService.listGoods();
		mav.addObject("goodsMap", goodsMap);
		
		return mav;
	}
}
