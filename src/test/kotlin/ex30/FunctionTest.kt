package ex30

import org.assertj.core.api.KotlinAssertions
import org.junit.Test

class FunctionTest {
    @Test
    fun flakyRandomTest() {
        KotlinAssertions.assertThat(sumWithRandom(50)).isGreaterThan(100)
    }

    @Test
    fun injectDepIntoFunction() {
        KotlinAssertions.assertThat(sumWithRandom2(50)).isEqualTo(100)
    }
}

fun sumWithRandom(num: Int): Long =
        num + randomInt()

fun randomInt() =
        Math.round(Math.random() * (100 - 0 + 1))


fun sumWithRandom2(num: Int, randomInt: () -> String = { "Hello World" }): Int = num

