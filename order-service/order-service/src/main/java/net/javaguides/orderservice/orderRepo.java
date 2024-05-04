package net.javaguides.orderservice;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface orderRepo extends JpaRepository <Order, Integer> {
	public Order findByOrdernumber (Integer id) ;
	//public List<Movie> findByStatus(String status) ;
}
