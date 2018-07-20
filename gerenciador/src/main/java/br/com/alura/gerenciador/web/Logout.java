package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
//		Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();
		HttpSession session = req.getSession();
		PrintWriter writer = resp.getWriter();
		if(session == null){
			writer.println("<html><body>Usuario não estava logado</body></html>");
		}else{
//			cookie.setMaxAge(0);
//			resp.addCookie(cookie);
			session.invalidate();
			writer.println("<html><body>Usuario deslogado com sucesso</body></html>");

		}
	}
}
