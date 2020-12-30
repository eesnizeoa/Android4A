# Android4A

## Présentation
Cette application permet de visualiser une liste de pokemon après identification d'un compte. Cette liste est chargée à partir de l'api rest pokeapi disponible sur le lien suivant: https://pokeapi.co/api/v2/pokemon . Elle permet lors de la selection d'un item de la liste d'afficher des détails sur un élément plus particulièrement le nom et un lien ppour trouver des infos complémentaires.
## Prérequis
* Avoir installé Android Studio  
* Télécharger la branche master de ce projet
## Consignes respectées
* Consignes de base 
  * Language Kotlin
  * Architecture MVVM
  * Clean Architecture
  * Utilisation d’une réelle BDD (Room)
  * Utilisation Api REST
  * Affichage d’une liste
  * Design
* Consignes supplémentaires  
  * [x] Splashscreen
  * [x] Logo App
## Fonctionnalités  
Lorsque l'application s'ouvre, un SplashScreen apparaît. Une page de login apparaît. Si vous venez de télécharger l'app vous n'avez pas encore de compte. Essayez de cliquer sur Login, vous verrez un message d'erreur.
<p align="center">
<img src="Android4A/.PNG" width="200" height="350" />  
</p>
<p align="center">
<img src="Android4A/.PNG" width="200" height="350" />  
</p>
<p align="center">
<img src="Android4A/.PNG" width="200" height="350" />  
</p>
<p align="center">
<img src="Android4A/.PNG" width="200" height="350" />  
</p>
<p align="center">
<img src="Android4A/.PNG" width="200" height="350" />  
</p>
<p align="center">
<img src="Android4A/.PNG" width="200" height="350" />  
</p>
<p align="center">
<img src="Android4A/.PNG" width="200" height="350" />  
</p>
Cliquez sur Create Account et vous accédez à une nouvelle activité. Sur cette activité, vous choisissez un identifiant et un mot de passe, puis cliquez sur Register.
cela vous ramène à la page de login. Cette fois-ci si vous entrez vos identifiant et mot de passe, cela marchera. Une liste de pokemons apparaîtra alors. Cliquez sur le logo android et vous aurez une page avec les infos sur l'élément choisi.
Lorsque l'on clique sur l'icone android d'un item, cela ouvre une nouvelle fenêtre qui charge le nom et l'url voulus.  
<p align="center">
<img src="myProjectCopy_Screen/Detail.PNG" width="200" height="350" />
</p>  
