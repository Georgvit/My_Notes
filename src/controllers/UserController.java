package controllers;

import model.Notes;
import model.Repository;

import java.util.List;

public class UserController {
    private final Repository repository;

    public UserController(Repository repository) {
        this.repository = repository;
    }

    public void saveNote(Notes notes){
        repository.CreateNotesBook(notes);
    }

    public void updateSaveNote(Notes notes, String id){
        repository.UpdateNote(notes, id);
    }

    public void deleteSelectionDate(String idNote){
        repository.DeleteSelectionNotes(idNote);
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
