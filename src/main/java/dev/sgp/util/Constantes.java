package dev.sgp.util;

import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.service.VisiteWebService;

public interface Constantes {
	/** DEPART_SERVICE : DepartementService */
	DepartementService DEPART_SERVICE = new DepartementService();
	/** COLLAB_SERVICE : CollaborateurService */
	CollaborateurService COLLAB_SERVICE = new CollaborateurService();
	/** VISIT_SERVICE : VisiteWebService */
	VisiteWebService VISIT_SERVICE = new VisiteWebService();

}
