package net.javaguides.stockservice;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StockRepo extends JpaRepository <Stock, Integer> {
	public Stock findByItemId (String itemId) ;
	//public List<Movie> findByStatus(String status) ;
}

