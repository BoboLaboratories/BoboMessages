package net.bobolabs.messages;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.TextReplacementConfig;
import org.intellij.lang.annotations.RegExp;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.*;
import java.util.regex.MatchResult;

public abstract class AbstractEzAdventurePhase3<A, P3 extends EzAdventurePhase3<A, P3>> implements EzAdventurePhase3<A, P3> {

    private final Supplier<Collection<A>> audiences;
    private final List<@NotNull Function<@NotNull A, TextReplacementConfig>> replacements;
    private final Function<@NotNull A, @NotNull ComponentLike> componentSupplier;

    protected AbstractEzAdventurePhase3(@NotNull AbstractEzAdventure<A, ?, ?, P3> ezAdventure,
                                        @NotNull Supplier<@NotNull Collection<@NotNull A>> audience,
                                        @NotNull Function<@NotNull A, @NotNull ComponentLike> componentSupplier) {
        this.componentSupplier = componentSupplier;
        this.replacements = new ArrayList<>();
        this.audiences = audience;
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
        replace(builder -> builder.replacement(asLiteralString(literal)).replacement(asReplacedString(replacement)));

        return (P3) this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public final @NotNull P3 replace(@NotNull CharSequence literal, @NotNull Function<A, Object> replacement) {
        replace((audience, builder) -> builder
                .matchLiteral(asLiteralString(literal))
                .replacement(miniMessage.deserialize(
                        asReplacedString(replacement.apply(audience))
                )));

        return (P3) this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public final @NotNull P3 replace(@NotNull @RegExp String pattern, @NotNull Object replacement) {
        replace(builder -> builder.match(pattern).replacement(asReplacedString(replacement)));
        return (P3) this;
    }


    @Override
    @SuppressWarnings("unchecked")
    public final @NotNull P3 replace(@NotNull @RegExp String pattern, @NotNull BiFunction<MatchResult, A, Object> replacement) {
        replace((audience, builder) -> {
            builder.match(pattern).replacement((matchResult, build) -> miniMessage.deserialize(
                    asReplacedString(replacement.apply(matchResult, audience))
            ));
        });
        return (P3) this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public final @NotNull P3 replaceTimes(@NotNull @RegExp String pattern, @NotNull Object replacement, int times) {
        replace(builder -> builder.match(pattern).replacement(asReplacedString(replacement)).times(times));
        return (P3) this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public final @NotNull P3 replace(@NotNull Consumer<TextReplacementConfig.Builder> replacement) {
        replacements.add(audience -> {
            TextReplacementConfig.Builder builder = TextReplacementConfig.builder();
            replacement.accept(builder);
            return builder.build();
        });
        return (P3) this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public final @NotNull P3 replace(@NotNull BiConsumer<A, TextReplacementConfig.Builder> replacement) {
        replacements.add(audience -> {
            TextReplacementConfig.Builder builder = TextReplacementConfig.builder();
            replacement.accept(audience, builder);
            return builder.build();
        });
        return (P3) this;
    }

    @Override
    public final void send() {
        // TODO: consider async

        for (A audience : audiences.get()) {
            Component component = componentSupplier.apply(audience).asComponent();

            for (Function<A, TextReplacementConfig> replacement : replacements) {
                TextReplacementConfig replacementConfig = replacement.apply(audience);
                component = component.replaceText(replacementConfig);
            }

            send(audience, component);
        }
    }

    protected abstract void send(@NotNull A audience, @NotNull ComponentLike component);

}