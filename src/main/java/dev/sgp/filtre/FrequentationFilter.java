package dev.sgp.filtre;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import dev.sgp.entite.VisiteWeb;
import dev.sgp.util.Constantes;

@WebFilter(urlPatterns = { "/*" })
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
		Long init = System.currentTimeMillis();
		chain.doFilter(req, resp);
		long end = System.currentTimeMillis();
		Optional<VisiteWeb> optVisit = Constantes.VISIT_SERVICE.getVisits().stream()
				.filter(visit -> visit.getChemin().equals(requestURI)).findFirst();
		if (optVisit.isPresent()) {
			optVisit.get().update((end - init));
		} else {
			Constantes.VISIT_SERVICE.add(new VisiteWeb(requestURI, (end - init)));
		}
	}

	@Override
	public void destroy() {
	}

	public static Map<String, Integer> getNbVisites() {
		return nbVisites;
	}

}
