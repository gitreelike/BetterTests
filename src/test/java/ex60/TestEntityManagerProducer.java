package ex60;

import org.jglue.cdiunit.ProducesAlternative;
import org.junit.rules.TestWatchman;
import org.junit.runners.model.FrameworkMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Alternative
public class TestEntityManagerProducer {

    @Produces
    @Alternative
    @ApplicationScoped
    public EntityManager em(EntityManagerFactory emf) {
        return emf.createEntityManager();
    }

    @Produces
    @ProducesAlternative
    public EntityManagerFactory emf() {
        return Persistence.createEntityManagerFactory("test-pu");
    }

}
