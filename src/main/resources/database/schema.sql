CREATE TABLE cookpal.users (
    id int NOT NULL AUTO_INCREMENT,
    username varchar(20) NOT NULL,
    email varchar(50) NOT NULL UNIQUE,
    password varchar(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE cookpal.recipes(
    id int NOT NULL AUTO_INCREMENT,
    title varchar(200),
    dateTime DATETIME,
    instructions varchar(5000),
    numPortions int,
    timeToPrepare double,
    isFavorite boolean,
    userId int NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (userId) REFERENCES cookpal.users(id)
);

CREATE TABLE cookpal.categories(
id int NOT NULL AUTO_INCREMENT,
name varchar(100),
PRIMARY KEY(id)
);

CREATE TABLE cookpal.recipeCategory(
name varchar(100),
recipeId int NOT NULL,
categoryId int NOT NULL,
PRIMARY KEY(recipeId, categoryId),
FOREIGN KEY (recipeId) REFERENCES cookpal.recipes(id),
FOREIGN KEY (categoryId) REFERENCES cookpal.categories(id)
);

CREATE TABLE cookpal.creditCards (
id int NOT NULL AUTO_INCREMENT,
ccNum int NOT NULL,
firstName varchar(100) NOT NULL,
lastName varchar(100) NOT NULL,
expDate varchar(5) NOT NULL,
cvv int,
userId int,
PRIMARY KEY (id),
FOREIGN KEY (userId) REFERENCES cookpal.users(id)
);

CREATE TABLE weeklyPlan (
id int NOT NULL AUTO_INCREMENT,
description varchar(1000),
userId int NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (userId) REFERENCES users(id)
);

CREATE TABLE recipesInWeeklyPlan (
weeklyPlanId int NOT NULL,
recipeId int NOT NULL,
dayOfWeek varchar(30),
PRIMARY KEY (weeklyPlanId, recipeId),
FOREIGN KEY (weeklyPlanId) REFERENCES weeklyPlan(id),
FOREIGN KEY (recipeId) REFERENCES recipes(id)
);

CREATE TABLE groceryLists (
id int NOT NULL AUTO_INCREMENT,
listTitle varchar(200),
PRIMARY KEY (id)
);
