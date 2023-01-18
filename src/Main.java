import controllers.UserController;
import model.Notes;
import model.SelectionFormat;
import view.UserView;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController(new SelectionFormat().selectedFormat());
//        Запуск программы, вызов пользовательского меню
        new UserView(userController).run();
    }
}