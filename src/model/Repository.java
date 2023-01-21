package model;

import java.util.List;

public interface Repository {
    void createNotesBook(Notes notes);
    List<Notes> getAllNote();

    void updateNote(Notes notes, String idNote);
    void deleteAllNotes();

    void deleteSelectionNotes(String idNote);
}
