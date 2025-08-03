package com.hinaplugin.initialPluginsDownloader.plugins;

import com.hinaplugin.initialPluginsDownloader.InitialPluginsDownloader;
import org.bukkit.Bukkit;

import java.io.*;
import java.net.URL;

public class WorldEdit {

    public void downloader(String version){
        try {
            Bukkit.getScheduler().runTaskAsynchronously(InitialPluginsDownloader.plugin, () -> {
                InitialPluginsDownloader.plugin.getLogger().info("WorldEditをダウンロード中・・・");
                try (final InputStream in = new URL(this.downloadURL(version)).openStream(); FileOutputStream outputStream = new FileOutputStream(new File(InitialPluginsDownloader.plugin.getDataFolder().getParentFile(), "WorldEdit.jar"))){
                    final byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) != -1){
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }catch (Exception exception){
                    exception.printStackTrace(new PrintWriter(new StringWriter()));
                }
                InitialPluginsDownloader.plugin.getLogger().info("WorldEditのダウンロードが完了しました．");
            });
        }catch (Exception exception){
            exception.printStackTrace(new PrintWriter(new StringWriter()));
        }
    }

    private String downloadURL(String version){
        switch (version){
            case "1.21.8" -> {
                return "https://dev.bukkit.org/projects/worldedit/files/6786280/download";
            }
            case "1.21.7" -> {
                return "https://dev.bukkit.org/projects/worldedit/files/6759251/download";
            }
            case "1.21.6" -> {
                return "https://dev.bukkit.org/projects/worldedit/files/6693946/download";
            }
            case "1.21.5" -> {
                return "https://dev.bukkit.org/projects/worldedit/files/6616961/download";
            }
            case "1.21.3" -> {
                return "https://dev.bukkit.org/projects/worldedit/files/6338605/download";
            }
            case "1.21" -> {
                return "https://dev.bukkit.org/projects/worldedit/files/6013130/download";
            }
            case "1.20.6" -> {
                return "https://dev.bukkit.org/projects/worldedit/files/5400331/download";
            }
            case "1.20.4" -> {
                return "https://dev.bukkit.org/projects/worldedit/files/5168643/download";
            }
            case "1.20.1" -> {
                return "https://dev.bukkit.org/projects/worldedit/files/4793142/download";
            }
            default -> {
                return "https://dev.bukkit.org/projects/worldedit/files/latest";
            }
        }
    }
}
