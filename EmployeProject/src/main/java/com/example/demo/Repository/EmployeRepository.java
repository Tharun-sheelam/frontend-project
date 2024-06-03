package com.example.demo.Repository;

import java.util.ArrayList;

import com.example.demo.model.Employe;

public interface EmployeRepository {
	public ArrayList<Employe> getEmployes();
	public Employe getEmploye(int empid);
	public Employe updateEmploye(Employe employe,int empid);
	public Employe deleteEmploye(int empid);
}
