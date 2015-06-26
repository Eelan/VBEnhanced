package fr.eelan.VBEnhanced;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;


public class VBEnhanced extends JavaPlugin {
	private VBBorderManager worldBorder = new VBBorderManager(this);
	
	public void onEnable(){
		PluginDescriptionFile pdf = this.getDescription();
		this.getLogger().info("Vanilla Border Enhanced " + pdf.getVersion() + " has been loaded");
		
		getCommand("wb").setExecutor(new VBCommand(this));
	}
	
	public void onDisable(){
		this.getLogger().info("VBEnhanced : Good bye !");
	}

	// Getters / Setters
	public VBBorderManager getWB() {
		return worldBorder;
	}

	public void setWB(VBBorderManager worldBorder) {
		this.worldBorder = worldBorder;
	}

}
