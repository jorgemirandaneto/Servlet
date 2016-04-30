package br.triadworks.javaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/contador")
public class ServletContador extends HttpServlet {

	private int contador = 0;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		contador++;

		PrintWriter saida = response.getWriter();
		saida.println("<html>");
		saida.println("<body>");
		saida.println("Servlet de número: " + contador);
		saida.println("</body>");
		saida.println("</html>");
	}
}
