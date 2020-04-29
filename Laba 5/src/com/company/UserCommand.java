package com.company;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.List;

import java.io.*;
import java.util.*;


public class UserCommand {
    List<File> tempList;
    JsonFile jsonFile = new JsonFile();
    java.util.Vector<Organization> organizationVector;
    private int arraySize = 0;

    public UserCommand() {
        arraySize = jsonFile.getVectorSize();
        organizationVector = firstElement();
    }
    public java.util.Vector<Organization> firstElement() {
        organizationVector = new java.util.Vector<>(createFirstObject());
        return organizationVector;
    }
    public void newElement(Organization org) {
        organizationVector.add(org);
    }
    public void info() {
        System.out.println("Size: " + organizationVector.size());
        System.out.println("isEmpty: " + organizationVector.isEmpty());
        System.out.println("Type: " + organizationVector.getClass());
    }
    public void show() {
        for (Organization o : organizationVector) {
            System.out.println("/n");
            System.out.println("name: " + o.getName());
            System.out.println("id: " + o.getId());
            System.out.println("Organization Type: " + o.getType());
            System.out.print("Coordinate X: " + o.getCoordinates().getX() + " ");
            System.out.println("Coordinate Y: " + o.getCoordinates().getY());
            System.out.println("Annual Turnover: " + o.getAnnualTurnover());
            System.out.println("Full Name: " + o.getFullName());
            System.out.println("Employees Count: " + o.getEmployeesCount());
            System.out.println("Street: " + o.getOfficialAddress().getStreet());
            System.out.println("Town: " + o.getOfficialAddress().getTown());
            System.out.println("/n");
        }
    }
        public void add (String name) {
            ReadData readData = new ReadData();
            Organization newOrganization = new Organization();
            int newId;
            newOrganization.setName(name);
            newId = readData.readId();
            if(newId == 0){
            } else newOrganization.setId(newId);
            newOrganization.setCoordinates(readData.readCoordinates());
            newOrganization.setAnnualTurnover(readData.readAnnualTurnover());
            newOrganization.setType(readData.readOrganizationType());
            newOrganization.setEmployeesCount(readData.readEmployeesCount());
            newOrganization.setOfficialAddress(readData.readOfficialAddress());
            organizationVector.add(newOrganization);

            System.out.println("Элемент добавлен!");
        }
        public void removeById(int i) {
            List<Organization> tempList = new ArrayList<>(organizationVector);
            Iterator<Organization> iterator = tempList.iterator();
            try {
                while (iterator.hasNext()) {
                    Organization org = iterator.next();
                    if (org.getId() == i) {
                        iterator.remove();
                    }
                }
            } catch (Exception e) {
                System.err.println(e);
            }
            organizationVector = new Vector<>(tempList);
        }

        public void clear() {
            organizationVector.clear();
        }
        public void save() {
            JSONArray toFileArray = new JSONArray();
            for (Organization org : organizationVector) {
                JSONObject toJsonArrayObj = new JSONObject();
                try {
                    toJsonArrayObj.put("name", org.getName());
                    toJsonArrayObj.put("id", org.getId());
                    toJsonArrayObj.put("coordinate_x", org.getCoordinates().getX());
                    toJsonArrayObj.put("coordinate_y", org.getCoordinates().getY());
                    toJsonArrayObj.put("Employees count", org.getEmployeesCount());
                    toJsonArrayObj.put("Organization type", org.getType().name());
                    toJsonArrayObj.put("Annual turnover", org.getAnnualTurnover());
                    toJsonArrayObj.put("Full name", org.getFullName());
                    toJsonArrayObj.put("Street", org.getOfficialAddress().getStreet());
                    toJsonArrayObj.put("Town", org.getOfficialAddress().getTown());
                    toFileArray.add(toJsonArrayObj);
                } catch (Exception e) {
                    System.out.println("Заполните все поля!");
                }
            }
            try {
                File finalFile = new File(System.getenv("JSON"));
                PrintWriter writer = new PrintWriter(finalFile);
                writer.print("");
                writer.close();
                BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(finalFile));
                outputStream.write(toFileArray.toJSONString().getBytes());
                outputStream.flush();
                outputStream.close();
            } catch (java.io.FileNotFoundException err) {
                System.out.println("File not found!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void executeScript(String user_input){
            File file = new File(user_input);
            if (tempList.lastIndexOf(file) == -1) {
                tempList.add(file);
                try {
                    if (!file.exists() || !file.isFile()) {
                        System.out.println(("Файл не существует."));
                        return;
                    }
                    if (!file.canRead()) {
                        System.out.println("Файл защищён от чтения!");
                        return;
                    }
                    if (file.length() == 0) {
                        System.out.println("Команды отсутствуют!");
                        return;
                    }
                    Scanner newScanner = new Scanner(file);
                    while (newScanner.hasNext()) {
                        try {
                            int i = 0;
                            String temp = newScanner.nextLine();
                            String[] newSec = temp.split("\\s");
                            String command = newSec[0];
                            switch (command) {
                                case "help":
                                    helpArray();
                                    break;
                                case "info":
                                    info();
                                    break;
                                case "show":
                                    show();
                                    break;
                                case "add":
                                    if (newSec[newSec.length - 1].equals("add")) {
                                        System.out.println("Введите имя после команды!");
                                        break;
                                    }
                                    add(newSec[newSec.length - 1]);
                                    break;
                                case "remove_by_id":
                                    try {
                                        i = Integer.parseInt(newSec[newSec.length - 1]);
                                    } catch (Exception e) {
                                        System.out.println("Введите число!");
                                    }
                                    removeById(i);
                                    break;
                                case "clear":
                                    clear();
                                    break;
                                case "save":
                                    save();
                                    break;
                                case "execute_script":
                                    executeScript(newSec[newSec.length - 1]);
                                    break;
                                case "exit":
                                    System.exit(0);
                                    break;
                                default:
                                    System.out.println("Неизвестная команда");
                            }
                        } catch (Exception e) {
                            System.err.println(e);
                        }
                    }
                    tempList.remove(0);
                } catch (Exception e) {
                    System.out.println("Файл не найден!");
                }
            } else System.out.println("Обнаружен цикл!");
        }
        public void removeLower(String name) {
            LowerRemover low = new LowerRemover();
            add(name);
            List<Organization> newList = new ArrayList<>(organizationVector);
            organizationVector = low.removeLowerElement(newList);
        }
        public void removeLast(String name) {
            LastRemover last = new LastRemover();
            add(name);
            List<Organization> newList = new ArrayList<>(organizationVector);
            organizationVector = last.removeLastElement(newList);
        }
        public void removeGreater(String name) {
            GreaterRemover great = new GreaterRemover();
            add(name);
            List<Organization> newList = new ArrayList<>(organizationVector);
            organizationVector = great.removeGreaterElement(newList);
        }
        public void printFieldDescendingType() {
            List<Organization> newList = new ArrayList<>(organizationVector);
            Collections.sort(newList);
            organizationVector = new Vector<>(newList);
            for (Organization org : organizationVector) {
                System.out.println(org.getType());
            }
        }
            public void printAscending() {
                List<Organization> newList = new ArrayList<>(organizationVector);
                Collections.sort(newList);
                organizationVector= new Vector<>(newList);
                show();
            }
            public void countGreaterThanType(){

            }


        public List<Organization> createFirstObject() {
            List<Organization> FirstObj = new LinkedList<Organization>();
            for (int i = 0; i < arraySize; i++) {
                Organization org = new Organization();
                org.setName(JsonFile.getName(i));
                if (JsonFile.getId(i) != 0) {
                    org.setId(JsonFile.getId(i));
                }
                org.setAnnualTurnover(JsonFile.getAnnualTurnover(i));
                org.setCoordinates(JsonFile.getCoordinates(i));
                org.setType(JsonFile.getOrganizationType(i));
                org.setEmployeesCount(JsonFile.getEmployeesCount(i));
                org.setFullName(JsonFile.getFullName(i));
                org.setOfficialAddress(JsonFile.getOfficialAddress(i));
                FirstObj.add(org);
            }
            return FirstObj;
        }
        public void helpArray() {
            String[] helpArray = {"help : вывести справку по доступным командам\n",
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n",
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n",
                "insert key {element} : добавить новый элемент с заданным ключом\n",
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n",
                "remove_key key : удалить элемент из коллекции по его ключу\n",
                "clear : очистить коллекцию\n",
                "save : сохранить коллекцию в файл\n",
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n",
                "exit : завершить программу (без сохранения в файл)\n",
                "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n",
                "replace_if_greater key {element} : заменить значение по ключу, если новое значение больше старого\n",
                "replace_if_lowe key {element} : заменить значение по ключу, если новое значение меньше старого\n",
                "remove_any_by_postal_address postalAddress : удалить из коллекции один элемент, значение поля postalAddress которого эквивалентно заданному\n",
                "average_of_annual_turnover : вывести среднее значение поля annualTurnover для всех элементов коллекции\n",
                "filter_less_than_postal_address postalAddress : вывести элементы, значение поля postalAddress которых меньше заданного\n"};
    }
}

