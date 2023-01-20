import controllers.NotesController;
import model.FormatFile;
import view.NotesView;

public class Main {
    public static void main(String[] args) {
        NotesController userController = new NotesController(new FormatFile().formatNoteFile());
//        Запуск программы, вызов пользовательского меню
        new NotesView(userController).run();
    }
}