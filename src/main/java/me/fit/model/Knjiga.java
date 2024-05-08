package me.fit.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import me.fit.model.rest.client.IPLog;

@Entity
public class Knjiga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String naziv;
    
    private int godinaIzdanja;
    
    @OneToMany(mappedBy = "knjiga")
    private Set<Izdavanje> izdavanja;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
    	name = "knjiga_autor",
    	joinColumns = @JoinColumn(name = "knjiga_id"),
    	inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private Set<Autor> autori;
    
    
    @ManyToMany
    @JoinTable(
        name = "knjiga_jezik",
        joinColumns = @JoinColumn(name = "knjiga_id"),
        inverseJoinColumns = @JoinColumn(name = "jezik_id")
    )
    private Set<Jezik> jezici;
    
    @OneToOne(cascade = CascadeType.ALL)
    private IPLog iplog;
    
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

    public int getGodinaIzdanja() {
        return godinaIzdanja;
    }

    public void setGodinaIzdanja(int godinaIzdanja) {
        this.godinaIzdanja = godinaIzdanja;
    }

    public Set<Autor> getAutori() {
        return autori;
    }

    public void setAutori(Set<Autor> autori) {
        this.autori = autori;
    }

	public Set<Izdavanje> getIzdavanja() {
		return izdavanja;
	}

	public void setIzdavanja(Set<Izdavanje> izdavanja) {
		this.izdavanja = izdavanja;
	}

	public Set<Jezik> getJezici() {
		return jezici;
	}

	public void setJezici(Set<Jezik> jezici) {
		this.jezici = jezici;
	}

	public IPLog getIplog() {
		return iplog;
	}

	public void setIplog(IPLog iplog) {
		this.iplog = iplog;
	}

	@Override
	public String toString() {
		return "Knjiga [id=" + id + ", naziv=" + naziv + ", godinaIzdanja=" + godinaIzdanja + ", izdavanja=" + izdavanja
				+ ", autori=" + autori + ", jezici=" + jezici + "]";
	}

	

	

    
    
}
