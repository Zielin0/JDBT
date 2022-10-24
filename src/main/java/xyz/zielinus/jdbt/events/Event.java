package xyz.zielinus.jdbt.events;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public abstract class Event extends ListenerAdapter {
    protected final String name;

    protected final JDA bot;
    protected Event(String name, JDA bot) {
        this.name = name;
        this.bot = bot;
    }

}
