import command.Commands;
import enums.DoctorSpecialization;
import enums.HospitalRoomType;
import enums.PatientType;
import enums.PersonType;
import model.*;
import storage.*;
import util.DateUtil;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static command.Commands.*;

public class Main {
    private static final DoctorsStorage doctorsStorage = new DoctorsStorage();
    private static final PatientsStorage patientsStorage = new PatientsStorage();
    private static final RoomsStorage roomsStorage = new RoomsStorage();
    private static final VisitorsStorage visitorsStorage = new VisitorsStorage();
    private static final DiagnosisStorage diagnosisStorage = new DiagnosisStorage();

    private static final Scanner scanner = new Scanner(System.in);

    private static PersonModel registeredPerson;

    static boolean runnable = true;

    public static void main(String[] args) {
        initData();

        while (runnable) {
            printLoginCommands();

            int command;

            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }

            switch (command) {
                case EXIT:
                    runnable = false;
                    break;
                case LOGIN:
                    login();
                    break;
                case REGISTER:
                    register();
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
    }
    private static void initData() throws ParseException {
//        ADMIN
        PersonModel admin = new PersonModel("Admin", "Admin", 30, "AT0092113", PersonType.ADMINISTRATOR);
//        DOCTORS
        DoctorModel doctor1 = new DoctorModel(101, "Simon", "Simonyan", 35, "AT1412543", PersonType.DOCTOR, "098000001", DoctorSpecialization.CARDIOLOGY);
        DoctorModel doctor2 = new DoctorModel(102, "Kim", "Kirakosyan", 32, "AT1223575", PersonType.DOCTOR, "098000002", DoctorSpecialization.DERMATOLOGY);
        DoctorModel doctor3 = new DoctorModel(103, "Karen", "Karapetyan", 28, "AT1113142", PersonType.DOCTOR, "098000003", DoctorSpecialization.FAMILY_MEDICINE);
        DoctorModel doctor4 = new DoctorModel(104, "Margarita", "Simonyan", 29, "AT4532567", PersonType.DOCTOR, "098000004", DoctorSpecialization.GASTROENTEROLOGY);
        DoctorModel doctor5 = new DoctorModel(105, "Azniv", "Kagavyan", 35, "AT3324156", PersonType.DOCTOR, "098000005", DoctorSpecialization.INTERNAL_MEDICINE);
        DoctorModel doctor6 = new DoctorModel(106, "Kamsar", "Vardanyan", 31, "AT1432557", PersonType.DOCTOR, "098000006", DoctorSpecialization.NEUROLOGY);
        DoctorModel doctor7 = new DoctorModel(107, "David", "Soghomonyan", 30, "AT1956805", PersonType.DOCTOR, "098000007", DoctorSpecialization.ONCOLOGY);
        DoctorModel doctor8 = new DoctorModel(108, "David", "Beglaryan", 27, "AT6346733", PersonType.DOCTOR, "098000008", DoctorSpecialization.SURGERY);
        doctorsStorage.add(doctor1);
        doctorsStorage.add(doctor2);
        doctorsStorage.add(doctor3);
        doctorsStorage.add(doctor4);
        doctorsStorage.add(doctor5);
        doctorsStorage.add(doctor6);
        doctorsStorage.add(doctor7);
        doctorsStorage.add(doctor8);
//        DIAGNOSIS
        DiagnosisModel diagnosis1 = new DiagnosisModel("David", DateUtil.stringToDate("24-12-2023"), "Illness");
        DiagnosisModel diagnosis2 = new DiagnosisModel("David", DateUtil.stringToDate("14-04-2024"), "Illness");
        DiagnosisModel diagnosis3 = new DiagnosisModel("Kamsar", DateUtil.stringToDate("02-05-2024"), "Illness");
        DiagnosisModel diagnosis4 = new DiagnosisModel("Azniv", DateUtil.stringToDate("21-02-2024"), "Illness");
        DiagnosisModel diagnosis5 = new DiagnosisModel("Karen", DateUtil.stringToDate("04-07-2024"), "Illness");
        DiagnosisModel diagnosis6 = new DiagnosisModel("Kim", DateUtil.stringToDate("24-12-2023"), "Illness");
        DiagnosisModel diagnosis7 = new DiagnosisModel("Simon", DateUtil.stringToDate("11-06-2024"), "Illness");
        DiagnosisModel diagnosis8 = new DiagnosisModel("Margarita", DateUtil.stringToDate("28-03-2024"), "Illness");
        diagnosisStorage.add(diagnosis1);
        diagnosisStorage.add(diagnosis2);
        diagnosisStorage.add(diagnosis3);
        diagnosisStorage.add(diagnosis4);
        diagnosisStorage.add(diagnosis5);
        diagnosisStorage.add(diagnosis6);
        diagnosisStorage.add(diagnosis7);
        diagnosisStorage.add(diagnosis8);
//        PATIENTS
        PatientModel patient1 = new PatientModel(201, "Azat", "Anibaryan", 45, "AT8762345", PersonType.PATIENT, "099112385", doctor1, PatientType.THE_DISEASE_HAS_JUST_OCCURRED, diagnosis1, diagnosis1.getDateOfDiagnosis());
        PatientModel patient2 = new PatientModel(202, "Ani", "Karapetyan", 22, "AT5213187", PersonType.PATIENT, "091002283", doctor2, PatientType.THE_DISEASE_IS_ADVANCED, diagnosis2, diagnosis2.getDateOfDiagnosis());
        PatientModel patient3 = new PatientModel(203, "Anna", "Azizyan", 26, "AT6731285", PersonType.PATIENT, "098979695", doctor3, PatientType.THE_DISEASE_HAS_JUST_OCCURRED, diagnosis3, diagnosis3.getDateOfDiagnosis());
        PatientModel patient4 = new PatientModel(204, "Karen", "Adamyan", 29, "AT6638290", PersonType.PATIENT, "094118453", doctor4, PatientType.THE_DISEASE_PROGRESSES, diagnosis4, diagnosis4.getDateOfDiagnosis());
        PatientModel patient5 = new PatientModel(205, "Mariam", "Amirjanyan", 32, "AT9087532", PersonType.PATIENT, "099112244", doctor5, PatientType.THE_DISEASE_PROGRESSES, diagnosis5, diagnosis5.getDateOfDiagnosis());
        PatientModel patient6 = new PatientModel(206, "Suzi", "Simonyan", 19, "AT8264738", PersonType.PATIENT, "099000098", doctor6, PatientType.THE_DISEASE_IS_IN_EXTREME_STATE, diagnosis6, diagnosis6.getDateOfDiagnosis());
        PatientModel patient7 = new PatientModel(207, "Sahak", "Abazyan", 31, "AT1198423", PersonType.PATIENT, "077846352", doctor7, PatientType.THE_DISEASE_PROGRESSES, diagnosis7, diagnosis7.getDateOfDiagnosis());
        PatientModel patient8 = new PatientModel(208, "Shavarsh", "Hunanyan", 22, "AT1438921", PersonType.PATIENT, "041237462", doctor8, PatientType.THE_DISEASE_HAS_JUST_OCCURRED, diagnosis8, diagnosis8.getDateOfDiagnosis());
        patientsStorage.add(patient1);
        patientsStorage.add(patient2);
        patientsStorage.add(patient3);
        patientsStorage.add(patient4);
        patientsStorage.add(patient5);
        patientsStorage.add(patient6);
        patientsStorage.add(patient7);
        patientsStorage.add(patient8);
//        ROOMS
        List<PatientModel> room1Members = new ArrayList<>();
        room1Members.add(patient1);
        room1Members.add(patient2);

        List<PatientModel> room2Members = new ArrayList<>();
        room1Members.add(patient3);
        room1Members.add(patient6);

        List<PatientModel> room3Members = new ArrayList<>();
        room1Members.add(patient4);
        room1Members.add(patient8);

        List<PatientModel> room4Members = new ArrayList<>();
        room1Members.add(patient5);

        List<PatientModel> room5Members = new ArrayList<>();
        room1Members.add(patient7);

        HospitalRoom room1 = new HospitalRoom(401, 4, HospitalRoomType.TREATED_BY_STATE_ORDER_ROOM, room1Members);
        HospitalRoom room2 = new HospitalRoom(402, 4, HospitalRoomType.TREATED_BY_STATE_ORDER_ROOM, room2Members);
        HospitalRoom room3 = new HospitalRoom(403, 2, HospitalRoomType.PAID_TREATMENT_ROOM, room3Members);
        HospitalRoom room4 = new HospitalRoom(404, 1, HospitalRoomType.PAID_TREATMENT_ROOM, room4Members);
        HospitalRoom room5 = new HospitalRoom(405, 1, HospitalRoomType.SEPARATE_ROOM, room5Members);
        roomsStorage.add(room1);
        roomsStorage.add(room2);
        roomsStorage.add(room3);
        roomsStorage.add(room4);
        roomsStorage.add(room5);

//        VISITORS
        Visitor visitor = new Visitor(901, "Anna", "Papazyan", 22, "AT6781432", PersonType.VISITOR, patient7, DateUtil.stringToDate("24-08-2024"));
        visitorsStorage.add(visitor);
    }

    private static void register() {
        System.out.println("Registration Form\nPlease input your personal information.");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your surname: ");
        String surname = scanner.nextLine();
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        System.out.print("Enter your passport number: ");
        String passportNumber = scanner.nextLine();
        if (doctorsStorage.getDoctorByPassportNumber(passportNumber) != null && patientsStorage.getPatientByPassportNumber(passportNumber) != null) {
            System.out.println("Person with " + passportNumber + " already exists.");
        } else {
            System.out.println("Please enter ");
        }
    }
}