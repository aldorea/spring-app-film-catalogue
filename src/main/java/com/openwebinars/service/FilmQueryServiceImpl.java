package com.openwebinars.service;

import java.util.Collection;
import java.util.function.Predicate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.openwebinars.dao.FilmDao;
import com.openwebinars.model.Film;

public class FilmQueryServiceImpl implements FilmQueryService {
	
	@Autowired
	private FilmDao dao;
	
	private Predicate<Film> predicate;
	
	@PostConstruct
	public void  init() {
		predicate = null;
	}

	@Override
	public Collection<Film> exec() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FilmQueryService anyGenre(String... genres) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FilmQueryService allGenres(String... genres) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FilmQueryService year(String year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FilmQueryService betweenYears(String from, String to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FilmQueryService titleContains(String title) {
		// TODO Auto-generated method stub
		return null;
	}

}
