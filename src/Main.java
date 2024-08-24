import command.Commands;
import enums.DoctorSpecialization;
import enums.HospitalRoomType;
import enums.PatientType;
import enums.PersonType;
import model.*;
import storage.*;
import util.DateUtil;

import java.text.ParseException;
import java.util.*;

import static command.Commands.*;
import static enums.PatientType.*;

public class Main {
    private static final DoctorsStorage doctorsStorage = new DoctorsStorage();
    private static final PatientsStorage patientsStorage = new PatientsStorage();
    private static final RoomsStorage roomsStorage = new RoomsStorage();
    private static final VisitorsStorage visitorsStorage = new VisitorsStorage();
    private static final DiagnosisStorage diagnosisStorage = new DiagnosisStorage();
    private static final PersonStorage personsStorage = new PersonStorage();

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random rand = new Random();


    private static PersonModel currentPerson;
    private static Visitor currentVisitor;
    private static DoctorModel currentDoctor;
    private static PatientModel currentPatient;

    static boolean runnable = true;

    public static void main(String[] args) throws ParseException {
        initData();

        while (runnable) {
            printLoginCommands();

            String command;

            try {
                command = scanner.nextLine();
            } catch (NumberFormatException e) {
                command = "-1";
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
        PersonModel admin = new PersonModel("Admin", "Admin", 30, "AT0092113", PersonType.ADMINISTRATOR, "a001");
        personsStorage.add(admin);
//        DOCTORS
        DoctorModel doctor1 = new DoctorModel(101, "Simon", "Simonyan", 35, "AT1412543", PersonType.DOCTOR, "d001", "098000001", DoctorSpecialization.CARDIOLOGY);
        DoctorModel doctor2 = new DoctorModel(102, "Kim", "Kirakosyan", 32, "AT1223575", PersonType.DOCTOR, "d002", "098000002", DoctorSpecialization.DERMATOLOGY);
        DoctorModel doctor3 = new DoctorModel(103, "Karen", "Karapetyan", 28, "AT1113142", PersonType.DOCTOR, "d003", "098000003", DoctorSpecialization.FAMILY_MEDICINE);
        DoctorModel doctor4 = new DoctorModel(104, "Margarita", "Simonyan", 29, "AT4532567", PersonType.DOCTOR, "d004", "098000004", DoctorSpecialization.GASTROENTEROLOGY);
        DoctorModel doctor5 = new DoctorModel(105, "Azniv", "Kagavyan", 35, "AT3324156", PersonType.DOCTOR, "d005", "098000005", DoctorSpecialization.INTERNAL_MEDICINE);
        DoctorModel doctor6 = new DoctorModel(106, "Kamsar", "Vardanyan", 31, "AT1432557", PersonType.DOCTOR, "d006", "098000006", DoctorSpecialization.NEUROLOGY);
        DoctorModel doctor7 = new DoctorModel(107, "David", "Soghomonyan", 30, "AT1956805", PersonType.DOCTOR, "d007", "098000007", DoctorSpecialization.ONCOLOGY);
        DoctorModel doctor8 = new DoctorModel(108, "David", "Beglaryan", 27, "AT6346733", PersonType.DOCTOR, "d008", "098000008", DoctorSpecialization.SURGERY);
        doctorsStorage.add(doctor1);
        doctorsStorage.add(doctor2);
        doctorsStorage.add(doctor3);
        doctorsStorage.add(doctor4);
        doctorsStorage.add(doctor5);
        doctorsStorage.add(doctor6);
        doctorsStorage.add(doctor7);
        doctorsStorage.add(doctor8);
//        DIAGNOSIS
        DiagnosisModel diagnosis1 = new DiagnosisModel(11, "David", DateUtil.stringToDate("24-12-2023"), "Illness");
        DiagnosisModel diagnosis2 = new DiagnosisModel(12, "David", DateUtil.stringToDate("14-04-2024"), "Illness");
        DiagnosisModel diagnosis3 = new DiagnosisModel(13, "Kamsar", DateUtil.stringToDate("02-05-2024"), "Illness");
        DiagnosisModel diagnosis4 = new DiagnosisModel(14, "Azniv", DateUtil.stringToDate("21-02-2024"), "Illness");
        DiagnosisModel diagnosis5 = new DiagnosisModel(15, "Karen", DateUtil.stringToDate("04-07-2024"), "Illness");
        DiagnosisModel diagnosis6 = new DiagnosisModel(16, "Kim", DateUtil.stringToDate("24-12-2023"), "Illness");
        DiagnosisModel diagnosis7 = new DiagnosisModel(17, "Simon", DateUtil.stringToDate("11-06-2024"), "Illness");
        DiagnosisModel diagnosis8 = new DiagnosisModel(18, "Margarita", DateUtil.stringToDate("28-03-2024"), "Illness");
        diagnosisStorage.add(diagnosis1);
        diagnosisStorage.add(diagnosis2);
        diagnosisStorage.add(diagnosis3);
        diagnosisStorage.add(diagnosis4);
        diagnosisStorage.add(diagnosis5);
        diagnosisStorage.add(diagnosis6);
        diagnosisStorage.add(diagnosis7);
        diagnosisStorage.add(diagnosis8);
//        PATIENTS
        PatientModel patient1 = new PatientModel(201, "Azat", "Anibaryan", 45, "AT8762345", PersonType.PATIENT, "u001", "099112385", doctor1, THE_DISEASE_HAS_JUST_OCCURRED, diagnosis1, diagnosis1.getDateOfDiagnosis());
        PatientModel patient2 = new PatientModel(202, "Ani", "Karapetyan", 22, "AT5213187", PersonType.PATIENT, "u002", "091002283", doctor2, THE_DISEASE_IS_ADVANCED, diagnosis2, diagnosis2.getDateOfDiagnosis());
        PatientModel patient3 = new PatientModel(203, "Anna", "Azizyan", 26, "AT6731285", PersonType.PATIENT, "u003", "098979695", doctor3, THE_DISEASE_HAS_JUST_OCCURRED, diagnosis3, diagnosis3.getDateOfDiagnosis());
        PatientModel patient4 = new PatientModel(204, "Karen", "Adamyan", 29, "AT6638290", PersonType.PATIENT, "u004", "094118453", doctor4, THE_DISEASE_PROGRESSES, diagnosis4, diagnosis4.getDateOfDiagnosis());
        PatientModel patient5 = new PatientModel(205, "Mariam", "Amirjanyan", 32, "AT9087532", PersonType.PATIENT, "u005", "099112244", doctor5, THE_DISEASE_PROGRESSES, diagnosis5, diagnosis5.getDateOfDiagnosis());
        PatientModel patient6 = new PatientModel(206, "Suzi", "Simonyan", 19, "AT8264738", PersonType.PATIENT, "u006", "099000098", doctor6, PatientType.THE_DISEASE_IS_IN_EXTREME_STATE, diagnosis6, diagnosis6.getDateOfDiagnosis());
        PatientModel patient7 = new PatientModel(207, "Sahak", "Abazyan", 31, "AT1198423", PersonType.PATIENT, "u007", "077846352", doctor7, THE_DISEASE_PROGRESSES, diagnosis7, diagnosis7.getDateOfDiagnosis());
        PatientModel patient8 = new PatientModel(208, "Shavarsh", "Hunanyan", 22, "AT1438921", PersonType.PATIENT, "u008", "041237462", doctor8, THE_DISEASE_HAS_JUST_OCCURRED, diagnosis8, diagnosis8.getDateOfDiagnosis());
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
        room2Members.add(patient3);
        room2Members.add(patient6);

        List<PatientModel> room3Members = new ArrayList<>();
        room3Members.add(patient4);
        room3Members.add(patient8);

        List<PatientModel> room4Members = new ArrayList<>();
        room4Members.add(patient5);

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
        Visitor visitor = new Visitor(901, "Anna", "Papazyan", 22, "AT6781432", PersonType.VISITOR, "v001", patient7, DateUtil.stringToDate("24-08-2024"));
        visitorsStorage.add(visitor);
    }

//        Registration
    private static PersonModel register() {
        System.out.println("Registration Form\nPlease input your personal information.");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your surname: ");
        String surname = scanner.nextLine();
        System.out.print("Enter your age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter your passport number: ");
        String passportNumber = scanner.nextLine();
        if (doctorsStorage.getDoctorByPassportNumber(passportNumber) != null &&
                patientsStorage.getPatientByPassportNumber(passportNumber) != null &&
                personsStorage.getPersonByPassportNumber(passportNumber) != null &&
                visitorsStorage.getVisitorByPassportNumber(passportNumber) != null) {
            System.out.println("Person with " + passportNumber + " already exists.");
        } else {
            System.out.println("Create password for your account: ");
            String password = scanner.nextLine();
            PersonModel newPerson = new PersonModel(name, surname, age, passportNumber, PersonType.PERSON, password);
            personsStorage.add(newPerson);
            return newPerson;
        }
        return null;
    }

//        Logins
    private static void login(){
        System.out.println("Login Form.");
        System.out.print("Enter your passport number: ");
        String passportNumber = scanner.nextLine();
        PersonModel person = personsStorage.getPersonByPassportNumber(passportNumber);
        Visitor visitor = visitorsStorage.getVisitorByPassportNumber(passportNumber);
        DoctorModel doctor = doctorsStorage.getDoctorByPassportNumber(passportNumber);
        PatientModel patient = patientsStorage.getPatientByPassportNumber(passportNumber);
        if (person == null && doctor == null && patient == null && visitor == null) {
            System.out.println("Invalid passport number.");
        } else {
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();
            if (person != null) {
                if (PersonModel.getPassword().equals(password)) {
                    currentPerson = person;
                    if (person.getPersonType().equals(PersonType.ADMINISTRATOR)) {
                        loginAdmin();
                    }
                    loginPerson();
                } else {
                    System.out.println("Invalid password for your person account.");
                }
            } else if (doctor != null) {
                currentDoctor = doctor;
                if (PersonModel.getPassword().equals(password)) {
                    loginDoctor();
                } else {
                    System.out.println("Invalid password for your doctor account.");
                }
            } else if (patient != null) {
                currentPatient = patient;
                if (PersonModel.getPassword().equals(password)) {
                    loginPatient();
                } else {
                    System.out.println("Invalid password for your patient account.");
                }
            } else if (visitor != null) {
                currentVisitor = visitor;
                if (PersonModel.getPassword().equals(password)) {
                    loginVisitor();
                } else {
                    System.out.println("Invalid password for your visitor account.");
                }
            }
        }
    }
    private static void loginVisitor() {
        boolean run = true;
        while (run) {
            System.out.println("\nHi " + currentPerson.getName());
            Commands.printVisitorsCommands();
            String command;

            try {
                command = scanner.nextLine();
            } catch (NumberFormatException e) {
                command = "-1";
            }

            switch (command) {
                case EXIT:
                    run = false;
                    break;
                case PRINT_INFO_ABOUT_PATIENT:
                    currentVisitor.getPatient().toString();
                    break;
                case PRINT_DOCTOR_INFO:
                    currentVisitor.getPatient().getDoctor().toString();
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }
    private static void loginPatient() {
        boolean run = true;
        while (run) {
            System.out.println("\nHi " + currentPerson.getName());
            Commands.printPatientsCommands();
            String command;

            try {
                command = scanner.nextLine();
            } catch (NumberFormatException e) {
                command = "-1";
            }

            switch (command) {
                case EXIT:
                    run = false;
                    break;
                case PRINT_ALL_DOCTORS:
                    doctorsStorage.printDoctors();
                    break;
                case CHOOSE_DOCTOR_BY_ID:
                    selectDoctorById();
                    break;
                case GET_MY_DIAGNOSIS:
                    currentPatient.getDiagnosis().toString();
                    break;
                case REGISTER_VISIT:
                    registerVisitor();
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }
    private static void loginDoctor() {
        boolean run = true;
        while (run) {
            System.out.println("\nHi " + currentPerson.getName());
            Commands.printDoctorCommands();
            String command;

            try {
                command = scanner.nextLine();
            } catch (NumberFormatException e) {
                command = "-1";
            }

            switch (command) {
                case EXIT:
                    run = false;
                    break;
                case VIEW_PATIENTS_INFO_BY_ID:
                    viewPatientsInfo();
                    break;
                case UPDATE_PATIENTS_DIAGNOSIS_BY_ID:
                    updatePatientsDiagnosis();
                    break;
                case UPDATE_PATIENTS_TYPE_BY_ID:
                    updatePatientsType();
                    break;
                case PRINT_MY_PATIENTS:
                    printMyPatients();
                    break;
                case DELETE_PATIENT_BY_ID:
                    dischargePatient();
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }
    private static void loginPerson(){
        boolean run = true;
        while (run) {
            System.out.println("\nHi " + currentPerson.getName());
            Commands.printPersonsCommands();
            String command;

            try {
                command = scanner.nextLine();
            } catch (NumberFormatException e) {
                command = "-1";
            }

            switch (command) {
                case EXIT:
                    run = false;
                    break;
                case PRINT_DOCTORS_LIST:
                    doctorsStorage.printDoctors();
                    break;
                case SELECT_DOCTOR_FOR_CONSULTATION_BY_ID:
                    selectDoctorById();
                    break;
                case SELECT_PATIENT_FOR_VISIT_BY_ID:
                    selectPatientById();
                    break;
                default:
                    System.out.println("Invalid command !");
            }

        }
    }
    private static void loginAdmin() {
        boolean run = true;
        while (run) {
            System.out.println("\nHi " + currentPerson.getName());
            Commands.printAdminCommands();
            String command;

            try {
                command = scanner.nextLine();
            } catch (NumberFormatException e) {
                command = "-1";
            }
            switch (command) {
                case EXIT:
                    run = false;
                    break;
                case PRINT_DOCTORS_LIST:
                    printDoctorsWithContactInfo();
                    break;
                case ADD_DOCTOR:
                    addDoctor();
                    break;
                case DELETE_DOCTOR:
                    deleteDoctor();
                    break;
                case GET_DOCTOR_BY_ID:
                    selectDoctorById();
                    break;
                case PRINT_PATIENTS_LIST:
                    patientsStorage.printPatients();
                    break;
                case PRINT_VISITORS_LIST:
                    visitorsStorage.printVisitors();
                    break;
                default:
                    System.out.println("Invalid command !");
            }
        }
    }

//        Methods
    private static void registerVisitor() {
        int visitorId = rand.nextInt(100);
        System.out.print("Please input visitor's name: ");
        String name = scanner.nextLine();
        System.out.print("Please input visitor's surname: ");
        String surname = scanner.nextLine();
        System.out.print("Please input visitor's age: ");
        int age = scanner.nextInt();
        System.out.print("Please input visitor's passport number: ");
        String passportNumber = scanner.nextLine();
        System.out.print("Please create password for your visitor: ");
        String password = scanner.nextLine();
        Date date = new Date();
        Visitor visitor = new Visitor(visitorId, name, surname, age, passportNumber, PersonType.VISITOR, password, currentPatient, date);
        visitorsStorage.add(visitor);
    }
    private static void dischargePatient(){
        System.out.print("Please input patient's id: ");
        int patientId = scanner.nextInt();
        patientsStorage.deletePatientById(patientId);
    }
    private static void printMyPatients(){
        patientsStorage.printPatientsByDoctor(currentDoctor);
    }
    private static void updatePatientsType() {
        System.out.print("Input patients id: ");
        int patientId = scanner.nextInt();
        PatientModel patient = patientsStorage.getPatientById(patientId);
        if (patient != null) {
            System.out.println("Ok. Take Info about patient" + patient);
            System.out.print("Now input new type: ");
            int command = scanner.nextInt();
            PatientType x = THE_DISEASE_HAS_JUST_OCCURRED;
            switch (command) {
                case 1:
                    x = THE_DISEASE_HAS_JUST_OCCURRED;
                    break;
                case 2:
                    x = THE_DISEASE_PROGRESSES;
                    break;
                case 3:
                    x = THE_DISEASE_IS_ADVANCED;
                    break;
                case 4:
                    x = THE_DISEASE_IS_IN_EXTREME_STATE;
                    break;
                default:
                    System.out.println("Invalid command !");
            }

            patient.setPatientType(x);
            System.out.println("Patient's type successfully updated !");
        } else {
            System.out.println("Invalid patient id !");
        }
    }
    private static void updatePatientsDiagnosis() {
        System.out.print("Input patients id: ");
        int patientId = scanner.nextInt();
        PatientModel patient = patientsStorage.getPatientById(patientId);
        if (patient != null) {
            System.out.println("Ok. Take Info about patient" + patient);
            System.out.print("Now input new diagnosis description: ");
            int id = rand.nextInt();
            String diagnosisDescription = scanner.nextLine();
            Date date = new Date();
            DiagnosisModel newDiagnosis = new DiagnosisModel(id, currentDoctor.getName(), date, diagnosisDescription);
            patient.setDiagnosis(newDiagnosis);
            System.out.println("Diagnosis successfully updated !");
        } else {
            System.out.println("Invalid patient id !");
        }
    }
    private static void viewPatientsInfo(){
        System.out.print("Input patients id: ");
        int patientId = scanner.nextInt();
        PatientModel patient = patientsStorage.getPatientById(patientId);
        if (patient != null) {
            System.out.println("Ok. Take Info about " + patient);
        } else {
            System.out.println("Invalid patient id !");
        }
    }
    private static void deleteDoctor() {
        System.out.print("Please input doctors id: ");
        int doctorId = scanner.nextInt();
        doctorsStorage.deleteDoctorById(doctorId);
        System.out.println("Doctor with id " + doctorId + "successfully deleted.");
    }
    private static void addDoctor(){
        int newDoctorId = rand.nextInt(100);
        PersonModel pers = register();
        if (pers != null) {
            System.out.print("Input doctor's phone number: ");
            String phoneNumber = scanner.nextLine();
            System.out.println("Select doctor's specialization from list using number\n" +
                    "1: INTERNAL_MEDICINE, 2: SURGERY, 3: FAMILY_MEDICINE, 4: DERMATOLOGY,\n" +
                    "    5: CARDIOLOGY, 6: GASTROENTEROLOGY, 7:ONCOLOGY, 8: NEUROLOGY");
            int specialization = scanner.nextInt();
            DoctorSpecialization x = DoctorSpecialization.CARDIOLOGY;
            switch (specialization) {
                case 1:
                    x = DoctorSpecialization.INTERNAL_MEDICINE;
                    break;
                case 2:
                    x = DoctorSpecialization.SURGERY;
                    break;
                case 3:
                    x = DoctorSpecialization.FAMILY_MEDICINE;
                    break;
                case 4:
                    x = DoctorSpecialization.DERMATOLOGY;
                    break;
                case 5:
                    x = DoctorSpecialization.CARDIOLOGY;
                    break;
                case 6:
                    x = DoctorSpecialization.GASTROENTEROLOGY;
                    break;
                case 7:
                    x = DoctorSpecialization.ONCOLOGY;
                    break;
                case 8:
                    x = DoctorSpecialization.NEUROLOGY;
                    break;
                default:
                    System.out.println("Invalid command!");
            }
            DoctorModel newDoctor = new DoctorModel(newDoctorId,pers.getName(),pers.getSurname(),
                    pers.getAge(),pers.getPassportCode(),PersonType.DOCTOR, PersonModel.getPassword(),phoneNumber, x);

            doctorsStorage.add(newDoctor);
            System.out.println("Doctor with id " + newDoctorId + "successfully added.");
        }

    }
    private static void printDoctorsWithContactInfo() {
        doctorsStorage.printDoctors(1);
    }
    private static void selectDoctorById(){
        System.out.print("Please input doctor's id :");
        int id = scanner.nextInt();
        if (doctorsStorage.getDoctorById(id) != null) {
            System.out.println("Ok, take Doctors contact info.\n" +
                    doctorsStorage.getDoctorById(id).toString(1));
        } else {
            System.out.println("Doctor not found.");
        }
    }
    private static void selectPatientById(){
        System.out.print("Please input patient id :");
        int id = scanner.nextInt();
        if (patientsStorage.getPatientById(id) != null) {
            int newVisitorId = rand.nextInt(100);
            Date registrationDate = new Date();
            Visitor visitor = new Visitor(newVisitorId,currentPerson.getName(), currentPerson.getSurname(),
                    currentPerson.getAge(),currentPerson.getPassportCode(),PersonType.VISITOR,
                    PersonModel.getPassword(),patientsStorage.getPatientById(id), registrationDate);
            System.out.println("Ok, you are just registered as Visitor.\nYou can visit patient.");
        }
    }


}