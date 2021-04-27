# Pizza

Let's represent pizza world. 

## Class Pizza

Firstly, we are going to create a `Pizza` class. A pizza contains a list of ingredients, that can be model like a list of strings. 

To create a pizza, we have to pass this list of ingredients in the constructor. 

We should have a getter to retrieve the list of ingredients of this pizza. 

We should also have a `toString` method that prints this list of ingredients. 

## Class Pizzeria

### Fields (State)

A pizzeria can cook pizzas. But...to cook those pizzas, you need ingredients. In this case, we are only modelling `tomato`, `mozzarella` and `ham`. 

For example:

- for a Pizza Margherita, we need a serve of tomato and another serve of mozzarella. 
- for a Pizza Bianca York, we need a serve of ham and another serve of mozzarella. 
- for a Pizza Formaggia, we need two serves of mozzarella. 


The number of serves available in the pizzeria for each ingredient can be modelled as an integer. Eg. 

```java
private int tomato = 5; We have five serves of tomato
```

At the beginning, the pizzeria has 0 serves for all kind of ingredientes. 

### Methods (Behaviour)

- Firstly, we should have getters for all the fields. 
- We should have methods to  _buy_ ingredients. For example:

```
pizzeria.buyTomato(2); //Adds two serves of tomato to the pizzeria.
```

- We should have three methods to cook pizza: `cookBianca`,... 
- Since we might not have enough serves for a Pizza, we should return `Optional<Pizza>` instead of `Pizza`.
- If we don't have enough ingredients, we should return `Optional.empty()` 
- If we do have enough ingredientes, we should decrease our serves and return the pizza. 

Eg. if in the Pizzeria we have tomato=2, mozzarella=3 and ham=1. If we cook a Bianca York, the Pizzeria should have tomato=2, mozzarella=2 and ham=0. 
