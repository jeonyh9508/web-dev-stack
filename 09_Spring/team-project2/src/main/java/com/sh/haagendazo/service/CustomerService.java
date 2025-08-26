package com.sh.haagendazo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sh.haagendazo.mapper.CustomerMapper;
import com.sh.haagendazo.model.Customer;
import com.sh.haagendazo.model.Paging;

@Service
public class CustomerService implements CustomerMapper {
	
	@Autowired
	private CustomerMapper mapper;

	@Override
	public List<Customer> allCustomer(Paging paging) {
		paging.setOffset(paging.getLimit() * (paging.getPage()-1));
		List<Customer> list = mapper.allCustomer(paging);
		return list;
	}

	@Override
	public int total(Paging paging) {
		return mapper.total(paging);
	}

	@Override
	public void updateCs(Customer vo) {
		mapper.updateCs(vo);
	}

	@Override
	public void updateLog(Customer vo) {
		mapper.updateLog(vo);		
	}

	@Override
	public List<Customer> allLog(Paging paging) {
		paging.setOffset(paging.getLimit() * (paging.getPage()-1));
		List<Customer> list = mapper.allLog(paging);
		return list;
	}

}
