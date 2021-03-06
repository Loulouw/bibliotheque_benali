package fr.ul.miage.bibliotheque.entite;
// Generated 8 oct. 2018 10:15:55 by Hibernate Tools 5.0.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Auteur generated by hbm2java
 */
@Entity
@Table(name = "auteur", catalog = "bibliotheque")
public class Auteur implements java.io.Serializable {

	private Integer id;
	private String prenom;
	private String nom;
	private Set<Oeuvre> oeuvres = new HashSet<Oeuvre>(0);

	public Auteur() {
	}

	public Auteur(String prenom, String nom) {
		this.prenom = prenom;
		this.nom = nom;
	}

	public Auteur(String prenom, String nom, Set<Oeuvre> oeuvres) {
		this.prenom = prenom;
		this.nom = nom;
		this.oeuvres = oeuvres;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "prenom", length = 100)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "nom", length = 100)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "auteur_has_oeuvre", catalog = "bibliotheque", joinColumns = {
			@JoinColumn(name = "auteur_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "oeuvre_id", nullable = false, updatable = false) })
	public Set<Oeuvre> getOeuvres() {
		return this.oeuvres;
	}

	public void setOeuvres(Set<Oeuvre> oeuvres) {
		this.oeuvres = oeuvres;
	}

	public String toString() {
		return prenom + " " + nom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
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
		Auteur other = (Auteur) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}
	
	

}
