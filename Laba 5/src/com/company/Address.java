package com.company;

public class Address {
    private String street; //Поле не может быть null
    private Location town; //Поле не может быть null

    public void setStreet(String street){
        this.street = street;
    }

    public String getStreet(){
        return street;
    }

    public void setTown(Location town) {
        this.town = town;
    }

    public Location getTown() {
        return town;
    }


}
