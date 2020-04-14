package ro.fasttrackit.homework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonValidator {
    public void verify(String firstName, String lastName, int age, String city) {
        verifyNotNull(firstName);
        verifyNotNull(lastName);
        verifyNotNull(city);
        verifyName(firstName);
        verifyName(lastName);
        verifyAge(age);
        verifyName(city);
    }

    private void verifyName(String element) {
        verifyNotNull(element);
        Pattern pattern = Pattern.compile("^[ A-za-z'\\-]+$");
        Matcher matcher = pattern.matcher(element);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(element + " is not an accepted argument");
        }
    }

    private void verifyAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Invalid age");
        }
    }

    private void verifyNotNull(String element) {
        if (element == null || element.equals("")) {
            throw new IllegalArgumentException("Invalid empty argument");
        }
    }

}
