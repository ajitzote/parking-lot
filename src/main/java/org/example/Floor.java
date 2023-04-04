package org.example;

import java.util.*;

public class Floor {

    public Map<Integer,Slot> slots = new HashMap<Integer,Slot>();

    public Floor(int noOfSlots) {

        initializeFloor(noOfSlots);

    }





    private void initializeFloor(int noOfSlots){
        Slot s = new Slot();

        for(int i=1;i<=noOfSlots;i++){

            switch(i) {
                case 1:
                    s = new Slot(VehicleType.TRUCK);
                    break;
                case 2:
                    s = new Slot(VehicleType.BIKE);
                    break;
                case 3:
                    s = new Slot(VehicleType.BIKE);
                    break;
                default:
                    s = new Slot(VehicleType.CAR);
                    break;
            }
            this.slots.put(i,s);
        }


    }

    public Map<Integer, Slot> getSlots() {
        return this.slots;
    }

    public int countFreeSlots(VehicleType v){
        int count=0;
        for(int i=1;i<=this.slots.size();i++){

            Slot temp = this.slots.get(i);
            if(temp.getSlotVehicleType()==v && !temp.getOccupied()){
                count++;
            }
        }
        return count;

    }

    public List<Integer> getFreeSlots(VehicleType v) {
        int count=0;
        List<Integer> freeSlots = new ArrayList<>();

        for(int i=1;i<=this.slots.size();i++){

            Slot temp = this.slots.get(i);
            if(temp.getSlotVehicleType()==v && !temp.getOccupied()){
                freeSlots.add(i);
            }
        }
        return freeSlots;
    }

    public List<Integer> getOccupiedSlots(VehicleType v) {
        int count=0;
        List<Integer> OccupiedSlots = new ArrayList<>();

        for(int i=1;i<=this.slots.size();i++){

            Slot temp = this.slots.get(i);
            if(temp.getSlotVehicleType()==v && temp.getOccupied()){
                OccupiedSlots.add(i);
            }

        }
        return OccupiedSlots;
    }

    public Integer getFreeSlot(VehicleType v) {

        for(int i=1;i<=this.slots.size();i++){

            Slot temp = this.slots.get(i);
            if(temp.getSlotVehicleType()==v && !temp.getOccupied()){
                return i;
            }

        }
        return null;
    }

}
