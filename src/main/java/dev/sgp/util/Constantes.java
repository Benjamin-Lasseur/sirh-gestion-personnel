package dev.sgp.util;

import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;

public interface Constantes {
	DepartementService DEPART_SERVICE = new DepartementService();
	CollaborateurService COLLAB_SERVICE = new CollaborateurService();
	
}
