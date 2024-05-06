package it.marconi.springverificaventurini.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.marconi.springverificaventurini.domains.Film;
import it.marconi.springverificaventurini.services.FilmService;

@Controller
@RequestMapping("/films")
public class FilmController {
    
    @Autowired
    private FilmService filmService;

    @GetMapping("/films")
    public String visualizzaCatalogo(Model model) {
        model.addAttribute("films", filmService.getCatalogo());
        return "films";
    }

    @GetMapping("/films/nuovo")
    public String mostraFormNuovoProdotto(Model model) {
        filmService.aggiungiFilm(new Film());
        return "formNuovoFilm";
    }

    @PostMapping("/catalogo/svuota")
    public String svuotaCatalogo() {
        filmService.svuotaCatalogo();
        return "films";
    }

    @GetMapping("/film/{codice}")
    public String mostraDettaglioProdotto(@PathVariable String codice, Model model) {
        Film film = filmService.getProdottoDalCodice(codice);
        if (film != null) {
            model.addAttribute("film", film);
            return "dettaglio";
        } else {
            return "films";
        }
    }
}
