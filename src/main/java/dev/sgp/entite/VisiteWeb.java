package dev.sgp.entite;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class VisiteWeb {
	private int nbConnections;
	private String chemin;
	private long tempsExecutionMax;
	private long tempsExecutionMin;
	private long tempsExecutionMoyen;
	private List<Long> temps = new ArrayList<>();

	public VisiteWeb(String chemin, long tempsExecution) {
		this.chemin = chemin;
		this.tempsExecutionMoyen = tempsExecution;
		this.temps.add(tempsExecution);
		this.tempsExecutionMax = tempsExecution;
		this.tempsExecutionMin = tempsExecution;
		this.nbConnections = 1;
	}

	public void update(long tempsExecution) {
		this.nbConnections++;
		if (this.tempsExecutionMin > tempsExecution) {
			this.tempsExecutionMin = tempsExecution;
		}
		if (this.tempsExecutionMax < tempsExecution) {
			this.tempsExecutionMax = tempsExecution;
		}
		this.temps.add(tempsExecution);
		OptionalDouble optAverage = this.temps.stream().mapToDouble(t -> t).average();
		if (optAverage.isPresent()) {
			this.tempsExecutionMoyen = (long) optAverage.getAsDouble();
		}

	}

	/**
	 * @return the nbConnections
	 */
	public int getNbConnections() {
		return nbConnections;
	}

	/**
	 * @param nbConnections
	 *            the nbConnections to set
	 */
	public void setNbConnections(int nbConnections) {
		this.nbConnections = nbConnections;
	}

	/**
	 * @return the chemin
	 */
	public String getChemin() {
		return chemin;
	}

	/**
	 * @param chemin
	 *            the chemin to set
	 */
	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	/**
	 * @return the tempsExecutionMax
	 */
	public long getTempsExecutionMax() {
		return tempsExecutionMax;
	}

	/**
	 * @param tempsExecutionMax
	 *            the tempsExecutionMax to set
	 */
	public void setTempsExecutionMax(long tempsExecutionMax) {
		this.tempsExecutionMax = tempsExecutionMax;
	}

	/**
	 * @return the tempsExecutionMin
	 */
	public long getTempsExecutionMin() {
		return tempsExecutionMin;
	}

	/**
	 * @param tempsExecutionMin
	 *            the tempsExecutionMin to set
	 */
	public void setTempsExecutionMin(long tempsExecutionMin) {
		this.tempsExecutionMin = tempsExecutionMin;
	}

	/**
	 * @return the tempsExecutionMoyen
	 */
	public long getTempsExecutionMoyen() {
		return tempsExecutionMoyen;
	}

	/**
	 * @param tempsExecutionMoyen
	 *            the tempsExecutionMoyen to set
	 */
	public void setTempsExecutionMoyen(long tempsExecutionMoyen) {
		this.tempsExecutionMoyen = tempsExecutionMoyen;
	}

	/**
	 * @return the temps
	 */
	public List<Long> getTemps() {
		return temps;
	}

	/**
	 * @param temps
	 *            the temps to set
	 */
	public void setTemps(List<Long> temps) {
		this.temps = temps;
	}

}
