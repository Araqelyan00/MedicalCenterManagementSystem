package model;

import enums.HospitalRoomType;

import java.util.List;

public class HospitalRoom {
    private int numberId;
    private int countOfBeds;
    private HospitalRoomType hospitalRoomType;
    private List<PatientModel> patientsList;

    public HospitalRoom() {

    }

    public HospitalRoom(int numberId, int countOfPatientBeds,HospitalRoomType hospitalRoomType, List<PatientModel> patientsList) {
        this.numberId = numberId;
        this.countOfBeds = countOfPatientBeds;
        this.hospitalRoomType = hospitalRoomType;
        this.patientsList = patientsList;
    }

    public int getNumberId() {
        return numberId;
    }

    public void setNumberId(int numberId) {
        this.numberId = numberId;
    }

    public int getCountOfBeds() {
        return countOfBeds;
    }

    public void setCountOfBeds(int countOfPatientBeds) {
        this.countOfBeds = countOfPatientBeds;
    }

    public List<PatientModel> getPatientsList() {
        return patientsList;
    }

    public void setPatientsList(List<PatientModel> patientsList) {
        this.patientsList = patientsList;
    }

    public HospitalRoomType getHospitalRoomType() {
        return hospitalRoomType;
    }

    public void setHospitalRoomType(HospitalRoomType hospitalRoomType) {
        this.hospitalRoomType = hospitalRoomType;
    }

    @Override
    public String toString() {
        return "Room number: " + getNumberId() + "Type: " + getHospitalRoomType() +
                "\nCount of free beds: " + (countOfBeds -  getPatientsList().size());
    }
}
