package com.openwebinars.service;

import java.util.Collection;

import com.openwebinars.model.Film;

public interface FilmQueryService {
	
	public Collection<Film> exec();
	
	public FilmQueryServiceImpl anyGenre(String... genres);

	public FilmQueryServiceImpl allGenres(String... genres);

	public FilmQueryServiceImpl year(String year);

	public FilmQueryServiceImpl betweenYears(String from, String to);

	public FilmQueryServiceImpl titleContains(String title);
}
