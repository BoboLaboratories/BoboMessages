package net.bobolabs.messages;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.translation.GlobalTranslator;
import net.kyori.adventure.translation.TranslationRegistry;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import static net.bobolabs.core.Utils.coalesce;

public abstract class AbstractEzAdventurePhase0
        <A,
                P1 extends EzAdventurePhase1<A, P2, P3>,
                P2 extends EzAdventurePhase2<A, P3>,
                P3 extends EzAdventurePhase3<A, P3>> implements EzAdventurePhase0<A, P1, P2, P3> {

    private static final String DEFAULT_LINE_JOINER = "\n";

    private final EzAdventureOptions options;

    private TranslationRegistry translationRegistry;

    protected AbstractEzAdventurePhase0(@NotNull EzAdventureOptions options) {
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
    public @NotNull P2 lang(@NotNull String key) {
        return sync().lang(key);
    }

    @Override
    public @NotNull P2 component(@NotNull ComponentLike component) {
        return sync().component(component);
    }

    @Override
    public @NotNull P2 text(@NotNull String text) {
        return sync().text(text);
    }

    @Override
    public @NotNull P2 text(@NotNull String[] text) {
        Collection<String> collection = List.of(text);
        return text(collection);
    }

    @Override
    public @NotNull P2 text(@NotNull Collection<String> text) {
        String joined = String.join(DEFAULT_LINE_JOINER, text);
        return text(joined);
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
        // TODO se non e' nelle options lo ricrea ogni volta o sbaglio?
        return coalesce(options.getMiniMessage(), MiniMessage::miniMessage);
    }

}
