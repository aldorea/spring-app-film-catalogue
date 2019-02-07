package com.openwebinars.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.openwebinars.model.Film;

@Repository
public class FilmDaoImpl implements FilmDao{
	
	public List<Film> films = new ArrayList<>();
	
	@Value("${file.path}")
	String path;
	
	@Value("${file.csv.list_separator}")
	String listSeparator;
	
	@Value("${file.csv.separator}")
	String separator;
	
	@PostConstruct
	public void init() {
		films = UtilsFilmReader.ReadFile(path, separator, listSeparator);
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Film findById(long id) {
		Optional<Film> result = films.stream().filter(f -> f.getId() == id).findFirst();
		return result.orElse(null);
	}

	@Override
	public List<Film> findAll() {
		// TODO Auto-generated method stub
		return films;
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
	}
	
	private int getIndexOf(long id) {
		boolean encontrado = false;
		int index = 0;
		
		while(!encontrado && index < films.size()) {
			if(films.get(index).getId() == id)
				encontrado = true;
			else
				index ++;
		}
		
		return (encotrado) ? index : -1;
	}

}
