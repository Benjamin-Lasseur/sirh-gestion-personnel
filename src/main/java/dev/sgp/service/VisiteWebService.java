package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.VisiteWeb;

public class VisiteWebService {

	List<VisiteWeb> listVisit = new ArrayList<>();

	public void add(VisiteWeb visit) {
		listVisit.add(visit);
	}

	public List<VisiteWeb> getVisits() {
		return listVisit;
	}
}
