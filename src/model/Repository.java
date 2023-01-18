package model;

import java.util.List;

public interface Repository {
    String CreateNotesBook (Notes notes);
    List<Notes> getAllUsers();
}
