package me.fit.model.rest.client;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = Autor.GET_ALL, query = "Select a from Autor a")
})
public class Autor {
	
	public static final String GET_ALL = "Autor.getAll";
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "autor_seq")
	@JsonIgnore
	private Long id;
	private String ime;
	private String prezime;
	private Date datumRodjenja;
	private String zemlja;
	
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
	
	public Date getDatumRodjenja() {
		return datumRodjenja;
	}
	
	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	
	public String getZemlja() {
		return zemlja;
	}
	
	public void setZemlja(String zemlja) {
		this.zemlja = zemlja;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", datumRodjenja=" + datumRodjenja
				+ ", zemlja=" + zemlja + "]";
	}
}
