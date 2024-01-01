package net.mov51.aspenrenewables.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.Levelled;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

import java.util.Random;

import static net.mov51.aspenrenewables.AspenRenewables.configHelper;
import static net.mov51.aspenrenewables.util.BlockManager.setBlock;

public class onExplosion implements Listener {
    @EventHandler
    public void onExplosionEvent(EntityExplodeEvent event){
    if(event.getEntityType() == EntityType.PRIMED_TNT || event.getEntityType() == EntityType.CREEPER)
        setRadius(event.getLocation());
    }
    private void setRadius(Location location){
        Random r = new Random();
        int k;
        int l;
        for(int j = 0; j < 16; ++j) {
            for(k = 0; k < 16; ++k) {
                for(l = 0; l < 16; ++l) {
                    if (j == 0 || j == 15 || k == 0 || k == 15 || l == 0 || l == 15) {
                        double d = (double)((float)j / 15.0F * 2.0F - 1.0F);
                        double e = (double)((float)k / 15.0F * 2.0F - 1.0F);
                        double f = (double)((float)l / 15.0F * 2.0F - 1.0F);
                        double g = Math.sqrt(d * d + e * e + f * f);
                        d /= g;
                        e /= g;
                        f /= g;
                        //4 is the strength of tnt explosions
                        float h = 4 * (0.7F + r.nextFloat() * 0.6F);
                        double m = location.getX();
                        double n = location.getY();
                        double o = location.getZ();

                        for(float p = 0.3F; h > 0.0F; h -= 0.22500001F) {
                            Location loc = new Location(location.getWorld(),m,n,o);
                            if (location.getWorld().getBlockAt(loc).getType() == Material.LAVA){
                                if(!configHelper.getConvertFlowing() && ((Levelled) location.getWorld().getBlockAt(loc).getBlockData()).getLevel() != 0){
                                    return;
                                }
                                setBlock(location.getWorld().getBlockAt(loc),Material.TUFF,"#tnt");
                            }
                            h -= ((location.getWorld().getBlockAt(loc).getType().getBlastResistance()/2) + 0.1F) * 0.1F;

                            //m n o are the coordinates of the explosion and iterate along the direction of the explosion
                            m += d * 0.30000001192092896;
                            n += e * 0.30000001192092896;
                            o += f * 0.30000001192092896;
                        }
                    }
                }
            }
        }
    }
}
