package com.Kevin.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;


import com.Kevin.ConexionBD.ConexionBD;
import com.Kevin.Entidades.usuario;


public class ClsUsuario {
	
	ConexionBD conexion = new ConexionBD();
	Connection con = conexion.retornarConexion();
	
	
	
	public void Eliminar(usuario user) {

		try {
			CallableStatement statement = con.prepareCall("call SP_D_USER(?)");
			statement.setInt("pId", user.getId());
			statement.executeQuery();
			System.out.println("Exito");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}
	
	
	
	
	
	
}
