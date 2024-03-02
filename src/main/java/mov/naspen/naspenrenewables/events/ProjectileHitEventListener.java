package mov.naspen.naspenrenewables.events;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ProjectileHitEventListener implements Listener {
    @EventHandler
    public void onProjectileHitEvent(ProjectileHitEvent event) {
        if(event.getHitBlock() == null)
            return;
        if(event.getHitBlock().getType() == Material.MAGMA_BLOCK && event.getEntity().getType() == EntityType.SMALL_FIREBALL){
            event.getHitBlock().setType(org.bukkit.Material.LAVA);
        }
    }
}
