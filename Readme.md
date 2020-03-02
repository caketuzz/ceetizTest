# Test Ceetiz
![Java CI](https://github.com/caketuzz/ceetizTest/workflows/Java%20CI/badge.svg) [![codecov](https://codecov.io/gh/caketuzz/ceetizTest/branch/master/graph/badge.svg)](https://codecov.io/gh/caketuzz/ceetizTest)

![Coverage](https://codecov.io/gh/caketuzz/ceetizTest/branch/master/graphs/commits.svg)
![Coverage](https://codecov.io/gh/caketuzz/ceetizTest/branch/master/graphs/sunburst.svg)


## Rappel du problème

Le ministère des finances vous demande de créer un programme devant permettre de calculer les impôts dus par les entreprises françaises.

Dans un premier temps, ce programme devra gérer 2 types d'entreprise :

A) Les auto-entreprises, qui ont les propriétés suivantes :
- N° SIRET
- Dénomination

B) Les SAS, qui ont les propriétés suivantes :
- N° SIRET
- Dénomination
- Adresse du siège social

Le programme sera étendu par la suite avec d'autres types d'entreprise (SASU, SARL ...)

Par ailleurs, le calcul des impôts devra respecter les règles de gestion suivantes :
- Pour les auto-entreprises :
--> impôts = 25% du CA annuel de l'entreprise
- Pour les SAS :
--> impôts = 33% du CA annuel de l'entreprise


## Implémentation de la solution

### Architecture

La modélisation des rôles s'articule autour des deux modèles:
- _TresorPublic_ , qui gère l'enregistrement et les actions des entreprises. Le TP est un singleton.
- le type générique et abstract _Societe_, dont les implémentations _SAS_ et _Autoentreprise_ diffèrent sur le calcul de l'impôt et leur représentation textuelle.

Note:
Le calcul de l'impôt n'est pas directement une action de l'entreprise, mais plutôt du Trésor Public qui est responsable de son calcul, en fonction des données provenant des entreprises (sociétés).
On peut donc considérer que cette tâche incombe au TP.

Dans le cadre de la modélisation de cet exercice, on peut également considérer qu'une entreprise est considérée du point de vue du TP et donc dans ce cas l'implémentation d'un type de société peut prendre en charge le calcul de son impôt. 

-> Les hypothèses de cet exercice ne permettent pas de trancher entre l'un ou l'autre modèle, et c'est donc la seconde approche qui est retenue.

### Fonctionnalités

- Les données sur les entreprises sont chargées par un fichier JSON. L'idée étant que dans un cas réel, les données peuvent provenir d'un autre progiciel avec une fonction d'export ou un connecteur vers une base de données.
Par ailleurs, cela permet d'envisager plus simplement un pattern _Repository_.

- Les _Societe_ peuvent calculer leur impôt pour n'importe quelle année, dans le cas d'une année ne comprenant aucune donnée, 0 est renvoyé.

### Evolutions possibles
- Pour ajouter un nouveau type d'entreprise (SARL, SASU, etc,...) il suffira de rajouter une classe étendant Societe en reprenant les exemples SAS ou Entrepreneur.
Il conviendra aussi de rajouter un subtype à l'auto-parser JSOn (ligne 42 du fichier Societe.java)

- Le modèle actuel permet de gérer simplement des évolutions des modes de calcul suivant les années, directement dans les classes Implémentation de sociétés.

- On pourrait imaginer décrire les modes de calculs complets, année par année et pour chacun des types de société dans un fichier JSON. Cela offirait l'avantage de pouvoir supprimer directement les fichiers Implémentation de sociétés et n'avoir qu'une classe _Societe_ unique. Les calculs avec de nombreuses variables et en particlulier non linéaires peuvent être difficiles à modéliser et retranscrire ensuite en code au runtime.

### Divers
- J'ai pour habitude d'écrire le code en anglais. Avec pour exception le code spécifique métier, qui peut être difficile et inadapté à traduire. C'est pourquoi la partie métier de ce code est en français, plutôt qu'en anglais.