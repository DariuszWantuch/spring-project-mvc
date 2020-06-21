package pl.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.project.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long>{
	UserRole findByRole(String role);
	

}
