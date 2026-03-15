package me.egli.brewExampleAddon.commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import me.egli.brewhack.core.command.DotCommand;
import me.egli.brewhack.render.Notifications;
import net.minecraft.commands.SharedSuggestionProvider;

public class ExampleCommand extends DotCommand {
    public ExampleCommand() {
        super("example");
    }

    @Override
    public void build(LiteralArgumentBuilder<SharedSuggestionProvider> literalArgumentBuilder) {
        literalArgumentBuilder.then(argument("message", StringArgumentType.greedyString())
                .executes(ctx -> {
                    String message = StringArgumentType.getString(ctx, "message");
                    Notifications.add("Example Notification", message);

                    return SINGLE_SUCCESS;
                })
        );
    }
}