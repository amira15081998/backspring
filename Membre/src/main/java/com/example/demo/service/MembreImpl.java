package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.PublicationBean;
import com.example.demo.entity.EnseignantChercheur;
import com.example.demo.entity.Etudiant;
import com.example.demo.entity.Membre;
import com.example.demo.entity.PublicationMembreIds;
import com.example.demo.entity.Publication_Membre;
import com.example.demo.proxy.PublicationProxyService;
import com.example.demo.repository.EnseignantChercheurRepository;
import com.example.demo.repository.EtudiantRepository;
import com.example.demo.repository.MemberPubRepository;
import com.example.demo.repository.MembreRepository;

@Service
public class MembreImpl implements IMembreService {
	@Autowired
	MembreRepository membreRepository;
	EnseignantChercheurRepository chercheurRepository;
	EtudiantRepository etudiantRepository;
	@Autowired
	MemberPubRepository memberpubrep;
	@Autowired
	PublicationProxyService proxy;

	@Override
	public Membre addMembre(Membre m) {
		membreRepository.save(m);
		return m;
	}

	@Override
	public void deleteMembre(Long id) {
		membreRepository.deleteById(id);

	}

	@Override
	public Membre updateMembre(Membre p) {
		return membreRepository.saveAndFlush(p);
	}

	@Override
	public Membre findMember(Long id) {
		Membre m = (Membre) membreRepository.findById(id).get();
		return m;
	}

	@Override
	public List<Membre> findAll() {
		return membreRepository.findAll();
	}

	@Override
	public Membre findByCin(String cin) {
		return membreRepository.findByCin(cin);
	}

	@Override
	public Membre findByEmail(String email) {
		return membreRepository.findByEmail(email);
	}

	@Override
	public List<Membre> findByNom(String nom) {
		return membreRepository.findByNom(nom);
	}

	@Override
	public List<Etudiant> findByDiplome(String diplome) {
		return etudiantRepository.findByDiplome(diplome);
	}

	@Override
	public List<EnseignantChercheur> findByGrade(String grade) {
		return chercheurRepository.findByGrade(grade);
	}

	@Override
	public List<EnseignantChercheur> findByEtablissement(String etablissement) {
		return chercheurRepository.findByEtablissement(etablissement);
	}

	@Override
	public void affecterauteurTopublication(Long idauteur, Long idpub) {
		Membre mbr = membreRepository.findById(idauteur).get();
		Publication_Membre mbs = new Publication_Membre();
		mbs.setAuteur(mbr);
		mbs.setId(new PublicationMembreIds(idpub, idauteur));
		memberpubrep.save(mbs);
	}

	@Override
	public List<PublicationBean> findPublicationparauteur(Long idauteur) {
		List<PublicationBean> pubs = new ArrayList<PublicationBean>();
		List<Publication_Membre> idpubs = memberpubrep.findpubId(idauteur);
		idpubs.forEach(s -> {
			System.out.println(s);
			pubs.add(proxy.findpublicationById(s.getId().getPublication_id()));
		});
		return pubs;
	}

}
