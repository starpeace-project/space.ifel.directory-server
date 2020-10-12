package space.ifel.directoryserver.persistence.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import space.ifel.directoryserver.persistence.model.Values;

/**
 * @author Daniel Filho created on 29/09/2020
 */


public interface ValuesRepository extends JpaRepository<Values, String> {
}
