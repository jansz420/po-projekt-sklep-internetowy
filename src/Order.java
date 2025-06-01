public class Order {
    private ShoppingCart cart = new ShoppingCart();
    private double deliveryPrice;
    private String status;
    private String customerName;
    private String customerSurname;
    private String customerEmail;
    private String customerPhoneNumber;
    private String customerAddress;

    public Order(ShoppingCart cart) {
        this.cart = cart;
        this.status ="Oczekujące";

    }

    /**
     * Oblicza cenę dostawy na podstawie wagi i rozmiarów
     * paczki(mała/średnia/duża/największa). Darmowa dostawa dla zamówień powyżej 400 zł
     * @return cena dostawy
     */
    public double getDeliveryPrice() {
        if (cart.sumUpPrices() > 500.0) {
            deliveryPrice = 0.0;
        }
        else {
            double weightInKg = cart.getTotalWeight() / 1000.0;
            double volume = cart.calculateTotalVolume();

            if (weightInKg <= 1.0 && volume <= 2000.0) {
                deliveryPrice = 7.0;
            } else if (weightInKg <= 5.0 && volume <= 10000.0) {
                deliveryPrice = 15.0;
            } else if (weightInKg <= 10.0 && volume <= 25000.0) {
                deliveryPrice = 25.0;
            } else {
                deliveryPrice = 40.0;
            }
        }
        return deliveryPrice;
    }

    /**
     *  Obliczanie całkowitego kosztu zamówienia (dostawa +
     * wartość koszyka)
     * @return cała wartość zamówienia
     */
    public double getUltimatePrice() {
        return cart.sumUpPrices()+ this.getDeliveryPrice();
    }

    public void changeStatus(String status) {
        this.status = status;
    }


    public String orderSummary() {
        String summary = this.cart.cartSummary();

        summary += "Cena Koszyka "+ this.cart.sumUpPrices()+" zł\nCena dostawy " + this.getDeliveryPrice()+" zł\nCena ostateczna " + this.getUltimatePrice()+" zł";
        return summary;
    }

}
