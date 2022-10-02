package listeners;

import java.io.File;

public class LoggingListeners implements EventListeners {

    private File log;

    public LoggingListeners(File log) {
        this.log = log;
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Zapisuje do logu "+ log+" ktos wykonal operacje "+ eventType +
                " na pliku "+ file.getName());
    }
}
