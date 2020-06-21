package pl.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.project.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
}
