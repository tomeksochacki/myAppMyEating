package pl.ts.database;

import org.springframework.stereotype.Component;
import pl.ts.model.Address;
import pl.ts.model.Dish;
import pl.ts.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

@Component
public class Database {
    private List<Dish> dishes = new ArrayList<>();
    private List<Restaurant> restaurants = new ArrayList<>();
    private List<Address> addresses = new ArrayList<>();

    public Database(){
        addresses.add(new Address(1, 11, 111, "Włodarzewska", "Ochota", "Warszawa"));
        addresses.add(new Address(2, 22, 222, "Wolska", "Wola", "Warszawa"));

        restaurants.add(new Restaurant(1, "India express", addresses.get(0), "444555666", "indiaexpress@wp.pl"));
        restaurants.add(new Restaurant(2, "Tutto pizza", addresses.get(1), "111222333", "tuttopizza@wp.pl"));

        dishes.add(new Dish(1, Dish.Taste.SALTY, Dish.Status.ACCEPTED, restaurants.get(0), Dish.PriceRange.UP_TO_20_PLN));
        dishes.add(new Dish(2, Dish.Taste.SWEET, Dish.Status.ACCEPTED, restaurants.get(1), Dish.PriceRange.UP_TO_100_PLN));
    }

    public List<Dish> getDishes(){
        return this.dishes;
    }
}
