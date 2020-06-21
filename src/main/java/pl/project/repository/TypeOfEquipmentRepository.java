package pl.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.project.model.TypeOfEquipment;

public interface TypeOfEquipmentRepository extends JpaRepository<TypeOfEquipment, Long>{
	TypeOfEquipment findByName(String name);
	
	
}
