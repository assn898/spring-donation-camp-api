package com.example.demo.repos;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



import com.example.demo.entity.DonationCamp;


public interface DonationCampRepository extends JpaRepository<DonationCamp, String> {

	@Query(value = "SELECT * from donation_camps where id=:id", nativeQuery = true)
	DonationCamp findCampById(@Param("id") int id);
	
	@Query(value = "DELETE from donation_camps where id=:id", nativeQuery = true)
	DonationCamp deleteCampById(@Param("id") int id);
	
	@Query(value = "SELECT * from donation_camps where location LIKE :location", nativeQuery = true)
	List<DonationCamp> findCampById(@Param("location") String location);
}
