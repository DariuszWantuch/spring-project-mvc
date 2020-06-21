package pl.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.project.model.TypeOfEquipment;
import pl.project.service.TypeOfEquipmentService;

@Controller
public class TypeOfEquipmentController {
	TypeOfEquipmentService typeOfEquipmentService;
	
	@Autowired
	public void setTypeOfEquipmentService(TypeOfEquipmentService typeOfEquipmentService) {
		this.typeOfEquipmentService = typeOfEquipmentService;
	}
	
	@GetMapping("/equipment")
	public String register(Model model) {
		model.addAttribute("typeofequipment", new TypeOfEquipment());
		return "equipmentForm";
	}
	
	@PostMapping("/equipment")
	public String addUser(@ModelAttribute @Valid TypeOfEquipment typeOfEquipment,
			BindingResult bindResult) {
		if(bindResult.hasErrors())
			return "equipmentForm";
		else {
			typeOfEquipmentService.addEquipment(typeOfEquipment);
			return "addSuccess";
		}
	}
}
