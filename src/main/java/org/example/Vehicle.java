package org.example;

public class Vehicle {
    private VehicleType type;
    private String regNo;
    private String colour;



    private Ticket ticket = null;
    public Vehicle(VehicleType type, String regNo, String colour) {
        this.type = type;
        this.regNo = regNo;
        this.colour = colour;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getColour() {
        return colour;
    }

}
