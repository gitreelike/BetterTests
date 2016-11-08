package ex51

import spock.lang.Specification
import spock.lang.Unroll

class MoreThanOneSpec extends Specification {

    @Unroll("name '#name' does not contain x")
    def nameDoesNotContainX() {
        expect:
        !name.contains('x')

        where:
        name << ['Spock', 'Zulu', 'Uhura']
    }

    def nameContainsZ() {
        expect:
        fullname.contains('Z') == expected

        where:
        firstname | lastname || expected
        'Hikaru'  | 'Zulu'   || true
        'Nyota'   | 'Uhura'  || false
        'Pavel'   | 'Chekov' || true

        fullname = firstname + ' ' + lastname
    }
}
