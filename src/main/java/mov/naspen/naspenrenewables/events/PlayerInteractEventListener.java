package mov.naspen.naspenrenewables.events;

import mov.naspen.naspenrenewables.util.BlockManager;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractEventListener implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(event.getClickedBlock() == null)
                return;
            if(event.getItem() == null)
                return;
            if(event.getMaterial() == Material.FIRE_CHARGE && event.getClickedBlock().getType() == Material.MAGMA_BLOCK){
                BlockManager.setBlock(event.getClickedBlock(),Material.LAVA,event.getPlayer().getName());

                event.getItem().setAmount(event.getItem().getAmount()-1);
            }
        }
    }
}
