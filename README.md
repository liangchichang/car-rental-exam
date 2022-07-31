# car-rental-system

## Runtime Environment

Visit http://175.178.70.185:8080 to access the website, do the user registration for experience.

## System Architecture

The rental car system should include the following features:

1. User registration and login.
2. Able to query vehicle and inventory information.
3. Able to see the user's orders, cancel the order and return the inventory.
4. The order cancel operation should guarantee the atomicity.

## Technology Stack

1. Spring Boot and Spring to develop the App quickly.
2. MySQL to store data.
3. Spring Security to auth the login status of user.
4. Thymeleaf for web page.

## Package Layering Of Code

- web   
  contains some configuration related to view controller and web.
- service   
  combination and execution of business logics, where transactions are used to ensure business atomicity.
- domain    
  model entities.
- dao    
  persistence layer, responsible for data persistence operations.