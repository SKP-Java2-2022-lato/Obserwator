import java.io.File;

public class Editor {

    public EventManager eventManager;
    private File file;

    public Editor() {
        this.eventManager = new EventManager("open", "save");
    }

    public void openFile(String path){
        this.file = new File(path);
        eventManager.notify("open", file);
    }

    public void saveFile() throws Exception{
        if(this.file != null)
            eventManager.notify("save", file);
        else
            throw new Exception("Otwórz najpierw plik");
    }
}
