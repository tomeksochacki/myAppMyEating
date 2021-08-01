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
    private List<Order> orders = new ArrayList<>();

    public Database() {
        addresses.add(new Address(1, 11, 111, "Włodarzewska", "Ochota", "Warszawa"));
        addresses.add(new Address(2, 22, 222, "Wolska", "Wola", "Warszawa"));
        addresses.add(new Address(3, 33, 333, "Włodarzewska", "Ochota", "Warszawa"));
        addresses.add(new Address(4, 44, 444, "Zadumana", "Ochota", "Warszawa"));
        addresses.add(new Address(5, 55, 555, "Lirowa", "Ochota", "Warszawa"));
        addresses.add(new Address(6, 66, 666, "Przy Parku", "Ochota", "Warszawa"));

        restaurants.add(new Restaurant(1, "India express", addresses.get(0), "444555666", "indiaexpress@wp.pl"));
        restaurants.add(new Restaurant(2, "Tutto pizza", addresses.get(1), "111222333", "tuttopizza@wp.pl"));

        dishes.add(new Dish(1, Dish.Taste.SALTY));
        dishes.add(new Dish(2, Dish.Taste.SWEET));

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
            if (user.getLogin().equals(login) && user.getPassword().equals(DigestUtils.md5Hex(password))){
                return user;
            }
        }
        return null;
    }

   /* public void addOrder(User user, Address address){
        this.users.add(user);
        this.addresses.add(address);
    }*/

    public void addOrder(Order order){
        this.orders.add(order);
    }

    public List<Order> getOrdersForManufacturer(User user){
        List<Order> result = new ArrayList<>();
        for (Order order:this.orders){
            if (order.getUser().getRole().equals(user.getRole() == User.Role.CUSTOMER)){
                result.add(order);
            }
        }
        return result;
    }
    //TODO tu zmienić zrobić żeby był tylko jeden smak z order-a, a nie tak jak teraz z oredra i z dish-a
    public void addTasteToOrder(Order.Taste taste){

    }

}
