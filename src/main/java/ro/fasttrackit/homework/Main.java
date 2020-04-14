package ro.fasttrackit.homework;

public class Main {
    public static void main(String[] args) {

        PersonService service = new PersonService();
        service.addPerson(new Person("Andrei", "Pop", 70, "Oradea"));
        service.addPerson(new Person("Maria", "Gal", 67, "Beius"));
        service.addPerson(new Person("Anamaria", "Tudorache", 15, "Constanta"));
        service.addPerson(new Person("Ioan", "Bogdan", 19, "Oradea"));
        service.addPerson(new Person("Augustin", "Popescu", 17, "Cluj"));
        service.addPerson(new Person("Iuliana", "Nagy", 50, "Cluj"));
        service.addPerson(new Person("Ecaterina", "Albu", 44, "Oradea"));
        service.addPerson(new Person("Ioan", "Stancu", 55, "Timisoana"));
        service.addPerson(new Person("Ioan", "Anghelescu", 49, "Arad"));
        service.addPerson(new Person("Andrei", "Muresan", 62, "Bucuresti"));
        service.addPerson(new Person("Anamaria", "Tudorache", 36, "Iasi"));
        service.addPerson(new Person("Ecaterina", "Albu", 40, "Buzau"));


        System.out.println("\n" + service.getAllNames() + "\n");
        System.out.println(service.getMajorPersons() + "\n");
        System.out.println(service.personsFromOradea() + "\n");
        System.out.println(service.fromOradeaOrCluj() + "\n");
        System.out.println(service.capitalizedFirstNames() + "\n");
        System.out.println(service.formattedNames() + "\n");
        System.out.println(service.withinAgeRange() + "\n");
        System.out.println(service.firstNameStartingWithLetter('I') + "\n");
        System.out.println(service.firstNamesWithA() + "\n");
        System.out.println(service.uniqueFirstNames() + "\n");
        System.out.println(service.sortedByFirstName() + "\n");
        System.out.println(service.sortedByLastName() + "\n");
        System.out.println(service.completeSort());

    }
}
