package com.openwebinars;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.openwebinars.model.Film;
import com.openwebinars.service.FilmQueryServiceImpl;
import com.openwebinars.service.FilmService;



@SpringBootApplication
public class MovieAdivsorApplication implements CommandLineRunner {
	
	@Autowired
	FilmService filmService;
	
	@Autowired
	FilmQueryServiceImpl filmQueryService;

	@Autowired
	MovieAdvisorHelp help;
	


	public static void main(String[] args)  {
		SpringApplication.run(MovieAdivsorApplication.class, args);		
	}

	@Override
	public void run(String... args) throws Exception {
			if (args.length < 1) {
				System.out.println("Error de sintaxis");
				System.out.println(help.getHelp());
			} else if (args.length == 1) {
				switch (args[0].toLowerCase()) {
				case "-lg":
					filmService.findByAllGenres().forEach(System.out::println);
					break;
				case "-h":
					System.out.println(help.getHelp());
					break;
				default:
					System.out.println("Error de sintaxis");
					System.out.println(help.getHelp());
	
				}
			} else if (args.length % 2 != 0) {
				System.out.println("Error de sintaxis");
				System.out.println(help.getHelp());
			} else if (args.length > 8) {
				System.out.println("Error de sintaxis");
				System.out.println(help.getHelp());
			} else {
	
				// De esta forma hemos asegurado que el número de argumentos
				// es par (opción valoropción) y que no hay más de cuatro
				// parejas (ver fichero de ayuda).
				List<String[]> argumentos = new ArrayList<>();
	
				for (int i = 0; i < args.length; i += 2) {
					argumentos.add(new String[] { args[i], args[i + 1] });
				}
				
				boolean error = false;
	
				for (String[] argumento : argumentos) {
					switch (argumento[0].toLowerCase()) {
					case "-ag":
						filmQueryService.anyGenre(argumento[1].split(","));
						break;
					case "-tg":
						break;
					case "-y":
						filmQueryService.year(argumento[1]);
						break;
					case "-b":
						String[] years = argumento[1].split(",");
						filmQueryService.betweenYears(years[0], years[1]);
						break;
					case "-t":
						filmQueryService.titleContains(argumento[1]);
						break;
					default: error = true;
							 System.out.println("Error de sintaxis");
							 System.out.println(help.getHelp());
					}
	
				}
				
			if (!error) {
				Collection<Film> result = filmQueryService.exec();
				System.out.printf("%s\t%-50s\t%s\t%s\n","ID","Título", "Año", "Géneros");
				if (result != null) {
					result.forEach(f -> System.out.printf("%s\t%-50s\t%s\t%s\n", 
							f.getId(), f.getTitle(), f.getYear(), 
							f.getGenres().stream().collect(Collectors.joining(", "))));
				} else {
					System.out.println("No hay películas que cumplan esos criterios. Lo sentimos");
				}
			}
		}
	
	}
		
}



