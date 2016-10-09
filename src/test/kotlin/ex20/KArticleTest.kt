package ex20

import bt.Article
import org.junit.Test
import kotlin.test.assertNotNull
import org.assertj.core.api.KotlinAssertions.assertThat

class KArticleTest {
    @Test
    fun articleMustBeNamedJunit() {
        assertNotNull(Article(null, 10).name)
    }

    @Test
    fun articleMustBeNamedAssertJ() {
        assertThat(Article(null, 10).name).isNotNull()
    }
}