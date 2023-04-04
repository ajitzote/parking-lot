package org.example;

public class Slot {
    private VehicleType slotVehicleType;
    private Boolean occupied;

    private Vehicle vehicle;

    public Slot(VehicleType slotVehicleType) {
        this.slotVehicleType = slotVehicleType;
        this.occupied = false;
        this.vehicle=null;
    }

    public VehicleType getSlotVehicleType() {
        return slotVehicleType;
    }

    public void setSlotVehicleType(VehicleType slotVehicleType) {
        this.slotVehicleType = slotVehicleType;
    }

    public Boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }

    public Slot() {
        this.occupied=false;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void unparkVehicle() {
        if(this.vehicle==null && this.occupied==false){
            System.out.println("Invalid ticket");
        }
        else{
            Vehicle temp = getVehicle();

            this.vehicle=null;
            this.occupied=false;

            System.out.println("Unparked vehicle with Registration Number: "+temp.getRegNo()+" and Colour: "+temp.getColour());

        }

    }

}
