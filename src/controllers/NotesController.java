package controllers;

import model.Notes;
import model.Repository;

import java.util.List;

public class NotesController {
    private final Repository repository;

    public NotesController(Repository repository) {
        this.repository = repository;
    }

    public void saveNote(Notes notes){
        repository.createNotesBook(notes);
    }

    public void updateSaveNote(Notes notes, String id){
        repository.updateNote(notes, id);
    }

    public void deleteSelectionDate(String idNote){
        repository.deleteSelectionNotes(idNote);
        System.out.println("Запись удалена");
    }

    public void daleteAllDate(){
        repository.getAllNote();
        System.out.println("Записи удалены");
    }

    public Notes readNotes(String noteId) throws Exception {
        List<Notes> notesAll = repository.getAllNote();
        for (Notes item : notesAll) {
            if (item.getId().equals(noteId)) {
                return item;
            }
        }
        throw new Exception("Запись не найдена");

    }

    public List<Notes> readNotesList() {
        List<Notes> notesAll = repository.getAllNote();
        return notesAll;
    }
}
