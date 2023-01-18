package view;

import controllers.UserController;
import model.Notes;
import model.NotesBook;

import java.util.Date;
import java.util.Scanner;

public class UserView {
    private UserController userController;

    public UserView(UserController userController) {
        this.userController = userController;
    }

    UserCommands command;

    //    Запуск программы
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
                    String date = new Date().toString();
                    Notes notes = new Notes(date, topic, text);
                    userController.saveNote(notes);
                    break;
            }

        }

    }

    //    Меню с подсказками команд
    private void greeting() {
        System.out.println("\nСписок команд записной книги:");
        System.out.println(UserCommands.CREATE + " - создание новой записи. \n" +
                UserCommands.READ + " - чтение записи по ID. \n" +
                UserCommands.UPDATE + " - обновление записи. \n" +
                UserCommands.LIST + " - вывод всех записей. \n" +
                UserCommands.DELETE + " - удаление записей. \n" +
                UserCommands.EXIT + " - выход из программы. \n");
    }

    //    Метод пользовательского ввода
    private String userInputComand(String message) {
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        return in.nextLine().toUpperCase();
    }
}
