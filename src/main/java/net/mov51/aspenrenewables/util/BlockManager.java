package net.mov51.aspenrenewables.util;

import org.bukkit.Material;
import org.bukkit.block.Block;

import static net.mov51.aspenrenewables.AspenRenewables.coreProtectHelper;

public class BlockManager {
    public static void setBlock(Block block, Material material, String user){
        block.setType(material);
        if(coreProtectHelper.isCoreProtectEnabled()){
            coreProtectHelper.getApi().logPlacement(user,block.getLocation(),block.getType(),block.getBlockData());
        }
    }
}
