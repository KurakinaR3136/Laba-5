package com.company;
import java.time.ZonedDateTime;

public class Organization {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double annualTurnover; //Значение поля должно быть больше 0
    private String fullName; //Значение этого поля должно быть уникальным, Поле может быть null
    private int employeesCount; //Значение поля должно быть больше 0
    private OrganizationType type; //Поле может быть null
    private Address officialAddress; //Поле не может быть null


public Organization() {
        double num;
        num = Math.random() * 141400;
        id = (int) num;
        creationDate = ZonedDateTime.now();
        }

        public int getId() { return id; }

        public void setId(int id){ this.id = id; }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setAnnualTurnover(double annualTurnover){
    this.annualTurnover = annualTurnover;
    }

    public double getAnnualTurnover(){
        return annualTurnover;
    }

 public void setType (OrganizationType type){
    this.type = type;
 }

 public OrganizationType getType(){
    return type;
 }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }


    public void setEmployeesCount(int employeesCount) {
        this.employeesCount = employeesCount;
    }

    public int getEmployeesCount() {
        return employeesCount;
    }

    public void setOfficialAddress(Address officialAddress) {
        this.officialAddress = officialAddress;
    }

    public Address getOfficialAddress() {
        return officialAddress;
    }
}