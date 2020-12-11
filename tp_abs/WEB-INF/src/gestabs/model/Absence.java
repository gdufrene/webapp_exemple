package gestabs.model;

import java.time.LocalDate;

public class Absence {
	
	int ano;
	LocalDate jour;
	Personne enseignant;
	Personne etudiant;
	
	
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public LocalDate getJour() {
		return jour;
	}
	public void setJour(LocalDate jour) {
		this.jour = jour;
	}
	public Personne getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Personne enseignant) {
		this.enseignant = enseignant;
	}
	public Personne getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Personne etudiant) {
		this.etudiant = etudiant;
	}
	
	@Override
	public String toString() {
		return "Absence [ano=" + ano + ", jour=" + jour + ", enseignant=" + enseignant + ", etudiant=" + etudiant + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ano;
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
		Absence other = (Absence) obj;
		if (ano != other.ano)
			return false;
		return true;
	}

}
