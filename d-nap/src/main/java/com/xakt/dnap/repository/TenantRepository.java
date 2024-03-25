package com.xakt.dnap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xakt.dnap.entity.Tenant;

public interface TenantRepository extends JpaRepository<Tenant, Long> {

	@Query(value="SELECT COUNT(tenant_id) FROM tenant WHERE national_id=:nationalId", nativeQuery=true)
	Integer findDuplicateByNationalId(String nationalId);

	@Query(value="SELECT COUNT(tenant_id) FROM tenant WHERE telephone1=:telephone1", nativeQuery=true)
	Integer findDuplicateByTelephone1(String telephone1);

	@Query(value="SELECT COUNT(tenant_id) FROM tenant WHERE telephone2=:telephone2", nativeQuery=true)
	Integer findDuplicateByTelephone2(String telephone2);
	
	@Query(value="SELECT COUNT(tenant_id) FROM tenant WHERE email=:email", nativeQuery=true)
	Integer findDuplicateByEmail(String email);

	@Query(value="SELECT COUNT(tenant_id) FROM tenant WHERE user_id=:userId", nativeQuery=true)
	Integer findDuplicateByUser(Long userId);

}
