package model;

import java.util.ArrayList;
import java.util.List;

//Создаем декоратор, переопределяем методы с добавлением логирования.
public class NotesBookDecorator implements Repository {
    NotesBook notesBook;

    private MyLogger myLogger;

    public NotesBookDecorator(NotesBook notesBook, MyLogger myLogger) {
        this.notesBook = notesBook;
        this.myLogger = myLogger;
    }

    @Override
    public void createNotesBook(Notes notes) {
        myLogger.myLog().info("Создание новой записи в записной книге");
        List<Notes> notes1 = getAllNote();
        int max = 0;
        for (Notes item : notes1) {
            int id = Integer.parseInt(item.getId());
            if (max < id) {
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);

        notes.setId(id);

        if (notes.getId().isEmpty()) {
            System.out.println("Не возможно создать ID");
        } else {
            notes1.add(notes);
            List<String> lines = new ArrayList<>();
            for (Notes item : notes1) {
                lines.add(notesBook.getFormatLine().fl(item));
            }

            notesBook.getDataOperations().saveAllLines(lines);
        }

    }

    @Override
    public List<Notes> getAllNote() {

        List<String> lines = notesBook.getDataOperations().readAllLines();
        List<Notes> notes = new ArrayList<>();
        for (String line : lines) {
            notes.add(notesBook.getFormatLine().fl(line));
        }
        return notes;
    }

    @Override
    public void updateNote(Notes notes, String idNote) {
        myLogger.myLog().info("Обновление записи в записной книге");
        int idNotes = Integer.parseInt(idNote);
        notes.setId(idNote);
        List<Notes> allNote = getAllNote();
        for (int i = 0; i < allNote.size(); i++) {
            if (i == idNotes - 1) {
                allNote.remove(i);
                allNote.add(i, notes);
            }
        }
        List<String> lines = new ArrayList<>();
        for (Notes item : allNote) {
            lines.add(notesBook.getFormatLine().fl(item));
        }
        notesBook.getDataOperations().saveAllLines(lines);
    }

    @Override
    public void deleteAllNotes() {
        myLogger.myLog().info("Удаление всех записей из книги");
        List<String> lines = new ArrayList<>();
        notesBook.getDataOperations().saveAllLines(lines);
    }

    @Override
    public void deleteSelectionNotes(String idNote) {
        myLogger.myLog().info("Выборочное удаление записей из книги");
        int idNotes = Integer.parseInt(idNote);
        List<Notes> allNote = getAllNote();
        for (int i = 0; i < allNote.size(); i++) {
            if (i == idNotes - 1) {
                allNote.remove(i);
            }
        }

        List<String> lines = new ArrayList<>();
        for (Notes item : allNote) {
            lines.add(notesBook.getFormatLine().fl(item));
        }
        notesBook.getDataOperations().saveAllLines(lines);
    }
}
