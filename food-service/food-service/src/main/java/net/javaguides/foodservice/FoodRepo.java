package net.javaguides.foodservice;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FoodRepo extends JpaRepository <Food, Integer> {
	public Food findByOrderId (Integer id) ;
	//public List<Movie> findByStatus(String status) ;
}
