package com.tonasolution;

import java.util.ArrayList;

public class GearBox {
    private ArrayList<Gear> gears;
    private int maxGears;
    private int currentGear = 0;
    private boolean clutchIsIn;

    public GearBox(int maxGears) {
        this.maxGears = maxGears;
        this.gears = new ArrayList<Gear>();
        Gear neutral = new Gear(0, 0.0);
        this.gears.add(neutral);
    }
    public void operateClutch(boolean in){
        this.clutchIsIn = in;
    }
    public void addGear(int number, double ratio){
        if(( number > 0 ) && ( number <= maxGears)){
            Gear newGear = new Gear(number, ratio);
            this.gears.add(newGear);
        }
    }

    public void changeGear(int newGear){
        if((newGear > 0 ) && (newGear < this.gears.size() && clutchIsIn)){
            this.currentGear = newGear;
            System.out.println("Gear " + newGear + "selected.");
        } else {
            System.out.println("Grind!");
            this.currentGear = 0;
        }
    }
    public double wheelSpeed(int rev){
        if(clutchIsIn){
            System.out.println("Screem!!");
            return 0.0;
        }
        return rev * (this.gears.get(this.currentGear).getRatio());
    }

    private class Gear {
        private int gearNumber;
        private double ratio;

        public Gear(int gearNumber, double ratio) {
            this.gearNumber = gearNumber;
            this.ratio = ratio;
        }
        public double driveSpeed(int revs){
            return revs * this.ratio;
        }

        public int getGearNumber() {
            return gearNumber;
        }

        public double getRatio() {
            return ratio;
        }
    }
}
