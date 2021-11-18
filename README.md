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

Day 7 16th Nov -> Fixed the GET request via postman. Adding all the recipes and ingredients ids to the database. 

Instructions For Set Up:

1) CREATE DATABASE nightowl;
2) Run Spring Boot Night Owl Application.
3) Choice of entering in recipes through postman(contact us for json file) or database(copy and paste code from our db resources onto terminal).





