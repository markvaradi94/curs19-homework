package ro.fasttrackit.homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    @DisplayName("WHEN arguments are valid THEN a person is created")
    void validPerson() {
        Person test = new Person("Ion", "Popescu", 50, "Oradea");
        assertNotNull(test);
    }

    @Test
    @DisplayName("WHEN age is invalid THEN exception is thrown")
    void invalidAge() {
        assertThrows(IllegalArgumentException.class, () -> new Person("Ion", "Popescu", 150, "Oradea"));
    }

    @Test
    @DisplayName("WHEN firstName is null THEN exception is thrown")
    void nullFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Person(null, "Popescu", 50, "Oradea"));
    }

    @Test
    @DisplayName("WHEN lastName is null THEN exception is thrown")
    void nullLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Person("Ion", null, 50, "Oradea"));
    }

    @Test
    @DisplayName("WHEN city is null THEN exception is thrown")
    void nullCity() {
        assertThrows(IllegalArgumentException.class, () -> new Person("Ion", "Popescu", 50, null));
    }

    @Test
    @DisplayName("WHEN firstName is empty THEN exception is thrown")
    void emptyFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Person("", "Popescu", 50, "Oradea"));
    }

    @Test
    @DisplayName("WHEN lastName is empty THEN exception is thrown")
    void emptyLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Person("Ion", "", 50, "Oradea"));
    }

    @Test
    @DisplayName("WHEN city is empty THEN exception is thrown")
    void emptyCity() {
        assertThrows(IllegalArgumentException.class, () -> new Person("Ion", "Popescu", 50, ""));
    }

    @Test
    @DisplayName("WHEN firstName is invalid THEN exception is thrown")
    void invalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Person("Ioan@", "Popescu", 50, "Oradea"));
    }

    @Test
    @DisplayName("WHEN lastName is invalid THEN exception is thrown")
    void invalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Person("Ion", "S!lagh!", 50, "Oradea"));
    }

    @Test
    @DisplayName("WHEN city is invalid THEN exception is thrown")
    void invalidCity() {
        assertThrows(IllegalArgumentException.class, () -> new Person("Ion", "Popescu", 50, "Orad3a"));
    }
}