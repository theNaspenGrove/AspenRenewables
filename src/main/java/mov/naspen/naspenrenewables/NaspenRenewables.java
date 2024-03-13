package mov.naspen.naspenrenewables;

import mov.naspen.naspenrenewables.events.*;
import mov.naspen.naspenrenewables.util.MaterialGenerator;
import mov.naspen.naspenrenewables.util.coreProtectHandler.CoreProtectHelper;
import mov.naspen.naspenrenewables.util.ConfigHelper;
import mov.naspen.periderm.loging.AspenLogHelper;
import org.bukkit.plugin.java.JavaPlugin;

public final class NaspenRenewables extends JavaPlugin {
    public static ConfigHelper configHelper;
    public static CoreProtectHelper coreProtectHelper;

    public static AspenLogHelper logHelper;

    @Override
    public void onEnable() {
        logHelper = new AspenLogHelper(this.getLogger());

        // Plugin startup logic
        this.saveDefaultConfig();
        configHelper = new ConfigHelper(this);
        coreProtectHelper = new CoreProtectHelper();
        if(coreProtectHelper.isCoreProtectEnabled()){
            logHelper.sendLogInfo("CoreProtect integration is enabled!");
        }
        MaterialGenerator.init();
        getServer().getPluginManager().registerEvents(new onBlockForm(),this);
        getServer().getPluginManager().registerEvents(new onExplosion(),this);
        getServer().getPluginManager().registerEvents(new DragonEggFormEventListener(),this);
        getServer().getPluginManager().registerEvents(new PiglinBarterEventListener(),this);
        getServer().getPluginManager().registerEvents(new BlockPhysicsEventListener(),this);
        getServer().getPluginManager().registerEvents(new ProjectileHitEventListener(),this);

        logHelper.sendLogInfo("AspenRenewables has been enabled!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
