# JDBT - Java Discord Bot Template

![repo-size-badge](https://img.shields.io/github/repo-size/Zielin0/JDBT?style=flat-square)
![license-badge](https://img.shields.io/github/license/Zielin0/JDBT?style=flat-square)
![stars-badge](https://img.shields.io/github/stars/Zielin0/JDBT?style=flat-square)
![activity-badge](https://img.shields.io/github/commit-activity/m/Zielin0/JDBT?style=flat-square)

## Very simple discord bot boilerplate in java.

## Table of contents

1. [General Info](#general-info)
2. [Features](#features)
3. [Downloading](#downloading)
4. [Running](#running)
5. [Configuring](#configuring)
6. [Dependencies](#dependencies)
7. [License](#license)
8. [Others](#others)
9. [Examples](#examples)
10. [TODO](#todo)

## General info
This is a very simple boilerplate for discord bots in java.

It might develop more with time.

## Features

- Event handling
- Command handling

## Downloading

1. Clone this repo.

    ```shell
    $ git clone https://github.com/Zielin0/JDBT.git
    ```
   
    Or use a ["Use this template"](https://github.com/Zielin0/JDBT/generate) feature.

2. Open created folder with [IntelliJ IDEA](https://www.jetbrains.com/idea/download/).

3. Install all maven dependencies.

4. Run maven scripts. `clean package`.

5. If no errors `.jar` should appear in the `target/` directory.

## Running

```shell
$ java -jar JDBT-1.1-SNAPSHOT.jar <prefix> <botToken> <yourID>
```

## Configuring

...

See [TODO](#todo)

## Dependencies

- [Lombok](https://projectlombok.org/setup/maven)
- [JDA](https://github.com/DV8FromTheWorld/JDA#download)

## License

The project is under the [Apache 2.0](./LICENSE).

## Others

If the bot throws an unexpected error **PLEASE** report it!

You can report issues and errors at [Issues Page](https://github.com/Zielin0/JDBT/issues).

## Examples

### Command Example:

Commands should be in the `xyz.zielinus.jdbt.commands.impl.category` package.

```java
package xyz.zielinus.jdbt.commands.impl.misc;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import xyz.zielinus.jdbt.commands.Command;

public class TestCommand extends Command {
    public TestCommand() {
        super("example", Category.MISC, false, "e", "ex"); // name, category, ownerOnly, ...aliases
    }

    @Override
    public void execute(JDA client, Message message, String[] args) {
        // do stuff
    }
}
```

### Event Example (onGuildBan):

Events should be in the `xyz.zielinus.jdbt.events.impl` package.

```java
package xyz.zielinus.jdbt.events.impl;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.guild.GuildBanEvent;
import org.jetbrains.annotations.NotNull;
import xyz.zielinus.jdbt.events.Event;

public class ReadyEvent extends Event {
    public ReadyEvent(JDA bot) {
        super("eventName", bot); // name of the event
    }

    @Override
    public void onGuildBan(@NotNull GuildBanEvent event) {
        // do stuff
    }
}

```

## TODO

- [x] Examples (Command & Event)
- [ ] Configuration. (YML/JSON)
   - Prefix
   - Token
   - Owner's ID
   - Other
- [ ] Something like an interactions handler (if possible with JDA)
