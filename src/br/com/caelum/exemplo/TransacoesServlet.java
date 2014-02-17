package br.com.caelum.exemplo;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/transacoes")
public class TransacoesServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Connection connection = ConnectionFactory.getConnectionFromPool();
		List<Transacao> transacoes = new Transacoes(connection).ultimas(Integer
				.parseInt(request.getParameter("quantidade")));		
		ConnectionFactory.close(connection);
		request.setAttribute("txs",transacoes);
		request.getRequestDispatcher("/WEB-INF/jsp/lista.jsp").forward(request,response);
	}
}
