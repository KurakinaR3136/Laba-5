package com.company;
import java.util.Scanner;


public class ReadData {
    private int i = 0;
    private int id = 0;
    private Scanner newScanner = new Scanner(System.in);
    private String newName = null;
    private Coordinates newCoordinates = new Coordinates();
    private double AnnualTurnover = 0;
    private String FullName = null;
    private int newEmployeesCount = 0;
    private OrganizationType newType = null;
    private Address newOfficialName = new Address();

    public int readId() {
        System.out.println("Введите число id большее 0");
        while (true) {
            try {
                if (!newScanner.hasNextInt()) {
                    System.out.println("Вы ввели неверное число");
                    newScanner.next();
                    continue;
                }
                id = newScanner.nextInt();
                if (id < 0) {
                    id = 0;
                }
            } catch (Exception ex) {
                System.out.println("Введите целочисленное значение!");
            }
            break;
        }
        return id;
    }

    public Coordinates readCoordinates() {
        System.out.println("Введите координаты, сначала Х, затем Y: ");
        while (true) {
            try {
                if (!newScanner.hasNextDouble()) {
                    System.out.println("Введите два числа!");
                    newScanner.next();
                    continue;
                }
                newCoordinates.setX(newScanner.nextInt());
                if (!newScanner.hasNextFloat()) {
                    System.out.println("Число неверное или слишком большое!");
                    newScanner.next();
                    continue;
                }
                newCoordinates.setY(newScanner.nextFloat());
            } catch (Exception e) {
                System.out.println("Вызовите команду снова и введите координаты в заданном формате!");
            }
            break;
        }
        return newCoordinates;
    }

    public double readAnnualTurnover() {
        System.out.println("Введите годовой оборот орагнизации: ");
        while (true) {

            while (true) {

                try {
                    if (!newScanner.hasNextDouble()) {
                        System.out.println("Число неверное!");
                        newScanner.next();
                        continue;
                    }
                    AnnualTurnover = newScanner.nextInt();
                } catch (Exception ex) {
                    System.out.println("Введите вещественное число!");
                }
                break;
            }
            break;
        }
        return AnnualTurnover;
    }

    public int readEmployeesCount() {
        System.out.println("Введите количество сотрудников: ");
        while (true) {

            try {
                if (!newScanner.hasNextInt()) {
                    System.out.println("Введено неверное число!");
                    newScanner.next();
                    continue;
                }
                newEmployeesCount = newScanner.nextInt();
            } catch (Exception ex) {
                System.out.println("Введите целочисленное значение!");
            }
            break;
        }
        return newEmployeesCount;
    }

    public OrganizationType readOrganizationType() {
        System.out.println("Введите номер нужного вам названия типа организации:");
        for (OrganizationType type : OrganizationType.values()) {
            i++;
            if (i == 1) {
                System.out.println("[" + i + "]" + ". " + type.name());
            } else
                System.out.println(i + ". " + type.name());
        }
        while (true) {
            try {
                if (!newScanner.hasNextInt()) {
                    System.out.println("Вы ввели неправильное число");
                    newScanner.next();
                    continue;
                }
                i = newScanner.nextInt();
                switch (i) {
                    case 1:
                        newType = OrganizationType.COMMERCIAL;
                        i = 0;
                        break;
                    case 2:
                        newType = OrganizationType.PUBLIC;
                        i = 0;
                        break;
                    case 3:
                        newType = OrganizationType.GOVERNMENT;
                        i = 0;
                        break;
                    case 4:
                        newType = OrganizationType.TRUST;
                        i = 0;
                        break;
                    default:
                        System.out.println("Неправильно введено, нужно выбрать из списка!");
                        newType = OrganizationType.PUBLIC;
                        i = 0;
                        break;

                }
            } catch (Exception e) {
            }
            break;
        }
        return newType;
    }

    public Address readOfficialAddress() {
        System.out.println("Введите адресс организации");
        while (true) {
            try {
                if (!newScanner.hasNextLine()) {
                    System.out.println("Введите название улицы!");
                    newScanner.next();
                    continue;
                }
                newOfficialName.setStreet(newScanner.hasNextLine());
                if (!newScanner.hasNext()) {
                    System.out.println("Введите название города!");
                    newScanner.next();
                    continue;
                }
                newOfficialName.setTown(newScanner.hasNextLine());
            } catch (Exception e) {
                System.out.println("Введено неверно");
            }
            break;
        }
        return newOfficialName;
    }

}
