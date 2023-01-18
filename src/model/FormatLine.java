package model;

public class FormatLine {
    public String fl(Notes notes) {
        return String.format("%s; %s; %s; %s", notes.getId(), notes.getDate(), notes.getTopic(), notes.getText());
    }

    public Notes fl(String line) {
        String[] lines = line.split("; ");
        return new Notes(lines[0], lines[1], lines[2], lines[3]);
    }
}
