package zsc.cys.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zsc.cys.impl.UserBiz;
import zsc.cys.impl.UserBizImpl;
import zsc.cys.utils.DBUtils;

@WebServlet("/deleteUser")
public class deleteUser extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException { 	
	          String userid=req.getParameter("userid");
                  UserBiz userBiz=new UserBizImpl();
                  try {
					if(userBiz.deleteByIdUsers(Integer.valueOf(userid))>0){
					     req.getRequestDispatcher("admin_index.jsp").forward(req, resp);
					}else{
						
					}
				
                  } catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					DBUtils.closeConnection();
				}

	}
}
