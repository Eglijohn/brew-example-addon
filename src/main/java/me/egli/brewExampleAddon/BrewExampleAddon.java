package me.egli.brewExampleAddon;

import com.mojang.logging.LogUtils;
import me.egli.brewExampleAddon.commands.ExampleCommand;
import me.egli.brewExampleAddon.huds.ExampleHud;
import me.egli.brewExampleAddon.modules.ExampleModule;
import me.egli.brewExampleAddon.tabs.ExampleTab;
import me.egli.brewhack.addon.BrewAddon;
import me.egli.brewhack.core.command.DotCommands;
import me.egli.brewhack.core.gui.tab.Tabs;
import me.egli.brewhack.core.hud.HudModules;
import me.egli.brewhack.core.module.Modules;
import org.slf4j.Logger;

public class BrewExampleAddon extends BrewAddon {
    public static final Logger LOG = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        LOG.info("Initializing...");

        Modules.add(new ExampleModule());
        DotCommands.add(new ExampleCommand());
        HudModules.registerType(new ExampleHud());
        Tabs.add(new ExampleTab());

        LOG.info("Initialized!");
    }

    @Override
    public void onRegisterCategories() {

    }
}
