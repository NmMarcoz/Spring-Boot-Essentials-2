package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.Repository.AnimeRepository;
import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.mapper.AnimeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import requests.AnimePostRequestBody;
import requests.AnimePutRequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class AnimeService {

   private final AnimeRepository animeRepository;
   private AnimeMapper mapper = AnimeMapper.INSTANCE;
    public List<Anime> listAll() {
        return animeRepository.findAll();
    }

    public Anime findById(Long id){
        return animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
    }
    public Anime save(AnimePostRequestBody animePostRequestBody){
        return animeRepository.save((mapper.toAnime(animePostRequestBody)));
    }
    public void remove(long id){
        animeRepository.delete(findById(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody){
        Anime savedAnime = findById(animePutRequestBody.getId());
        Anime anime = mapper.toAnime(animePutRequestBody);
        anime.setId(savedAnime.getId());

        animeRepository.save(anime);


    }

}
