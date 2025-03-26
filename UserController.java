package com.jsp.jdbc_project_architecture_crud.controller;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jsp.jdbc_project_architecture_crud.connection.UserConnection;
import com.jsp.jdbc_project_architecture_crud.dao.UserDao;
import com.jsp.jdbc_project_architecture_crud.dto.User;
import com.jsp.jdbc_project_architecture_crud.service.UserService;

public class UserController {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		UserDao dao = new UserDao();
		
		UserService service = new UserService();
		
		Connection connection = UserConnection.getUserConnection();
		while (true) {
			System.out.println("1.INSERT\n2.DELETE\n3.DISPLAYBYID\n4.DISPLAYALLUSERS\n5.DISPLAYUSERDESCBYNAME\n6.SaveMultipleUser");

			System.out.println("enter your option");

			int option = scanner.nextInt();

			switch (option) {
			
			case 1:{
					System.out.println("enter user id");
					int id = scanner.nextInt();
					scanner.nextLine();
					System.out.println("enter user name");
					String name = scanner.nextLine();
					System.out.println("enter user email");
					String email = scanner.nextLine();
					System.out.println("enter user address");
					String address = scanner.nextLine();
					//pass dob in this format "yyyy-MM-dd"
					System.out.println("enter user dob");
					String dob=scanner.next();
					
					LocalDate dob1=LocalDate.parse(dob);
					
					User user=new User(id, name, email, address, dob1);
					
					User saveUser=service.saveUserService(user);
					
					if(saveUser!=null) {
						System.out.println("user data inserted");
					}else {
						System.out.println("user data not inserted ....something went wrong");
					}
					
			}break;
			
			case 2:{
				System.out.println("enter user id to delete");
				int id = scanner.nextInt();
				boolean b=dao.deleteUserByIdDao(id);
				if(b) {
					System.out.println("Data Deleted");
				}else {
					System.out.println("given id not found");
				}
			}break;
			
			case 3:{
				System.out.println("enter user id to display");
				int id = scanner.nextInt();
				User user=dao.getUserByIdDao(id);
				
				if(user!=null) {
					System.out.println(user);
				}else {
					System.out.println("given id is not found......");
				}
			}break;
			
			case 4:{
				List<User> users=dao.getAllUserDao();
				
				for (User user : users) {
					System.out.println(user);
				}
			}break;
			
			case 5:{
				List<User> users=service.sortAllUserDataByNameDESC();
				
				users.forEach(user->System.out.println(user));
			}break;
			
			case 6:{
				
				System.out.println("enter how many users you want to add");
				int size  = scanner.nextInt();
				
				List<User> users = new ArrayList<User>();
				
				for(int i=1;i<=size;i++) {
					System.out.println("enter "+i+" user details");
					
					System.out.println("enter user id");
					int id = scanner.nextInt();
					scanner.nextLine();
					System.out.println("enter user name");
					String name = scanner.nextLine();
					System.out.println("enter user email");
					String email = scanner.nextLine();
					System.out.println("enter user address");
					String address = scanner.nextLine();
					//pass dob in this format "yyyy-MM-dd"
					System.out.println("enter user dob");
					String dob=scanner.next();
					
					LocalDate dob1=LocalDate.parse(dob);
					
					users.add(new User(id, name, email, address, dob1));
				}
				
				List<User> users2=dao.saveMultipleUserDao(users);
				
				if(users2!=null) {
					System.out.println("Data persisted");
				}
				
			}break;
			
			}
		}

	}

}
