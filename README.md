# VBEnhanced
Vanilla Border Enhanced
-= EN =- 
	This description will be translate as soon as possible.
	
-= FR =-
Ce plugin est en cours de r�alisation, et non encore op�rationnel.
Il a pour but d'ajouter quelques fonctionnalit�s interessantes aux bordures Vanilla.
	Commande � r�aliser :
	 /wb set [taille] ([reductionTime]) (-force)
	 	R�duire ou augmenter la bordure jusqu'� [taille].
	 	[reductionTime] permet de sp�cifier le temp en seconde que mettra la bordure � r�duire/augmenter.
	 	-force indiquera que la commande doit �tre ex�cuter, m�me si des joueurs se trouvent � l'ext�rieur de la bordure.
	 
	 /wb get
	 	Connaitre la taille de la bordure, et ses coordonn�es	
	 /wb setcenter ([CoordX]) ([CoordZ])
	 	D�fini le centre de la bordure.
	 	Si [CoordX] et [CoordZ] ne sont pas sp�cifi�s, elle sera d�fini � la position de l'executeur de la commande.
	 /wb add [timeToChange] [taille] ([reductionTime]) (-warning)(X)(-force)
	 	Programme un futur changement de bordure dans [timeToChange] minutes.
	 	-warning indique qu'un "warning" sera effectu� toutes les X secondes (d�fini par d�faut dans la config si non sp�cifi�) � tous les joueurs non pr�sent dans la limite.
	 /wb list
	 	Liste les futurs changement de bordure sous cette forme :
	 		ID : Taille - Temps
	 /wb clear
	 	Supprime tout les futurs changement
	 /wb del [ID]
	 	Supprime le changement avec le num�ro [ID]
	 /wb fill
	 	Pr�g�n�re la totalit� des chunk pr�sent � l'int�rieur de la bordure.
	 /wb warning [taille] [timeToChange] (X)
	 	Simple warning d'un futur changement de bordure (sans application auto � la fin)
	 /wb getplayer [taille]
	 	Lister les joueurs hors des limites [taille]
	 	