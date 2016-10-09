package ex0

import spock.lang.Specification
import spock.lang.Unroll

class HelloSpockSpec extends Specification {

    /*
        Spock unterstützt die
        given/when/then Struktur

        Innerhalb eines then/expect Blocks gelten alle Ausdrücke
        implizit als assertions!
     */

    def "hello spock"() {
        given:
        def a = 'hello'
        def b = 'world'

        when:
        def actual = a + b

        then:
        actual == 'hello world'
    }

    /*
        knappere Alternative zu when/then
     */
    def "when/then can be combined to expect"() {
        given:
        def a = 'hello'
        def b = 'world'

        expect:
        a + b == 'hello world'
    }

    /*
        Parameter :-)
     */
    @Unroll("'#actual' should be '#expected'")
    def "using parameters is easy"() {
        expect:
        actual == expected

        where:
        actual | expected
        'a'    | 'a'
        'b'    | 'c'
    }
}
