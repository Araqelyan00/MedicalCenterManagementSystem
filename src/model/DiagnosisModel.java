package model;

import java.util.Date;

public class DiagnosisModel {
    private String doctorName;
    private Date dateOfDiagnosis;
    private String diagnosisDescription;

    public DiagnosisModel() {

    }

    public DiagnosisModel(String doctorName, Date dateOfDiagnosis, String diagnosisDescription) {
        this.doctorName = doctorName;
        this.dateOfDiagnosis = dateOfDiagnosis;
        this.diagnosisDescription = diagnosisDescription;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Date getDateOfDiagnosis() {
        return dateOfDiagnosis;
    }

    public void setDateOfDiagnosis(Date dateOfDiagnosis) {
        this.dateOfDiagnosis = dateOfDiagnosis;
    }

    public String getDiagnosisDescription() {
        return diagnosisDescription;
    }

    public void setDiagnosisDescription(String diagnosisDescription) {
        this.diagnosisDescription = diagnosisDescription;
    }

    @Override
    public String toString() {
        return "Diagnosis: " +
                "\n Description : " + getDiagnosisDescription() +
                "\n Date of Diagnosis : " + getDateOfDiagnosis();
    }
}
