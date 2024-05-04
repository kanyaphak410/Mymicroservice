package net.javaguides.dessertservice;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DessertRepo extends JpaRepository <Dessert, Integer> {
	//public Food findByOrderId (Integer id) ;
	//public List<Movie> findByStatus(String status) ;
}
