package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employe;
import com.example.demo.services.EmployeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class EmployeController {
@Autowired
public EmployeService employeService;
@GetMapping("/employes")
public ArrayList<Employe> getEmployes(){
	return employeService.getEmployes();
}
@GetMapping("/employes/{empid}")
public Employe getEmploye(@PathVariable("empid") int empid) {
	
return employeService.getEmploye(empid);

}
@PostMapping("/employes")
  public Employe addEmploye(@RequestBody Employe employe ) { 
    return employeService.addEmploye(employe);
}

@PutMapping("employes/{empid}")
public Employe updateEmploye(@PathVariable("empid") int empid, @RequestBody Employe employe) {
    
    return employeService.updateEmploye(employe, empid);
}
@DeleteMapping("/employes/{empid}")
	public  Employe deleteEmploye(@PathVariable("empid") int empid) {
	return employeService.deleteEmploye(empid);
}
}
