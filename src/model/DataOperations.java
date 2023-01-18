package model;

import java.util.List;

public interface DataOperations {
    List<String> readAllLines();
    void saveAllLines(List<String> lines);


}
