package pl.inder00.automessage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class AutoMessage extends JavaPlugin {

	public static List<String> messages = new ArrayList<String>();
	
	private static File mainDir;
	private static File cfgFile = new File(mainDir, "config.yml");
	
	FileConfiguration cfg = this.getConfig();
	
	public static int interval = 900;
	
	public void onEnable(){
	
		mainDir = this.getDataFolder();
		if(!mainDir.exists()) mainDir.mkdir();
		if(!cfgFile.exists()) this.saveDefaultConfig();
		
		interval = cfg.getInt("interval");
		for(String a : cfg.getStringList("messages")){
			messages.add(ChatColor.translateAlternateColorCodes('&', a).replace("Â", ""));
		}
		new Task().runTaskTimer(this, 0, interval*20);
		
	}
	
}
