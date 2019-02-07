package com.openwebinars.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.openwebinars.dao.FilmDao;
import com.openwebinars.model.Film;

public class FilmService {
	
	@Autowired
	FilmDao filmDao;
	
	@Autowired
	FilmQueryService filmQueryService;
	
	public Collection<String> findAllGennres() {
		List<String> result;
		
		result = filmDao.findAll()
						.stream()
						.map(film -> film.getGenres())
						.flatMap(genres -> genres.stream())
						.distinct()
						.sorted()
						.collect(Collectors.toList());
		return result;
	}
	
	public Collection<Film> findByAllGenres(String... genres) {
		return filmQueryService.anyGenre(genres).exec();
	}
	
	public Collection<Film> findByAllGenres (String...genres) {
		return filmQueryService.allGenres(genres).exec();
	}
	
	public Collection<Film> findByYear (String year) {
		return filmQueryService.year(year).exec();
	}
	
	public Collection<Film> findBetweenYears (String from, String to) {
		return filmQueryService.betweenYears(from, to).exec();
	}
	
	public Collection<Film> findByTitleContains (String title) {
		return filmQueryService.titleContains(title).exec();
	}
	
	public Collection<Film> findAll() {
		return filmDao.findAll();
	}
}