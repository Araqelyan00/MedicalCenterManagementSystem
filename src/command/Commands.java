package command;

public interface Commands {

    //        Main commands
    String EXIT = "0";
    String LOGIN = "1";
    String REGISTER = "2";

    //        Doctor commands
    String VIEW_PATIENTS_INFO_BY_ID = "1";
    String UPDATE_PATIENTS_DIAGNOSIS_BY_ID = "2";
    String UPDATE_PATIENTS_TYPE_BY_ID = "3";
    String PRINT_MY_PATIENTS = "4";
    String DELETE_PATIENT_BY_ID = "5";

    //        Patient commands
    String PRINT_ALL_DOCTORS = "1";
    String CHOOSE_DOCTOR_BY_ID = "2";
    String GET_MY_DIAGNOSIS = "3";
    String REGISTER_VISIT = "4";

    //        Admin commands
    String PRINT_DOCTORS_LIST = "1";
    String ADD_DOCTOR = "2";
    String DELETE_DOCTOR = "3";
    String GET_DOCTOR_BY_ID = "4";
    String PRINT_PATIENTS_LIST = "5";
    String PRINT_VISITORS_LIST = "6";

//            Visitor commands
    String PRINT_INFO_ABOUT_PATIENT = "1";
    String PRINT_DOCTOR_INFO = "2";

//            Person commands
    String SELECT_DOCTOR_FOR_CONSULTATION_BY_ID = "2";
    String SELECT_PATIENT_FOR_VISIT_BY_ID = "3";

    static void printLoginCommands() {
        System.out.println("Input " + EXIT + " to exit");
        System.out.println("Input " + LOGIN + " to login");
        System.out.println("Input " + REGISTER + " to register");
        System.out.print("\nInput command :");
    }

    static void printAdminCommands() {
        System.out.println("Input " + EXIT + " to exit");
        System.out.println("Input " + PRINT_DOCTORS_LIST + " to print doctors list");
        System.out.println("Input " + ADD_DOCTOR + " to add doctor");
        System.out.println("Input " + DELETE_DOCTOR + " to delete doctor");
        System.out.println("Input " + GET_DOCTOR_BY_ID + " to get doctor by id");
        System.out.println("Input " + PRINT_PATIENTS_LIST + " to print patients list");
        System.out.println("Input " + PRINT_VISITORS_LIST + " to print visitors list");
        System.out.print("\nInput command :");
    }

    static void printDoctorCommands() {
        System.out.println("Input " + EXIT + " to exit");
        System.out.println("Input " + VIEW_PATIENTS_INFO_BY_ID + " to view patients info");
        System.out.println("Input " + UPDATE_PATIENTS_DIAGNOSIS_BY_ID + " to update patients diagnosis");
        System.out.println("Input " + UPDATE_PATIENTS_TYPE_BY_ID + " to update patients type information");
        System.out.println("Input " + PRINT_MY_PATIENTS + " to print my patients list");
        System.out.println("Input " + DELETE_PATIENT_BY_ID + " to discharge the patient");
        System.out.print("\nInput command :");
    }

    static void printPatientsCommands() {
        System.out.println("Input " + EXIT + " to exit");
        System.out.println("Input " + PRINT_ALL_DOCTORS + " to print all doctors list");
        System.out.println("Input " + CHOOSE_DOCTOR_BY_ID + " to choose doctor by id");
        System.out.println("Input " + GET_MY_DIAGNOSIS + " to get my diagnosis");
        System.out.println("Input " + REGISTER_VISIT + " to register a visit");
        System.out.print("\nInput command :");
    }

    static void printVisitorsCommands() {
        System.out.println("Input " + EXIT + " to exit");
        System.out.println("Input " + PRINT_INFO_ABOUT_PATIENT + " to print info about patient");
        System.out.println("Input " + PRINT_DOCTOR_INFO + " to print doctor info");
        System.out.print("\nInput command :");
    }

    static void printPersonsCommands() {
        System.out.println("Input " + EXIT + " to exit");
        System.out.println("Input " + PRINT_DOCTORS_LIST + " to print doctors list");
        System.out.println("Input " + SELECT_DOCTOR_FOR_CONSULTATION_BY_ID + " to select doctor for consultation");
        System.out.println("Input " + SELECT_PATIENT_FOR_VISIT_BY_ID + " to visit patient");
        System.out.print("\nInput command :");
    }
}