package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Repository.EmployeJpaRepository;
import com.example.demo.Repository.EmployeRepository;
import com.example.demo.model.Employe;
@Service
public class EmployeService implements EmployeRepository{
@Autowired
public EmployeJpaRepository employeJpaRepository;

	public ArrayList<Employe> getEmployes(){
		List<Employe> employelist=employeJpaRepository.findAll();
		ArrayList<Employe> employes=new ArrayList<>(employelist);
		return employes;	
	}
	public Employe getEmploye(int empid) {
		try {
			 Employe employe=employeJpaRepository.findById(empid).get();
			return employe;
		}
		catch(Exception e) {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
  }
	public Employe addEmploye(Employe employe) {
		employeJpaRepository.save(employe);
		return employe;
	}
	public Employe updateEmploye(Employe employe,int empid) {
		Employe existingEmploye=employeJpaRepository.findById(empid).get();
		try {
			if(existingEmploye!=null) {
				existingEmploye.setName(employe.getName());
			}
			if(existingEmploye!=null) {
				existingEmploye.setCompany(employe.getCompany());
			}
			employeJpaRepository.save(employe);
			return employe;
	   }
          catch(Exception e) {
        	  throw new ResponseStatusException(HttpStatus.NOT_FOUND);
          }
			
		}
	public Employe deleteEmploye(int empid) {
		try {
			employeJpaRepository.deleteById(empid);
			throw new ResponseStatusException(HttpStatus.NO_CONTENT);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
}

