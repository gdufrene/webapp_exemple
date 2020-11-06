# Authentification.

Le fichier [database.sql](database.sql) permet de créer une base contenant quelques personnes.

Le formulaire d'authentification reprend le style d'une page de login d'un jeu assez connu...  
Ce formulaire émet une requête POST vers ["Authent"](WEB-INF/classes/Authent.java) avec les paramètres "login" et "pwd".  
La servlet se connecte à une base H2 "~/authent" en tcp (il faut que la console H2 soit lancée).

## Quelques points d'attention...

1. formulaire en POST

Si votre formulaire n'est pas en method="post" les paramètres sont transmis dans la "query string" (dans l'url après le ?).  
Ces paramètres sont donc visible et l'url est potentiellement stockée dans des fichiers de log ...  
Autant de moyen de récupérer le mot de passe en clair.

2. Https

Idéalement il faut mettre en place du http**s** entre le navigateur et le serveur afin de limiter la faculté de quelqu'un à "écouter"
les communication entre votre navigateur et le serveur.  
Cette écoute est particulièrement facile sur les réseaux Wifi ...

Le cadre de cet exemple n'est pas de montrer comment mettre en place du https mais il est important d'en souligner l'intérêt.

3. Le nom des paramètres

Les données des champs input sont transmis en fonction de l'attribut "name" de chaque input, ne pas confondre avec "id" qui sert plutot côté navigateur.  
Les ids sont utilisé pour le CSS, ou pour lié un label à son champ input.

4. Injection SQL

**Attention** à la manière de positionner vos paramètres convenablement sur la requête !  
Il ne faut surtout pas concaténer un paramètre transmis par l'utilisateur sans en effectuter un contrôle.  
Pour éviter les injection SQL, passez toujours par un "PreparedStatement" et positionnez vos paramètres avec les "setter" prévu sur cet objet.

Ce qu'il ne faut surtout pas faire :  
<pre>con.prepareStatement("select * from personne where login = '"+req.getParameter("login")+"' and mdp = '"+req.getParameter("pwd")+"'");</pre>

Ce qu'il faut faire:
<pre>PreparedStatement ps = con.prepareStatement("select * from personne where login = ? and mdp = ?");
ps.setString(1, req.getParameter("login"));
ps.setString(2, req.getParameter("pwd"));
ResultSet rs = ps.executeQuery();
</pre>

5. Mot de passe en clair en BDD

Ce n'est jamais une bonne idée de conserver les mots de passe des utilisateurs en base de données.  
Si jamais votre base venait à être volée ou accéder par quelqu'un il auraut à sa disposition la liste de tous les mots de passe des utilisateurs.  
Et malheureusement les utilisateurs ont tendance à utiliser le même mot de passe sur tous leurs comptes, il serait alors assez facile d'usurper l'identité numérique de quelqu'un (compte réseau social ou autre).

Il convient plutot de stocker le "hash" du mot de passe.  
Un "hash" est une somme de controle qui donnera toujours le même résultat si l'entrée est la même.  
Inversement il n'est pas possible, ou très compliqué, de retrouver une chaine qui donne une valeur de hash.

Il existe plusieurs algo de hash, on pourra utiliser par exemple SHA256.  
Afin d'améliorer encore la sécurité on peut introduire un élément variable dans le hash pour chaque utilisateur. Son login par exemple.

Comment faire ?  
Quand un utilisateur s'enregistre sur notre application on calcul hash(login + mot_de_passe) et on stocke cette information en base.  
Lorsque l'utilisateur s'identifie, il donne login et mot de passe, on recalcule le hash et on le compare au hash en base.  
Si les hash sont égaux, alors l'utilisateur a correctement saisi son login et son mot de passe.




