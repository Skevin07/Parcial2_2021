package com.Kevin.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.Kevin.ConexionBD.ConexionBD;
import com.Kevin.Entidades.usuario;

public class LoginDAO {

	ConexionBD conexion = new ConexionBD();
	Connection con = conexion.retornarConexion();
	
	public boolean Login(usuario usu) {
		
		boolean verificar = false;
		
		try {
			CallableStatement consulta = con.prepareCall("call Sp_s_Login(?,?)");
			consulta.setString("PNombre", usu.getNombre());
			consulta.setString("PContrasena", usu.getContrasena());
			ResultSet resultado = consulta.executeQuery();
			
			if(resultado.next()) {
				verificar = true;
			}
		} catch (Exception e) {
			
		}
		
		return verificar;
	}
	
}
