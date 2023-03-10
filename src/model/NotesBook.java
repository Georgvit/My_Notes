package model;

import java.util.ArrayList;
import java.util.List;

public class NotesBook implements Repository {
    private final DataOperations dataOperations;
    private final FormatLine formatLine;
    public DataOperations getDataOperations() {
        return dataOperations;
    }

    public FormatLine getFormatLine() {
        return formatLine;
    }

    public NotesBook(DataOperations dataOperations, FormatLine formatLine) {
        this.dataOperations = dataOperations;
        this.formatLine = formatLine;
    }

    @Override
    public List<Notes> getAllNote() {
        List<String> lines = dataOperations.readAllLines();
        List<Notes> notes = new ArrayList<>();
        for (String line : lines) {
            notes.add(formatLine.fl(line));
        }
        return notes;
    }

    @Override
    public void createNotesBook(Notes notes) {
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
                lines.add(formatLine.fl(item));
            }

            dataOperations.saveAllLines(lines);
        }


    }

    @Override
    public void updateNote(Notes notes, String idNote) {
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
            lines.add(formatLine.fl(item));
        }
        dataOperations.saveAllLines(lines);
    }

    @Override
    public void deleteAllNotes() {
        List<String> lines = new ArrayList<>();
        dataOperations.saveAllLines(lines);
    }

    @Override
    public void deleteSelectionNotes(String idNote) {
        int idNotes = Integer.parseInt(idNote);
        List<Notes> allNote = getAllNote();
        for (int i = 0; i < allNote.size(); i++) {
            if (i == idNotes - 1) {
                allNote.remove(i);
            }
        }

        List<String> lines = new ArrayList<>();
        for (Notes item : allNote) {
            lines.add(formatLine.fl(item));
        }
        dataOperations.saveAllLines(lines);
    }
}
