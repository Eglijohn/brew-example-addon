package me.egli.brewExampleAddon.modules;

import me.egli.brewhack.core.event.events.render.Render3DEvent;
import me.egli.brewhack.core.event.system.EventHandler;
import me.egli.brewhack.core.module.Categories;
import me.egli.brewhack.core.module.Module;
import me.egli.brewhack.core.setting.Setting;
import me.egli.brewhack.core.setting.SettingCategory;
import me.egli.brewhack.core.setting.settings.BooleanSetting;
import me.egli.brewhack.core.setting.settings.ColorSetting;
import me.egli.brewhack.util.color.Color;
import me.egli.brewhack.util.misc.ChatUtils;
import me.egli.brewhack.util.render.brew.RenderUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.AABB;

public class ExampleModule extends Module {
    public ExampleModule() {
        super("example-module", Categories.MISC, "An example module");
    }

    private final SettingCategory sgGeneral = SettingCategory.getGeneral();

    private final Setting<Boolean> render = sgGeneral.add(new BooleanSetting.Builder()
            .name("render")
            .defaultValue(true)
            .description("Render a Box at 0, 100, 0")
            .onChanged(_ -> ChatUtils.info("This gets called onChanged"))
            .build()
    );

    private final Setting<Color> sideColor = sgGeneral.add(new ColorSetting.Builder()
            .name("side-color")
            .defaultValue(new Color(255, 255, 255, 100))
            .description("The side color of the Box")
            .visible(render::get)
            .build()
    );

    private final Setting<Color> lineColor = sgGeneral.add(new ColorSetting.Builder()
            .name("line-color")
            .defaultValue(new Color(255, 255, 255))
            .description("The line color of the Box")
            .visible(render::get)
            .build()
    );

    @Override
    public void onActivate() {
        ChatUtils.info("Enabled Example Module!");
    }

    @Override
    public String onUpdateStatus() {
        return "Hello :D";
    }

    @EventHandler
    public void onRender(Render3DEvent event) {
        AABB box = new AABB(new BlockPos(0, 100, 0));

        RenderUtils.renderBox(event, box, sideColor.get(), lineColor.get(), 1, true);
    }
}