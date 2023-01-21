package model;

import com.sun.tools.javac.Main;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

//Создаем класс для логирования
public class MyLogger {
    private final static Logger log = Logger.getLogger(Main.class.getName());
    final File file = new File("MyLogFile.log");
    private final FileHandler fl = new FileHandler(file.getAbsolutePath());

    public MyLogger() throws IOException {
    }

    public Logger myLog() {
        log.addHandler(fl);
        return log;
    }
}
