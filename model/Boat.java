package nl.workingtalent.dock.model;

public class Boat {
    private String type;
    private double length;
    private String color;

    public Boat(String type, double length, String color) {
        this.type = type;
        this.length = length;
        this.color = color;

    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return  "type = " + type +
                ", length = " + length +
                ", color = " + color;
    }
}
