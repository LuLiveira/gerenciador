package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		if(session == null){

			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/logoutInvalido.html");
			dispatcher.forward(req, resp);

		}else{
//			cookie.setMaxAge(0);
//			resp.addCookie(cookie);
			session.invalidate();
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/logout.html");
			dispatcher.forward(req, resp);


		}
	}
}
