package net.bobolabs.messages;

import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.TextReplacementConfig;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public abstract class AbstractEzAdventurePhase3<A, P3 extends EzAdventurePhase3<A, P3>> implements EzAdventurePhase3<A, P3> {

    private final Supplier<Collection<A>> audience;

    private final List<@NotNull Function<@NotNull A, @NotNull TextReplacementConfig>> replacements;

    // MiniMessage
    protected AbstractEzAdventurePhase3(@NotNull Supplier<@NotNull Collection<@NotNull A>> audience) {
        this.replacements = new ArrayList<>();
        this.audience = audience;
    }

    private static @NotNull String asReplacedString(@NotNull Object replacement) {
        if (replacement instanceof Replaceable replaceable) {
            return replaceable.asReplaced();
        } else {
            return replacement.toString();
        }
    }

    private static @NotNull String asLiteralString(@NotNull CharSequence target) {
        return String.valueOf(target);
    }

    @Override
    @SuppressWarnings("unchecked")
    public final @NotNull P3 replace(@NotNull CharSequence literal, @NotNull Object replacement) {
        replacements.add(audience -> TextReplacementConfig.builder()
                .matchLiteral(asLiteralString(literal))
                .replacement(asReplacedString(replacement))
                .build());

        return (P3) this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public @NotNull P3 replace(@NotNull CharSequence literal, @NotNull Function<A, Object> replacement) {
        replacements.add(audience -> TextReplacementConfig.builder()
                .matchLiteral(asLiteralString(literal))
                .replacement(builder -> replacement.apply(audience))
                .build());

        return (P3) this;
    }

    @Override
    public @NotNull P3 replaceAll(@NotNull String pattern, @NotNull Object replacement) {
        return null;
    }

    @Override
    public @NotNull P3 replaceFirst(@NotNull String regex, @NotNull Object replacement) {
        return null;
    }

    @Override
    public @NotNull P3 replace(@NotNull UnaryOperator<String> replacement) {
        return null;
    }

}
