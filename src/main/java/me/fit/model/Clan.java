package me.fit.model;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@Entity
@NamedQueries({ 
	@NamedQuery(name = Clan.GET_ALL_CLAN, query = "Select c from Clan c"),
	})
public class Clan {
	
	public static final String GET_ALL_CLAN = "getAllClan";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ime;
	private String prezime;
	private String adresa;
	private String email;
	private String telefon;
	private Date datumUclanjenja;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "clan_id")
	private Set<Izdavanje> izdavanje;
	
	
	public Set<Izdavanje> getIzdavanje() {
		return izdavanje;
	}

	public void setIzdavanje(Set<Izdavanje> izdavanje) {
		this.izdavanje = izdavanje;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getIme() {
		return ime;
	}
	
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public String getAdresa() {
		return adresa;
	}
	
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefon() {
		return telefon;
	}
	
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	public Date getDatumUclanjenja() {
		return datumUclanjenja;
	}
	
	public void setDatumUclanjenja(Date datumUclanjenja) {
		this.datumUclanjenja = datumUclanjenja;
	}

	@Override
	public String toString() {
		return "Clan [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", adresa=" + adresa + ", email=" + email
				+ ", telefon=" + telefon + ", datumUclanjenja=" + datumUclanjenja + "]";
	}
	
	
	
	
	
	

}
