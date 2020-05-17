package HomeWork8;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Building {
    Logger logger = LogManager.getLogger();
    private String buildingName;
    private List<Room> list = new ArrayList();

    public Building(String buildingName) {
        this.buildingName = buildingName;
    }

    public void addRoom(Room room) {
        list.add(room);
    }

    public void describe() {
        for (Room room : list) {
            logger.info(buildingName + " includes " + room);
        }
    }

    public Room getRoom(String roomName) {
        for (Room room : list) {
            if (room.getNameOfRoom().equals(roomName)) {
                return room;
            }
        }
        return null;
    }
}
