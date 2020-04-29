package com.company;

//Reciever
import java.io.PrintStream;

public class Actions {
    void help(){
        int i=0;
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
        for(i=0;i<helpArray.length; i++) {
            System.out.printf(helpArray[i]);
        }
    }
}

