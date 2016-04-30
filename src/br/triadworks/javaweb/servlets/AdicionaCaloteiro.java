
package br.triadworks.javaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.triadworks.javaweb.dao.CaloteiroDAO;
import br.triadworks.javaweb.modelo.Caloteiro;

@SuppressWarnings("serial")
@WebServlet("/adicionaCaloteiro")
public class AdicionaCaloteiro extends HttpServlet {

	protected void service(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
		
		PrintWriter out = response.getWriter();
		
		String nome= request.getParameter("nome");
		String email= request.getParameter("email");
		String devendo = request.getParameter("devendo");
		String dataDivida = request.getParameter("dataDivida");
		
		Calendar dataDividaConvertida = null;
		
		try {
			
			java.util.Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataDivida);
			dataDividaConvertida = Calendar.getInstance();
			dataDividaConvertida.setTime(data);
		} catch (Exception e) {
			out.println("Erro de conversao de data");
			throw new CaloteiroServletException();									
		}
		
		Caloteiro caloteiro = new Caloteiro();
		caloteiro.setNome(nome);
		caloteiro.setEmail(email);
		caloteiro.setDevendo(new Integer(devendo));
		caloteiro.setDataDivida(dataDividaConvertida);
		
		
		CaloteiroDAO dao = new CaloteiroDAO();
		dao.adicionar(caloteiro);
		
		
		
		out.println("<html>");
		out.println("<body>");
		out.println("Caloteiro " + caloteiro.getNome() + " adicionado com sucesso");
		out.println("</body>");
		out.println("</html>");
		
		
		
	}
	
}
