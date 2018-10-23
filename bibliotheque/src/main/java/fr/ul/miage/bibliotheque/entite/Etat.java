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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Etat generated by hbm2java
 */
@Entity
@Table(name = "etat", catalog = "bibliotheque", uniqueConstraints = @UniqueConstraint(columnNames = "libelle"))
public class Etat implements java.io.Serializable {

	private Integer id;
	private String libelle;
	private Set<Exemplaire> exemplaires = new HashSet<Exemplaire>(0);

	public Etat() {
	}

	public Etat(String libelle) {
		this.libelle = libelle;
	}

	public Etat(String libelle, Set<Exemplaire> exemplaires) {
		this.libelle = libelle;
		this.exemplaires = exemplaires;
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

	@Column(name = "libelle", unique = true, nullable = false, length = 50)
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "etat")
	public Set<Exemplaire> getExemplaires() {
		return this.exemplaires;
	}

	public void setExemplaires(Set<Exemplaire> exemplaires) {
		this.exemplaires = exemplaires;
	}

}
