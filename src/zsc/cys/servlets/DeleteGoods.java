package zsc.cys.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zsc.cys.impl.GoodsBiz;
import zsc.cys.impl.GoodsBizImpl;
import zsc.cys.utils.DBUtils;


@WebServlet("/DeleteGoods")
public class DeleteGoods extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String goodsid = req.getParameter("goodsid");
		GoodsBiz goodsbiz=new GoodsBizImpl();
		
		 try {
				if(goodsbiz.deleteGood(Integer.valueOf(goodsid))>0){
					req.getRequestDispatcher("findAllGoods").forward(req, resp);

				}else{
					resp.getWriter().print("删除失败");	
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
