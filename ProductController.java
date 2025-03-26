package com.ibm.jdbc_preparedstatement_crud.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.ibm.jdbc_preparedstatement_crud.connection.ProductConnection;
import com.ibm.jdbc_preparedstatement_crud.entity.Product;

public class ProductController {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Connection connection = ProductConnection.getProductConnection();
		
		while(true) {
			System.out.println("1.INSERT\n2.DELETE\n3.DISPLAYBYID");

			System.out.println("enter your option");

			int option = scanner.nextInt();

			switch (option) {

			case 1: {
				System.out.println("enter product id");
				int id = scanner.nextInt();
				System.out.println("enter product name");
				String name = scanner.next();
				System.out.println("enter product color");
				String color = scanner.next();
				System.out.println("enter product price");
				double price=scanner.nextDouble();
				
				Product product=new Product(id, name, color, price);
				
				String insertQuery = "insert into product(id,name,color,price) values(?,?,?,?)";
				
					try {
						PreparedStatement ps=connection.prepareStatement(insertQuery);
						ps.setInt(1, product.getId());
						ps.setString(2, product.getName());
						ps.setString(3, product.getColor());
						ps.setDouble(4, product.getPrice());
						
						ps.execute();
						
						System.out.println("data stored.....");
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("data not stored");
					}
			}
				break;

			case 2: {

			}
				break;

			case 3: {

			}
				break;
				
				default:{
					System.out.println("given option is invalid");
				}break;
			}
		}

	}
}
