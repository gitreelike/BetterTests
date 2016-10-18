package ex32

import jpa.TestEntity
import jpa.TestEntityRepository
import spock.lang.Specification
import spock.lang.Subject

import javax.persistence.EntityManager
import javax.persistence.TypedQuery

class TestEntityRepositorySpec extends Specification {

    @Subject
    TestEntityRepository sut = new TestEntityRepository()

    EntityManager em = Mock()

    TypedQuery query = Mock()

    def setup() {
        sut.entityManager = em
    }

    def uglyTest() {
        given:
        em.createQuery("FROM TestEntity t WHERE t.name = :name", TestEntity.class) >> query
        query.setParameter('name', 'myName') >> query
        query.getSingleResult() >> new TestEntity()

        expect:
        sut.findByName('myName')
    }

    def uglyToo() {
        given:
        em.createQuery(_, _) >> query
        query.setParameter(_, _) >> query
        query.getSingleResult() >> new TestEntity()

        expect:
        sut.findByName('myName')
    }
}
