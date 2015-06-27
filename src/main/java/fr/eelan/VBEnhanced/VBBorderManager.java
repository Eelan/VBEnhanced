package fr.eelan.VBEnhanced;

import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VBBorderManager {
	private VBEnhanced plugin;
	private double XCenterBorder;
	private double ZCenterBorder;
	private long defaultReductionTime;
	private double sizeBorder; // Taille Actuelle de la bordure
	private double XMin, XMax, ZMin, ZMax; // Limite X, Y de la bordure actuelle
	
	private double[] XMinNB, XMaxNB, ZMinNB, ZMaxNB; // Limite X, Y des futurs bordures
	private long[] timeToChange; // Temps pour les futurs changement
	
	public VBBorderManager(VBEnhanced plugin){
		this.plugin = plugin;
		/* A modifier pour prendre en compte le fichier de config */
		XCenterBorder = 0; ZCenterBorder = 0;
		sizeBorder = 1000;
		defaultReductionTime = 30;
		XMin = XCenterBorder - sizeBorder/2;
		XMax = XCenterBorder + sizeBorder/2;
		ZMin = ZCenterBorder - sizeBorder/2;
		ZMax = ZCenterBorder + sizeBorder/2;
		initConfigBorder(); // On laisse le temps des essais
	}
	
	// Méthode pour initialiser la bordure par défaut (selon config.yml)
	public void initConfigBorder(){
		for(World w : plugin.getServer().getWorlds()){
			w.getWorldBorder().setCenter(XCenterBorder, ZCenterBorder);
			w.getWorldBorder().setSize(sizeBorder);
		}
	}
	
	public void infoBorder(CommandSender sender){
		// A planifier, return d'un tableau avec les infos interessante plutôt que d'afficher directement les infos
		sender.sendMessage(Localisation.INFO_BORDER_1 + " [X]"+ XCenterBorder + " [Z]" + ZCenterBorder);
		sender.sendMessage(Localisation.INFO_BORDER_2 + " " + sizeBorder);
		/*
		player.sendMessage(plugin.getLoc().getString("INFO_BORDER_1") + " [X]"+ XCenterBorder + " [Z]" + ZCenterBorder);
		player.sendMessage(plugin.getLoc().getString("INFO_BORDER_2") + " " + sizeBorder);
		*/
	}
	
	public void setCenter(double X, double Z){
		for(World w : plugin.getServer().getWorlds()){
			w.getWorldBorder().setCenter(X, Z);
		}
	}
}
