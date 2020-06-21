package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Yemi Shin on 06/18/20.
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}