package me.fit.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Jezik {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String naziv;
	
	@ManyToMany(mappedBy = "jezici")
	private Set<Knjiga> knjige;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Set<Knjiga> getKnjige() {
		return knjige;
	}

	public void setKnjige(Set<Knjiga> knjige) {
		this.knjige = knjige;
	}

	@Override
	public String toString() {
		return "Jezik [id=" + id + ", naziv=" + naziv + ", knjige=" + knjige + "]";
	}
	
	
	
	
	

}
