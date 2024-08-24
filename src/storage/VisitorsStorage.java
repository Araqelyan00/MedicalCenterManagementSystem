package storage;

import model.Visitor;

public class VisitorsStorage {
    private static Visitor[] visitors = new Visitor[10];
    private static int size = 0;

    public void add(Visitor visitor) {
        if (visitors.length == size) {
            extend();
        }
        visitors[size++] = visitor;
    }

    private static void extend() {
        Visitor[] temp = new Visitor[visitors.length + 10];
        for (int i = 0; i < size; i++) {
            temp[i] = visitors[i];
        }
        visitors = temp;
    }

    public void printVisitors() {
        for (int i = 0; i < size; i++) {
            System.out.println(visitors[i].toString() + "\n");
        }
    }

    public boolean isEmpty(Visitor[] arrays){
        return size == 0;
    }

    public void deletePatientById(int id){
        if (isEmpty(new Visitor[size])) {
            System.out.println("Visitor does not exist");
        } else {
            for (int i = 0; i < size; i++) {
                if(visitors[i].getId() == id){
                    visitors[i] = null;
                }
            }
            size--;
        }
    }


    public Visitor getVisitorByPassportNumber(String passportNumber){
        for (int i = 0; i < size; i++) {
            if (visitors[i].getPassportCode().equals(passportNumber)) {
                return visitors[i];
            }
        }
        return null;
    }
}
