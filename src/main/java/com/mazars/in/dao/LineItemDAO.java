package  com.mazars.in.dao;

import java.util.List;

import com.mazars.in.model.transactionmodel.LineItem;


public interface LineItemDAO {

	public void save(LineItem p);
	
	public List<LineItem> list();
	
}
