import controllers.NotesController;
import model.FormatFile;
import view.NotesView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        NotesController userController = new NotesController(new FormatFile().formatNoteFile());
//        Запуск программы, вызов пользовательского меню
        new NotesView(userController).run();
    }
}