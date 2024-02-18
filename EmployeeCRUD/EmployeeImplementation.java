package EmployeeCRUD;

import java.security.DrbgParameters.NextBytes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class EmployeeImplementation implements EmployeeInterface {

	Scanner sc = new Scanner(System.in);

	@Override
	public void addEmp() {
		System.out.println("Enter the student id");
		int id = sc.nextInt();
		System.out.println("Enter the student name");
		String name = sc.next();
		System.out.println("Enter the student age");
		int age = sc.nextInt();
		System.out.println("Enter the student designation");
		String desig = sc.next();
		System.out.println("Enter the student experience");
		int exp = sc.nextInt();
		System.out.println("Enter the student sal");
		double sal = sc.nextDouble();

		// JDBC
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeecrud", "root",
					"root");
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into employee values(?,?,?,?,?,?)");
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setInt(3, age);
			preparedStatement.setString(4, desig);
			preparedStatement.setInt(5, exp);
			preparedStatement.setDouble(6, sal);
			preparedStatement.execute();
			System.out.println("Details added Successfully.....!");
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmpByDesignation() {
		System.out.println("Enter the designation of employee you want to delete");
		String desig = sc.next();
		// JDBC
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeecrud", "root",
					"root");
			PreparedStatement preparedStatement = connection.prepareStatement("delete from employee where desig=?");
			preparedStatement.setString(1, desig);
			preparedStatement.execute();
			System.out.println("Data deleted Successfully.....!");
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateEmp() {
		System.out.println("1.Update Salary\n2.Update designation \n3.Update experience\n4.Exit");
		System.out.println("Enter your choice");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter the employee id :");
			int id = sc.nextInt();
			System.out.println("Enter the employee salary to update :");
			Double sal = sc.nextDouble();
			// JDBC
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeecrud", "root",
						"root");
				PreparedStatement preparedStatement = connection
						.prepareStatement("update employee set salary=? where id=?");
				preparedStatement.setInt(2, id);
				preparedStatement.setDouble(1, sal);
				preparedStatement.execute();
				System.out.println("Updated salary Successfully.....!");
				connection.close();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case 2:
			System.out.println("Enter the employee id :");
			int id1 = sc.nextInt();
			System.out.println("Enter the employee Designation to update :");
			String desig= sc.next();
			// JDBC
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeecrud", "root",
						"root");
				PreparedStatement preparedStatement = connection
						.prepareStatement("update employee set desig=? where id=?");
				preparedStatement.setInt(2, id1);
				preparedStatement.setString(1, desig);
				preparedStatement.execute();
				System.out.println("Updated designation Successfully.....!");
				connection.close();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case 3:
			System.out.println("Enter the employee id :");
			int id2 = sc.nextInt();
			System.out.println("Enter the employee experience to update :");
			int exp= sc.nextInt();
			// JDBC
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeecrud", "root",
						"root");
				PreparedStatement preparedStatement = connection
						.prepareStatement("update employee set experience=? where id=?");
				preparedStatement.setInt(2, id2);
				preparedStatement.setInt(1, exp);
				preparedStatement.execute();
				System.out.println("Updated designation Successfully.....!");
				connection.close();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 4:
			System.out.println("Thank you visit again");
			System.exit(0);
		default:
			System.out.println("invalid input");

		}

	}

	@Override
	public void getEmpexperinceGreater5() {
		// JDBC
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeecrud", "root",
					"root");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where experience>5");
			ResultSet resultset=preparedStatement.executeQuery();
			while(resultset.next()) {
				System.out.println("Student id : "+resultset.getInt(1));
				System.out.println("Student name : "+resultset.getString(2));
				System.out.println("Student age : "+resultset.getInt(3));
				System.out.println("Student Designation : "+resultset.getString(4));
				System.out.println("Student expirence : "+resultset.getInt(5));
				System.out.println("Student salary : "+resultset.getDouble(6));

				System.out.println("====================================================\n");
			}
			System.out.println("These are the data.....!");
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void getAll() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeecrud", "root",
					"root");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from employee");
			ResultSet resultset=preparedStatement.executeQuery();
			while(resultset.next()) {
				System.out.println("Student id : "+resultset.getInt(1));
				System.out.println("Student name : "+resultset.getString(2));
				System.out.println("Student age : "+resultset.getInt(3));
				System.out.println("Student Designation : "+resultset.getString(4));
				System.out.println("Student expirence : "+resultset.getInt(5));
				System.out.println("Student salary : "+resultset.getDouble(6));

				System.out.println("====================================================\n");
			}
			System.out.println("These are the data.....!");
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
