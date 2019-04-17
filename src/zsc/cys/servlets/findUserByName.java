package zsc.cys.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zsc.cys.entity.Users;
import zsc.cys.impl.UserBiz;
import zsc.cys.impl.UserBizImpl;
import zsc.cys.utils.DBUtils;

@WebServlet("/findUserByName")
public class findUserByName extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		System.out.println(username);
		UserBiz userBiz = new UserBizImpl();
		try {
			List<Users> list = userBiz.finByNameUsers(username);
			if(list.size()!=0){
			req.setAttribute("list", list);
			req.getRequestDispatcher("deleteUser.jsp?rowid=1").forward(req, resp);
			}else{
				 req.setAttribute("findError", "没有该用户");
				req.getRequestDispatcher("deleteUser.jsp?rowid=1").forward(req, resp);

			}
	} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeConnection();
		}
	}
}
