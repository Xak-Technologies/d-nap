package com.xakt.dnap.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xakt.dnap.entity.Tenant;
import com.xakt.dnap.entity.User;
import com.xakt.dnap.error.AlreadyExistsException;
import com.xakt.dnap.error.BlankFieldException;
import com.xakt.dnap.error.NotFoundException;
import com.xakt.dnap.error.SuccessMessageException;
import com.xakt.dnap.repository.TenantRepository;
import com.xakt.dnap.repository.UserRepository;

@Service
public class TenantServiceImplementation implements TenantService {
	
	@Autowired
	TenantRepository tenantRepository;
	
	@Autowired
	UserRepository userRepository;
	
/*
 * ADDING A NEW TENANT TO THE ACCOUNT	
 */
	@Override
	public void addNewTenant(Tenant tenant)
			throws NotFoundException, AlreadyExistsException, SuccessMessageException, BlankFieldException {

		//	CHECKING IF USER ACCOUNT EXISTS IN THE DATABASE	
		Optional<User> userDB = userRepository.findByUserId(tenant.getUser().getUserId());
		if(userDB.isEmpty()) {
			throw new NotFoundException("User account not found.");
		}
		
		if(!userDB.get().getUserRole().equals("Tenant")) {
			throw new NotFoundException("This account does not belong to a tenant user.");
		}
		tenant.setUser(userDB.get());
		
		
//		CHECKING FOR DUPLICATE TENANTS
		Integer tenantDBNationalId = 
				tenantRepository.findDuplicateByNationalId(tenant.getNationalId());
		if(tenantDBNationalId > 0) {
			throw new AlreadyExistsException("National Id alreday used.");
		}
		
		Integer tenantDBTelephone1 = 
				tenantRepository.findDuplicateByTelephone1(tenant.getContact().getTelephone1());
		if(tenantDBTelephone1 > 0) {
			throw new AlreadyExistsException("Telephone1 already used.");
		}
		
		Integer tenantDBTelephone2 = 
				tenantRepository.findDuplicateByTelephone2(tenant.getContact().getTelephone2());
		if(tenantDBTelephone2 > 0) {
			throw new AlreadyExistsException("Telephone2 already used.");
		}
		
		Integer tenantDBEmail = 
				tenantRepository.findDuplicateByEmail(tenant.getContact().getEmail());
		if(tenantDBEmail > 0) {
			throw new AlreadyExistsException("Email already used.");
		}
		
		Integer tenantDBUser = 
				tenantRepository.findDuplicateByUser(tenant.getUser().getUserId());
		if(tenantDBUser > 0) {
			throw new AlreadyExistsException("Tenant with similar details already exists.");
		}
		
//		CHECKING IF NEXT OF KIN DETAILS ARE SIMILAR TO TENANT'S DETAILS
		if(tenant.getContact().getEmail().equals(tenant.getNextOfKin().getNokEmail())) {
			throw new AlreadyExistsException("Tenant email can not be the same as next of kin email.");
		}
		
		if(tenant.getContact().getTelephone1().equals(tenant.getNextOfKin().getNokTelephone())) {
			throw new AlreadyExistsException("Tenant telephone1 can not be the same as next of kin telephone.");
		}
		
		if(tenant.getContact().getTelephone2().equals(tenant.getNextOfKin().getNokTelephone())) {
			throw new AlreadyExistsException("Tenant telephone2 can not be the same as next of kin telephone.");
		}
		
		if(tenant.getNationalId().equals(tenant.getNextOfKin().getNokNationalId())) {
			throw new AlreadyExistsException("Tenant national ID can not be the same as next of kin national ID.");
		}
		
		
//		CHECKING FOR NULL REQUIRED FIELDS
		
		if(Objects.isNull(tenant.getUser())) {
			throw new NotFoundException("User account not found.");
		}
		
		if(Objects.isNull(tenant.getUser().getUserId())) {
			throw new NotFoundException("User account not found.");
		}
		
		
		if(Objects.isNull(tenant.getFirstName()) || 
				"".equalsIgnoreCase(tenant.getFirstName())) {
			throw new BlankFieldException("Please add first name.");
		}
		
		if(Objects.isNull(tenant.getLastName()) || 
				"".equalsIgnoreCase(tenant.getLastName())) {
			throw new BlankFieldException("Please add last name.");
		}
		
		if(Objects.isNull(tenant.getNationalId()) || 
				"".equalsIgnoreCase(tenant.getNationalId())) {
			throw new BlankFieldException("Please add tenant national ID.");
		}
		
		if(Objects.isNull(tenant.getNextOfKin().getNokName()) || 
				"".equalsIgnoreCase(tenant.getNextOfKin().getNokName())) {
			throw new BlankFieldException("Please add next of kin name.");
		}
		
		if(Objects.isNull(tenant.getNextOfKin().getNokEmail()) || 
				"".equalsIgnoreCase(tenant.getNextOfKin().getNokEmail())) {
			throw new BlankFieldException("Please add next of kin email");
		}
		
		if(Objects.isNull(tenant.getNextOfKin().getNokTelephone()) || 
				"".equalsIgnoreCase(tenant.getNextOfKin().getNokTelephone())) {
			throw new BlankFieldException("Please add next of kin telephone");
		}
		
		if(Objects.isNull(tenant.getNextOfKin().getNokNationalId()) || 
				"".equalsIgnoreCase(tenant.getNextOfKin().getNokNationalId())) {
			throw new BlankFieldException("Please add next of kin national ID");
		}
		
		if(Objects.isNull(tenant.getContact().getEmail()) || 
				"".equalsIgnoreCase(tenant.getContact().getEmail())) {
			throw new BlankFieldException("Please add tenant email");
		}
		
		if(Objects.isNull(tenant.getContact().getTelephone1()) || 
				"".equalsIgnoreCase(tenant.getContact().getTelephone1())) {
			throw new BlankFieldException("Please add tenant telephone1");
		}
		
		if(Objects.isNull(tenant.getContact().getTelephone2()) || 
				"".equalsIgnoreCase(tenant.getContact().getTelephone2())) {
			throw new BlankFieldException("Please add tenant telephone2");
		}
		
		if(Objects.isNull(tenant.getNationalId()) || 
				"".equalsIgnoreCase(tenant.getNationalId())) {
			throw new BlankFieldException("Please add tenant national ID");
		}
		
		
		tenantRepository.save(tenant);
		throw new SuccessMessageException("Tenant saved successfully.");
	}

}
