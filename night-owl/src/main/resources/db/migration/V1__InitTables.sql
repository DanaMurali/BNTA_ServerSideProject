CREATE TYPE CUISINE as ENUM('ITALIAN', 'BRITISH');
CREATE TYPE MealType as ENUM('BREAKFAST', 'LUNCH', 'DINNER', 'SNACK', 'DESSERT');
CREATE TYPE SpiceRating as ENUM('HOT', 'MEDIUM', 'MILD', 'SWEET');


CREATE TABLE recipes (
    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    cuisine CUISINE,
    vegetarian BOOLEAN,
    vegan BOOLEAN,
    meatOnly BOOLEAN,
    pescatarian BOOLEAN,
    mealType MealType,
    spiceRating SpiceRating,
    cookingTime INT NOT NULL,
    instructions TEXT NOT NULL
);

