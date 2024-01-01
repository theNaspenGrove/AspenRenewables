package net.mov51.aspenrenewables;

import net.mov51.aspenrenewables.events.DragonEggFormEventListener;
import net.mov51.aspenrenewables.events.PiglinBarterEventListener;
import net.mov51.aspenrenewables.events.onBlockForm;
import net.mov51.aspenrenewables.events.onExplosion;
import net.mov51.aspenrenewables.util.ConfigHelper;
import net.mov51.aspenrenewables.util.MaterialGenerator;
import net.mov51.aspenrenewables.util.coreProtectHandler.CoreProtectHelper;
import org.bukkit.plugin.java.JavaPlugin;

public final class AspenRenewables extends JavaPlugin {
    public static ConfigHelper configHelper;
    public static CoreProtectHelper coreProtectHelper;

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("AspenRenewables has been enabled!");
        this.saveDefaultConfig();
        configHelper = new ConfigHelper(this);
        coreProtectHelper = new CoreProtectHelper();
        if(coreProtectHelper.isCoreProtectEnabled()){
            System.out.println("CoreProtect integration is enabled!");
        }
        MaterialGenerator.init();
        getServer().getPluginManager().registerEvents(new onBlockForm(),this);
        getServer().getPluginManager().registerEvents(new onExplosion(),this);
        getServer().getPluginManager().registerEvents(new DragonEggFormEventListener(),this);
        getServer().getPluginManager().registerEvents(new PiglinBarterEventListener(),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
