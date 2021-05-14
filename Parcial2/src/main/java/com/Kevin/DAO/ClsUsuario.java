package com.Kevin.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.Kevin.ConexionBD.ConexionBD;
import com.Kevin.Entidades.Consulta;




public class ClsUsuario {
	
	ConexionBD conexion = new ConexionBD();
	Connection con = conexion.retornarConexion();
	
	
	
	
	public ArrayList<Consulta> ListadoUSUARIOS() {
		ArrayList<Consulta> Lista = new ArrayList<>();

		try {

			CallableStatement consulta = con.prepareCall("call Sp_S_SHOWCONSULTA()");
			ResultSet rs = consulta.executeQuery();
			while (rs.next()) {
				Consulta user = new Consulta();
				user.setId(rs.getInt("Id"));
				user.setNombre(rs.getString("Nombre"));
				user.setApellido(rs.getString("Apellido"));
				Lista.add(user);
			}
		} catch (Exception e) {
			
		}

		return Lista;
	}
	
	
	public void Eliminar(Consulta consulta) {

		try {
			CallableStatement statement = con.prepareCall("call SP_D_USER(?)");
			statement.setInt("pId", consulta.getId());
			statement.executeQuery();
			System.out.println("Exito");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}
	
	
	
	
	
	
}
