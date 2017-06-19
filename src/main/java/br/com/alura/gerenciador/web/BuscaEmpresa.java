package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns="/busca")
public class BuscaEmpresa extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3224711501804764529L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		String filtro = req.getParameter("filtro");
		Collection<Empresa> empresas= new EmpresaDAO().buscaPorSimilaridade(filtro);
		
		
		
		
		writer.println("<html><body>");
		writer.println("Resultado da busca");
		
		writer.println("<ul>");
		for (Empresa empresa : empresas) {
			writer.println("<li>");
			writer.println(empresa.getId());
			writer.println("  ");
			writer.println(empresa.getNome());			
			writer.println("</li>");
		}		
		writer.println("</ul>");
		writer.println("</body> </html>");
	}
	
	
	
	
	

}
