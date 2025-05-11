# LAT2025
Task for LAT2025

# to do
[done] Create persistence layer entities  
[ ] Create persistence layer repositories  
[ ] Test repositories  
[ ] Create endpoints 
[ ] Create service layer  
[ ] Test service layer  
[ ] Add Swagger for documentation  
[ ] Look for improvements
[ ] Create sample JSON inputs

# PERSISTENCE LAYER
to do:
- consider changing table names
1. Schema:

event: 
id
collectionBoxes (one to many)
account (one to one)

collection_box:
id
registered
event (many to one)
monetary_amount (one to many)

monetary_amount
id
currency
amount

account
id
event (one to one)
preffered_currency
balance

Repositories:
I have decided that I only need EventRepository and CollectionBoxRepository since all the changes will be propagated and i will never need to access them directly.

# service layer
dtailed explanation here

# presentation layer
detailed explanation here



