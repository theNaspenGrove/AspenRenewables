package mov.naspen.naspenrenewables.events;

import mov.naspen.naspenrenewables.NaspenRenewables;
import mov.naspen.naspenrenewables.util.BlockManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.Levelled;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Explosive;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

import java.util.Random;

public class onExplosion implements Listener {
    @EventHandler
    public void onExplosionEvent(EntityExplodeEvent event){
        switch (event.getEntityType()){
            case CREEPER:
                setRadius(event.getLocation(),((Creeper)event.getEntity()).isPowered(), ((Creeper)event.getEntity()).getExplosionRadius());
                break;
            case PRIMED_TNT:
                setRadius(event.getLocation(),((Explosive)event.getEntity()).isIncendiary(), ((Explosive)event.getEntity()).getYield());
                break;
            case ENDER_CRYSTAL, SMALL_FIREBALL, FIREBALL:
                setRadius(event.getLocation(),true, ((Explosive)event.getEntity()).getYield());
                break;
        }
    }

    private void setRadius(Location location, boolean hot, float power){
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
                        float h = power * (0.7F + r.nextFloat() * 0.6F);
                        double m = location.getX();
                        double n = location.getY();
                        double o = location.getZ();

                        for(float p = 0.3F; h > 0.0F; h -= 0.22500001F) {
                            Location loc = new Location(location.getWorld(),m,n,o);
                            if (location.getWorld().getBlockAt(loc).getType() == Material.LAVA){
                                if(!NaspenRenewables.configHelper.getConvertFlowing() && ((Levelled) location.getWorld().getBlockAt(loc).getBlockData()).getLevel() != 0){
                                    return;
                                }
                                if(location.getWorld().isUltraWarm() || hot){
                                    BlockManager.setBlock(location.getWorld().getBlockAt(loc),Material.MAGMA_BLOCK,"#tnt");
                                }else{
                                    BlockManager.setBlock(location.getWorld().getBlockAt(loc),Material.TUFF,"#tnt");
                                }
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
