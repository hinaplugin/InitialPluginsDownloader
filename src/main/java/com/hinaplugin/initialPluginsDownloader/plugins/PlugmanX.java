package com.hinaplugin.initialPluginsDownloader.plugins;

import com.hinaplugin.initialPluginsDownloader.InitialPluginsDownloader;
import org.bukkit.Bukkit;

import java.io.*;
import java.net.URL;

public class PlugmanX {

    public void downloader(){
        try {
            Bukkit.getScheduler().runTaskAsynchronously(InitialPluginsDownloader.plugin, () -> {
                InitialPluginsDownloader.plugin.getLogger().info("PlugmanXをダウンロード中・・・");
                try (final InputStream in = new URL(this.downloadURL()).openStream(); FileOutputStream outputStream = new FileOutputStream(new File(InitialPluginsDownloader.plugin.getDataFolder().getParentFile(), "PlugmanX.jar"))){
                    final byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) != -1){
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }catch (Exception exception){
                    exception.printStackTrace(new PrintWriter(new StringWriter()));
                }
                InitialPluginsDownloader.plugin.getLogger().info("PlugmanXのダウンロードが完了しました．");
            });
        }catch (Exception exception){
            exception.printStackTrace(new PrintWriter(new StringWriter()));
        }
    }

    private String downloadURL(){
        return "https://www.spigotmc.org/resources/plugmanx.88135/download?version=547026";
    }
}
