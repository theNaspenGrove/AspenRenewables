package net.mov51.aspenrenewables.events;

import io.papermc.paper.event.block.DragonEggFormEvent;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class DragonEggFormEventListener implements Listener {
    @EventHandler
    public void onDragonEggFormEvent(DragonEggFormEvent event){
        if(event.getBlock().getWorld().getHighestBlockAt(event.getBlock().getLocation()).getType() == Material.OBSIDIAN){
            event.getBlock().getWorld().getHighestBlockAt(event.getBlock().getLocation()).setType(Material.AIR);
            event.setCancelled(false);
        }
    }
}
