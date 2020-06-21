package pl.project.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.project.model.RepairRequest;
import pl.project.service.RepairRequestService;

@Controller
public class RepairServiceController {
	RepairRequestService repairRequestService;

	public RepairServiceController(RepairRequestService repairRequestService) {
		super();
		this.repairRequestService = repairRequestService;
	}
	
	@GetMapping("/repairRequest")
	public String register(Model model) {
		model.addAttribute("repairrequest", new RepairRequest());
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
