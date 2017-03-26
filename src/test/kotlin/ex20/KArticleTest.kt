package ex20

import bt.Article
import org.junit.Test
import kotlin.test.assertNotNull
import org.assertj.core.api.KotlinAssertions.assertThat

class KArticleTest {
    @Test
    fun `article must be named (Junit)`() {
        assertNotNull(Article(null, 10).name)
    }

    @Test
    fun `article must be named (AssertJ)`() {
        assertThat(Article(null, 10).name).isNotNull()
    }
}