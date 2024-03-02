package mov.naspen.naspenrenewables.util;

import mov.naspen.naspenrenewables.NaspenRenewables;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class BlockManager {
    public static void setBlock(Block block, Material material, String user){
        block.setType(material);
        if(NaspenRenewables.coreProtectHelper.isCoreProtectEnabled()){
            NaspenRenewables.coreProtectHelper.getApi().logPlacement(user,block.getLocation(),block.getType(),block.getBlockData());
        }
    }
}
