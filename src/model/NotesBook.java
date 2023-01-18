package model;

import java.util.ArrayList;
import java.util.List;

public class NotesBook implements Repository {
    DataOperations dataOperations;
    FormatLine formatLine;

    public NotesBook(DataOperations dataOperations, FormatLine formatLine) {
        this.dataOperations = dataOperations;
        this.formatLine = formatLine;
    }

    @Override
    public List<Notes> getAllUsers() {
        List<String> lines = dataOperations.readAllLines();
        List<Notes> notes = new ArrayList<>();
        for (String line : lines) {
            notes.add(formatLine.fl(line));
        }
        return notes;
    }

    @Override
    public String CreateNotesBook(Notes notes) {
        List<Notes> notes1 = getAllUsers();
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
            return null;
        } else {
            notes1.add(notes);
            List<String> lines = new ArrayList<>();
            for (Notes item : notes1) {
                lines.add(formatLine.fl(item));
            }

            dataOperations.saveAllLines(lines);
            return id;
        }


    }
}
