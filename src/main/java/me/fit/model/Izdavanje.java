package me.fit.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name=Izdavanje.GET_ALL_FOR_CLAN, query = "Select i from Izdavanje i where i.clan.id = :id")
})
public class Izdavanje {
	
	public static final String GET_ALL_FOR_CLAN = "getAllIzdavanjeForClan";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "izdavanje_seq")
	public Long id;
	
	@ManyToOne
	@JsonIgnore
	public Clan clan;
	public Date datumIznajmljivanja;
	public Date datumVracanja;
	
	public Izdavanje() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatumIznajmljivanja() {
		return datumIznajmljivanja;
	}

	public void setDatumIznajmljivanja(Date datumIznajmljivanja) {
		this.datumIznajmljivanja = datumIznajmljivanja;
	}

	public Date getDatumVracanja() {
		return datumVracanja;
	}

	public void setDatumVracanja(Date datumVracanja) {
		this.datumVracanja = datumVracanja;
	}
	
	
	
	

}
