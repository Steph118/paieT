# paieT

## Contexte du projet
L'église *** *** *** a entrepris d'acquérir le terrain qu'elle loue actuellement en contractant un prêt auprès d'une institution de microfinance. Ce prêt permettra à l'église de devenir propriétaire du terrain, pour lequel elle paie actuellement un loyer mensuel.

L'institution de microfinance a approuvé la demande de prêt et a établi un plan de remboursement mensuel. L'église s'engage à verser une somme fixe chaque mois pour rembourser le prêt.

Pour faciliter le processus de remboursement, un système a été mis en place par l'eglise. Ce système vise à encourager la participation active des membres de l'église qui souhaitent contribuer financièrement, tout en garantissant une gestion transparente et efficace des fonds.

## Objectifs

### Objectif general
Permettre une gestion numérique et digitale du processus de mise en place par L'église remboursements du crédit.

### Objectifs spécifiques
- Automatiser les enregistrements:
A ce stade, il sera question de mettre en place un système informatisé pour enregistrer les promesses et cotisations de versement mensuel des membres, leurs informations personnelles, ainsi que les paiements effectués.

- Communiquer efficacement avec les membres :
Permettre une communication automatisée pour informer les membres des échéances de paiement à venir, des rappels de paiement, et des confirmations de paiement reçues.

- Permettre aux membres d’avoir un suivi général sur les paiements des remboursements effectués.

Ce projet vise à garantir une gestion transparente et efficiente des ressources tout en promouvant l'engagement financier et la solidarité au sein de la communauté ecclésiastique.

## Analyse et Conception
- Diagramme des classes:
https://drive.google.com/file/d/1cpIfbfe6AnzsuD2QBkst9UwtQalsLOoU/view?usp=sharing

- Cahier de charges:
https://docs.google.com/document/d/1OqdOueNHKPIMTMiStkIc2vH638FM_pntFMQx6MfmpbM/edit?usp=sharing

## Installations et configurations

Le projet est réalisé avec Jakarta EE 10,

1- Maven, version 3

2- JDK, version required is 17

3- Payara, version required is 6

4- Postgresql database
To configure the database connection, go to the folder /src/main/resoources/filters directory and change the configuration in the snapshot.properties file and enter the coorect values for posgresql username and password.


