package com.openwebinars.dao;

import java.util.List;

import com.openwebinars.model.Film;

public interface FilmDao {
	
	public void delete();
	public Film findById();
	public List<Film>findAll();
	public void edit();
	public void insert();
	
	
}
