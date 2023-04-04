package org.example;

public class Ticket {

    private int floor;
    private int slot;
    private String parkingLotId;

    private String ticketId;

    public Ticket(int floor, int slot, String parkingLotId) {
        this.floor = floor;
        this.slot = slot;
        this.parkingLotId = parkingLotId;
        setTicketId();
    }

    public void setTicketId() {
        this.ticketId = this.parkingLotId+"_"+Integer.toString(this.floor)+"_"+Integer.toString(this.slot);
    }

    public String getTicketId() {
        return ticketId;
    }



}
