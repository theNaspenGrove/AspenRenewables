package mov.naspen.naspenrenewables.events;

import mov.naspen.naspenrenewables.util.MaterialGenerator;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;

import java.util.Random;

import static mov.naspen.naspenrenewables.NaspenRenewables.configHelper;
import static mov.naspen.naspenrenewables.util.BlockManager.setBlock;

public class onBlockForm implements Listener {

    Random random = new Random();
    @EventHandler
    public void BlockFormEvent(BlockFormEvent event){
        switch (event.getNewState().getType()) {
            case COBBLESTONE -> {
                if (event.getBlock().getLocation().getBlockY() < 0) {
                    event.setCancelled(true);
                    setBlock(event.getBlock(), MaterialGenerator.getRandomCobbleDeepType(),"#lava");
                }
            }
            case STONE -> {
                if (event.getBlock().getLocation().add(0, -1, 0).getBlock().getType() == Material.BONE_BLOCK) {
                    event.setCancelled(true);
                    setBlock(event.getBlock(),Material.CALCITE,"#lava");
                    if(random.nextInt(configHelper.getBoneBlockConvertChance()) == 0){
                        setBlock(event.getBlock().getLocation().add(0, -1, 0).getBlock(),Material.COAL_BLOCK,"#lava");
                    }
                } else if (event.getBlock().getLocation().getBlockY() < 0) {
                    event.setCancelled(true);
                    setBlock(event.getBlock(), MaterialGenerator.getRandomDeepType(),"#lava");
                }else if(event.getBlock().getLocation().getBlockY() >= 0){
                    event.setCancelled(true);
                    setBlock(event.getBlock(), MaterialGenerator.getRandomStoneType(),"#lava");
                }
            }
        }

    }
}
