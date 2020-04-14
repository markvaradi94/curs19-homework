package ro.fasttrackit.homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class PersonService {

    private final List<Person> people;

    public PersonService() {
        people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        this.people.add(person);
    }

    public List<Person> getPeople() {
        return people;
    }

    public List<String> getAllNames() {
        return people.stream()
                .map(this::firstAndLastNames)
                .collect(toList());
    }

    public List<Person> getMajorPersons() {
        return people.stream()
                .filter(person -> person.getAge() >= 18)
                .collect(toList());
    }

    public List<Person> personsFromOradea() {
        return people.stream()
                .filter(this::isFromOradea)
                .collect(toList());
    }

    public List<Person> fromOradeaOrCluj() {
        return people.stream()
                .filter(this::isFromOradeaOrCluj)
                .collect(toList());
    }

    public List<String> capitalizedFirstNames() {
        return people.stream()
                .map(person -> person.getFirstName().toUpperCase())
                .collect(toList());
    }

    public List<String> formattedNames() {
        return people.stream()
                .map(this::formatNames)
                .collect(toList());
    }

    public List<Person> withinAgeRange() {
        return people.stream()
                .filter(this::isInAgeRange)
                .collect(toList());
    }

    public List<Person> firstNamesWithA() {
        return people.stream()
                .filter(this::firstNameStartsWithA)
                .collect(toList());
    }

    public Set<String> uniqueFirstNames() {
        return people.stream()
                .map(Person::getFirstName)
                .collect(toSet());
    }

    public List<Person> sortedByFirstName() {
        return people.stream()
                .sorted(Comparator.comparing(Person::getFirstName))
                .collect(toList());
    }

    public List<Person> sortedByLastName() {
        return people.stream()
                .sorted(Comparator.comparing(Person::getLastName))
                .collect(toList());
    }

    public List<Person> completeSort() {
        return people.stream()
                .sorted(Comparator.comparing(Person::getFirstName)
                        .thenComparing(Person::getLastName)
                        .thenComparing(Person::getAge))
                .collect(toList());
    }

    public List<Person> firstNameStartingWithLetter(char letter) {
        return people.stream()
                .filter(person -> firstNameStartsWithLetter(person, letter))
                .collect(toList());
    }

    private String firstAndLastNames(Person person) {
        return person.getFirstName() + " " + person.getLastName();
    }

    private String formatNames(Person person) {
        return person.getFirstName() + " " + person.getLastName().charAt(0) + ".";
    }

    private boolean isInAgeRange(Person person) {
        return person.getAge() > 18 && person.getAge() < 60;
    }

    private boolean isFromOradea(Person person) {
        return person.getCity().equalsIgnoreCase("oradea");
    }

    private boolean isFromOradeaOrCluj(Person person) {
        return person.getCity().equalsIgnoreCase("oradea") || person.getCity().equalsIgnoreCase("cluj");
    }

    private boolean firstNameStartsWithLetter(Person person, char letter) {
        return person.getFirstName().toLowerCase().charAt(0) == letter || person.getFirstName().toUpperCase().charAt(0) == letter;
    }

    private boolean firstNameStartsWithA(Person person) {
        return person.getFirstName().toLowerCase().charAt(0) == 'a';
    }
}
