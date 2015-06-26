package fr.eelan.VBEnhanced;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VBCommand implements CommandExecutor {
	private VBEnhanced plugin;
			
	/* TODO
	 * /wb set [taille] ([reductionTime]) (-force)
	 * /wb get
	 * /wb setcenter ([CoordX]) ([CoordZ])
	 * /wb add [timeToChange] [taille] ([reductionTime]) (-warning) (X) (-force)
	 * /wb list
	 * /wb clear
	 * /wb del [ID]
	 * /wb fill
	 * /wb warning [taille] [timeToChange] (X)
	 * /wb getplayer [taille]
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
		if(!sender.isOp() || !sender.hasPermission("vbenhanced.vb"))
			sender.sendMessage(Localisation.NO_PERMISSION);
		else{
			if(arg.length == 0){
				/* Afficher l'aide VBEnhanced */
			}else{
				Player player = (Player) sender;
				switch(arg[0]){
				case "set":
					break;
				case "setcenter":
					break;
				case "get":
					plugin.getWB().infoBorder(player);
					break;
				case "add":
					break;
				case "list":
					break;
				case "clear":
					break;
				case "del":
					break;
				case "fill":
					break;
				case "warning":
					break;
				case "getplayer":
					break;
				default:
					/* Afficher l'aide VBEnhanced */
				}
			}
		}
		return false;
	}

}
