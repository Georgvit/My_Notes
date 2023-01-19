package model;

import java.util.List;

public interface Repository {
    void CreateNotesBook (Notes notes);
    List<Notes> getAllNote();

    void UpdateNote(Notes notes, String idNote);
    void DeleteAllNotes();

    void DeleteSelectionNotes(String idNote);
}
