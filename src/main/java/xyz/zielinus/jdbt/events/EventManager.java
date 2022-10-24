package xyz.zielinus.jdbt.events;

import lombok.Getter;
import net.dv8tion.jda.api.JDA;
import xyz.zielinus.jdbt.events.impl.MessageEvent;
import xyz.zielinus.jdbt.events.impl.ReadyEvent;

import java.util.ArrayList;
import java.util.List;

public class EventManager {

    @Getter
    private final List<Event> events;

    public EventManager() {
        this.events = new ArrayList<Event>();
    }

    public void registerEvent(Event event) {
        events.add(event);
    }

    public void registerEvents(JDA bot) {
        registerEvent(new MessageEvent(bot));
        registerEvent(new ReadyEvent(bot));
    }
}
