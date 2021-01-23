package com.example.demo.repos;




import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DonationCamp;

@Repository
public interface DonationCampRepository extends JpaRepository<DonationCamp, String> {

	@Query(value = "SELECT * from donation_camps where id=:id", nativeQuery = true)
	DonationCamp findCampById(@Param("id") int id);
	
	@Query(value = "DELETE from donation_camps where id=:id", nativeQuery = true)
	@Modifying
	@Transactional
	int deleteCampById(@Param("id") int id);
	
	@Query(value = "SELECT * from donation_camps where location LIKE :location", nativeQuery = true)
	List<DonationCamp> findCampById(@Param("location") String location);

	@Query(value = "SELECT DISTINCT location from donation_camps", nativeQuery = true)
	List<String> findAllCampLocations();
}
