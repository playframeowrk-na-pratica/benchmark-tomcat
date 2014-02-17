package br.com.caelum.exemplo;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/webservice")
public class WebServiceServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		URL url = new URL("https://www.google.com.br/?gfe_rd=cr&ei=oWsBU6n8E8Ki8we43IDoCA#q=federer");
		InputStream content = url.openConnection().getInputStream();
		response.setStatus(200);
		
	}
}
