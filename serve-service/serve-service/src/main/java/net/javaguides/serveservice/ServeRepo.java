package net.javaguides.serveservice;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ServeRepo extends JpaRepository <Serve, Integer> {
	//public Food findByOrderId (Integer id) ;
	//public List<Movie> findByStatus(String status) ;
}
