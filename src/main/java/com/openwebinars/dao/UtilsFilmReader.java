package com.openwebinars.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.ResourceUtils;

import com.openwebinars.model.Film;

public class UtilsFilmReader {
	
	public static List<Film> ReadFile(final String path, final String separator, final String listSeparator) {
		
		List<Film> result = new ArrayList<>();
		try {
			result = Files.lines(Paths.get(ResourceUtils.getFile(path).toURI()))
				.skip(1)
				.map(lines -> {
						String[] values = lines.split(separator);
						return new Film(Long.parseLong(values[0]), values[1], Arrays.asList(values[3].split(listSeparator)),values[2]);
										
				}).collect(Collectors.toList());
		} catch (FileNotFoundException e) {
			System.err.println("Error de lectura del fichero de datos: imdb_data");
			System.exit(-1);
		} catch (IOException e) {
			System.err.println("Error de lectura del fichero de datos: imdb_data");
			System.exit(-1);
		}
		
		return result;
	}
	
	
}
