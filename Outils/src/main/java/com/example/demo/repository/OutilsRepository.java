package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Outil;

@Repository
public interface OutilsRepository extends JpaRepository<Outil, Long> {
	List<Outil> findBySource(String source);

	List<Outil> findByDate(Date date);
}
