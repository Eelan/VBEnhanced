package fr.eelan.VBEnhanced;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;


public class VBEnhanced extends JavaPlugin {
	private VBBorderManager worldBorder = null;
	//private Localisation loc = new Localisation(getConfig().getString("language"));
	
	public void onEnable(){
		saveDefaultConfig();
		PluginDescriptionFile pdf = this.getDescription();
		worldBorder = new VBBorderManager(this);
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
/*
	public Localisation getLoc() {
		return loc;
	}

	public void setLoc(Localisation loc) {
		this.loc = loc;
	}
*/
}
