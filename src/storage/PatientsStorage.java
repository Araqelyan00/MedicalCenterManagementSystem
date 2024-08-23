package storage;

import model.DoctorModel;
import model.PatientModel;

public class PatientsStorage {
    private static PatientModel[] patients = new PatientModel[10];
    private static int size = 0;

    public void add(PatientModel patient) {
        if (patients.length == size) {
            extend();
        }
        patients[size++] = patient;
    }

    private static void extend() {
        PatientModel[] temp = new PatientModel[patients.length + 10];
        for (int i = 0; i < size; i++) {
            temp[i] = patients[i];
        }
        patients = temp;
    }

    public void printPatients() {
        for (int i = 0; i < size; i++) {
            System.out.println( i + ": " + patients[i].toString() + "\n");
        }
    }

    public boolean isEmpty(PatientModel[] arrays){
        return size == 0;
    }

    public void deletePatientById(int id){
        if (isEmpty(new PatientModel[size])) {
            System.out.println("Patient does not exist");
        } else {
            for (int i = 0; i < size; i++) {
                if(patients[i].getPatientID() == id){
                    patients[i] = null;
                }
            }
            size--;
        }
    }

    public PatientModel getPatientByPassportNumber(String passportNumber){
        for (int i = 0; i < size; i++) {
            if (patients[i].getPassportCode().equals(passportNumber)) {
                return patients[i];
            }
        }
        return null;
    }


    public PatientModel getPatientById(int id){
        for (int i = 0; i < size; i++) {
            if (patients[i].getPatientID() == id) {
                return patients[i];
            }
        }
        return null;
    }

    public void printPatientsByDoctor(DoctorModel doctor) {
        int counter = 1;
        for (int i = 0; i < size; i++) {
            if (patients[i].getDoctor().equals(doctor)) {
                System.out.println(counter++ + ": " + patients[i].toString() + "\n");
            }
        }
    }
}
