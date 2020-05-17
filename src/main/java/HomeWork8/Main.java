package HomeWork8;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static void main(String[] args) {
        System.setProperty("log4j.configurationFile", "C:\\Users\\Admin\\IdeaProjects\\FinalHomeWork\\src\\main\\resources\\log4j2.xml");
        Logger logger = LogManager.getLogger();
        Building building = new Building("Office building");
        Room room1 = new Room("Accountant room", 110, 3);
        Room room2 = new Room("Technical support room", 100, 2);

        building.addRoom(room1);
        building.addRoom(room2);

        try {
            building.getRoom("Accountant room").add(new Light(30));
            building.getRoom("Accountant room").add(new Light(100));
            building.getRoom("Accountant room").add(new Furniture("Desk", 10));
            building.getRoom("Accountant room").add(new Furniture("Chair", 1));
            building.getRoom("Technical support room").add(new Light(50));
            building.getRoom("Technical support room").add(new Light(50));
            building.getRoom("Technical support room").add(new Furniture("Desk", 6));
            building.getRoom("Technical support room").add(new Furniture("Chair",2));
        } catch (IlluminanceTooMuchException | SpaceUsageTooMuchException e) {
            logger.error(e);
        }
        building.describe();

    }
}