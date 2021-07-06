package tr.com.khg.template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.khg.template.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
