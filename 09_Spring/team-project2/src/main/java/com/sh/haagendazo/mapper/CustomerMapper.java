package com.sh.haagendazo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sh.haagendazo.model.Customer;
import com.sh.haagendazo.model.Paging;

@Mapper
public interface CustomerMapper {
	
	List<Customer> allCustomer(Paging paging);
	int total(Paging paging);
	void updateCs(Customer vo);
	void updateLog(Customer vo);
	List<Customer> allLog(Paging paging);
}
