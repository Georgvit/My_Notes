package model;

public class FormatFile {
    public Repository formatNoteFile() {
        String formFile;
        FormatLine formatLine;
        formFile = "Notes.txt";
        formatLine = new FormatLine();
        DataOperations dataOperations = new DataOperationsInFile(formFile);
        return new NotesBook(dataOperations, formatLine);

    }


}
