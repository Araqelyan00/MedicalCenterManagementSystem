package storage;

import model.DiagnosisModel;

public class DiagnosisStorage {
    private static DiagnosisModel[] diagnosis = new DiagnosisModel[10];
    private static int size = 0;

    public void add(DiagnosisModel diagnose) {
        if (diagnosis.length == size) {
            extend();
        }
        diagnosis[size++] = diagnose;
    }

    private static void extend() {
        DiagnosisModel[] temp = new DiagnosisModel[diagnosis.length + 10];
        for (int i = 0; i < size; i++) {
            temp[i] = diagnosis[i];
        }
        diagnosis = temp;
    }

    public void printDoctors() {
        for (int i = 0; i < size; i++) {
            System.out.println( i + ": " + diagnosis[i].toString() + "\n");
        }
    }

    public boolean isEmpty(DiagnosisModel[] arrays){
        return size == 0;
    }


}