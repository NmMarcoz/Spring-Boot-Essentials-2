package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.Anime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("anime")
//Essa anotação demarca que essa classe é um controller. Todos os métodos terão adicionados um ResponseBody(O retorno será apenas Strings)
public class AnimeController {
    @GetMapping("list")
    public List<Anime> list(){
        return List.of(new Anime("Bakugou"),  new Anime("One Piece"), new Anime("Berserk"));
    }
}
