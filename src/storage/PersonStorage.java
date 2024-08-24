package storage;

import model.PersonModel;

public class PersonStorage {
    private static PersonModel[] persons = new PersonModel[10];
    private static int size = 0;

    public void add(PersonModel person) {
        if (persons.length == size) {
            extend();
        }
        persons[size++] = person;
    }

    private static void extend() {
        PersonModel[] temp = new PersonModel[persons.length + 10];
        for (int i = 0; i < size; i++) {
            temp[i] = persons[i];
        }
        persons = temp;
    }

    public void printPersons() {
        for (int i = 0; i < size; i++) {
            System.out.println(persons[i].toString() + "\n");
        }
    }

    public boolean isEmpty(PersonModel[] arrays){
        return size == 0;
    }


    public PersonModel getPersonByPassportNumber(String passportNumber){
        for (int i = 0; i < size; i++) {
            if (persons[i].getPassportCode().equals(passportNumber)) {
                return persons[i];
            }
        }
        return null;
    }


}
