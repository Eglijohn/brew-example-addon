package me.egli.brewExampleAddon.huds;

import me.egli.brewhack.core.hud.HudModule;
import me.egli.brewhack.core.setting.Setting;
import me.egli.brewhack.core.setting.SettingCategory;
import me.egli.brewhack.core.setting.settings.ColorSetting;
import me.egli.brewhack.util.misc.Color;
import net.minecraft.client.gui.DrawContext;

import static me.egli.brewhack.BrewHack.mc;

public class ExampleHud extends HudModule {
    public ExampleHud() {
        super("example", "Example HUD Module", Integer.MAX_VALUE);
    }

    private final SettingCategory sgGeneral = SettingCategory.getDefault();

    private final Setting<Color> textColor = sgGeneral.add(new ColorSetting.Builder()
            .name("text-color")
            .description("Color of the Text")
            .defaultValue(new Color(255, 255, 255))
            .build()
    );

    @Override
    public int render(DrawContext drawContext, int y) {
        String text = "Example HUD Module";
        int x = mc.getWindow().getScaledWidth() / 2 - mc.textRenderer.getWidth(text) / 2;
        drawContext.drawText(mc.textRenderer, text, x, 2, textColor.get().getPacked(), true);
        return 0;
    }
}
