import model.DoctorModel;
import storage.DoctorsStorage;
import storage.PatientsStorage;
import storage.PersonStorage;
import storage.VisitorsStorage;

import java.text.ParseException;

public class Tests {
    public static void main(String[] args) throws ParseException {
        Main.initData();

        DoctorsStorage doctorsStorage = new DoctorsStorage();
        PatientsStorage patientsStorage = new PatientsStorage();
        VisitorsStorage visitorsStorage = new VisitorsStorage();
        PersonStorage personStorage = new PersonStorage();
        personStorage.printPersons();
        System.out.println("---------");
        doctorsStorage.printDoctors();
        System.out.println("---------");
        patientsStorage.printPatients();
        System.out.println("---------");
        visitorsStorage.printVisitors();

    }
}
