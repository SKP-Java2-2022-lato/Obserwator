import listeners.EventListeners;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {

    Map<String, List<EventListeners>> listeners = new HashMap<>();

    public EventManager(String... operations){
        for(String o : operations)
            this.listeners.put(o, new ArrayList<>());
    }

    public void subscribe(String eventType, EventListeners listener){
        List<EventListeners> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, EventListeners listener){
        List<EventListeners> users = listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(String eventType, File file){
        List<EventListeners> users = listeners.get(eventType);
        for(EventListeners e: users)
            e.update(eventType, file);
    }
}
