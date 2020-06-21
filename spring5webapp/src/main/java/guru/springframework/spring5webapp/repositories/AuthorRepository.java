package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Yemi Shin on 06/18/20.
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
