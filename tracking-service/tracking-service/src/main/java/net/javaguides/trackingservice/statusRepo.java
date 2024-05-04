package net.javaguides.trackingservice;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface statusRepo extends JpaRepository <Status, Integer> {
	//public Order findByOrdernumber (Integer id) ;
	//public List<Movie> findByStatus(String status) ;
}
