package ex70

import spock.lang.Specification
import spock.util.environment.RestoreSystemProperties

class CleanupSpec extends Specification {

    def setup() {
        println "setup"
    }

    def cleanup() {
        println "cleanup"
    }

    def setupSpec() {
        println "setupSpec"
    }

    def cleanupSpec() {
        println "cleanupSpec"

        assert !System.getProperty("bla")
    }

    def "spock can cleanup"() {
        expect:
        1 == 1
    }

    @RestoreSystemProperties
    def "system properties"() {
        when:
        System.setProperty("bla", "test")

        then:
        System.getProperty("bla")
    }
}
