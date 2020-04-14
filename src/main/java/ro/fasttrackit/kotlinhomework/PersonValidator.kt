package ro.fasttrackit.kotlinhomework

import java.util.regex.Matcher
import java.util.regex.Pattern

class PersonValidator {
    fun verify(firstName: String, lastName: String, age: Int, city: String) {
        verifyNotNull(firstName)
        verifyNotNull(lastName)
        verifyNotNull(city)
        verifyName(firstName)
        verifyName(lastName)
        verifyAge(age)
        verifyName(city)
    }

    private fun verifyName(element: String) {
        verifyNotNull(element)
        val pattern: Pattern = Pattern.compile("^[ A-za-z'\\-]+$")
        val matcher: Matcher = pattern.matcher(element)
        if (!matcher.matches()) throw IllegalArgumentException("$element + is not an accepted argument")
    }

    private fun verifyAge(age: Int) {
        if (age < 0 || age > 120) throw IllegalArgumentException("Invalid age")
    }

    private fun verifyNotNull(element: String?) {
        if (element == "" || element == null) throw IllegalArgumentException("Invalid empty argument")
    }
}