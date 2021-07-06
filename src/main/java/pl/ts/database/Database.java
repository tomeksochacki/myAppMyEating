package pl.ts.database;

import org.springframework.stereotype.Component;
import pl.ts.model.Address;
import pl.ts.model.Dish;
import pl.ts.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

@Component
public class Database {
    List<Dish> dishes = new ArrayList<>();
    List<Restaurant> restaurants = new ArrayList<>();
    List<Address> addresses = new ArrayList<>();

    public Database(){
        dishes.add(new Dish(1, Dish.Taste.SALTY, Dish.Status.ACCEPTED, restaurants.get(0), Dish.PriceRange.UP_TO_20_PLN));
        dishes.add(new Dish(2, Dish.Taste.SWEET, Dish.Status.ACCEPTED, restaurants.get(1), Dish.PriceRange.UP_TO_100_PLN));

        restaurants.add(new Restaurant(1, "Tutto pizza", addresses.get(0), "111222333", "tuttopizza@wp.pl"));
        restaurants.add(new Restaurant(1, "India express", addresses.get(1), "444555666", "indiaexpress@wp.pl"));

        addresses.add(new Address(1, 11, 111, "Włodarzewska", "Ochota", "Warszawa"));
        addresses.add(new Address(2, 22, 222, "Wolska", "Wola", "Warszawa"));
    }
}
