package ex20

import bt.Article
import spock.lang.Specification

class ArticleSpec extends Specification {

    def "article must be named"() {
        given:
        def article = new Article(null, 10)

        expect:
        article.name
    }

    def "articles in list should have name"() {
        given:
        def list = [new Article(null, 10), new Article("name", 5)]

        expect:
        list.every {
            it.name
        }
    }
}
