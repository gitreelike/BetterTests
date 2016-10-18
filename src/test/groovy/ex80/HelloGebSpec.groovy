package ex80

import geb.spock.GebSpec

class HelloGebSpec extends GebSpec {

    def 'can search for test literature'() {
        given:
        go "http://www.google.com"

        expect:
        title == 'Google'

        when:
        $(name: 'q') << 'junit'
        $(name: 'q') << '\n'

        then:
        def results = waitFor {
            $('#search .g .r')
        }

        results.collect { it.text() }.contains( 'JUnit - About')
    }

    def 'can search using PageObject (dynamic)'() {
        given:
        to GooglePage

        when:
        search 'junit'

        then:
        results.contains('JUnit - About')
    }

    def 'can search using PageObject (conservative)'() {
        given:
        def page = to GooglePage

        when:
        page.search('junit')

        then:
        page.viewResults().contains('JUnit - About')
    }
}
