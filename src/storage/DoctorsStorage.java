package storage;

import model.DoctorModel;

public class DoctorsStorage {
    private static DoctorModel[] doctors = new DoctorModel[10];
    private static int size = 0;

    public void add(DoctorModel doctor) {
        if (doctors.length == size) {
            extend();
        }
        doctors[size++] = doctor;
    }

    private static void extend() {
        DoctorModel[] temp = new DoctorModel[doctors.length + 10];
        for (int i = 0; i < size; i++) {
            temp[i] = doctors[i];
        }
        doctors = temp;
    }

    public void printDoctors() {
        for (int i = 0; i < size; i++) {
            System.out.println( i + ": " + doctors[i].toString() + "\n");
        }
    }

    public boolean isEmpty(DoctorModel[] arrays){
        return size == 0;
    }

    public void deleteDoctorById(int id){
        if (isEmpty(new DoctorModel[size])) {
            System.out.println("Doctor does not exist");
        } else {
            for (int i = 0; i < size; i++) {
                if(doctors[i].getDoctorId() == id){
                    doctors[i] = null;
                }
            }
            size--;
        }
    }

    public DoctorModel getDoctorByPassportNumber(String passportNumber){
        for (int i = 0; i < size; i++) {
            if (doctors[i].getPassportCode().equals(passportNumber)) {
                return doctors[i];
            }
        }
        return null;
    }
    
}
