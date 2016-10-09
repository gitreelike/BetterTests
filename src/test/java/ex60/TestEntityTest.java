package ex60;

import jpa.TestEntity;
import org.jglue.cdiunit.ActivatedAlternatives;
import org.jglue.cdiunit.CdiRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@RunWith(CdiRunner.class)
@ActivatedAlternatives(TestEntityManagerProducer.class)
public class TestEntityTest {

    @Inject
    EntityManager em;

    EntityTransaction tx;

    @Before
    public void setup() throws Exception {
        tx = em.getTransaction();
        tx.begin();
    }

    @After
    public void teardown() {
        tx.rollback();
        em.getEntityManagerFactory().close();
    }

    @Test
    public void canPersistEntity() throws Exception {
        em.persist(new TestEntity());
    }
}
