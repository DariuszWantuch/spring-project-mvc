package pl.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.project.model.TypeOfEquipment;
import pl.project.repository.TypeOfEquipmentRepository;

@Service
public class TypeOfEquipmentService {
	private TypeOfEquipmentRepository typeOfEquipmentRepository;
	
	@Autowired
	public void setypeOfEquipmentRepository(TypeOfEquipmentRepository typeOfEquipmentRepository) {
		this.typeOfEquipmentRepository = typeOfEquipmentRepository;
	}
	
	
	public void addEquipment(TypeOfEquipment typeOfEquipment) {		
		typeOfEquipmentRepository.save(typeOfEquipment);
	}
	
	public List<TypeOfEquipment> findAll(){
		return typeOfEquipmentRepository.findAll();
	}
	
	
	
}
