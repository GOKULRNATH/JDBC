package EmployeeCRUD;

import java.util.Scanner;

import com.ty.StudentImplementation;
import com.ty.Studentinterface;

public class EmployeeDetails {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to employee Details");
		EmployeeInterface si=new EmployeeImplementation();
		while(true) {
			System.out.println("1.Save Employee\n2.Delete Employee\n3.Update Employee\n4.Get Employee whose experince >5\n5.Get all details\n6.Exit");
			System.out.println("Enter your choice : ");
			int choice=sc.nextInt();
			switch (choice) {
			case 1: 
				si.addEmp();
				break;
			case 2:
				si.deleteEmpByDesignation();
				break;
			case 3:
				si.updateEmp();
				break;
			case 4:
				si.getEmpexperinceGreater5();
				break;
			case 5:
				si.getAll();
			case 6:
				System.out.println("Thank you visit again");
				System.exit(0);
			default:
				System.out.println("invalid input");
			
			}
			
		}
	}

}
