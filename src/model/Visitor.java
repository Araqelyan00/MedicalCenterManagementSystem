package model;

import enums.PersonType;
import util.DateUtil;

import java.util.Date;

public class Visitor{
    private int id;
    private String name;
    private String surname;
    private int age;
    private String passportCode;
    private PersonType personType;
    private String password;
    private PatientModel patient;
    private Date visitDate;

    public Visitor() {

    }
    public Visitor( int id, String name, String surname, int age, String passportCode, PersonType personType, String password, PatientModel patient, Date visitDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.passportCode = passportCode;
        this.personType = personType;
        this.password = password;
        this.patient = patient;
        this.visitDate = visitDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public PatientModel getPatient() {
        return patient;
    }

    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    @Override
    public String toString() {
        return "Visitor: " + getName() + " " + getSurname()+
                "\nVisit to patient (Id): " + getPatient().getPatientID() + "-> " + getPatient().getName() + " " + getPatient().getSurname() +
                "\nVisit time: " + DateUtil.dateTimeToString(getVisitDate());
    }
}
