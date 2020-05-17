package HomeWork8;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private List<Furniture> listOfFurniture = new ArrayList<>();
    private List<Light> listOfIllumination = new ArrayList<>();

    private String nameOfRoom;
    private double square;
    private int numberOfWindows;
    private int lightFromWindow;
    private int sumOfSquareOfFurniture;

    private static final int LIGHT_FROM_ONE_WINDOW = 700;
    private static final int MINIMUM_REQUIRED_LIGHT = 300;
    private static final int MAXIMUM_REQUIRED_LIGHT = 4000;
    private static final double MAXIMUM_SQUARE = 0.7;

    public Room(String nameOfRoom, double square, int numberOfWindows) {
        this.nameOfRoom = nameOfRoom;
        this.square = square;
        this.numberOfWindows = numberOfWindows;
        this.lightFromWindow = numberOfWindows * LIGHT_FROM_ONE_WINDOW;
    }

    public String getNameOfRoom() {
        return nameOfRoom;
    }

    public void add(Light lightBulb) throws IlluminanceTooMuchException {
        if (lightFromWindow + lightBulb.getLight() < MINIMUM_REQUIRED_LIGHT || lightFromWindow + lightBulb.getLight() > MAXIMUM_REQUIRED_LIGHT) {
            throw new IlluminanceTooMuchException(getNameOfRoom() + " is out of range 300k - 4000 lx");
        }
        listOfIllumination.add(lightBulb);
        lightFromWindow += lightBulb.getLight();
    }

    public void add(Furniture furniture) {
        if (sumOfSquareOfFurniture + furniture.getSquareOfFurniture() > square * MAXIMUM_SQUARE) {
            throw new SpaceUsageTooMuchException(getNameOfRoom() + " more than 70% of that room is occupied by furniture");
        }
        listOfFurniture.add(furniture);
        sumOfSquareOfFurniture += furniture.getSquareOfFurniture();
    }

    public double occupiedPlace() {
        return (100 * sumOfSquareOfFurniture) / square;
    }

    @Override
    public String toString() {
        return (nameOfRoom + " with illumination = " + lightFromWindow + "lx " + "( " + numberOfWindows + " - windows, each with 700 lx, " +
                +listOfIllumination.size() + " - lightbulbs)." + "\n" + "Square of room - " + square + "m^2, " + listOfFurniture.size() + " - furniture takes " + sumOfSquareOfFurniture + "m^2, " +
                "occupied place " + occupiedPlace() + "%");
    }
}
