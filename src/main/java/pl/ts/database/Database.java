package pl.ts.database;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;
import pl.ts.model.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class Database {
    private List<Dish> dishes = new ArrayList<>();
    private List<Restaurant> restaurants = new ArrayList<>();
    private List<Address> addresses = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Wallet> wallets = new ArrayList<>();

    public Database() {
        addresses.add(new Address(1, 11, 111, "Włodarzewska", "Ochota", "Warszawa"));
        addresses.add(new Address(2, 22, 222, "Wolska", "Wola", "Warszawa"));
        addresses.add(new Address(3, 33, 333, "Włodarzewska", "Ochota", "Warszawa"));
        addresses.add(new Address(4, 44, 444, "Zadumana", "Ochota", "Warszawa"));
        addresses.add(new Address(5, 55, 555, "Lirowa", "Ochota", "Warszawa"));
        addresses.add(new Address(6, 66, 666, "Przy Parku", "Ochota", "Warszawa"));

        restaurants.add(new Restaurant(1, "India express", addresses.get(0), "444555666", "indiaexpress@wp.pl"));
        restaurants.add(new Restaurant(2, "Tutto pizza", addresses.get(1), "111222333", "tuttopizza@wp.pl"));

        dishes.add(new Dish(1, Dish.Taste.SALTY, Dish.Status.ACCEPTED, restaurants.get(0), Dish.PriceRange.UP_TO_20_PLN));
        dishes.add(new Dish(2, Dish.Taste.SWEET, Dish.Status.ACCEPTED, restaurants.get(1), Dish.PriceRange.UP_TO_100_PLN));

        wallets.add(new Wallet(1, true));

        users.add(new User(1, "admin", DigestUtils.md5Hex("admin"), "Tomek", "Sochacki", addresses.get(2), "444555666", User.Role.ADMIN, wallets.get(0)));
        users.add(new User(2, "customer", DigestUtils.md5Hex("customer"), "Domek", "Dochacki", addresses.get(3), "555666777", User.Role.CUSTOMER, wallets.get(0)));
        users.add(new User(3, "manufacturer", DigestUtils.md5Hex("manufacturer"), "Romek", "Rochacki", addresses.get(4), "666777888", User.Role.MANUFACTURER, wallets.get(0)));
        users.add(new User(4, "courier", DigestUtils.md5Hex("courier"), "Aomek", "Aochacki", addresses.get(5), "777888999", User.Role.COURIER, wallets.get(0)));

    }

    public List<Dish> getDishes() {
        return this.dishes;
    }

    public User authenticate(String login, String password) {
        for (User user : this.users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(DigestUtils.md5Hex(password))) ;
            return user;
        }
        return null;
    }

}
