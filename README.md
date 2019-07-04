s collegues-api
pour tester la web api il faut se rendre à l'adresse https://cassan-collegues-api.herokuapp.com
Pour tester quelle fonctionne il faut rentrer des parametres dans l'url qui permettent de vérifier son fonctionnement
Par exemple rajouter /collegues?nom=MATHIEU pour vérifier qu'il y a bien des collegues dont le nom est MATHIEU.
Dans ce cas le corps de la méthode devrait renvoyer 2 matricules distincts car il y a 2 personnes qui portent le nom MATHIEU.
autres valeurs de test : /collegues?nom=Oddet et /collegues?nom=Cassan qui renvoient chacune 1 matricule.
