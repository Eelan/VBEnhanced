# VBEnhanced
Vanilla Border Enhanced
##-= EN =- 
	This description will be translate as soon as possible.  
	
##-= FR =-  
Ce plugin est en cours de réalisation, et non encore opérationnel.  
Il a pour but d'ajouter quelques fonctionnalités interessantes aux bordures Vanilla.  

##Commandes
	
 - '/wb set [taille] ([reductionTime]) (-force)'  
	 	Réduire ou augmenter la bordure jusqu'à [taille].
	 	[reductionTime] permet de spécifier le temp en seconde que mettra la bordure à réduire/augmenter.
	 	-force indiquera que la commande doit être exécuter, même si des joueurs se trouvent à l'extérieur de la bordure.
	 
 - '/wb get'  
	 	Connaitre la taille de la bordure, et ses coordonnées  	
 - '/wb setcenter ([CoordX]) ([CoordZ])'  
	 	Définition du centre de la bordure.  
	 	Si [CoordX] et [CoordZ] ne sont pas spécifiées, elle sera défini à la position de l'executeur de la commande.  
 - '/wb add [timeToChange] [taille] ([reductionTime]) (-warning)(-force)'  
	 	Programme un futur changement de bordure dans [timeToChange] minutes.  
		-warning indique qu'un "warning" sera effectué toutes les X secondes (défini par défaut dans la config si non spécifié) à tous les joueurs non présent dans la limite.  
 - '/wb list'  
	 	Liste les futurs changement de bordure sous cette forme :  
	 		ID : Taille - Temps  
 - '/wb clear'  
	 	Supprime tout les futurs changement  
 - '/wb del [ID]'  
	 	Supprime le changement avec le numéro [ID]  
 - '/wb fill'  
	 	Prégénère la totalité des chunk présent à l'intérieur de la bordure.  
 - '/wb warning [taille] [timeToChange] (X)'  
	 	Simple warning d'un futur changement de bordure (sans application auto à la fin)  
 - '/wb getplayer [taille]'  
	 	Lister les joueurs hors des limites [taille]  
	 	
