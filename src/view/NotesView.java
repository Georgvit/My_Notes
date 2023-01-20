package view;

import controllers.NotesController;
import model.Notes;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class NotesView {
    private NotesController userController;

    public NotesView(NotesController userController) {
        this.userController = userController;
    }

    NotesCommands command;

    //    Запуск программы
    public void run() {
        while (true) {
            greeting();
            String inputComand = userInputComand("Введите команду");
            command = NotesCommands.valueOf(inputComand.toUpperCase());
            if (command == NotesCommands.EXIT) return;
            switch (command) {
                case CREATE:
                    String topic = userInputComand("Введите тему записи:");
                    String text = userInputComand("Введите текси записи:");
                    String date = new Date().toString();
                    Notes notes = new Notes(date, topic.toUpperCase(), text);
                    userController.saveNote(notes);
                    break;
                case READ:
                    String id = userInputComand("Идентификатор записи в документе: ");
                    try {
                        Notes note = userController.readNotes(id);
                        System.out.println(note);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case LIST:
                    try {
                        List<Notes> notesList = userController.readNotesList();
                        for (Notes item : notesList) {
                            System.out.println(item + "\n");
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case UPDATE:
                    id = userInputComand("Идентификатор записи в документе: ");
                    try {
                        Notes note = userController.readNotes(id);
                        switch (parameterSelection()) {
                            case 1:
                                String newTopic = userInputComand("Введите тему записи:");
                                note.setTopic(newTopic.toUpperCase());
                                note.setDate(new Date().toString());
                                userController.updateSaveNote(note, id);
                                System.out.println("Данные изменены.");
                                break;
                            case 2:
                                String newText = userInputComand("Введите текси записи:");
                                note.setText(newText);
                                note.setDate(new Date().toString());
                                userController.updateSaveNote(note, id);
                                System.out.println("Данные изменены.");
                                break;
                        }

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case DELETE:
                    switch (deleteSelection()) {
                        case 1:
                            id = userInputComand("Идентификатор записи в документе: ");
                            userController.deleteSelectionDate(id);
                            break;
                        case 2:
                            userController.daleteAllDate();
                            break;
                    }
            }

        }

    }

    //    Меню с подсказками команд
    private void greeting() {
        System.out.println("\nСписок команд записной книги:");
        System.out.println(NotesCommands.CREATE + " - создание новой записи. \n" +
                NotesCommands.READ + " - чтение записи по ID. \n" +
                NotesCommands.UPDATE + " - обновление записи. \n" +
                NotesCommands.LIST + " - вывод всех записей. \n" +
                NotesCommands.DELETE + " - удаление записей. \n" +
                NotesCommands.EXIT + " - выход из программы. \n");
    }

    //    Метод пользовательского ввода
    private String userInputComand(String message) {
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        return in.nextLine();
    }

    private int parameterSelection() {
        System.out.println("Какие параметры хотите изменить?");
        System.out.println("1. Тема записи \n2.Текст записи \n");
        int selection = Integer.parseInt(userInputComand("Введите пункт меню:"));
        return selection;
    }

    private int deleteSelection() {
        System.out.println("Какие данные удалить?");
        System.out.println("1. Все данные из топика \n2. Все данные в записной книге");
        int selection = Integer.parseInt(userInputComand("Введите пункт меню:"));
        return selection;
    }
}
