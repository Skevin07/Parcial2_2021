package com.Kevin.ConexionBD;

import java.sql.*;


public class ConexionBD {
	private Connection conexion;

	public ConexionBD() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conexion = DriverManager.getConnection("jdbc:mysql://localhost/parcial3", "root", "root");
	            System.out.println("Conexion exitosa");

		} catch (Exception e) {
			System.out.println("ERROR DE CONEXION A LA BD " + e);
		}
	}

	public Connection retornarConexion() {
		return conexion;
	}

}