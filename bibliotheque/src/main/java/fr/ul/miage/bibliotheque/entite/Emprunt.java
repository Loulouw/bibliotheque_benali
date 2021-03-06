package fr.ul.miage.bibliotheque.entite;
// Generated 8 oct. 2018 10:15:55 by Hibernate Tools 5.0.6.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Emprunt generated by hbm2java
 */
@Entity
@Table(name = "emprunt", catalog = "bibliotheque")
public class Emprunt implements java.io.Serializable {

	private Integer id;
	private Exemplaire exemplaire;
	private Usager usager;
	private Date dateEmprunt;
	private Date dateRetour;
	private Date dateRendu;
	private int empruntRendu;

	public Emprunt() {
	}

	public Emprunt(Exemplaire exemplaire, Usager usager, Date dateEmprunt, Date dateRetour, Date dateRendu,
			int empruntRendu) {
		this.exemplaire = exemplaire;
		this.usager = usager;
		this.dateEmprunt = dateEmprunt;
		this.dateRetour = dateRetour;
		this.dateRendu = dateRendu;
		this.empruntRendu = empruntRendu;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_exemplaire", nullable = false)
	public Exemplaire getExemplaire() {
		return this.exemplaire;
	}

	public void setExemplaire(Exemplaire exemplaire) {
		this.exemplaire = exemplaire;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usager", nullable = false)
	public Usager getUsager() {
		return this.usager;
	}

	public void setUsager(Usager usager) {
		this.usager = usager;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_emprunt", nullable = false, length = 19)
	public Date getDateEmprunt() {
		return this.dateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_retour", nullable = false, length = 19)
	public Date getDateRetour() {
		return this.dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_rendu", nullable = true, length = 19)
	public Date getDateRendu() {
		return this.dateRendu;
	}

	public void setDateRendu(Date dateRendu) {
		this.dateRendu = dateRendu;
	}

	@Column(name = "emprunt_rendu", nullable = false)
	public int getEmpruntRendu() {
		return this.empruntRendu;
	}

	public void setEmpruntRendu(int empruntRendu) {
		this.empruntRendu = empruntRendu;
	}
	
	public String toString() {
		return usager.getNom() + " : " + exemplaire.getOeuvre().getTitre();
	}

}
