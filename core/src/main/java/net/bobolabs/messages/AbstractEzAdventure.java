package net.bobolabs.messages;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.platform.AudienceProvider;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.translation.GlobalTranslator;
import net.kyori.adventure.translation.TranslationRegistry;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/*

    - lang.yml

    - lang/
        file1.yml
        file2.yml

    - lang/
        lang_en_US.yml
        lang_it_IT.yml

    - lang/
        en_US/
            file1.yml
            file2.yml
        file3.yml
        file4.yml

    - lang/
        en_US/
            file1.yml
            file2.yml
        it_IT/
            file1.yml
            file2.yml
        file3.yml
        file4.yml

 */
public abstract class AbstractEzAdventure<T, U extends AbstractMessage<T, U>> implements EzAdventure<T, U> {

    private static final String JOINER = "\u200B";

    private final File langs;

    private LangLoadStrategy langLoadStrategy;
    private TranslationRegistry registry;
    private MiniMessage miniMessage;
    private Locale defaultLocale;
    private String namespace;
    private boolean enabled;

    protected AbstractEzAdventure(@NotNull File langs) {
        this.langs = langs;
    }

    public synchronized void setNamespace(@NotNull String namespace) {
        if (enabled) {
            throw new IllegalStateException("Could not set namespace while ezAdventure is enabled");
        }
        this.namespace = namespace;
    }

    public synchronized void setDefaultLocale(@NotNull Locale defaultLocale) {
        if (enabled) {
            throw new IllegalStateException("Could not set default Locale while ezAdventure is enabled");
        }
        this.defaultLocale = defaultLocale;
    }

    public synchronized void setMiniMessage(@NotNull MiniMessage miniMessage) {
        if (enabled) {
            throw new IllegalStateException("Could not set MiniMessage while ezAdventure is enabled");
        }
        this.miniMessage = miniMessage;
    }

    public synchronized void setLangLoadStrategy(@NotNull LangLoadStrategy langLoadStrategy) {
        if (enabled) {
            throw new IllegalStateException("Could not set LangLoadStrategy while ezAdventure is enabled");
        }
        this.langLoadStrategy = langLoadStrategy;
    }

    @Override
    public synchronized void enable() {
        // Check mandatory data
        if (defaultLocale == null) {

        }
        if (namespace == null) {

        }

        // Create non mandatory data
        if (miniMessage == null) {

        }



        Key key = Key.key(namespace, "main");
        registry = TranslationRegistry.create(key);
        // TODO registry.defaultLocale(Locale.ITALIAN);

        GlobalTranslator.translator().addSource(registry);

        enabled = true;
    }

    @Override
    public synchronized void disable() {
        if (registry != null) {
            GlobalTranslator.translator().removeSource(registry);
            registry = null;
        }

        enabled = false;
    }

    @Override
    public final @NotNull Locale getDefaultLocale() {
        return defaultLocale;
    }

    protected @NotNull String getRawMessage(@NotNull T audience, @NotNull String key) {
        Locale locale = getLocale(audience);
        return registry.translate("", locale).toPattern(); // TODO null check
    }

    @Override
    public @NotNull Component getComponent(@NotNull T audience, @NotNull String key) {
        String serialized = getRawMessage(audience, key);
        return miniMessage.deserialize(serialized);
    }

    @Override
    public @NotNull U getMessage(@NotNull T audience, @NotNull String key) {
        String serialized = getRawMessage(audience, key);
    }


    protected final @NotNull String getNamespace() {
        return namespace;
    }

    protected abstract @NotNull Locale getLocale(@NotNull T audience);


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
