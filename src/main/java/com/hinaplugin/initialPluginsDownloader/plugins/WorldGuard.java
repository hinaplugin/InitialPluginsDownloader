package com.hinaplugin.initialPluginsDownloader.plugins;

import com.hinaplugin.initialPluginsDownloader.InitialPluginsDownloader;
import org.bukkit.Bukkit;

import java.io.*;
import java.net.URL;

public class WorldGuard {

    public void downloader(String version){
        try {
            Bukkit.getScheduler().runTaskAsynchronously(InitialPluginsDownloader.plugin, () -> {
                InitialPluginsDownloader.plugin.getLogger().info("WorldGuardをダウンロード中・・・");
                try (final InputStream in = new URL(this.downloadURL(version)).openStream(); FileOutputStream outputStream = new FileOutputStream(new File(InitialPluginsDownloader.plugin.getDataFolder().getParentFile(), "WorldGuard.jar"))){
                    final byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) != -1){
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }catch (Exception exception){
                    exception.printStackTrace(new PrintWriter(new StringWriter()));
                }
                InitialPluginsDownloader.plugin.getLogger().info("WorldGuardのダウンロードが完了しました．");
            });
        }catch (Exception exception){
            exception.printStackTrace(new PrintWriter(new StringWriter()));
        }
    }

    private String downloadURL(String version){
        switch (version){
            case "1.21.8" -> {
                return "https://dev.bukkit.org/projects/worldguard/files/6643567/download";
            }
            case "1.21.4" -> {
                return "https://dev.bukkit.org/projects/worldguard/files/6201343/download";
            }
            case "1.21.3" -> {
                return "https://dev.bukkit.org/projects/worldguard/files/5888870/download";
            }
            case "1.21.1" -> {
                return "https://dev.bukkit.org/projects/worldguard/files/5719698/download";
            }
            case "1.21" -> {
                return "https://dev.bukkit.org/projects/worldguard/files/5707983/download";
            }
            case "1.20.6" -> {
                return "https://dev.bukkit.org/projects/worldguard/files/5344377/download";
            }
            case "1.20.4" -> {
                return "https://dev.bukkit.org/projects/worldguard/files/4675318/download";
            }
            default -> {
                return "https://dev.bukkit.org/projects/worldguard/files/latest";
            }
        }
    }
}
