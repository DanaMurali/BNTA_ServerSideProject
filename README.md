# BNTA_ServerSideProject

Night Owls Recipes by Hajera, Darania, Tamara, and Jordan. 

Key abbreviations 
- ri = recipe ingredient 
- rname = recipe name
- iname = ingredient name

Purpose of our Recipe API: For the user to be able to filter out recipes within the database according to their allergies.

Method of Coding: Mainly mob coding using IntelliJ's Code with Me feature. Coding alone where absolutely necessary. Percentange of commits is not a realistic record of each individual's work ethic.

Daily Work Record:

Day 1, 10th Nov -> Use miro to create an outline of our project ideas. Planned classes and how everything fits in the whole API.

Day 2, 11th Nov -> Initialized Spring Boot. Created api, service and controller class. Successfully created database via flyway migration and JDBC. Successfully managed to GET Request. Connected localhost to postman and we tried to POST a request to add a new recipe but it is not happy with ENUMs.:(

Day 3, 12th Nov -> Had a syntax error fixed, for enums and have implemented them from java into postgres. Ingredients and Recipes Class successfully created. GET, POST, DELETE & PUT requests successfully working.

Day 4, 13th Nov -> Unique ingredients and recipes on the table. Adding in UNIQUE names for ingrediens and recipes so there is no conflict of interest and so two of the same item for a column for either recipe or ingredient cannot be posted. Got the files to have joined table recipes_ingredients. Got the SQL logic sorted, now working on Java logic.

Day 5, 14th Nov -> Figured out how to inner join databases to give out exact results necessary. Have successfully associated each ingredient in an array list per recipe rather than returning a messy table which would print out the same thing for each ingredient present in each recipe. Have written complicated sql query involving cte analytic method to filter out recipes according to allergy category. We have successfully hardcoded it, however now have to implement it into java code to do GET request which it is not happy with for some reason.

Day 6, 15th Nov -> Tried to fix GET request via postman. There are some issues to how we are trying to communicate using RequestParam, path variables, etc...And it still hasn't worked. SQL query itself is working fine. It's linking the request to postman that's a problem. Have run to Colin for help as a last resort. Started to test our application. Having some difficulties trying to test DataAccessService. So we have allocated a method per person to test in our own time.

Day 7, 16th Nov -> Fixed GET request via postman. Adding all the recipes and ingredients ids to the database. Have finished testing for all service classes, just have throwables to do. API essentially finished. Have the extensions to do if we have time: Users should be able to select from more parameters e.g by cuisine, meal type, etc… & User should be able to enter in two allergies. 

Day 8, 17th Nov -> Finished up testing all service classes. Ran out of time to test the data access service class. Making presentation and preparing for the 18th.

Day 9, 18th Nov -> Day of Judgement aka Presentation Day

Instructions For Set Up:

1) CREATE DATABASE nightowl;

2) Run Spring Boot Night Owl Application.

3) Choice of entering in recipes through postman - recipes can be found here in json format (BNTA_ServerSideProject/Back-End Project MegaDoc.pdf) or via the database (copy and paste code from our db resources onto terminal: BNTA_ServerSideProject/night-owl/src/main/java/com/nightowl/databaseResources/) - recommend doing this one code block at a time. psql can't take all 250 lines of code in one go.

4) From user's point of view, we're currently at a point where user can only input allergy or cooking time not both at once.


Path Variables - for Recipe Database 

List all Recipes: GET localhost:8080/api/v1/recipe

List Recipe By Id: e.g. GET localhost:8080/api/v1/recipe/1

Add Recipe to Database: POST localhost:8080/api/v1/recipe

To Update Recipe in Database: e.g. PUT localhost:8080/api/v1/recipe/1  [enter change in body]

Delete Recipe in Database: e.g DELETE localhost:8080/api/v1/recipe/1


Path Variables - for Ingredient Database 

List all Ingredients: GET localhost:8080/api/v1/ingredient

List Ingredient By Id: e.g. GET localhost:8080/api/v1/ingredient/1

Add Ingredient to Database: POST localhost:8080/api/v1/ingredient

Update Ingredient in Database: e.g. PUT localhost:8080/api/v1/ingredient/1  [enter change in body]

Delete Ingredient in Database: e.g DELETE localhost:8080/api/v1/ingredient/1


Path Variables - for Recipes_Ingredients Database to filter by allergy or cooking time

List all recipes with ingredients: GET localhost:8080/api/v1/ri

List Recipes According to Allergy: e.g GET localhost:8080/api/v1/ri?allergen=lactose

List Recipes According to Cooking Time: e.g GET localhost:8080/api/v1/ri?cookingTime=30






