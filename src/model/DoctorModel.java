package model;

import enums.DoctorSpecialization;
import enums.PersonType;

public class DoctorModel {
    private int doctorId;
    private static String name;
    private static String surname;
    private static int age;
    private static String passportCode;
    private static PersonType personType;
    private static String password;
    private String phoneNumber;
    private DoctorSpecialization specialization;

    public DoctorModel() {

    }

    public DoctorModel(int doctorId, String name, String surname, int age, String passportCode, PersonType personType, String password, String phoneNumber, DoctorSpecialization specialization) {
        this.doctorId = doctorId;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.passportCode = passportCode;
        this.personType = personType;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.specialization = specialization;
    }


    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassportCode() {
        return passportCode;
    }

    public void setPassportCode(String passportCode) {
        this.passportCode = passportCode;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public DoctorSpecialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(DoctorSpecialization specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Doctor Id: " + getDoctorId() + " " + getName() + " " + getSurname() +
                "\nSpecialization: " + getSpecialization();
    }

    public String toString(int ok) {
        return "Doctor Id: " + getDoctorId() + " " + getName() + " " + getSurname() +
                "\nContact: " + getPhoneNumber() +
                "\nSpecialization: " + getSpecialization();
    }

}
