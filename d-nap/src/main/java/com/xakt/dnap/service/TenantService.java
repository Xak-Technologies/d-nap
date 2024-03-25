package com.xakt.dnap.service;

import com.xakt.dnap.entity.Tenant;
import com.xakt.dnap.error.AlreadyExistsException;
import com.xakt.dnap.error.BlankFieldException;
import com.xakt.dnap.error.NotFoundException;
import com.xakt.dnap.error.SuccessMessageException;

public interface TenantService {

	void addNewTenant(Tenant tenant) throws NotFoundException, AlreadyExistsException, 
	SuccessMessageException, BlankFieldException;

}
