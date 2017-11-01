package dev.sgp.filtre;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FrequentationFilter implements Filter {

	private static Map<String, Integer> nbVisites = new HashMap<>();
	private FilterConfig config = null;

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		config.getServletContext().log("Frequentation filter initialized");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		String requestURI = request.getRequestURI();

		if (nbVisites.containsKey(requestURI)) {
			nbVisites.put(requestURI, nbVisites.get(requestURI) + 1);
		} else {
			nbVisites.put(requestURI, 1);
		}

		chain.doFilter(req, resp);
	}

	@Override
	public void destroy() {
	}

	public static Map<String, Integer> getNbVisites() {
		return nbVisites;
	}

}
