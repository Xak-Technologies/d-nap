package com.xakt.dnap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xakt.dnap.entity.Tenant;
import com.xakt.dnap.error.AlreadyExistsException;
import com.xakt.dnap.error.BlankFieldException;
import com.xakt.dnap.error.NotFoundException;
import com.xakt.dnap.error.SuccessMessageException;
import com.xakt.dnap.service.TenantService;

@RestController
public class TenantController {
	
	@Autowired
	TenantService tenantService;
	
	@PostMapping("/api/addNewTenant")
	public void addNewTenant(@RequestBody Tenant tenant) 
			throws NotFoundException, AlreadyExistsException, 
			SuccessMessageException, BlankFieldException {
		tenantService.addNewTenant(tenant);
	}

}
