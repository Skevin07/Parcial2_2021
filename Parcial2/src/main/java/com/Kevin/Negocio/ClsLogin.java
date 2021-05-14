package com.Kevin.Negocio;

import com.Kevin.DAO.LoginDAO;
import com.Kevin.Entidades.usuario;

public class ClsLogin {
	
	
	
public int VerificarUsuario(usuario usuario) {
		
		int Acceso = 0;
		LoginDAO validacion = new LoginDAO();
		
		var validar = validacion.Login(usuario);
		
		if(validar == true) {
			Acceso = 1;
		}
		
		return Acceso;
	}

}
