package pl.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.project.model.RepairRequest;

public interface RepairRequestRepository extends JpaRepository<RepairRequest, Long>{
	
	
	
}
