package ex20

import org.junit.Test
import kotlin.test.assertFailsWith

class KExceptionTest {

    @Test(expected = NullPointerException::class)
    fun canExpectExceptionJunit() {
        throw NullPointerException()
    }

    @Test
    fun canExpectException() {
        assertFailsWith<NullPointerException> {
            throw NullPointerException()
        }
    }

}