package repository;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;

public class Repo {

    @Inject
    EntityManager entityManager;
}
