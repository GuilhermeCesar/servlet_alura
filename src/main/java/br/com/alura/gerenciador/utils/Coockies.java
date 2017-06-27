package br.com.alura.gerenciador.utils;

import javax.servlet.http.Cookie;

public class Coockies {
	
	private Cookie[] cookies;

	public Coockies(Cookie[] cookies) {
		super();
		this.cookies = cookies;
	}
	
	public Cookie getUsuarioLogado() {
		if(this.cookies==null){
			return null;
		}
		
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("usuario.logado")){
				return cookie;
			}
		}
		
		return null;		
	}	

}
