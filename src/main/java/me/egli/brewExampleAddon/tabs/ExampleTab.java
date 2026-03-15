package me.egli.brewExampleAddon.tabs;

import me.egli.brewhack.core.gui.tab.Tab;
import net.minecraft.client.gui.GuiGraphics;

import static me.egli.brewhack.BrewHack.mc;

public class ExampleTab extends Tab {
    public ExampleTab() {
        super("Example");
    }

    @Override
    public void render(GuiGraphics drawContext, int i, int i1, float v) {
        drawContext.drawString(mc.font, "A simple example Tab :)", 20, 20, 0xFFFFFFFF, true);
    }
}