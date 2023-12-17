package FlatProject.models.rooms;


import FlatProject.menu.Application;

import java.io.Serializable;

import static FlatProject.menu.Application.doubleFormatter;

public abstract class AbstractRoom implements Serializable {
    private String numberRoom;
    private double width;
    private double length;
    private double square;

    public AbstractRoom(String numberRoom, double width, double length, double square) {
        this.numberRoom = numberRoom;
        this.width = width;
        this.length = length;
        this.square = square;
    }

    private void cleanRoom(){
        //cleaning room
    }

    public String getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(String numberRoom) {
        this.numberRoom = numberRoom;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = width*length;
    }

    @Override
    public String toString() {
        return "numberRoom='" + numberRoom + '\'' +
                ", width=" + width +
                ", length=" + length +
                ", square=" + Application.doubleFormatter.format(square);
    }

    //https://javarush.com/groups/posts/2372--patternih-proektirovanija-factorymethod
}
