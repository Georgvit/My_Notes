package model;

import java.util.Scanner;

public class SelectionFormat {
    private int selectionUser;

    public Repository selectedFormat() {
        String formFile;
        selectionUser = prompt();
        FormatLine formatLine;

        if (selectionUser == 1) {
            formFile = "htmlNotes.html";
            formatLine = new FormatLine();
        } else {
            formFile = "Notes.txt";
            formatLine = new FormatLine();
        }

        DataOperations dataOperations = new DataOperationsInFile(formFile);
        return new NotesBook(dataOperations, formatLine);

    }

    private int prompt() {
        System.out.println("Выберите формат работы с документом:");
        System.out.println("1. TXT \n2. html");
        System.out.println("Введите пункт меню:");
        Scanner in = new Scanner(System.in);
        return Integer.parseInt(in.nextLine().toUpperCase());
    }
}
