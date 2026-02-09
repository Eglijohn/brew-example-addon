package me.egli.brewExampleAddon.keybinds;

import me.egli.brewhack.core.keybind.Keybind;
import me.egli.brewhack.util.misc.ChatUtils;
import org.lwjgl.glfw.GLFW;

public class ExampleKeybind extends Keybind {
    public ExampleKeybind() {
        super("example", GLFW.GLFW_KEY_H);
    }

    @Override
    public void execute() {
        ChatUtils.info("Example Key hit!");
    }
}
