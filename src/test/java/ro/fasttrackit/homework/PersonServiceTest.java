package ro.fasttrackit.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
class PersonServiceTest {
    private PersonService service;

    @BeforeEach
    void setUp() {
        service = new PersonService();
        service.addPerson(new Person("Maria", "Gal", 67, "Beius"));
        service.addPerson(new Person("Anamaria", "Tudorache", 15, "Constanta"));
        service.addPerson(new Person("Ioan", "Bogdan", 19, "Oradea"));
        service.addPerson(new Person("Augustin", "Popescu", 17, "Cluj"));
        service.addPerson(new Person("Andrei", "Pop", 70, "Oradea"));
        service.addPerson(new Person("Iuliana", "Nagy", 50, "Cluj"));
        service.addPerson(new Person("Ecaterina", "Albu", 44, "Oradea"));
        service.addPerson(new Person("Ioan", "Stancu", 55, "Timisoana"));
        service.addPerson(new Person("Ioan", "Anghelescu", 14, "Arad"));
        service.addPerson(new Person("Andrei", "Muresan", 62, "Bucuresti"));
        service.addPerson(new Person("Anamaria", "Tudorache", 36, "Iasi"));
        service.addPerson(new Person("Ecaterina", "Albu", 40, "Buzau"));
    }

    @Test
    @DisplayName("WHEN a person is added THEN it gets added to people list")
    void addPerson() {
        service.addPerson(new Person("test", "testulescu", 30, "oradea"));
        assertThat(service.getPeople().size()).isEqualTo(13);
    }

    @Test
    @DisplayName("WHEN requesting for list of persons THEN list is returned")
    void getPeople() {
        assertThat(service.getPeople().size()).isEqualTo(12);
    }

    @Test
    @DisplayName("WHEN full names are requested THEN list of names is returned")
    void getAllNames() {
        assertThat(service.getAllNames().size()).isEqualTo(12);
        assertThat(service.getAllNames().get(0)).isEqualTo("Maria Gal");
    }

    @Test
    @DisplayName("WHEN searching for people older than 18 THEN list is returned")
    void getMajorPersons() {
        assertThat(service.getMajorPersons().size()).isEqualTo(9);
        assertThat(service.getMajorPersons().get(0)).isEqualTo(service.getPeople().get(0));
    }

    @Test
    @DisplayName("WHEN no persons older than 18 THEN empty list is returned")
    void noMajorPersons() {
        PersonService testService = new PersonService();
        testService.addPerson(new Person("Andrei", "Muresan", 15, "Bucuresti"));
        testService.addPerson(new Person("Anamaria", "Tudorache", 17, "Iasi"));
        testService.addPerson(new Person("Ecaterina", "Albu", 16, "Buzau"));

        assertThat(testService.getMajorPersons()).isEmpty();
    }

    @Test
    @DisplayName("WHEN people from Oradea are found THEN list is returned")
    void personsFromOradea() {
        assertThat(service.personsFromOradea().size()).isEqualTo(3);
        assertThat(service.personsFromOradea().get(0)).isEqualTo(service.getPeople().get(2));
    }

    @Test
    @DisplayName("WHEN no people from Oradea are found THEN empty list is returned")
    void noPersonsFromOradea() {
        PersonService testService = new PersonService();
        testService.addPerson(new Person("Andrei", "Muresan", 15, "Bucuresti"));
        testService.addPerson(new Person("Anamaria", "Tudorache", 17, "Iasi"));
        testService.addPerson(new Person("Ecaterina", "Albu", 16, "Buzau"));

        assertThat(testService.personsFromOradea()).isEmpty();
    }

    @Test
    @DisplayName("WHEN people from Oradea or Cluj are found THEN list is returned")
    void fromOradeaOrCluj() {
        assertThat(service.fromOradeaOrCluj().size()).isEqualTo(5);
        assertThat(service.fromOradeaOrCluj().get(0)).isEqualTo(service.getPeople().get(2));
    }

    @Test
    @DisplayName("WHEN no people from Oradea or Cluj are found THEN empty list is returned")
    void noPersonsFromOradeaOrCluj() {
        PersonService testService = new PersonService();
        testService.addPerson(new Person("Andrei", "Muresan", 15, "Bucuresti"));
        testService.addPerson(new Person("Anamaria", "Tudorache", 17, "Iasi"));
        testService.addPerson(new Person("Ecaterina", "Albu", 16, "Buzau"));

        assertThat(testService.fromOradeaOrCluj()).isEmpty();
    }

    @Test
    @DisplayName("WHEN requested THEN list of capitalized names is returned")
    void capitalizedFirstNames() {
        assertThat(service.capitalizedFirstNames().size()).isEqualTo(12);
        assertThat(service.capitalizedFirstNames().get(0)).isEqualTo("MARIA");
    }

    @Test
    @DisplayName("WHEN requested THEN list of formatted names is returned")
    void formattedNames() {
        assertThat(service.formattedNames().size()).isEqualTo(12);
        assertThat(service.formattedNames().get(0)).isEqualTo("Maria G.");
    }

    @Test
    @DisplayName("WHEN persons within age range are found THEN list is returned")
    void withinAgeRange() {
        assertThat(service.withinAgeRange().size()).isEqualTo(6);
        assertThat(service.withinAgeRange().get(0)).isEqualTo(service.getPeople().get(2));
    }

    @Test
    @DisplayName("WHEN no people within age range are found THEN empty list is returned")
    void noPersonsWithinAgeRange() {
        PersonService testService = new PersonService();
        testService.addPerson(new Person("Andrei", "Muresan", 15, "Bucuresti"));
        testService.addPerson(new Person("Anamaria", "Tudorache", 17, "Iasi"));
        testService.addPerson(new Person("Ecaterina", "Albu", 75, "Buzau"));

        assertThat(testService.withinAgeRange()).isEmpty();
    }

    @Test
    @DisplayName("WHEN persons with first name starting with A are found THEN list is returned")
    void firstNamesWithA() {
        assertThat(service.firstNamesWithA().size()).isEqualTo(5);
        assertThat(service.firstNamesWithA().get(0)).isEqualTo(service.getPeople().get(1));
    }

    @Test
    @DisplayName("WHEN no people with first name starting with A are found THEN empty list is returned")
    void noFirstNamesWithAFound() {
        PersonService testService = new PersonService();
        testService.addPerson(new Person("Marius", "Muresan", 15, "Bucuresti"));
        testService.addPerson(new Person("Daria", "Tudorache", 17, "Iasi"));
        testService.addPerson(new Person("Ecaterina", "Albu", 75, "Buzau"));

        assertThat(testService.firstNamesWithA()).isEmpty();
    }

    @Test
    @DisplayName("WHEN requested THEN unique first names are returned")
    void uniqueFirstNames() {
        assertThat(service.uniqueFirstNames().size()).isEqualTo(7);
        List<String> uniqueNames = new ArrayList<>(service.uniqueFirstNames());
        assertThat(uniqueNames.get(0)).isEqualTo("Ioan");
    }

    @Test
    @DisplayName("WHEN requested THEN list of persons sorted by first name is returned")
    void sortedByFirstName() {
        assertThat(service.sortedByFirstName().size()).isEqualTo(12);
        assertThat(service.sortedByFirstName().get(0)).isEqualTo(service.getPeople().get(1));
    }

    @Test
    @DisplayName("WHEN requested THEN list of persons sorted by last name is returned")
    void sortedByLastName() {
        assertThat(service.sortedByLastName().size()).isEqualTo(12);
        assertThat(service.sortedByLastName().get(0)).isEqualTo(service.getPeople().get(6));
    }

    @Test
    @DisplayName("WHEN requested THEN list of persons sorted by first name, last name and age is returned")
    void completeSort() {
        assertThat(service.completeSort().size()).isEqualTo(12);
        assertThat(service.completeSort().get(0)).isEqualTo(service.getPeople().get(1));
    }

    @Test
    @DisplayName("WHEN persons with first name starting with specified letter are found THEN list is returned")
    void firstNameStartingWithLetter() {
        assertThat(service.firstNameStartingWithLetter('e').size()).isEqualTo(2);
        assertThat(service.firstNameStartingWithLetter('e').get(0)).isEqualTo(service.getPeople().get(6));
    }

    @Test
    @DisplayName("WHEN no people with first name starting with specified letter are found THEN empty list is returned")
    void noFirstNamesWithLetterFound() {
        PersonService testService = new PersonService();
        testService.addPerson(new Person("Marius", "Muresan", 15, "Bucuresti"));
        testService.addPerson(new Person("Daria", "Tudorache", 17, "Iasi"));
        testService.addPerson(new Person("Valentina", "Albu", 75, "Buzau"));

        assertThat(testService.firstNameStartingWithLetter('e')).isEmpty();
    }
}