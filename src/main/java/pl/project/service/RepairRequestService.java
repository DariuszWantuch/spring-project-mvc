package pl.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.project.model.RepairRequest;
import pl.project.repository.RepairRequestRepository;


@Service
public class RepairRequestService {
	
	private RepairRequestRepository repairRequestRepository;

	
	@Autowired
	public void setRepairRequestRepository(RepairRequestRepository repairRequestRepository) {
		this.repairRequestRepository = repairRequestRepository;
	}
	
	
	public void addRequest(RepairRequest repairRequest) {		
		repairRequestRepository.save(repairRequest);
	}
	
	public List<RepairRequest> findAll(){
		return repairRequestRepository.findAll();
	}
}
