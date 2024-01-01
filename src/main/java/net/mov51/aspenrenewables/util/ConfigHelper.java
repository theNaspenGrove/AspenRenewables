package net.mov51.aspenrenewables.util;

import org.bukkit.plugin.Plugin;

public class ConfigHelper {
    boolean ConvertFlowing;
    int boneBlockConvertChance;
    int gildingChance;

    public ConfigHelper(Plugin plugin){
        ConvertFlowing = plugin.getConfig().getBoolean("convert-flowing");
        boneBlockConvertChance = plugin.getConfig().getInt("1-in-bone-convert-chance");
        gildingChance = plugin.getConfig().getInt("1-in-gilding-chance");
    }
    public boolean getConvertFlowing(){
        return ConvertFlowing;
    }
    public int getBoneBlockConvertChance(){
        return boneBlockConvertChance;
    }

    public int getGildingChance(){
        return gildingChance;
    }
}
