package host.elizon.christmasevent.events;

import host.elizon.christmasevent.util.TeleportUtils;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class PlayerHandler implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.joinMessage(Component.text("&a" + event.getPlayer().getName() + " joined."));
        if(!event.getPlayer().hasPlayedBefore()) {
            PlayerInventory inventory = event.getPlayer().getInventory();
            inventory.setItemInOffHand(new ItemStack(Material.SHIELD, 1));
            inventory.setItemInMainHand(new ItemStack(Material.STONE_SWORD, 1));
            inventory.setHelmet(new ItemStack(Material.LEATHER_HELMET, 1));
            inventory.setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
            inventory.setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));
            inventory.setBoots(new ItemStack(Material.LEATHER_BOOTS, 1));
            event.getPlayer().teleport(TeleportUtils.findSafeLocation(event.getPlayer()));
            event.getPlayer().sendMessage(Component.text(
                    "Welcome to this ELIZON. event.\n" +
                    "On this event, you can mine ores and collect gifts from them (if you are lucky).\n" +
                    "These are the chances for the ores, that you can mine to get gifts:\n" +
                    "Coal: 1%\n" +
                    "Iron: 5%\n" +
                    "Gold: 10%\n" +
                    "Diamond: 20%\n" +
                    "Emerald: 50%\n" +
                    "\n" +
                    "Please be aware, that you can only get one gift of each category.\n" +
                    "\n" +
                    "These are the categories, from them you can get a gift:\n" +
                    "Free Minecraft Plugin development (work time limited)\n" +
                    "Free ELIZON. Hosting Gameserver (as long as used)\n" +
                    "ELIZON. Hosting Server Boosts (per Server)\n" +
                    "ELIZON. Hosting VPS (only one available, only on Emerald ores, time limited)\n" +
                    "\n" +
                    "Cheating isn't allowed and will be sanctioned (ban, no gift redemption).\n" +
                    "Gifts aren't transferable and only three gifts can be redeemed per individual.\n" +
                    "Please note, that mining bots aren't allowed.\n" +
                    "ELIZON. Hosting Terms of Use apply for ELIZON. Hosting services.\n" +
                    "\n" +
                    "Read here the Terms of Use:\n" +
                    "English: https://elizon.host/en/tou\n" +
                    "German: https://elizon.host/de/tou\n" +
                    "\n" +
                    "For ELIZON. Hosting VPS special conditions do apply (sent before gift redeem).\n" +
                    "\n" +
                    "You can redeem your gifts with ELIZON.BOT over the support function.\n" +
                    "Please open a ticket with the following usage syntax: REDEEM XXXXXXX (code)\n" +
                    "For the use of ELIZON.BOT the Special Conditions for ELIZON.BOT apply.\n" +
                    "\n" +
                    "Read here the Special Conditions for ELIZON.BOT:\n" +
                    "English: https://elizon.host/en/specialconditions\n" +
                    "German: https://elizon.host/de/specialconditions\n" +
                    "\n" +
                    "Have fun!"));
        }
    }

    @EventHandler
    public void onChat(AsyncChatEvent event) {
        event.message(Component.text(event.getPlayer().getName() + ": &7" + event.originalMessage()));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.quitMessage(Component.text("&c" + event.getPlayer().getName() + " left."));
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if(event.getEntityType().equals(EntityType.PLAYER)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onItemDamage(PlayerItemDamageEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        event.deathMessage(Component.text("&c" + event.getPlayer().getName() + " died."));
        event.getPlayer().sendMessage("&7Your death location\n" +
                "&fX: " + event.getPlayer().getLocation().getX() + "\n" +
                "&fY: " + event.getPlayer().getLocation().getZ() + "\n" +
                "&fZ: " + event.getPlayer().getLocation().getZ());

    }

}
