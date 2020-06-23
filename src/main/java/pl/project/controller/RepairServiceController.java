package pl.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import pl.project.model.RepairRequest;
import pl.project.model.TypeOfEquipment;
import pl.project.service.RepairRequestService;
import pl.project.service.TypeOfEquipmentService;


@Controller
public class RepairServiceController {
	RepairRequestService repairRequestService;	
	TypeOfEquipmentService typeOfEquipmentService;

	public RepairServiceController(RepairRequestService repairRequestService, TypeOfEquipmentService typeOfEquipmentService) {
		super();
		this.repairRequestService = repairRequestService;
		this.typeOfEquipmentService = typeOfEquipmentService;
	}
	
	@GetMapping("/repairRequest")
	public String register(Model model) {
		List<TypeOfEquipment> typeOfEquipments = typeOfEquipmentService.findAll();
		model.addAttribute("repairrequest", new RepairRequest());
		model.addAttribute("typeOfEquipments", typeOfEquipments);
		return "repairRequestForm";
	}
	
	@PostMapping("/repairRequest")
	public String addRequest(@ModelAttribute @Valid RepairRequest repairRequest,
			BindingResult bindResult) {
		if(bindResult.hasErrors())
			return "repairRequestForm";
		else {
			repairRequestService.addRequest(repairRequest);
			return "addRequestSuccess";
		}
	}
}
