package pl.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javassist.expr.NewArray;
import pl.project.model.TypeOfEquipment;
import pl.project.service.TypeOfEquipmentService;

@Controller
public class TypeOfEquipmentController {
	TypeOfEquipmentService typeOfEquipmentService;
	
	@Autowired
	public void setTypeOfEquipmentService(TypeOfEquipmentService typeOfEquipmentService) {
		this.typeOfEquipmentService = typeOfEquipmentService;
	}
	
	@GetMapping("/manageEquipment")
	public String showEquipment(Model model) {
		List<TypeOfEquipment> typeOfEquipments = typeOfEquipmentService.findAll();
		model.addAttribute("typeOfEquipment", typeOfEquipments);
		return "manageEquipmentForm";
	}
	@GetMapping("/equipment")
	public String addEquipment(Model model) {	
		model.addAttribute("typeofequipment", new TypeOfEquipment());
		return "equipmentForm";
	}
	
	@PostMapping("/equipment")
	public String addType(@ModelAttribute @Valid TypeOfEquipment typeOfEquipment,
			BindingResult bindResult) {
		if(bindResult.hasErrors())
			return "equipmentForm";
		else {
			typeOfEquipmentService.addEquipment(typeOfEquipment);
			return "addSuccess";
		}
	}
}
