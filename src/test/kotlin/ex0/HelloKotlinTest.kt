package ex0

import org.junit.Test
import kotlin.test.assertEquals

class HelloKotlinTest {
    @Test
    fun helloKotlin() {
        val actual = "hello" + "kotlin"
        
        assertEquals("hello kotlin", actual)
    }
}