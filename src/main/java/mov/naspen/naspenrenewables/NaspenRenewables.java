package mov.naspen.naspenrenewables;

import mov.naspen.naspenrenewables.events.*;
import mov.naspen.naspenrenewables.util.MaterialGenerator;
import mov.naspen.naspenrenewables.util.coreProtectHandler.CoreProtectHelper;
import mov.naspen.naspenrenewables.util.ConfigHelper;
import org.bukkit.plugin.java.JavaPlugin;

public final class NaspenRenewables extends JavaPlugin {
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
        getServer().getPluginManager().registerEvents(new PlayerInteractEventListener(),this);
        getServer().getPluginManager().registerEvents(new ProjectileHitEventListener(),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
