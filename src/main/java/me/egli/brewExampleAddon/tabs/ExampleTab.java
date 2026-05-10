package me.egli.brewExampleAddon.tabs;

import me.egli.brewhack.core.gui.tab.Tab;
import me.egli.brewhack.util.ui.GraphicsWrapper;

import static me.egli.brewhack.BrewHack.mc;

public class ExampleTab extends Tab {
    public ExampleTab() {
        super("Example");
    }

    @Override
    public void render(GraphicsWrapper graphicsWrapper, int i, int i1, float v) {
        graphicsWrapper.ctx().drawString(mc.font, "A simple example Tab :)", 20, 20, 0xFFFFFFFF, true);
        graphicsWrapper.g().drawString("You can put anything you want in here!", 20, 40, 0xFFFFFFFF);
    }
}