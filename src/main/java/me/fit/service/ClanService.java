package me.fit.service;

import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.enums.ClanStatus;
import me.fit.exception.ClanException;
import me.fit.model.Clan;

@Dependent
public class ClanService {
	
	@Inject
	private EntityManager em;
	
	@Transactional
	public Clan createClan(Clan c) throws ClanException {
		List<Clan> clanovi = getAllClan();

		if (clanovi.contains(c)) {
			throw new ClanException(ClanStatus.EXISTS.getLabel());
		}

		return em.merge(c);
	}
	
	@Transactional
	public List<Clan> getAllClan() {
		return em.createNamedQuery(Clan.GET_ALL_CLAN, Clan.class).getResultList();
	}
	
}
