package model;

import enums.DoctorSpecialization;
import enums.PersonType;

public class DoctorModel extends PersonModel {
    private int doctorId;
    private String phoneNumber;
    private DoctorSpecialization specialization;

    public DoctorModel() {

    }

    public DoctorModel(int doctorId, String name, String surname, int age, String passportCode, PersonType personType, String password, String phoneNumber, DoctorSpecialization specialization) {
        super(name, surname, age, passportCode, personType, password);
        this.doctorId = doctorId;
        this.phoneNumber = phoneNumber;
        this.specialization = specialization;
    }


    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
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
