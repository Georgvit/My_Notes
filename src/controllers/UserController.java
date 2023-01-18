package controllers;

import model.Notes;
import model.Repository;

public class UserController {
    private final Repository repository;

    public UserController(Repository repository) {
        this.repository = repository;
    }

    public void saveNote(Notes notes){
        repository.CreateNotesBook(notes);
    }
}
