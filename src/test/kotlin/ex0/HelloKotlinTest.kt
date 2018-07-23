package ex0

import org.junit.Test
import kotlin.test.assertEquals

class HelloKotlinTest {
    @Test
    fun `hello Kotlin`() {
        val actual = "hello" + "kotlin"
        
        assertEquals("hello kotlin", actual)
    }
}