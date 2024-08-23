package model;

import enums.PersonType;
import util.DateUtil;

import java.util.Date;

public class Visitor extends PersonModel{
    private int id;
    private PatientModel patient;
    private Date visitDate;

    public Visitor() {

    }
    public Visitor( int id, String name, String surname, int age, String passportCode, PersonType personType, String password, PatientModel patient, Date visitDate) {
        super(name, surname, age, passportCode, personType, password);
        this.id = id;
        this.patient = patient;
        this.visitDate = visitDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
