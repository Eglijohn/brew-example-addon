package me.egli.brewExampleAddon.commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import me.egli.brewhack.core.command.DotCommand;
import me.egli.brewhack.util.misc.Notifications;
import net.minecraft.command.CommandSource;

public class ExampleCommand extends DotCommand {
    public ExampleCommand() {
        super("example");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> literalArgumentBuilder) {
        literalArgumentBuilder.then(argument("message", StringArgumentType.greedyString())
                .executes(ctx -> {
                    String message = StringArgumentType.getString(ctx, "message");
                    Notifications.add("Example Notification", message);

                    return SINGLE_SUCCESS;
                })
        );
    }
}