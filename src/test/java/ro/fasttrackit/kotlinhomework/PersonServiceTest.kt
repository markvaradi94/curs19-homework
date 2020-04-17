package ro.fasttrackit.kotlinhomework

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.assertj.core.api.AssertionsForClassTypes.*
import org.junit.jupiter.api.TestInstance

import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import kotlin.test.assertTrue


@TestInstance(PER_CLASS)
internal class PersonServiceTest {
    private var service: PersonService = PersonService()

    @BeforeEach
    fun setUp() {
        service = PersonService()
        service.addPerson(Person("Andrei", "Pop", 70, "Oradea"))
        service.addPerson(Person("Maria", "Gal", 67, "Beius"))
        service.addPerson(Person("Anamaria", "Tudorache", 15, "Constanta"))
        service.addPerson(Person("Ioan", "Bogdan", 19, "Oradea"))
        service.addPerson(Person("Augustin", "Popescu", 17, "Cluj"))
        service.addPerson(Person("Iuliana", "Nagy", 50, "Cluj"))
        service.addPerson(Person("Ecaterina", "Albu", 44, "Oradea"))
        service.addPerson(Person("Ioan", "Stancu", 55, "Timisoana"))
        service.addPerson(Person("Ioan", "Anghelescu", 16, "Arad"))
        service.addPerson(Person("Andrei", "Muresan", 62, "Bucuresti"))
        service.addPerson(Person("Anamaria", "Tudorache", 36, "Iasi"))
        service.addPerson(Person("Ecaterina", "Albu", 40, "Buzau"))
    }

    @Test
    fun `WHEN a person is added THEN it gets added to people list`() {
        service.addPerson(Person("test", "testulescu", 30, "oradea"))
        assertThat(service.getAllPersons().size).isEqualTo(13)
    }

    @Test
    fun `WHEN requesting for list of persons THEN list is returned`() {
        assertThat(service.getAllPersons().size).isEqualTo(12)
    }

    @Test
    fun `WHEN full names are requested THEN list of names is returned`() {
        assertThat(service.getAllNames().size).isEqualTo(12)
        assertThat(service.getAllNames()[0]).isEqualTo("Andrei Pop")

//        val names = service.getAllNames()
//        assertThat(service.getAllPersons()).extracting("firstName", "lastName").containsExactly("Andrei Pop, Maria Gal, " +
//                "Anamaria Tudorache, Ioan Bogdan, Augustin Popescu, Iuliana Nagy, Ecaterina Albu, " +
//                "Ioan Stancu, Ioan Anghelescu, Andrei Muresan, Anamaria Tudorache, Ecaterina Albu")
    }

    @Test
    fun `WHEN searching for people older than 18 THEN list is returned`() {
        assertThat(service.getMajorPersons().size).isEqualTo(9)
        assertThat(service.getMajorPersons()[0]).isEqualTo(service.getAllPersons()[0])
    }

    @Test
    fun `WHEN no persons older than 18 THEN empty list is returned`() {
        val testService = PersonService()
        testService.addPerson(Person("Andrei", "Muresan", 14, "Bucuresti"))
        testService.addPerson(Person("Anamaria", "Tudorache", 17, "Iasi"))
        testService.addPerson(Person("Ecaterina", "Albu", 16, "Buzau"))

        assertTrue { testService.getMajorPersons().isEmpty() }
    }

    @Test
    fun `WHEN people from Oradea are found THEN list is returned`() {
        assertThat(service.personsFromOradea().size).isEqualTo(3)
        assertThat(service.personsFromOradea()[0]).isEqualTo(service.getAllPersons()[0])
    }

    @Test
    fun `WHEN no people from Oradea are found THEN empty list is returned`() {
        val testService = PersonService()
        testService.addPerson(Person("Andrei", "Muresan", 14, "Bucuresti"))
        testService.addPerson(Person("Anamaria", "Tudorache", 17, "Iasi"))
        testService.addPerson(Person("Ecaterina", "Albu", 16, "Buzau"))

        assertTrue { testService.personsFromOradea().isEmpty() }
    }

    @Test
    fun `WHEN people from Oradea or Cluj are found THEN list is returned`() {
        assertThat(service.personsFromOradeaAndCluj().size).isEqualTo(5)
        assertThat(service.personsFromOradeaAndCluj()[0]).isEqualTo(service.getAllPersons()[0])
    }

    @Test
    fun `WHEN no people from Oradea or Cluj are found THEN empty list is returned`() {
        val testService = PersonService()
        testService.addPerson(Person("Andrei", "Muresan", 14, "Bucuresti"))
        testService.addPerson(Person("Anamaria", "Tudorache", 17, "Iasi"))
        testService.addPerson(Person("Ecaterina", "Albu", 16, "Buzau"))

        assertTrue { testService.personsFromOradeaAndCluj().isEmpty() }
    }

    @Test
    fun `WHEN requested THEN list of capitalized names is returned`() {
        assertThat(service.capitalizedFirstNames().size).isEqualTo(12)
        assertThat(service.capitalizedFirstNames()[0]).isEqualTo("ANDREI")
    }

    @Test
    fun `WHEN requested THEN list of formatted names is returned`() {
        assertThat(service.formattedNames().size).isEqualTo(12)
        assertThat(service.formattedNames()[0]).isEqualTo("Andrei P.")
    }

    @Test
    fun `WHEN persons within age range are found THEN list is returned`() {
        assertThat(service.personsWithinAgeRange().size).isEqualTo(6)
        assertThat(service.personsWithinAgeRange()[0]).isEqualTo(service.getAllPersons()[3])
    }

    @Test
    fun `WHEN no people within age range are found THEN empty list is returned`() {
        val testService = PersonService()
        testService.addPerson(Person("Andrei", "Muresan", 14, "Bucuresti"))
        testService.addPerson(Person("Anamaria", "Tudorache", 17, "Iasi"))
        testService.addPerson(Person("Ecaterina", "Albu", 16, "Buzau"))

        assertTrue { testService.personsWithinAgeRange().isEmpty() }
    }

    @Test
    fun `WHEN requested THEN unique first names are returned`() {
        assertThat(service.uniqueFirstNames().size).isEqualTo(7)
        val uniqueNames: List<String> = service.uniqueFirstNames().toList()
        assertThat(uniqueNames[0]).isEqualTo("Andrei")
    }

    @Test
    fun `WHEN requested THEN list of persons sorted by first name is returned`() {
        assertThat(service.sortByFirstName().size).isEqualTo(12)
        assertThat(service.sortByFirstName()[0]).isEqualTo(service.getAllPersons()[2])
    }

    @Test
    fun `WHEN requested THEN list of persons sorted by last name is returned`() {
        assertThat(service.sortByLastName().size).isEqualTo(12)
        assertThat(service.sortByLastName()[0]).isEqualTo(service.getAllPersons()[6])
    }

    @Test
    fun `WHEN requested THEN list of persons sorted by first name, last name and age is returned`() {
        assertThat(service.completeSort().size).isEqualTo(12)
        assertThat(service.completeSort()[0]).isEqualTo(service.getAllPersons()[2])
    }

    @Test
    fun `WHEN persons with first name starting with specified letter are found THEN list is returned`() {
        assertThat(service.firstNamesStartingWithLetter('m').size).isEqualTo(1)
        assertThat(service.firstNamesStartingWithLetter('m')[0]).isEqualTo(service.getAllPersons()[1])
    }

    @Test
    fun `WHEN no people with first name starting with specified letter are found THEN empty list is returned`() {
        val testService = PersonService()
        testService.addPerson(Person("Robert", "Muresan", 14, "Bucuresti"))
        testService.addPerson(Person("Denisa", "Tudorache", 17, "Iasi"))
        testService.addPerson(Person("Ecaterina", "Albu", 16, "Buzau"))

        assertTrue { testService.firstNamesStartingWithLetter('m').isEmpty() }
    }
}