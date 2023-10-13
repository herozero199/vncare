package Repository;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

public class Repository {

    @Inject
    EntityManager entityManager;
}
