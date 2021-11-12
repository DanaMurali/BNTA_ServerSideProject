CREATE TYPE cuisine as ENUM('ITALIAN', 'BRITISH');
CREATE TYPE meal_type as ENUM('BREAKFAST', 'LUNCH', 'DINNER', 'SNACK', 'DESSERT');
CREATE TYPE spice_rating as ENUM('HOT', 'MEDIUM', 'MILD', 'SWEET');


CREATE TABLE recipes (
    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    cuisine cuisine,
    vegetarian BOOLEAN,
    vegan BOOLEAN,
    meat_only BOOLEAN,
    pescatarian BOOLEAN,
    meal_type meal_type,
    spice_rating spice_rating,
    cooking_time INT NOT NULL,
    instructions TEXT NOT NULL
);



