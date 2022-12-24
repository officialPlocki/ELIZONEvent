package host.elizon.christmasevent;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChristmasEvent extends JavaPlugin {

    public static JDA jda;

    @Override
    public void onEnable() {
        // Plugin startup logic
        JDABuilder builder = JDABuilder.createDefault("TOKEN");
        builder.setEnabledIntents(GatewayIntent.DIRECT_MESSAGES, GatewayIntent.MESSAGE_CONTENT);

        jda = builder.build();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
