# LAT2025
Task for LAT2025

# to do
[done] Create persistence layer entities\
[done] Create persistence layer repositories\
[ ] Test repositories\
[ ] Create endpoints\
[ ] Create service layer\
[ ] Test service layer\
[ ] Add Swagger for documentation\
[ ] Look for improvements\
[ ] Create sample JSON inputs\
[ ] Think of improvements for types in Services

# PERSISTENCE LAYER
to do:
- consider changing table names
1. Schema:

event:\
id\
title\
collectionBoxes (one to many)\
account (one to one)

collection_box:
id\
registered\
event (many to one)\
monetary_amount (one to many)

monetary_amount:\
id\
currency\
amount

account:\
id\
event (one to one)\
preffered_currency\
balance

2. Repositories:

3. Tests:
Event:
Account should be deleted when event is deleted
Account should be saved when event is saved

CollectionBox:
MonetaryValue should be deleted when box is deleted
MonetaryValue should be saved when 




# service layer
dtailed explanation here

# presentation layer




