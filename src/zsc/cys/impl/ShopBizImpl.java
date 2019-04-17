package zsc.cys.impl;

import zsc.cys.Dao.DingdanDao;
import zsc.cys.Dao.DingdanImpl;
import zsc.cys.Dao.ShopDao;
import zsc.cys.Dao.ShopImpl;
import zsc.cys.entity.Dingdan;
import zsc.cys.entity.Shop;
import zsc.cys.servlets.deleteUser;

public class ShopBizImpl implements ShopBiz {
	private ShopDao shopDao = new ShopImpl();

	@Override
	public int addShop(Shop shop) throws Exception {
		// TODO Auto-generated method stub
		return shopDao.addShop(shop);
	}

	@Override
	public int findShopID(Shop shop) throws Exception {
		// TODO Auto-generated method stub
		return shopDao.findShopID(shop);
	}

}
