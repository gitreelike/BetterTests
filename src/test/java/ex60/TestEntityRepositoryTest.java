package ex60;

import jpa.TestEntityRepository;
import org.jglue.cdiunit.ActivatedAlternatives;
import org.jglue.cdiunit.CdiRunner;
import org.jglue.cdiunit.ContextController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(CdiRunner.class)
@ActivatedAlternatives(TestEntityManagerProducer.class)
public class TestEntityRepositoryTest {

    @Inject
    EntityManager em;

    EntityTransaction tx;

    @Inject
    TestEntityRepository repository;

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
    public void canUseRepository() throws Exception {
        repository.createEntity("myName");

        assertThat(repository.findByName("myName")).isNotNull();
    }
}
