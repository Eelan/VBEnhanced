package fr.eelan.VBEnhanced;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VBCommand implements CommandExecutor {
	private VBEnhanced plugin;
			
	/* TODO
	 * /wb set [taille] ([reductionTime]) (-force)
	 * /wb get																			OK
	 * /wb setcenter ([CoordX]) ([CoordZ])												OK
	 * /wb add [timeToChange] [taille] ([reductionTime]) (-warning) (-force)
	 * /wb list
	 * /wb clear
	 * /wb del [ID]
	 * /wb fill [confirm]
	 * /wb warning [taille] [timeToChange] (X)
	 * /wb getplayer [taille]															OK
	 * 
	 * A planifier ?
	 * Ajout des damage buffer, damage amount...
	 * Possibilité pour les joueurs de voter un changement de bordure
	 * Commande pour réaliser une bordure "par défaut" rapidement.
	 */
	
	public VBCommand(VBEnhanced plugin){
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg) {
		boolean helpMessage = false;
		double coordX = 0;
		double coordZ = 0;
		
		
		if(!sender.isOp() || !sender.hasPermission("vbenhanced.vb"))
			sender.sendMessage(Localisation.NO_PERMISSION);
		else{
			if(arg.length == 0){
				/* Afficher l'aide VBEnhanced */
			}else{
				switch(arg[0]){
				case "set":
					if(!setCmd(sender, arg)){
						/* Message d'aide */
					}
					break;
				case "setcenter":
					if(!setCenter(sender, arg)){
						/* Message d'aide */
					}
					break;
				case "get":
					if(arg.length == 1){
						plugin.getWB().infoBorder(sender);
					}else{
						/* Message d'aide */
					}
						
					break;
				case "add":
					if(!addCmd(sender, arg)){
						/* Message d'aide */
					}
					break;
				case "list":
					if(arg.length == 1){
						/* Commande */
					}else{
						/* Message d'aide*/
					}
					break;
				case "clear":
					if(arg.length == 1){
						/* Commande */
					}else{
						/* Message d'aide */ 
					}
					break;
				case "del":
					
					break;
				case "fill":
					break;
				case "warning":
					break;
				case "getplayer":
					if(!getPlayer(sender, arg)){
						/* Message d'aide */
					}
					break;
				default:
					/* Afficher l'aide VBEnhanced */
				}
			}
		}
		return false;
	}
	
	private boolean setCenter(CommandSender sender, String arg[]){
		// /wb setcenter ([CoordX] [CoordZ])
		Player player = (Player) sender;
		double coordX = 0;
		double coordZ = 0;
		
		if(arg.length == 1){
			if(isPlayer(sender)){
				coordX = player.getLocation().getX();
				coordZ = player.getLocation().getZ();				
			}else
				return true; // Logique ? Bon on verra...
		}else if(arg.length == 3){
			try{
				coordX = Double.parseDouble(arg[1]);
				coordZ = Double.parseDouble(arg[2]);
			}catch(NumberFormatException ex){
				return false;
			}
		}else
			return false;
		
		plugin.getWB().setCenter(coordX, coordZ);
		return true;
	}
	
	private boolean setCmd(CommandSender sender, String arg[]){
		// /wb set [taille] ([reductionTime]) (-force)
		long reductionTime = 30;
		boolean force = false;
		double taille = 2000;
		
		if(!(arg.length >= 2 && arg.length <= 4))
			return false;
		else{
			try{
				taille = Double.parseDouble(arg[1]);
			}catch(NumberFormatException ex){
				return false;
			}
			for(int i=2; i < arg.length; i++){
				switch(arg[i]){
				case "-force": case "-f":
					break;
				default:
					try{
						reductionTime = Long.parseLong(arg[2]);
					}catch(NumberFormatException ex){
						return false;
					}
				}
			}
		}
		// Méthode à coder pour exécuter la commande
		return true;
	}
	
	private boolean addCmd(CommandSender sender, String arg[]){
		// /wb add [timeToChange] [taille] ([reductionTime]) (-warning) (-force)

		long timeToChange, reductionTime, freqWarning;
		double taille;
		boolean warning, force;
		
		if(!(arg.length >= 3 && arg.length <= 7)){
			return false;
		}else{
			try{
				timeToChange = Long.parseLong(arg[1]);
				taille = Double.parseDouble(arg[2]);
			}catch(NumberFormatException ex){
				return false;
			}
			for(int i = 3 ; i < arg.length ; i++){
				switch(arg[i]){
				case "-warning": case "-w":
					warning = true;
					break;
				case "-force": case "-f":
					force = true;
					break;
				default:
					try{
						reductionTime = Long.parseLong(arg[i]);
					}catch(NumberFormatException ex){
						return false;
					}
				}
			}
		}
		
		/* Commande à coder */
		return true;
	}

	private boolean fillCmd(CommandSender sender){
		 // /wb fill [confirm]
				 

		return true;
	}
	
	private boolean getPlayer(CommandSender sender, String[] arg){
		// /wb getplayer [taille]
		ArrayList<Player> playerOut = new ArrayList<>();
		double size = 0;
		try{
			size = Double.parseDouble(arg[1]);
		}catch(NumberFormatException ex){
			sender.sendMessage("[taille] doit être un nombre !");
			return false;
		}
		
		playerOut = plugin.getWB().getPlayerOut(size);
		for(Player p : playerOut){
			sender.sendMessage(p.getName() + " est à " + plugin.getWB().getDistBorder(p, size) + " bloc de la limite.");
		}
		return true;
	}
	
	private boolean warningCmd(CommandSender sender, String[] arg){
		// /wb warning [taille] [timeToChange] (X)
		
		return true;
	}
	
	private boolean isPlayer(CommandSender sender){
		if(!(sender instanceof Player)){
			sender.sendMessage("Vous n'êtes pas un joueur");
			return false;
		}
		return true;
	}
}
