package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AnimeService {
    private static List<Anime> animes;
    static{
        animes = new ArrayList<>(List.of(new Anime(1L, "Bakugan"), new Anime(15L, "Boku no Hero")));
    }
    public List<Anime> listAll() {
        return animes;
    }

    public Anime findById(Long id){
        return animes.stream().filter(anime -> anime.getId()
                .equals(id))
                .findAny()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
    }
    public Anime findByName(String name){
        return animes.stream().filter(anime ->anime.getName().equals(name)).findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "This anime does not exists"));
    }
    public Anime save(Anime anime){
        System.out.println(animes.stream().filter(animee->animee.getName().equals(anime.getName())).findAny().isPresent());
        if(animes.stream().anyMatch(animee->animee.getName().equals(anime.getName()))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This anime already exists");
        }
        anime.setId(ThreadLocalRandom.current().nextLong(3, 10000));
        animes.add(anime);
        return anime;
    }
}
