package zsc.cys.servlets;

import zsc.cys.entity.Goods;
import zsc.cys.entity.Users;
import zsc.cys.impl.GoodsBiz;
import zsc.cys.impl.GoodsBizImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;


@WebServlet("/index_ShowGoods")
public class index_ShowGoods extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			Goods goods = new Goods();
			GoodsBiz goodsBiz = new GoodsBizImpl();
			HttpSession session = req.getSession();
			String page = req.getParameter("page");
			Users users = (Users) session.getAttribute("user");
			// System.out.println("userid是"+users.getId());
			int pages = goodsBiz.GoodsPages(12);
			List<Goods> list;
			System.out.println("页数是" + page);
			if (page == null || Integer.valueOf(page) <= 0 || Integer.valueOf(page) > pages) {
				list = goodsBiz.findAllGoods(1, 12);
			} else {
				list = goodsBiz.findAllGoods(Integer.valueOf(page), 12);
			}
			req.setAttribute("list", list);
			req.setAttribute("page", pages);
			req.getRequestDispatcher("index_show.jsp").forward(req, resp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
