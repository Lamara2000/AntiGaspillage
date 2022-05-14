package com.antigaspillage.demo.dao;

import com.antigaspillage.demo.data.Trader;

public interface ITraderDAO {
	
	public Trader findByRef(Long id);

}
