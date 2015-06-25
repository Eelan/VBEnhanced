package fr.eelan.VBEnhanced;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;


public class VBEnhanced extends JavaPlugin {
	public void onEnable(){
		PluginDescriptionFile pdf = this.getDescription();
		this.getLogger().info("Vanilla Border Enhanced " + pdf.getVersion() + " has been loaded");
	}
	
	public void onDisable(){
		this.getLogger().info("VBEnhanced : Good bye !");
	}

}
