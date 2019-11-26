package com.iris.pbms.daos;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.iris.pbms.models.DataEntryOperator;
import com.iris.pbms.models.ProjectAllocation;
import com.iris.pbms.models.User;


public interface UserDao {
	 public User getUserById(int Id);
	 public User validateUser(int Id,String password);
	 public boolean setAttendance(DataEntryOperator obj);
	 public List<DataEntryOperator> getAllDeoAttendance();
	 public ProjectAllocation getConfig(int id);
	 public DataEntryOperator getBill(Integer id, String month, int year);
	 public double getBill(double perHourBilling, DataEntryOperator deo);
	 
}
