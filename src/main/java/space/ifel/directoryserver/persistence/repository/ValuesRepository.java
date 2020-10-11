package space.ifel.directoryserver.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import space.ifel.springdirectoryserver.persistence.model.Values;

/**
 * @author Daniel Filho created on 29/09/2020
 */


public interface ValuesRepository extends JpaRepository<Values, String> {
}
