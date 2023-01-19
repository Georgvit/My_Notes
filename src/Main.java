import controllers.UserController;
import model.FormatFile;
import view.UserView;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController(new FormatFile().formatNoteFile());
//        Запуск программы, вызов пользовательского меню
        new UserView(userController).run();
    }
}