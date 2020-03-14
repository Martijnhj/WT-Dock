package nl.workingtalent.dock.model;


import java.sql.SQLOutput;

public class Dock {
    private Boat[] boatsInDock;

    public Dock(int size) {
        boatsInDock = new Boat[size];
    }

    public int getDockSize() {
        return boatsInDock.length;
    }

    public void addBoat(Boat boat, long location) {
            boatsInDock[(int)location] = boat;
            System.out.println("Received number: " + (location+1) + "\n");
    }

    public void removeBoat(long id, String type) {
        if (this.rightBoat(id, type)) {
            boatsInDock[(int) id-1] = null;
        } else {
            System.out.println("Couldn't find your boat on this place");
        }
    }

    public long spaceChecker() {
            long location;
            location = java.util.Arrays.asList(boatsInDock).indexOf(null);
            return location;
    }

    public String printBoatChoice(long id, String type) {
        if (this.rightBoat(id, type)) {
            return "The selected boat on " + id + " has the following features: " + boatsInDock[(int) id-1];
        } else {
            return "We couldn't find this boat on this location.";
        }

    }



    public boolean rightBoat(long id, String type) {
        if (boatsInDock[(int) id-1].getType().equalsIgnoreCase(type)) {
            return true;
        } else {
            //maybe put couldn't find your boat here. but can't remain boolean then.
            return false;
        }
    }


    @Override
    public String toString() {
        String status1 = "\n";

        for (int i = 0; i < boatsInDock.length; i++) {

            if (boatsInDock[i] == null) {
                status1 += "Location " + (i+1) + " is empty.\n";
            } else {
                status1 += "Location " + (i+1) + ": " + boatsInDock[i] + "\n";
            }

        }

        return status1;
    }
}