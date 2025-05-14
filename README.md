# LAT2025
Task for LAT2025

# HOW TO RUN THE APP
!please make sure you are running java 17 or it will not work!

1. inside the root project directory(collection-boxes):
./mvnw clean install
2. 
java -jar target/collection-boxes-0.0.1-SNAPSHOT.jar
3. to stop: ctrl + C


# ENDPOINTS
can be found under: http://localhost:8080/swagger-ui/index.html
available currencies values: USD, PLN, EUR

# WHAT I WOULD DO IF I HAD MORE TIME

- write more unit tests for service layer
- write integration tests for endpoints
- create a real client (now exchange rates are hardcoded)



# to do
[done] Create persistence layer entities\
[done] Create persistence layer repositories\
[ ] Test repositories\
[done] Create endpoints\
[done] Create service layer\
[ ] Test service layer\
[done] Add Swagger for documentation\
[done] Look for improvements\
[ ] Create sample JSON inputs\
[done] Think of improvements for types in Services\
[ ] Change Delete box dto to not expose assigned event
[done] Change Json properties\
[done] Add Exception handler for internal server error, maybe global for currencies error\
[done] Add Eception handler for invalid Json request\
[] Change errorResponse to have error type and message\
[done] Finish CollectionBoxController widthdrawal and EventBoxController report\
[done] Add unique to event title\
[done] Improve custom exceptions\
[done] add exception handler for WithdrawalAmount and BoxisEmpty\
[ ] add event title to be returned in some places
[ ] add a common validator
[ ] add timestamps



# tests:
Didnt have enough time


Things to consider:\
"Functional requirements
1. Every collection box should have a unique identifier.
2. A collection box can be assigned to only one fundraising event at a time.
3. You can only assign a collection box to a fundraising event if the collection box is empty.
4. When a collection box is unregistered, it is automatically emptied. No money is transfered to any
fundraising event’s account.
5. A collection box can contain money in different currencies. For simplicity, you can limit possible
currencies to a subset of your choice (e.g. three different currencies).
6. Fundraising events have their own accounts where they store collected money. The account has
only one currency.
7. When money is transfered from a collection box to a fundraising event’s account, it is converted
to the currency used by the fundraising event. The exchange rates can be hardcoded."

[done] every collection box should have a unique identifier

[done] A collection box can be assigned to only one funraising event at a time\
[done] assign collection box only when its empty\
meaning: it can be assigned, it should be a one to many association box is the owning part, box must be empty to assign\
requirements to accept assign request: box must exist, it must not be already assigned, event must exist, cant assign to the same event more than once(will be validated already with "it must not be already assigned")\
requirements to accept deposit request: box must be assigned to deposit otherwise it makes no sense

[done] when a collection box is unregistered it is automatically emptied:\
meaning: i think simply deleting the box is a good idea, but its not a must - it can exist as empty box\
requirements to accept unregister request: box must be already assigned, box must exist

[done] a collection box can contain money in different currencies.\
meaning: a currencies enum and value in MonetaryValue entity with many to one relationship with box. it will be a list in box, probably set would be better but for entity simplicity im sticking with list and can manage it in service\
[done] fundraising events have their own account where they store collected money the account has only one currency\
meaining: account entity with one to one relationship with event, account enitity have preffered currency\
[done] When money is transferred from a collection box to a founraising event's account it is converted to the currency used by the fundraising event. the exchange rates can be hardcoded.\
meaning: since colllection box containt event_id it is better to be done from box perspective, additionally there is no requirement to withdrawal from all boxes at once so it makes even more sense to do it from box perspective\
!drop that! according to requirements there should be no info in boxes report to what event box is assigned so its better to withdraw from event perspective, but i will leave for now!/
requirements for withdrawal request: box must exist, box must have some money, box must be assigned (though if it has money it must be already assigned, becouse of previous validations)


# REQUIREMENTS
1. Create a new fundraising event.\ 
validation:\
- [done] validate enum (thought maybe move it to a better place)\
- [done] title must not be empty, title should be unique (TO DO)\
2. Register a new collection box.(create)\
validation: \
- no needed\
3. List all collection boxes. Include information if the box is assigned (but don’t expose to what\
fundraising event) and if it is empty or not (but don’t expose the actual value in the box).\
validation:\
- no needed BUT maybe i shouldt expose event_id when assigning a box to event?\
4. Unregister (remove) a collection box (e.g. in case it was damaged or stolen).\
validation:
- [done] box must exist
5. Assign the collection box to an existing fundraising event
validation:
- [done] box must exist
- [done] box must not be assigned
- [done] box must be empty (though it should never be unassigned and filled with money becouse deposit wont be allowed for unassigned boxes)
- [done] event must exist
6. Put (add) some money inside the collection box.
validation:
- [done]box must exist
- [done]box must be assigned
- [done]validate enum
7. Empty the collection box i.e. “transfer” money from the box to the fundraising event’s account.
validation:
- [done] box must be assigned
- [done] box must exist
- [done] box must have money
8. Display a financial report with all fundraising events and the sum of their accounts.
validation:
- none needed










