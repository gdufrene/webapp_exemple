package gestabs.model;

import java.time.LocalDate;

public class Justificatif {

	int jno;
	LocalDate debut;
	LocalDate fin;
	String raison;
	Personne etudiant;
	Personne secretaire;
	
	public int getJno() {
		return jno;
	}
	public void setJno(int jno) {
		this.jno = jno;
	}
	public LocalDate getDebut() {
		return debut;
	}
	public void setDebut(LocalDate debut) {
		this.debut = debut;
	}
	public LocalDate getFin() {
		return fin;
	}
	public void setFin(LocalDate fin) {
		this.fin = fin;
	}
	public String getRaison() {
		return raison;
	}
	public void setRaison(String raison) {
		this.raison = raison;
	}
	public Personne getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Personne etudiant) {
		this.etudiant = etudiant;
	}
	public Personne getSecretaire() {
		return secretaire;
	}
	public void setSecretaire(Personne secretaire) {
		this.secretaire = secretaire;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + jno;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Justificatif other = (Justificatif) obj;
		if (jno != other.jno)
			return false;
		return true;
	}
	
	
}
