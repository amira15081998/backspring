package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Outil;
import com.example.demo.repository.OutilsRepository;

@Service
public class OutilImpl implements IOutilService {
	@Autowired
	OutilsRepository outilsRepository;

	@Override
	public Outil addOutil(Outil o) {
		outilsRepository.save(o);
		return o;
	}

	@Override
	public void deleteOutil(Long id) {
		outilsRepository.deleteById(id);
	}

	@Override
	public Outil updateOutil(Outil o) {
		return outilsRepository.saveAndFlush(o);
	}

	@Override
	public Outil findOutil(Long id) {
		Outil o = (Outil) outilsRepository.findById(id).get();
		return o;
	}

	@Override
	public List<Outil> findAll() {
		return outilsRepository.findAll();
	}

	@Override
	public List<Outil> findBySource(String source) {
		return outilsRepository.findBySource(source);
	}

	@Override
	public List<Outil> findByDate(Date date) {
		return outilsRepository.findByDate(date);
	}

}
