package storage;

import model.HospitalRoom;

public class RoomsStorage {
    private static HospitalRoom[] rooms = new HospitalRoom[10];
    private static int size = 0;

    public void add(HospitalRoom room) {
        if (rooms.length == size) {
            extend();
        }
        rooms[size++] = room;
    }

    private static void extend() {
        HospitalRoom[] temp = new HospitalRoom[rooms.length + 10];
        for (int i = 0; i < size; i++) {
            temp[i] = rooms[i];
        }
        rooms = temp;
    }

    public void printRooms() {
        for (int i = 0; i < size; i++) {
            System.out.println( i + ": " + rooms[i].toString() + "\n");
        }
    }

    public boolean isEmpty(HospitalRoom[] arrays){
        return size == 0;
    }

}
