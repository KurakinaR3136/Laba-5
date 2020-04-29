package com.company;
import java.util.Scanner;
public class UserDataGetter {
    Scanner userInput = new Scanner(System.in);
    String command;
    UserCommand usrCommand = new UserCommand();

    public UserDataGetter() {
        getUserCommand();
    }

    public void getUserCommand() {
        String usersInput[];
        String newValue;
        int i = 0;
        System.out.println("Введите команды или введите 'help' для просмотра списка команд...");
        while (true) {
            if (!userInput.hasNext()) {
                System.out.println("Работа программы завершена! Начните заново.");
                System.exit(0);
            }
            command = userInput.nextLine();
            usersInput = command.split("\\s");
            newValue = usersInput[0];
            switch (newValue) {
                case "help":
                    usrCommand.helpArray();
                    break;
                case "info":
                    usrCommand.info();
                    break;
                case "show":
                    usrCommand.show();
                    break;
                case "add":
                    if (usersInput[usersInput.length - 1].equals("add")) {
                        System.out.println("Введите имя после команды!");
                        break;
                    }
                    usrCommand.add(usersInput[usersInput.length - 1]);
                    break;
                case "remove_by_id":
                    try {
                        i = Integer.parseInt(usersInput[usersInput.length - 1]);
                    } catch (Exception e) {
                        System.out.println("Введите число!");
                    }
                    usrCommand.removeById(i);
                    break;
                case "clear":
                    usrCommand.clear();
                    break;
                case "save":
                    usrCommand.save();
                    break;
                case "execute_script":
                    usrCommand.executeScript(usersInput[usersInput.length - 1]);
                    break;
                case "exit":
                    System.exit(0);
                    break;
                case "remove_greater":
                    if (usersInput[usersInput.length - 1].equals("remove_greater")) {
                        System.out.println("Введите имя после команды!");
                        break;
                    }
                    usrCommand.removeGreater(usersInput[usersInput.length - 1]);
                    break;
                case "remove_last":
                    if (usersInput[usersInput.length - 1].equals("remove_last")) {
                        System.out.println("Введите имя после команды!");
                        break;
                    }
                    usrCommand.removeLast(usersInput[usersInput.length - 1]);
                    break;
                case "remove_lower":
                    if (usersInput[usersInput.length - 1].equals("remove_lower")) {
                        System.out.println("Введите имя после команды!");
                        break;
                    }
                    usrCommand.removeLower(usersInput[usersInput.length - 1]);
                    break;
                case "count_greater_than_type type":
                    usrCommand.countGreaterThanType();
                    break;
                case "print_ascending":
                    usrCommand.printAscending();
                    break;
                case "print_field_descending_type":
                    usrCommand.printFieldDescendingType();
                    break;
                default:
                    System.out.println("Вернитесь с списку комманд");
                    break;
            }
        }
    }


}
