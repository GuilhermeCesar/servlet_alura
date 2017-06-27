package br.com.alura.gerenciador.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.utils.Coockies;

@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chains)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String uri = httpRequest.getRequestURI();
		HttpSession session = httpRequest.getSession();	
		
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuario.logado");
		
		String usuario = "<deslogado>";
		
		if(usuarioLogado!=null){
			usuario= usuarioLogado.getEmail();
		}
				
		System.out.println("O usuário"+usuario+" esta utilizando a URI ".concat(uri));
		
		chains.doFilter(request, response);
	}	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
