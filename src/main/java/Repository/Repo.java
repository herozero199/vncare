package Repository;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

public class Repo {

    @Inject
    EntityManager entityManager;
}
