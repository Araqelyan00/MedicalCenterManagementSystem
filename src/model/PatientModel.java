package model;

import enums.PatientType;
import enums.PersonType;

import java.util.Date;

public class PatientModel{
    private int patientID;
    private String name;
    private String surname;
    private int age;
    private String passportCode;
    private PersonType personType;
    private String password;
    private String phoneNumber;
    private DoctorModel doctor;
    private PatientType patientType;
    private DiagnosisModel diagnosis;
    private Date registrationDate;

    public PatientModel() {

    }
    public PatientModel(int patientID, String name, String surname, int age, String passportCode, PersonType personType, String password, String phoneNumber, DoctorModel doctor, PatientType patientType, DiagnosisModel diagnosis, Date registrationDate) {
        this.patientID = patientID;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.passportCode = passportCode;
        this.personType = personType;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.doctor = doctor;
        this.patientType = patientType;
        this.diagnosis = diagnosis;
        this.registrationDate = registrationDate;
    }


    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
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

    public DoctorModel getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorModel doctor) {
        this.doctor = doctor;
    }

    public PatientType getPatientType() {
        return patientType;
    }

    public void setPatientType(PatientType patientType) {
        this.patientType = patientType;
    }

    public DiagnosisModel getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(DiagnosisModel diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "Patient: " + getName() + " " + getSurname() +
                "\nTreating doctor: "  + getDoctor().getName() +
                "\nContact: "  + getPhoneNumber() +
                "\nPatient type: " + getPatientType()+
                "\n" + getDiagnosis().toString();
    }
}
