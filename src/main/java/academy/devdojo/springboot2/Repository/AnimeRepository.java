package academy.devdojo.springboot2.Repository;

import academy.devdojo.springboot2.domain.Anime;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AnimeRepository extends JpaRepository<Anime, Long> {

}
