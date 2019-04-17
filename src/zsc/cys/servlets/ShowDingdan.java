package zsc.cys.servlets;

import zsc.cys.entity.Dingdan;
import zsc.cys.entity.Users;
import zsc.cys.impl.DingdanBiz;
import zsc.cys.impl.DingdanBizImpl;
import zsc.cys.impl.UserBiz;
import zsc.cys.impl.UserBizImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/ShowDingdan")
public class ShowDingdan extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		DingdanBiz dingdanBiz = new DingdanBizImpl();
		UserBiz userBiz = new UserBizImpl();
		Users users = (Users) session.getAttribute("user");
		System.out.println(users.getId());
		List<Dingdan> list;
		try {
			if ((list = dingdanBiz.findDingdan(users)) != null) {
				req.setAttribute("list", list);
				req.getRequestDispatcher("dingdan.jsp").forward(req, resp);
			} else {
				resp.setCharacterEncoding("utf-8");
				resp.getWriter().print("抱歉没有人买你的商品,暂无生成订单");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
