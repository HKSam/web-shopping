package zsc.cys.impl;

import java.util.List;

import zsc.cys.entity.Dingdan;
import zsc.cys.entity.Shop;
import zsc.cys.entity.Users;

public interface DingdanBiz {
	// 订单添加
	public int addDingdan(Dingdan dingdan) throws Exception;

	// 商家查询自己的货物订单
	public List<Dingdan> findDingdan(Users users) throws Exception;
}
