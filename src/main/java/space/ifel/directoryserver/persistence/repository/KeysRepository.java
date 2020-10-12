package space.ifel.directoryserver.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.ifel.directoryserver.persistence.model.Keys;

/**
 * @author Daniel Filho created on 22/09/2020
 */


public interface KeysRepository extends JpaRepository<Keys, String> {
}
