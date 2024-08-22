package model;

import enums.PersonType;

public class PersonModel {
    private static String name;
    private static String surname;
    private static int age;
    private static String passportCode;
    private static PersonType personType;

    public PersonModel() {

    }

    public PersonModel(String name, String surname, int age, String passportCode, PersonType personType) {
        PersonModel.name = name;
        PersonModel.surname = surname;
        PersonModel.age = age;
        PersonModel.passportCode = passportCode;
        PersonModel.personType = personType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        PersonModel.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        PersonModel.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        PersonModel.age = age;
    }

    public String getPassportCode() {
        return passportCode;
    }

    public void setPassportCode(String passportCode) {
        PersonModel.passportCode = passportCode;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        PersonModel.personType = personType;
    }

    @Override
    public String toString() {
        return "Person: " + getName() + " " + getSurname() + ",Age: " + getAge();
    }
}
