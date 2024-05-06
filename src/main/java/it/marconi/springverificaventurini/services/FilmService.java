package it.marconi.springverificaventurini.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.marconi.springverificaventurini.domains.Film;

@Service
public class FilmService {
    private final List<Film> catalogo = new ArrayList<>();

    public List<Film> getCatalogo() {
        return catalogo;
    }

    public void aggiungiFilm(Film film) {
        catalogo.add(film);
    }

    public void svuotaCatalogo() {
        catalogo.clear();
    }

    public Film getProdottoDalCodice(String codice) {
        for (Film film : catalogo) {
            if (film.getCodice().equals(codice)) {
                return film;
            }
        }
        return null;
    }
}
