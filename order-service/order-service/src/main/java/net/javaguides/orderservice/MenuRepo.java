package net.javaguides.orderservice;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MenuRepo extends JpaRepository <Menu, Integer> {
	public Menu findByMenuid (String menuid) ;
	//public List<Movie> findByStatus(String status) ;
}