package jpa;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class TestEntityRepository {

    @Inject
    @PersistenceContext(unitName = "test-pu")
    private EntityManager entityManager;

    public TestEntity createEntity(String name) {
        TestEntity e = new TestEntity();
        e.setName(name);
        entityManager.persist(e);
        return e;
    }

    public TestEntity findByName(String name) {
        return entityManager.createQuery("FROM TestEntity t WHERE t.name = :name", TestEntity.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
