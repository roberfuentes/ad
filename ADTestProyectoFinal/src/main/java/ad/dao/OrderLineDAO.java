package ad.dao;

import java.util.List;

import ad.OrderLine;

public interface OrderLineDAO extends DAO<OrderLine, Integer>{
	
	List<OrderLine> getTFromOrder(int id);
}
