package mov.naspen.naspenrenewables.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PiglinBarterEvent;

import java.util.Random;

import static mov.naspen.naspenrenewables.NaspenRenewables.configHelper;
import static mov.naspen.naspenrenewables.util.BlockManager.setBlock;

public class PiglinBarterEventListener implements Listener {
    @EventHandler
    public void onPiglinBarterEvent(PiglinBarterEvent event){
        Material material = event.getEntity().getLocation().add(0,-1,0).getBlock().getType();
        if(material == Material.BLACKSTONE || material == Material.NETHERRACK){
            Random random = new Random();
            if(random.nextInt(configHelper.getGildingChance()) == 0){
                if(material == Material.BLACKSTONE){
                    setBlock(event.getEntity().getLocation().add(0,-1,0).getBlock(),Material.GILDED_BLACKSTONE,"#piglin");
                }else {
                    setBlock(event.getEntity().getLocation().add(0,-1,0).getBlock(),Material.NETHER_GOLD_ORE,"#piglin");
                }
            }
        }

    }
}
