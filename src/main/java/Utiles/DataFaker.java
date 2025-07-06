package Utiles;

import com.github.javafaker.Faker;

import java.util.Random;

public class DataFaker {
    private static final Faker faker = new Faker(new Random(System.nanoTime()));

    public static String getFirstName() { return faker.name().firstName(); }
    public static String getLastName() { return faker.name().lastName(); }
    public static String getStreetAddress() { return faker.address().streetAddress(); }
    public static String getCity() { return faker.address().city(); }
    public static String getState() { return faker.address().state(); }
    public static String getZipCode() { return faker.address().zipCode(); }
    public static String getPhoneNumber() { return faker.phoneNumber().cellPhone(); }
    public static String getSSN() { return faker.idNumber().ssnValid(); }
    public static String getUsername() { return faker.name().username() + faker.number().randomDigit(); }
    public static String getPassword() { return faker.internet().password(8, 12); }
}