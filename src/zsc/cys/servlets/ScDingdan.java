package zsc.cys.servlets;

import zsc.cys.entity.Dingdan;
import zsc.cys.entity.Shop;
import zsc.cys.impl.DingdanBiz;
import zsc.cys.impl.DingdanBizImpl;
import zsc.cys.impl.ShopBiz;
import zsc.cys.impl.ShopBizImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/ScDingdan")
public class ScDingdan extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		try {
			Shop shop = (Shop) req.getAttribute("shop");
			ShopBiz shopBiz = new ShopBizImpl();
			int id = shopBiz.findShopID(shop);
			shop.setId(id);
			List<Dingdan> list = (List<Dingdan>) req.getAttribute("list");
			DingdanBiz dingdanBiz = new DingdanBizImpl();
			for (Dingdan dingdan : list) {
			    dingdan.getShop().setId(id);
			    dingdanBiz.addDingdan(dingdan);
			}
			resp.sendRedirect("success.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
