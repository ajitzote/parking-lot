package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);

        ParkingLot pl = new ParkingLot("PR1234",2,6);

        while(true){
            String command = scanner.nextLine();
            String s = command.toUpperCase();
            String[] s1 = s.split(" ", 0);

//            System.out.println(s1[1]);


            if(s1[0].equals("DISPLAY")) {

                if (s1[1].equals("FREE_COUNT")) {
                    if (s1[2].equals("CAR")){
                        pl.displayFreeCount(VehicleType.CAR);
                    }
                    else if (s1[2].equals("TRUCK")){

                        pl.displayFreeCount(VehicleType.TRUCK);
                    }
                    else if (s1[2].equals("BIKE")){

                        pl.displayFreeCount(VehicleType.BIKE);
                    }
                }

                if (s1[1].equals("FREE_SLOTS")) {
                    if (s1[2].equals("CAR")){
                        pl.displayFreeSlots(VehicleType.CAR);
                    }
                    else if (s1[2].equals("TRUCK")){

                        pl.displayFreeSlots(VehicleType.TRUCK);
                    }
                    else if (s1[2].equals("BIKE")){

                        pl.displayFreeSlots(VehicleType.BIKE);
                    }
                }

                if (s1[1].equals("OCCUPIED_SLOTS")) {
                    if (s1[2].equals("CAR")){
                        pl.displayOccupiedSlots(VehicleType.CAR);
                    }
                    else if (s1[2].equals("TRUCK")){

                        pl.displayOccupiedSlots(VehicleType.TRUCK);
                    }
                    else if (s1[2].equals("BIKE")){

                        pl.displayOccupiedSlots(VehicleType.BIKE);
                    }
                }
            }

            if(s1[0].equals("PARK_VEHICLE")){
                if(s1[1].equals("BIKE")){
                    Vehicle vehicle = new Vehicle(VehicleType.BIKE,s1[2],s1[3]);
                    pl.parkVehicle(VehicleType.BIKE,vehicle);

                }
                if(s1[1].equals("CAR")){
                    Vehicle vehicle = new Vehicle(VehicleType.CAR,s1[2],s1[3]);
                    pl.parkVehicle(VehicleType.CAR,vehicle);

                }
                if(s1[1].equals("TRUCK")){
                    Vehicle vehicle = new Vehicle(VehicleType.TRUCK,s1[2],s1[3]);
                    pl.parkVehicle(VehicleType.TRUCK,vehicle);

                }
            }

            if(s1[0].equals("UNPARK_VEHICLE")){
                pl.unparkVehicle(s1[1]);
            }

            if(s1[0].equals("EXIT")){
                return;
            }

        }




    }
}