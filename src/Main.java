import model.Notes;

public class Main {
    public static void main(String[] args) {

        Notes notes = new Notes("1", "18/01/2023","Начать и кончить",
                "Вся тема проекта это создать удобную записную книжку" );
        System.out.println(notes);
    }
}