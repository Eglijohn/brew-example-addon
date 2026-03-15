package me.egli.brewExampleAddon.huds;

import me.egli.brewhack.core.hud.HudModule;
import me.egli.brewhack.core.setting.Setting;
import me.egli.brewhack.core.setting.SettingCategory;
import me.egli.brewhack.core.setting.settings.ColorSetting;
import me.egli.brewhack.util.color.Color;
import net.minecraft.client.gui.GuiGraphics;

import static me.egli.brewhack.BrewHack.mc;

public class ExampleHud extends HudModule {
    public ExampleHud() {
        super("example", "Example HUD Module");
    }

    private final SettingCategory sgGeneral = SettingCategory.getDefault();

    private final Setting<Color> textColor = sgGeneral.add(new ColorSetting.Builder()
            .name("text-color")
            .description("Color of the Text")
            .defaultValue(new Color(255, 255, 255))
            .build()
    );

    @Override
    public void render(GuiGraphics drawContext) {
        String text = "Example HUD Module";
        int x = mc.getWindow().getGuiScaledWidth() / 2 - mc.font.width(text) / 2;
        drawContext.drawString(mc.font, text, x, 2, textColor.get().getPacked(), true);
    }
}
