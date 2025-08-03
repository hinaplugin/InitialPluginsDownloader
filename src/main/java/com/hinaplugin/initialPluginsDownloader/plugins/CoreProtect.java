package com.hinaplugin.initialPluginsDownloader.plugins;

import com.hinaplugin.initialPluginsDownloader.InitialPluginsDownloader;
import org.bukkit.Bukkit;

import java.io.*;
import java.net.URL;

public class CoreProtect {

    public void downloader(){
        try {
            Bukkit.getScheduler().runTaskAsynchronously(InitialPluginsDownloader.plugin, () -> {
                InitialPluginsDownloader.plugin.getLogger().info("Coreprotectをダウンロード中・・・");
                try (final InputStream in = new URL(this.downloadURL()).openStream(); FileOutputStream outputStream = new FileOutputStream(new File(InitialPluginsDownloader.plugin.getDataFolder().getParentFile(), "Coreprotect.jar"))){
                    final byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) != -1){
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }catch (Exception exception){
                    exception.printStackTrace(new PrintWriter(new StringWriter()));
                }
                InitialPluginsDownloader.plugin.getLogger().info("Coreprotectのダウンロードが完了しました．");
            });
        }catch (Exception exception){
            exception.printStackTrace(new PrintWriter(new StringWriter()));
        }
    }

    private String downloadURL(){
        return "https://www.patreon.com/file?h=104200466&i=18902237";
    }
}
