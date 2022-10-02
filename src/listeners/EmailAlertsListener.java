package listeners;

import java.io.File;

public class EmailAlertsListener implements EventListeners {

    private String mail;

    public EmailAlertsListener(String mail) {
        this.mail = mail;
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Wysałam maila do "+ mail+" ktos wykonal operacje "+ eventType +
                " na pliku "+ file.getName());
    }
}
