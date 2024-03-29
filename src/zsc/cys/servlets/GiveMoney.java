package zsc.cys.servlets;

import zsc.cys.entity.Dingdan;
import zsc.cys.entity.Goods;
import zsc.cys.entity.Shop;
import zsc.cys.entity.Users;
import zsc.cys.impl.GoodsBiz;
import zsc.cys.impl.GoodsBizImpl;
import zsc.cys.impl.ShopBiz;
import zsc.cys.impl.ShopBizImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/GiveMoney")
public class GiveMoney extends HttpServlet {
   //生成订单
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			
			HttpSession session = req.getSession();
		Map<Integer, Goods> map = (Map<Integer, Goods>) session
				.getAttribute("car");
	              Users user=(Users) session.getAttribute("user");
		Set<Integer> set = map.keySet();
		List<Goods> list = new ArrayList<Goods>();
		Goods goods=new Goods();
		for (Integer integer : set) {
			  goods= map.get(integer);
			  list.add(goods);
		}
		//上面是从购物车中将对象传过来
		GoodsBiz goodsBiz=new GoodsBizImpl();
        ShopBiz shopBiz=new ShopBizImpl();
	    Shop shop=new Shop(user, new Date().toLocaleString(), 0);
	    shopBiz.addShop(shop);
	    System.out.println(shop.getId());
	    List<Dingdan> lDingdan=new ArrayList<Dingdan>();
		for (Goods goods1 : list) {
			if(goodsBiz.downByGoods(goods1.getId(), goods1.getCount())>0){
			    Dingdan  dingdan=new Dingdan();
			    dingdan.setCount(goods1.getCount());
			    dingdan.setGoodsname(goods1.getGoodsname());
			    dingdan.setGoodsprice(goods1.getPrice());
			    dingdan.setGoodsid(goods1.getId());
			    dingdan.setShop(shop);
			    lDingdan.add(dingdan);
			}else{
			System.out.println("修改失败");
			}
	       }
	       // throw new Exception(); 
           req.setAttribute("shop", shop);
           req.setAttribute("list", lDingdan);
     		 req.getRequestDispatcher("ScDingdan").forward(req, resp);
	//	   resp.sendRedirect("index.jsp");
		
		} catch (Exception e) {
			e.printStackTrace();
		}}

}
