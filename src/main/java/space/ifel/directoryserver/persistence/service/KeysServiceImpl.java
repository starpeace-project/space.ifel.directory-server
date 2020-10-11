package space.ifel.directoryserver.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.ifel.springdirectoryserver.persistence.repository.KeysRepository;

/**
 * @author Daniel Filho created on 29/09/2020
 */

@Service
public class KeysServiceImpl {

    @Autowired
    KeysRepository keysRepository;
}
