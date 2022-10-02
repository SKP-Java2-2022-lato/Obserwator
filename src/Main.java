import listeners.EmailAlertsListener;
import listeners.EventListeners;
import listeners.LoggingListeners;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        EventListeners mail = new EmailAlertsListener("mail@mail.com");
        File log = new File("./log.txt");
        EventListeners loggingListeners = new LoggingListeners(log);
        editor.eventManager.subscribe("open",loggingListeners);
        editor.eventManager.subscribe("open", mail);
        editor.eventManager.subscribe("save", mail);

        editor.openFile("text.txt");
        try {
            editor.saveFile();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}