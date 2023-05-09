package net.bobolabs.messages;

import net.bobolabs.core.Check;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.translation.GlobalTranslator;
import net.kyori.adventure.translation.TranslationRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.text.MessageFormat;
import java.util.Locale;

import static net.bobolabs.core.Utils.coalesce;

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

public abstract class AbstractEzAdventure<T extends Audience, U extends EzComponent<T, U>>
        implements EzAdventure<T, U>, EzAdventureConfigurable {

    private static final LangLoadStrategy DEFAULT_LANG_LOAD_STRATEGY = LangLoadStrategy.FILE;
    private static final String JOINER = "\u200B";

    private final EzAdventureOptions options;
    private TranslationRegistry translationRegistry;

    protected AbstractEzAdventure(@NotNull EzAdventureOptions options) {
        this.options = options;
    }

    @Override
    public void onEnable() {
        Key key = Key.key(getNamespace(), "main");
        translationRegistry = TranslationRegistry.create(key);
        translationRegistry.defaultLocale(getDefaultLocale());

        GlobalTranslator.translator().addSource(translationRegistry);
    }

    @Override
    public void onDisable() {
        if (translationRegistry != null) {
            GlobalTranslator.translator().removeSource(translationRegistry);
            translationRegistry = null;
        }
    }

    @Override
    public final @NotNull Locale getDefaultLocale() {
        return options.getDefaultLocale();
    }

    @Override
    public final @NotNull String getNamespace() {
        return options.getNamespace();
    }

    @Override
    public final @NotNull File getLangs() {
        return options.getLangs();
    }

    @Override
    public final @NotNull LangLoadStrategy getLangLoadStrategy() {
        return coalesce(options.getLangLoadStrategy(), () -> DEFAULT_LANG_LOAD_STRATEGY);
    }

    // A Stami piace :D
    @Override
    public final @NotNull MiniMessage getMiniMessage() {
        return coalesce(options.getMiniMessage(), MiniMessage::miniMessage);
    }

    protected @NotNull String getRawMessage(@NotNull T audience, @NotNull String key) {
        Locale locale = getLocale(audience);
        return translationRegistry.translate("", locale).toPattern(); // TODO null check
    }

    @Override
    public final @NotNull Component getComponent(@NotNull String key) {
        return getComponent(getDefaultLocale(), key);
    }

    @Override
    public final @NotNull Component getComponent(@NotNull Locale locale, @NotNull String key) {
        MessageFormat messageFormat = translationRegistry.translate(key, locale);
        Check.argument(messageFormat != null, () -> "unknown translation key " + key + " for locale " + locale);
        return getMiniMessage().deserialize(messageFormat.toPattern());
    }

    @Override
    public final @NotNull Component getComponent(@NotNull T audience, @NotNull String key) {
        Locale locale = getLocale(audience);
        if (locale == null) {
            locale = getDefaultLocale();
        }
        return getComponent(locale, key);
    }

    @Override
    public final @NotNull U getEzComponent(@NotNull String key) {
        Component component = getComponent(key);
        return ezify();
    }

    @Override
    public final @NotNull U getEzComponent(@NotNull Locale locale, @NotNull String key) {

        return null;
    }

    @Override
    public final @NotNull EzSendableComponent<T, U> getEzComponent(@NotNull T audience, @NotNull String key) {
        return null;
    }

    protected abstract @Nullable Locale getLocale(@NotNull T audience);


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
