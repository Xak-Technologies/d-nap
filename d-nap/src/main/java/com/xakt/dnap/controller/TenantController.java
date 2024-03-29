package com.xakt.dnap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/api/fetchTenants")
	private List<Tenant> fetchTenants() throws NotFoundException{
		return tenantService.fetchTenants();
	}
	
	
	@GetMapping("/api/fetchTenantById/{tenant_id}")
	private Tenant fetchTenantById(@PathVariable("tenant_id") Long tenantId) 
			throws NotFoundException {
		return tenantService.fetchTenantById(tenantId);
	}
	
	@DeleteMapping("/api/deleteTenantById/{tenant_id}")	
	private void deleteTenantById(@PathVariable("tenant_id") Long tenantId) 
			throws NotFoundException, SuccessMessageException {
		tenantService.deleteTenantById(tenantId);
	}
	

}
