package mov.naspen.naspenrenewables.events;

import mov.naspen.naspenrenewables.util.BlockManager;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Fire;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;

import java.util.Random;

public class BlockPhysicsEventListener implements Listener {
    @EventHandler
    public void onBlockFadeEvent(BlockPhysicsEvent event) {
        if(event.getChangedType() != Material.FIRE){
            return;
        }
        if(event.getSourceBlock().getType() != Material.FIRE){
            return;
        }
        if(event.getSourceBlock().getRelative(BlockFace.DOWN).getType() == Material.MAGMA_BLOCK){
            if(((Fire)event.getSourceBlock().getBlockData()).getAge() >= 6){
                BlockManager.setBlock(event.getSourceBlock().getRelative(BlockFace.DOWN),Material.LAVA,"#fire");
            }
        }
    }
}
