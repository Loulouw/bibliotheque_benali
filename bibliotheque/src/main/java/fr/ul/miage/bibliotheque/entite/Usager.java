package fr.ul.miage.bibliotheque.entite;
// Generated 8 oct. 2018 10:15:55 by Hibernate Tools 5.0.6.Final

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Usager generated by hbm2java
 */
@Entity
@Table(name = "usager", catalog = "bibliotheque")
public class Usager implements java.io.Serializable {

	private Integer id;
	private String prenom;
	private String nom;
	private String commune;
	private Date dateNaissance;
	private Set<Emprunt> emprunts = new HashSet<Emprunt>(0);
	private Set<Reservation> reservations = new HashSet<Reservation>(0);

	public Usager() {
	}

	public Usager(String prenom, String nom, String commune, Date dateNaissance) {
		this.prenom = prenom;
		this.nom = nom;
		this.commune = commune;
		this.dateNaissance = dateNaissance;
	}

	public Usager(String prenom, String nom, String commune, Date dateNaissance, Set<Emprunt> emprunts,
			Set<Reservation> reservations) {
		this.prenom = prenom;
		this.nom = nom;
		this.commune = commune;
		this.dateNaissance = dateNaissance;
		this.emprunts = emprunts;
		this.reservations = reservations;
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

	@Column(name = "prenom", nullable = false, length = 100)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "nom", nullable = false, length = 100)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "commune", nullable = false, length = 250)
	public String getCommune() {
		return this.commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_naissance", nullable = false, length = 19)
	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usager")
	public Set<Emprunt> getEmprunts() {
		return this.emprunts;
	}

	public void setEmprunts(Set<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usager")
	public Set<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

}
