package com.openwebinars.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.openwebinars.model.Film;

@Repository
public class FilmDaoImpl implements FilmDao{
	
	public List<Film> films = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		peliculas = UtilsFilmReader.ReadFile(path, separator, listSeparator);
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Film findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Film> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
	}

}
