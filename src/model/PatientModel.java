package model;

import enums.PatientType;
import enums.PersonType;

import java.util.Date;

public class PatientModel extends PersonModel{
    private int patientID;
    private String phoneNumber;
    private DoctorModel doctor;
    private PatientType patientType;
    private DiagnosisModel diagnosis;
    private Date registrationDate;

    public PatientModel() {

    }
    public PatientModel(int patientID, String name, String surname, int age, String passportCode, PersonType personType, String phoneNumber, DoctorModel doctor, PatientType patientType, DiagnosisModel diagnosis, Date registrationDate) {
        super(name, surname, age, passportCode, personType);
        this.patientID = patientID;
        this.phoneNumber = phoneNumber;
        this.doctor = doctor;
        this.patientType = patientType;
        this.diagnosis = diagnosis;
        this.registrationDate = registrationDate;
    }

    public String getName(){
        return super.getName();
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
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
