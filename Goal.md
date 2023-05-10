File langs = new File(getDataFolder(), "langs");
new MessageManager(miniMessage, langs, Locale.ENGLISH);

plugin.getMessage(player, "my.key)
.replace("%name%, player.getName())
.send();

plugin.sendMessage(player, "my.key")

BukkitMessage message =

Message<CommandSender> message =

    messageManger().fromKey("some.fancy.key")
            .replace("%:D%", something)
            .send(player);

        Message message = new Message("some thing to message")
            .replace("%boh%", stuff)
            .send(player);



key
component deserializzato minimessage
[opt] ez replacement
send (...)

## La tabella della felicitá

|             | Paper |    Bungee     | Velocity |
|:-----------:|:-----:|:-------------:|:--------:|
|  Adventure  |   x   | BaseComponent |    x     |
| MiniMessage |       |               |          |


- [ ] Supportare il wrap in Message di Component creati a mano
        ComponentLike componentLike = new ComponentLike("aaaaaa");
        Message message = new Message(componentLike);
        message.send();