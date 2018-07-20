package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		
		if(usuario == null){
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/loginInvalido.html");
			dispatcher.forward(req, resp);

		}else {
			//cria um cookie para o usuario com nome de usuario.logado fazendo referencia ao usuario.getEmail();
				//Cookie cookie = new Cookie("usuario.logado", usuario.getEmail());
			//seta uma idade em segundos para o cookie durar no caso 10 minutos
				//cookie.setMaxAge(10 * 60);
			//responde o cookie para o usuario ou seja, envia o cookie ao usuario
				//resp.addCookie(cookie);
			HttpSession session = req.getSession();
			session.setAttribute("usuario.logado", usuario);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/login.html");
			dispatcher.forward(req, resp);
		}
	}
}
