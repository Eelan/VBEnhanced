package fr.eelan.VBEnhanced;

import java.util.ArrayList;

import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VBBorderManager {
	private VBEnhanced plugin;
	private double XCenterBorder;
	private double ZCenterBorder;
	private long defaultReductionTime;
	private double sizeBorder; // Taille Actuelle de la bordure
	private double damageBuffer;
	private double damageAmount;
	
	private long[] timeToChange; // Temps pour les futurs changement
	private double[] sizeToChange;
	
	public VBBorderManager(VBEnhanced plugin){
		this.plugin = plugin;
		/* A modifier pour prendre en compte le fichier de config */
		XCenterBorder = plugin.getConfig().getDouble("BorderCenter.XCenter");
		ZCenterBorder = plugin.getConfig().getDouble("BorderCenter.ZCenter");
		sizeBorder = plugin.getConfig().getDouble("BorderSize");
		defaultReductionTime = plugin.getConfig().getLong("TimeToReduce");
		damageBuffer = plugin.getConfig().getDouble("DamageBuffer");
		damageAmount = plugin.getConfig().getDouble("DamageAmount");
		plugin.getLogger().info("--===== Info VBEnhanced =====--");
		plugin.getLogger().info("[X]"+ XCenterBorder + " / [Z]" + ZCenterBorder + " / [Taille]" + sizeBorder);
		plugin.getLogger().info("--===========================--");
		initBorder();
	}
	
	// Méthode pour initialiser la bordure par défaut (selon config.yml)
	
	public void initBorder(){
		for(World w : plugin.getServer().getWorlds()){
			w.getWorldBorder().setCenter(XCenterBorder, ZCenterBorder);
			w.getWorldBorder().setSize(sizeBorder);
			w.getWorldBorder().setDamageAmount(damageAmount);
			w.getWorldBorder().setDamageBuffer(damageBuffer);
			plugin.getLogger().info("Bordure de " + w.getName() + " changée.");
		}		
	}
	
	private void refreshInfo(){
		for(World w : plugin.getServer().getWorlds()){
			this.XCenterBorder = w.getWorldBorder().getCenter().getX();
			this.ZCenterBorder = w.getWorldBorder().getCenter().getZ();
			this.sizeBorder = w.getWorldBorder().getSize();
		}
	}
	
	public void infoBorder(CommandSender sender){
		// A planifier, return d'un tableau avec les infos interessante plutôt que d'afficher directement les infos
		refreshInfo();
		sender.sendMessage(Localisation.INFO_BORDER_1 + " [X]"+ (int)this.XCenterBorder + " [Z]" + (int)this.ZCenterBorder);
		sender.sendMessage(Localisation.INFO_BORDER_2 + " " + (int)this.sizeBorder);
		/*
		player.sendMessage(plugin.getLoc().getString("INFO_BORDER_1") + " [X]"+ XCenterBorder + " [Z]" + ZCenterBorder);
		player.sendMessage(plugin.getLoc().getString("INFO_BORDER_2") + " " + sizeBorder);
		*/
	}
	
	public void setCenter(double X, double Z){
		for(World w : plugin.getServer().getWorlds()){
			w.getWorldBorder().setCenter(X, Z);
			XCenterBorder = w.getWorldBorder().getCenter().getX();
			ZCenterBorder = w.getWorldBorder().getCenter().getZ();
		}
	}
	
	public ArrayList<Player> getPlayerOut(double size){
		refreshInfo();
		double XLoc, ZLoc;
		double XMin, XMax, ZMin, ZMax;
		
		XMin = this.XCenterBorder - size/2;
		XMax = this.XCenterBorder + size/2;
		ZMin = this.ZCenterBorder - size/2;
		ZMax = this.ZCenterBorder + size/2;
		
		plugin.getLogger().info("--===== Info VBEnhanced =====--");
		plugin.getLogger().info("[XMin]" + XMin + " / [XMax]" + XMax + " / [ZMin]" + ZMin + " / [ZMax]" + ZMax);
		plugin.getLogger().info("--===========================--");
		
		ArrayList<Player> playerOut = new ArrayList<>();
		for(Player p : plugin.getServer().getOnlinePlayers()){
			XLoc = p.getLocation().getX();
			ZLoc = p.getLocation().getZ();
			if(XMin > XLoc || XMax < XLoc || ZMin > ZLoc || ZMax < ZLoc){
				playerOut.add(p);
				plugin.getLogger().info(p.getName() + " en dehors de la bordure");
			}
		}
		return playerOut;
	}
	
	public int getDistBorder(Player player, double size){
		refreshInfo();
		int dist = 0;
		double distX=0, distZ=0;
		double XLoc, ZLoc;
		double XMin, XMax, ZMin, ZMax;
		
		XMin = this.XCenterBorder - size/2;
		XMax = this.XCenterBorder + size/2;
		ZMin = this.ZCenterBorder - size/2;
		ZMax = this.ZCenterBorder + size/2;
		
		XLoc = player.getLocation().getX();
		ZLoc = player.getLocation().getZ();
		
		if(XMin > XLoc){
			distX = Math.abs(XLoc - XMin);
		}
		if(XMax < XLoc){
			distX = Math.abs(XLoc - XMax);
		}
		if(ZMin > ZLoc){
			distZ = Math.abs(ZLoc - ZMin);
		}
		if(ZMax < ZLoc){
			distZ = Math.abs(ZLoc - ZMax);
		}
		
		if(distX == 0)
			dist = (int)distZ;
		else if(distZ == 0)
			dist = (int)distX;
		else
			dist = (int)Math.sqrt(distX * distZ);
				
		return dist;
	}
}
