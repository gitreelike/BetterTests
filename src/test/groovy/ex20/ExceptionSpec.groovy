package ex20

import spock.lang.Specification

class ExceptionSpec extends Specification {

    def "can expect exception"() {
        when:
        throw new NullPointerException()

        then:
        thrown(NullPointerException)
    }
}
