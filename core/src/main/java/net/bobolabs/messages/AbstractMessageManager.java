package net.bobolabs.messages;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.translation.GlobalTranslator;
import net.kyori.adventure.translation.TranslationRegistry;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Locale;

/*
        lang/
            en_US/
                enchants.yml
                welcome.yml
 */
public abstract class AbstractMessageManager<T, U extends AbstractMessage<T>> implements MessageManager<T, U> {

    private static final String JOINER = "\u200B";

    private TranslationRegistry registry;
    private final MiniMessage miniMessage;

    protected AbstractMessageManager() {
        miniMessage = MiniMessage.miniMessage();
    }

    protected AbstractMessageManager(@NotNull File langs) {
        miniMessage = MiniMessage.miniMessage();
    }

    protected abstract @NotNull String getNamespace();

    protected abstract @NotNull Locale getLocale(@NotNull T audience);

    //@Override
    public void enable() {
        String namespace = getNamespace();
        Key key = Key.key(namespace, "main");
        registry = TranslationRegistry.create(key);
        // TODO registry.defaultLocale(Locale.ITALIAN);

        GlobalTranslator.translator().addSource(registry);
    }

    //@Override
    public void disable() {
        if (registry != null) {
            GlobalTranslator.translator().removeSource(registry);
            registry = null;
        }
    }

    @Override
    public @NotNull U getMessage(@NotNull T player, @NotNull String key) {
        Locale locale = getLocale(player);
        String raw = registry.translate("", locale).toPattern();






//        if (lang != null) {
//            String rawMessage = lang.getString(key);
//            if (rawMessage != null) {
//                return new Message(audiences, miniMessage, rawMessage);
//            } else {
//                Logger.severe("La key: {0} non è stata trovata nel config", key);
//            }
//        } else {
//            Logger.severe("Non è stato inizializzato nessun file di configuratione");
//        }
        return null;
    }

//    public static @NotNull Message fromLines(@NotNull String... lines) {
//        return new Message(audiences, miniMessage, lines);
//    }
//
//    public void sendFromKey(@NotNull CommandSender sender, @NotNull String key, Replacer<?>... replacers) {
//        Message message = replaceMessage(key, replacers);
//        if (message != null) {
//            message.send(sender);
//        }
//    }
//
//    public <S extends Collection<CommandSender>> void sendFromKey(
//            @NotNull S senders,
//            @NotNull String key,
//            Replacer<?>... replacers) {
//
//        Message message = replaceMessage(key, replacers);
//        if (message != null) {
//            message.send(senders);
//        }
//    }
//
//    private @Nullable Message replaceMessage(String key, Replacer<?>... replacers) {
//        Message message = fromKey(key);
//
//        if (message != null) {
//            for (Replacer<?> replacer : replacers) {
//                message.replace(replacer.from(), replacer.to().toString());
//            }
//        }
//        return message;
//    }
//
//    public static @NotNull List<Component> toColorizedComponent(@NotNull List<String> list) {
//        List<Component> result = new ArrayList<>();
//        for (String str : list) {
//            result.add(toColorizedComponent(str));
//        }
//        return result;
//    }
//
//    public static @NotNull Component toColorizedComponent(@NotNull String text) {
//        return fromLines(text).build(miniMessage);
//    }
//
//
//    // Legacy stuff start
//    // Please be kind to humanity and use this stuff only if necessary
//
//    public static @NotNull List<BaseComponent[]> toColorizedBaseComponent(@NotNull List<String> list) {
//        List<BaseComponent[]> result = new ArrayList<>();
//        for (String str : list) {
//            result.add(toColorizedBaseComponent(str));
//        }
//        return result;
//    }
//
//    public static @NotNull BaseComponent[] toColorizedBaseComponent(@NotNull String text) {
//        return fromLines(text).toBaseComponents();
//    }
//
//
//    public static @NotNull String toColorizedString(@NotNull String text) {
//        return LegacyComponentSerializer.legacyAmpersand().serialize(toColorizedComponent(text));
//    }
//
//    public static @NotNull List<String> toColorizedString(@NotNull List<String> list) {
//        List<String> result = new ArrayList<>();
//        for (String str : list) {
//            result.add(toColorizedString(str));
//        }
//        return result;
//    }
//
//    // Legacy stuff end
//
//    public static @NotNull List<String> batchReplace(@NotNull List<String> lore, Replacer<?>... replacers) {
//        return Arrays.asList(replace(String.join(JOINER, lore), replacers).split(JOINER));
//    }
//
//    public static @NotNull String replace(@NotNull String text, Replacer<?>... replacers) {
//        String replacedText = text;
//
//        for (Replacer<?> replacer : replacers) {
//            replacedText = replacedText.replace(replacer.from(), replacer.to().toString());
//        }
//
//        return replacedText;
//    }
//
//    public @NotNull BukkitAudiences getAudiences() {
//        return audiences;
//    }
//
//    public @NotNull MiniMessage getMiniMessage() {
//        return miniMessage;
//    }
}
