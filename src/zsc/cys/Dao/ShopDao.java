package zsc.cys.Dao;

import java.util.List;

import zsc.cys.entity.Goods;
import zsc.cys.entity.Shop;

public interface ShopDao {
	//订单添加
	public int addShop(Shop shop) throws Exception;
    //一个订单对应多个商品,查询该订单的id
	public int findShopID(Shop shop)throws Exception;
	

	
}
