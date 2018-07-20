package br.com.alura.gerenciador.web;

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

@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		// String uri = req.getRequestURI();
		// String usuario = getUsuario(req);
		// Incurtando o código
		System.out.println("Usuario: " + getUsuario(req, resp)
				+ " acessando a URI: " + req.getRequestURI());

		// depois de filtrar segue com o request e responde
		chain.doFilter(request, response);

	}

	// METODO getUsuario
	private String getUsuario(HttpServletRequest req, HttpServletResponse resp) {

		Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();
		if (cookie == null) {
			return "<deslogado>";
		}
		cookie.setMaxAge(10 * 60);
		resp.addCookie(cookie);
		return cookie.getValue();
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
