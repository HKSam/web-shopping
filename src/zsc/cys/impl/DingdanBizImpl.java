package zsc.cys.impl;

import java.util.List;

import zsc.cys.Dao.DingdanDao;
import zsc.cys.Dao.DingdanImpl;
import zsc.cys.entity.Dingdan;
import zsc.cys.entity.Users;
import zsc.cys.servlets.deleteUser;

public class DingdanBizImpl implements DingdanBiz {
    private DingdanDao DingdanDao=new DingdanImpl();
	@Override
	public int addDingdan(Dingdan dingdan) throws Exception {
		// TODO Auto-generated method stub
		return DingdanDao.addDingdan(dingdan);
	}
	@Override
	public List<Dingdan> findDingdan(Users users) throws Exception {
		return DingdanDao.findDingdan(users);
	}

}
