package pl.ts.validators;

import pl.ts.model.Address;
import pl.ts.model.User;

public class OrderValidator {
    public static boolean validate(User user, Address address) { //TODO dopisać metodę walidacji, w nagraniu była pisana od 0.59 minnuty, ale była pisana z jednym modelem a ja przyjmuje w dwuch modelach dane trzeba to zmienić jakoś może na model oorder????
        if (user.getName().equals("") ||
                user.getSurname().equals("") ||
                user.getPhoneNumber().equals("") ||
                address.getPlace().equals("") ||
                address.getDistrict().equals("") ||
                address.getStreet().equals("") ||
                address.getNumberHouse() <= 0 ||
                address.getNumberLocal() <= 0) {
            return false;
        }
        return true;
    }
}
