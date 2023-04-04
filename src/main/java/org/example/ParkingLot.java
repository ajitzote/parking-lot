package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingLot {

    private String parkingLotId;
    private Integer noOfFloors;

    private Integer noOfSlotsPerFloor;

    private ArrayList<Floor> parkingFloors;


    public ParkingLot(String parkingLotId, int noOfFloors, int noOfSlotsPerFloor) {
        this.parkingLotId =parkingLotId;
        this.noOfFloors = noOfFloors;
        this.noOfSlotsPerFloor = noOfSlotsPerFloor;
        parkingFloors = new ArrayList<>();
        initializeParkingLot();
    }


    private void initializeParkingLot() {

    for(int i=1;i<=noOfFloors;i++){
        Floor floor = new Floor(noOfSlotsPerFloor);
        boolean add = this.parkingFloors.add(floor);
    }



    }

    public void displayFreeCount(VehicleType v){

        for(int i=0;i<this.parkingFloors.size();i++){

            int freeSlots = countFreeSlots(v,parkingFloors.get(i));

            System.out.println("No. of free slots for "+v+" on Floor "+(i+1)+": "+freeSlots);
        }

    }

    private int countFreeSlots(VehicleType v,Floor floor) {

        return floor.countFreeSlots(v);

    }


    public void displayFreeSlots(VehicleType v) {

        for(int i=0;i<this.parkingFloors.size();i++){

            List <Integer> freeSlots = getFreeSlots(v,parkingFloors.get(i));

            System.out.println("No. of free slots for "+v+" on Floor "+(i+1)+": "+freeSlots);
        }

    }

    private List<Integer> getFreeSlots(VehicleType v, Floor floor) {

        return floor.getFreeSlots(v);

    }

    public void displayOccupiedSlots(VehicleType v) {
        for(int i=0;i<this.parkingFloors.size();i++){

            List<Integer> occupiedSlots= this.parkingFloors.get(i).getOccupiedSlots(v);
            System.out.println("occupied slots for "+v+" on Floor "+(i+1)+": "+occupiedSlots);

        }
    }

    public void parkVehicle(VehicleType v,Vehicle vehicle) {
    boolean parked=false;
        for(int i=0;i<this.parkingFloors.size();i++){

            Integer freeSlotNo = parkingFloors.get(i).getFreeSlot(v);

            if(freeSlotNo!=null){
                Ticket ticket = new Ticket(i+1,freeSlotNo, this.parkingLotId);

                vehicle.setTicket(ticket);

                parkingFloors.get(i).getSlots().get(freeSlotNo).setVehicle(vehicle);
                parkingFloors.get(i).getSlots().get(freeSlotNo).setOccupied(true);

                System.out.println("Parked vehicle. Ticket ID: "+parkingFloors.get(i).getSlots().get(freeSlotNo).getVehicle().getTicket().getTicketId() );


                parked=true;

                break;

            }


        }
        if(parked==false) {
            System.out.println("Parking Lot Full");
        }

    }

    public void unparkVehicle(String ticketId) {
         String[] s1 = ticketId.split("_", 0);
         if(Integer.valueOf(s1[1])>this.parkingFloors.size() || Integer.valueOf(s1[2]) > this.parkingFloors.get(0).slots.size()){
             System.out.println("Invalid ticket");
             return;
         }
         Floor floor= this.parkingFloors.get(Integer.valueOf(s1[1])-1);
         Slot slot=  floor.slots.get(Integer.valueOf(s1[2]));
         slot.unparkVehicle();

    }

}
