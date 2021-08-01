package pl.ts.model;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<BasketPosition> basketPositions = new ArrayList<>();

    public Basket() {
    }

    public List<BasketPosition> getBasketPositions() {
        return basketPositions;
    }

    public void addOrder(Order order){
        BasketPosition basketPosition = new BasketPosition();
        basketPosition.setOrder(order);
        basketPosition.setPieces(1);

        this.basketPositions.add(basketPosition);
    }

    public class BasketPosition{
        private Order order;
        private int pieces;

        public BasketPosition() {
        }

        public BasketPosition(Order order, int pieces) {
            this.order = order;
            this.pieces = pieces;
        }

        public Order getOrder() {
            return order;
        }

        public void setOrder(Order order) {
            this.order = order;
        }

        public int getPieces() {
            return pieces;
        }

        public void setPieces(int pieces) {
            this.pieces = pieces;
        }
    }
}
