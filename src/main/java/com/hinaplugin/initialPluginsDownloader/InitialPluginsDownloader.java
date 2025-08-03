package com.hinaplugin.initialPluginsDownloader;

import com.hinaplugin.initialPluginsDownloader.plugins.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class InitialPluginsDownloader extends JavaPlugin {
    public static InitialPluginsDownloader plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        final String mcVersion = this.getServer().getVersion().split("-")[0];
        this.getLogger().info("[Downloader]: Minecraft Version is " + mcVersion);
        if (this.isPlugin("LuckPerms")){
            new LuckPerms().downloader();
        }
        if (this.isPlugin("WorldEdit")){
            new WorldEdit().downloader(mcVersion);
        }
        if (this.isPlugin("WorldGuard")){
            new WorldGuard().downloader(mcVersion);
        }
        if (this.isPlugin("Coreprotect")){
            new CoreProtect().downloader();
        }
        if (this.isPlugin("Plugman")){
            new PlugmanX().downloader();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private boolean isPlugin(String pluginName){
        return this.getServer().getPluginManager().getPlugin(pluginName) == null;
    }
}
