package fr.eelan.VBEnhanced;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public abstract class Localisation {
	
	File file = null;
	FileConfiguration locFile = null;
	
	public Localisation(String language){
		file = new File("plugin/VBEnhanced/localisation/" + language + ".yml");
		locFile = YamlConfiguration.loadConfiguration(file);
		try {
			locFile.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getString(String str){
		return locFile.getString(str);
	}
	
	public static final String NO_PERMISSION = "Vous n'êtes autorisé à exécuter cette Commande.";
	
	public static final String INFO_BORDER_1 = "Coordonnées du centre :";
	public static final String INFO_BORDER_2 = "Taille de la bordure :";
	
	/* Messages d'aides / Helping Message */
	public static final String VB_HELP_1 = "";
	public static final String VB_HELP_2 = "";
	public static final String VB_HELP_3 = "";
	public static final String VB_HELP_4 = "";
	public static final String VB_HELP_5 = "";
}
