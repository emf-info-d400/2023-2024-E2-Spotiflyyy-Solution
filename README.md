# E2-D400-Spotiflyyy

## Contexte général

L'application `Spotiflyyy`, très populaire, permet d'écouter à volonté de la musique et de créer des playlists personnalisées.

Les chansons sont incluses dans des albums publiés par divers artistes. Les albums ont chacun un titre et peuvent contenir des nombres de chansons différents.

Les playlists quant à elles sont créées par les utilisateurs avec des chansons de leur choix. Ils peuvent ainsi créer des ambiances musicales selon leurs goûts et les partager avec leurs amis.

<img src="doc/Spotiflyyy.webp" width="320" alt="Image application Spotiflyyy"/>

## ATTENTION

Commencez par lire cette consigne `avec grande attention` et prenez garde :

- Les descriptions fonctionnelles sont précises et le choix des mots n'est pas anodin.
- Faites les points mentionnés avec précision et dans l'ordre indiqué.
- Revérifiez bien ensuite avoir fait ce qui est demandé.

## CONSIGNE

### Service de calcul de durée

Dans le package `services` créez une classe nommée `ServiceCalculDuree`. Cette classe contiendra des méthodes, **directement accessibles sans avoir à créer d'instance de la classe**, pour faciliter le passage d'une durée en secondes à une durée en minutes et secondes, et inversément. Dans cette classe, créez 3 méthodes:

- `calculeDureeSecondes`, qui recevra deux informations : une durée en minutes ainsi qu'une durée secondes, et retournera la durée totale correspondante en secondes.  
  Par exemple, si on lui donne **3** minutes et **2** secondes, elle retournera **182** secondes.
- `calculeMinutesEntieres` qui recevra une durée totale en secondes, et retournera le nombre de minutes entières correspondantes.  
  Par exemple, si on lui donne **182** secondes, elle retournera **3** minutes.
- `calculeResteSecondes` qui recevra une durée totale en secondes, et retournera le nombre de secondes ne permettant pas de faire de minute entière, c'est-à-dire ce qui reste si on enlève les munites entières.  
  Par exemple, si on lui donne **182** secondes, elle retournera **2** secondes.

**N.B.** À partir de maintenant, chaque fois que vous devrez isoler les minutes et les secondes de la durée d'une chanson et/ou d'un album, pensez à utiliser ces méthodes de votre service ! Cela vous facilitera le travail pour ensuite les traiter, les afficher.

### Chansons

Dans le package `models` créez une classe nommée `Chanson`. Une `Chanson` aura les caractéristiques suivantes :

- `interprete` (par exemple "Lady Gaga" ou "Ninho")
- `titre` (par exemple "Cantique Suisse", ou "Poker Face")
- `duree` de la chanson en **secondes** (par exemple 182, pour une chanson de 3 minutes et 2 secondes)

Toutes ces informations doivent être fournies lors de sa **création**.

On doit pouvoir **demander toutes ces informations** à une chanson. Aucune de ces informations ne devra pouvoir être modifiée après coup.

Si on **affiche une chanson**, celle-ci doit se montrer sous cette forme:

`Lady Gaga - Just Dance, 4:02`

ou encore

`PSY - Gangnam Style, 3:39`

Les secondes sont toujours affichées sur **2 positions**, c'est à dire "4:02" et non "4:2".

**N.B.** Pensez à utiliser le service que vous venez d'écrire pour isoler ces durées !

### Albums

Toujours dans le package `models`, créez une classe nommée `Album`. Un album aura:

- un `titre` (par exemple "The Fame")
- un `interprete` (par exemple "Lady Gaga" ou "Ninho")
- un certain nombre de `chansons`

Pour **créer un nouvel album**, toutes ces informations doivent être fournies. Une fois un album créé, le titre, l'interprète et les chansons ne peuvent plus être modifiés, mais on pourra toujours lui **demander ses caractéristiques**.

On doit pouvoir **demander à un album sa durée totale** en secondes, c-à-d la somme des durées de chacune des chansons qu'il contient.

Si on **affiche un album**, celui-ci doit se montrer sous cette forme:

`The Fame par Lady Gaga : 3 titres, durée 11 minutes et 29 secondes`

ou encore

`Destin par Ninho : 18 titres, durée 57 minutes et 57 secondes`

**N.B.** Pensez à utiliser le service que vous venez d'écrire pour isoler ces durées !

### Playlists

Toujours dans le package `models`, créez une classe nommée `Playlist`. Un album aura:

- un `proprietaire` (par exemple "John" ou "utilisateur223")
- un certain nombre de `chansons`
- un `nom` donné à cette playlist (par exemple "Playlist calme pour révisions" ou "Party Time")

Pour **créer une nouvelle playlist**, il faut fournir son propriétaire et son nom. La playlist ne contient pas de chanson à sa création, elle a une taille de 0. On pourra récupérer et modifier les caractéristiques en tout temps.

On doit pouvoir **demander à une playlist si oui ou non elle contient une certaine chanson**.

On doit pouvoir **ajouter une chanson** à une playlist. La chanson a ajouter est toujours placée en dernier dans la liste des chansons. On ne doit pas pouvoir ajouter 2 fois la même chanson dans la playlist. ATTENTION : la liste des chansons d'une Playlist ne contient jamais d'espace disponibles (`null`) pour accueillir des chansons supplémentaires mais juste les chansons qu'elle contient, sans plus. Il va donc falloir faire le nécessaire pour aggrandir cette liste et y mettre cette nouvelle chanson à sa fin. Cette méthode est détaillée sous forme de diagramme de séquence/interaction plus bas.

De même, on doit pouvoir **retirer une chanson** de la playlist. On précise quelle chanson il faut retirer. Une fois la chanson retirée, la playlist ne contient jamais de piste vide, elle a toujours une taille adaptée.

On doit pouvoir **demander à une playlist sa durée totale** en secondes, c-à-d la somme des durées de chacune des chansons qu'elle contient.

Si on **affiche une playlist**, celle-ci doit se montrer sous cette forme:

`Playlist 'Concentration - Revisions' crée par Medusagician : 3 titres, durée 7 minutes et 9 secondes`

#### Diagramme de séquence de la méthode ajouterChanson

```mermaid
sequenceDiagram
    
    ajouterChanson()->>ajouterChanson(): reussite=false

    ajouterChanson()->>ajouterChanson():chansonDejaPresente = contientChanson(chanson);

    alt !chansonDejaPresente
        create participant nouvellePlaylist
        ajouterChanson()->>nouvellePlaylist: new Chanson[chansons.length+1]
        loop pour chaque Chanson dans chansons
            ajouterChanson()->>nouvellePlaylist: nouvellePlaylist[i]=chansons[i]
        end
        ajouterChanson()->>nouvellePlaylist: nouvellePlaylist[nouvellePlaylist.length-1]=chanson

        nouvellePlaylist->>ajouterChanson(): chansons = nouvellePlaylist
        
        ajouterChanson()->>ajouterChanson(): reussite=true
    
    end
```

### Application

#### Données à utiliser dans votre programme

Voici ci-dessous les données (albums et leurs chansons) que vous allez devoir utiliser dans votre programme.

#### Album 'The Fame - Lady Gaga'

| The Fame - Lady Gaga     |  |
|-------------|-------|
| Just Dance  | 4:02  |
| Poker Face  | 3:59  |
| Paparazzi   | 3:28  |
|||

#### Album 'Psy 6 - PSY'

| Psy 6 - PSY       |  |
|---------------|-------|
| Gangnam Style | 3:39 |
|||

#### Album 'The Code - Nemo'

| The Code - Nemo       |  |
|---------------|-------|
| The Code | 3:30 |
|||

#### Méthode - `void main(String[] args)`

Dans le `main()` de la classe `Application` déjà fournie, effectuez les opérations suivantes :

- Créez les albums listés ci-dessous avec leurs chansons. **N'oubliez pas d'utiliser votre service de calcul durée pour donner la durée correcte de vos chansons!**
- Créez un tableau contenant ces 3 albums, appelé `bibliotheque`.
- Ensuite, créez un tableau pouvant accueillir 5 playlists, appelé `playlists`.
- Dans la première position du tableau, créez une playlist nommée "Playlist pour les vacances" et appartenant à "fan2Squ33zie".
- Dans la dernière position du tableau, créez une playlist nommée "Concentration - Revisions" et vous appartenant.
- Ajoutez des chansons de votre choix à ces playlists (au minimum 1 par playlist)
- Pour finir, affichez le contenu des tableaux `bibliotheque` et `playlists`.

## Résultat sur la console

Si vous avez correctement réalisé cette application vous devriez obtenir un affichage ressemblant à ceci :

```text
 
Bibliothèque:
****************************
The Fame par Lady Gaga : 3 titres, durée 11 minutes et 29 secondes
Lady Gaga - Just Dance, 4:02
Lady Gaga - Poker Face, 3:59
Lady Gaga - Paparazzi, 3:28
****************************
Psy 6 par PSY : 1 titres, durée 3 minutes et 39 secondes    
PSY - Gangnam Style, 3:39
****************************
The Code par Nemo : 2 titres, durée 3 minutes et 30 secondes
Nemo - The Code, 3:30
****************************
Playlists:
****************************
Playlist "Playlist pour les vacances" crée par fan2Squ33zie : 4 titres, durée 14 minutes et 59 secondes.
Lady Gaga - Just Dance, 4:02
Lady Gaga - Poker Face, 3:59
Lady Gaga - Paparazzi, 3:28
Nemo - The Code, 3:30
****************************
Playlist "Concentration - Revisions" crée par Fanny Riedo : 1 titres, durée 3 minutes et 39 secondes.
PSY - Gangnam Style, 3:39
****************************
```

## Fonctionnalités supplémentaires

Une fois tout ce qui précède réalisé et fonctionnel, ajoutiez ces capacités à vos classes `Album` et `Playlist`:

### Album

- **Recherche par titre** : on doit pouvoir demander à un `Album` une chanson en lui fournissant le titre (par exemple, "Gangnam Style"). Si la chanson n'est pas dans l'album, on obtiendra `null`.
- **Recherche de la plus longue durée de chanson** : on doit pouvoir demander à un `Album` la durée de sa chanson la plus longue. On obtiendra la durée en secondes.
- **Chanson aléatoire** : on doit pouvoir demander à un `Album` de retourner une chanson choisie au hasard.

### Playlist

- **Supprimer les chansons longues** : on doit pouvoir demander à une `Playlist` de supprimer les chansons plus longues que la durée fournie en secondes. On obtiendra le nombre de chansons supprimées.
- **Calcul de la durée moyenne des chansons de la playlist** : on doit pouvoir demander à une `Playlist` la durée moyenne des chansons qu'elle contient. On obtiendra la durée en secondes.

**Pensez à tester vos méthodes!**

## RESTITUTION

1. Faites signe au prof lorsque vous aurez terminé et que vous êtes prêt à rendre. Il vous autorisera à remettre le réseau.
2. Rendre votre travail par `push` GitHub.
3. Attendre que le prof vous ait confirmé avoir reçu votre travail.
4. Quitter rapidement la salle en silence.
