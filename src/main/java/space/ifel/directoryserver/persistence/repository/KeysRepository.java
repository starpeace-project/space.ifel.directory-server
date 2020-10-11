package space.ifel.directoryserver.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import space.ifel.springdirectoryserver.persistence.model.Keys;

/**
 * @author Daniel Filho created on 22/09/2020
 */


public interface KeysRepository extends JpaRepository<Keys, String> {
}
