package ro.fasttrackit.kotlinhomework

data class Person(val firstName: String, val lastName: String, val age: Int, val city: String) {
    val validator = PersonValidator().verify(firstName, lastName, age, city)
}

class PersonService(private val persons: MutableList<Person> = mutableListOf()) {

    fun addPerson(person: Person) = this.persons.add(person)

    fun getAllPersons(): List<Person> = persons

    fun getAllNames(): List<String> = persons.map { firstAndLastName(it) }

    fun getMajorPersons(): List<Person> = persons.filter { it.age >= 18 }

    fun personsFromOradea(): List<Person> = persons.filter { isFrom(it, "oradea") }

    fun personsFromOradeaAndCluj(): List<Person> = persons.filter { isFrom(it, "oradea") || isFrom(it, "cluj") }

    fun capitalizedFirstNames(): List<String> = persons.map { it.firstName.toUpperCase() }

    fun formattedNames(): List<String> = persons.map { formatName(it) }

    fun personsWithinAgeRange(): List<Person> = persons.filter { it.age in 19..59 }

    fun uniqueFirstNames(): Set<String> = persons.map { it.firstName }.toSet()

    fun sortByFirstName(): List<Person> = persons.sortedBy { it.firstName }

    fun sortByLastName(): List<Person> = persons.sortedBy { it.lastName }

    fun completeSort(): List<Person> = persons.sortedWith(compareBy({ it.firstName }, { it.lastName }, { it.age }))

    fun firstNamesStartingWithLetter(letter: Char): List<Person> = persons.filter { firstNameStartsWithLetter(it, letter) }

    private fun firstAndLastName(person: Person): String = "${person.firstName} ${person.lastName}"

    private fun isFrom(person: Person, city: String) = person.city.toLowerCase() == city.toLowerCase()

    private fun formatName(person: Person): String = "${person.firstName} ${person.lastName[0]}."

    private fun firstNameStartsWithLetter(person: Person, letter: Char): Boolean =
            person.firstName.toLowerCase()[0] == letter || person.firstName.toUpperCase()[0] == letter
}