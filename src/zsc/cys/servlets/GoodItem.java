package zsc.cys.servlets;

import zsc.cys.entity.Goods;
import zsc.cys.impl.GoodsBiz;
import zsc.cys.impl.GoodsBizImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/GoodItem")
public class GoodItem extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String goodid = req.getParameter("id");
		GoodsBiz goodsBiz = new GoodsBizImpl();
		Goods goods = new Goods();
		try {
			if ((goods=goodsBiz.findByIdGoods(Integer.valueOf(goodid))) != null) {
                 req.setAttribute("good", goods);
                 req.getRequestDispatcher("good.jsp").forward(req, resp);
			}

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
