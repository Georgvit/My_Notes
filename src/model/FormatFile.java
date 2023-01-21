package model;

import java.io.IOException;


public class FormatFile {
    public Repository formatNoteFile() throws IOException {
        String formFile;
        FormatLine formatLine;
        formFile = "Notes.txt";
        formatLine = new FormatLine();
        DataOperations dataOperations = new DataOperationsInFile(formFile);
        return new NotesBookDecorator(new NotesBook(dataOperations, formatLine), new MyLogger());

    }


}
