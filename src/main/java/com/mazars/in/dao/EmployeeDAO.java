package  com.mazars.in.dao;

import java.util.List;

import com.mazars.in.model.mastermodel.Employee;


public interface EmployeeDAO {

	public void save(Employee p);
	
	public List<Employee> list();
	
}
