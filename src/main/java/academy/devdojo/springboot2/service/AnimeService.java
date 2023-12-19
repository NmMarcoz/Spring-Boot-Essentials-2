package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class AnimeService {
    private final List<Anime> animes= List.of(new Anime(1L, "Bakugan"), new Anime(15L, "Boku no Hero"));
    public List<Anime> listAll() {
        return animes;
    }

    public Anime findById(Long id){
        return animes.stream().filter(anime -> anime.getId()
                .equals(id))
                .findAny()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
    }
}
