package com.company;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.lang.Object;



import java.math.BigDecimal;
import java.io.*;
import java.util.Vector;


public class JsonFile {
   // public class JSONArray extends Vector; {
     //   JSONArray jsonVector = new JSONArray();
    //}
    private static String pathToJsonFile = System.getenv("JSON");
    private static JSONParser jsonParser = new JSONParser();

    public Integer getVectorSize() {
        int i = 0;
        try {
            System.out.println(pathToJsonFile);
            JSONArray jsonVector = (JSONArray) jsonParser.parse(new FileReader(pathToJsonFile));
            for (Object obj : jsonVector) {
                i++;
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (ParseException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return i;
    }

    public static String getName(int index) {
        String vectorName = null;
        try {
            JSONArray jsonVector = (JSONArray) jsonParser.parse(new FileReader(pathToJsonFile));
            JSONObject jsonData = (JSONObject) jsonVector.get(index);
            vectorName = (String) jsonData.get("name");
        } catch (IOException e) {
            System.err.println(e);
        } catch (ParseException pe) {
            System.err.println(pe);
        }
        return vectorName;
    }
    public static int getId(int index) {
        int numId = 0;
        try {
            JSONArray jsonVector = (JSONArray) jsonParser.parse(new FileReader(pathToJsonFile));
            JSONObject jsonData = (JSONObject) jsonVector.get(index);
            numId = BigDecimal.valueOf((Long) jsonData.get("id")).intValue();
        } catch (IOException e) {
            System.err.println(e);
        } catch (ParseException pe) {
            System.err.println(pe);
        }
        return numId;
    }

    public static Coordinates getCoordinates(int index) {
        Coordinates coordinates = new Coordinates();
        Integer jsonX = 0;
        Float jsonY = 0f;
        try {
            JSONArray jsonVector = (JSONArray) jsonParser.parse(new FileReader(pathToJsonFile));
            JSONObject jsonData = (JSONObject) jsonVector.get(index);
            jsonX = (Integer) jsonData.get("coordinate_x");
            jsonY = BigDecimal.valueOf((Double) jsonData.get("coordinate_y")).floatValue();
        } catch (IOException e) {
            System.err.println(e);
        } catch (ParseException pe) {
            System.err.println(pe);
        }
        coordinates.setX(jsonX);
        coordinates.setY(jsonY);
        return coordinates;
    }
    public static double getAnnualTurnover(int index) {
        double jsonAnnualTurnover = 0;
        try {
            JSONArray jsonVector = (JSONArray) jsonParser.parse(new FileReader(pathToJsonFile));
            JSONObject jsonData = (JSONObject) jsonVector.get(index);
            jsonAnnualTurnover = BigDecimal.valueOf((Long) jsonData.get("annualTrunover")).intValue();
        } catch (IOException e) {
            System.err.println(e);
        } catch (ParseException pe) {
            System.err.println(pe);
        }
        return jsonAnnualTurnover;
    }
    public static OrganizationType getOrganizationType(int index) {
        OrganizationType jsonOrganizationType = null;
        String numVariants;
        try {
            JSONArray jsonVector = (JSONArray) jsonParser.parse(new FileReader(pathToJsonFile));
            JSONObject jsonData = (JSONObject) jsonVector.get(index);
            numVariants = (String) jsonData.get("Organization Type");
            switch (numVariants) {
                case "COMMERCIAL":
                    jsonOrganizationType = OrganizationType.COMMERCIAL;
                    break;
                case "PUBLIC":
                    jsonOrganizationType = OrganizationType.PUBLIC;
                    break;
                case "GOVERMENT":
                    jsonOrganizationType = OrganizationType.GOVERNMENT;
                    break;
                case "TRUST":
                    jsonOrganizationType = OrganizationType.TRUST;
                    break;
            }
        } catch (IOException e) {
            System.err.println(e);
        } catch (ParseException pe) {
            System.err.println(pe);
        }
        return jsonOrganizationType;
    }
    public static String getFullName(int index) {
        String fullName = null;
        try {
            JSONArray jsonVector;
            jsonVector = (JSONArray) jsonParser.parse(new FileReader(pathToJsonFile));
            JSONObject jsonData = (JSONObject) jsonVector.get(index);
            fullName = (String) jsonData.get("Full name");
        } catch (IOException e) {
            System.err.println(e);
        } catch (ParseException pe) {
            System.err.println(pe);
        }
        return fullName;
    }
    public static int getEmployeesCount(int index) {
        int jsonEmployeesCount = 0;
        try {
            JSONArray jsonVector = (JSONArray) jsonParser.parse(new FileReader(pathToJsonFile));
            JSONObject jsonData = (JSONObject) jsonVector.get(index);
            jsonEmployeesCount = BigDecimal.valueOf((Long) jsonData.get("Employees count")).intValue();
        } catch (IOException e) {
            System.err.println(e);
        } catch (ParseException pe) {
            System.err.println(pe);
        }
        return jsonEmployeesCount;
    }
    public static Address getOfficialAddress(int index) {
        Address address = new Address();
        String jsonStreet = null;
        Location jsonTown = null;
        try {
            JSONArray jsonVector;
            jsonVector = (JSONArray) jsonParser.parse(new FileReader(pathToJsonFile));
            JSONObject jsonData = (JSONObject) jsonVector.get(index);
            jsonStreet = (String) jsonData.get("Street");
            jsonTown = (Location) jsonData.get("Town");
        } catch (IOException e) {
            System.err.println(e);
        } catch (ParseException pe) {
            System.err.println(pe);
        }
        address.setStreet(jsonStreet);
        address.setTown(jsonTown);
        return address;
    }
}
