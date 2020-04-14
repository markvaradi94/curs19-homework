package ro.fasttrackit.kotlinhomework

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

internal class PersonTest {

    @Test
    fun `WHEN arguments are valid THEN a person is created`() {
        val test = Person("test", "testulescu", 30, "Oradea")
        assertNotNull(test)
    }

    @Test
    fun `WHEN age is invalid THEN exception is thrown`() {
        assertThrows<IllegalArgumentException> { Person("Mihai", "Ionescu", 150, "Oradea") }
    }

    @Test
    fun `WHEN firstName is empty THEN exception is thrown`() {
        assertThrows<IllegalArgumentException> { Person("", "Ionescu", 50, "Oradea") }
    }

    @Test
    fun `WHEN lastName is empty THEN exception is thrown`() {
        assertThrows<IllegalArgumentException> { Person("George", "", 50, "Oradea") }
    }

    @Test
    fun `WHEN city is empty THEN exception is thrown`() {
        assertThrows<IllegalArgumentException> { Person("Mihai", "Ionescu", 50, "") }
    }

    @Test
    fun `WHEN firstName is invalid THEN exception is thrown`() {
        assertThrows<IllegalArgumentException> { Person("Mihai7za", "Ionescu", 50, "Oradea") }
    }

    @Test
    fun `WHEN lastName is invalid THEN exception is thrown`() {
        assertThrows<IllegalArgumentException> { Person("George", "Ionesc0", 50, "Oradea") }
    }

    @Test
    fun `WHEN city is invalid THEN exception is thrown`() {
        assertThrows<IllegalArgumentException> { Person("Mihai", "Ionescu", 50, "Orade@") }
    }


}