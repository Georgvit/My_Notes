package view;

import model.Notes;

import java.util.Date;
import java.util.Scanner;

public class UserView {

    UserCommands command;

    public void run() {
        while (true) {
            greeting();
            String inputComand = userInputComand("Введите команду");
            command = UserCommands.valueOf(inputComand);
            if (command == UserCommands.EXIT) return;
            switch (command) {
                case CREATE:
                    String topic = userInputComand("Введите тему записи:");
                    String text = userInputComand("Введите текси записи:");
                    System.out.println(new Notes(new Date(),topic, text));


            }

        }

    }

    private void greeting() {
        System.out.println("\nСписок команд записной книги:");
        System.out.println(UserCommands.CREATE + " - создание новой записи. \n" +
                UserCommands.READ + " - чтение записи по ID. \n" +
                UserCommands.UPDATE + " - обновление записи. \n" +
                UserCommands.LIST + " - вывод всех записей. \n" +
                UserCommands.DELETE + " - удаление записей. \n" +
                UserCommands.EXIT + " - выход из программы. \n");
    }

    private String userInputComand(String message) {
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        return in.nextLine().toUpperCase();
    }
}
