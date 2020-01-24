package ad.dao;

import java.util.List;

import ad.Orders;

public interface OrdersDAO extends DAO<Orders, Integer>{

	List<Orders> getTFromCustomer(int id);

	
}
