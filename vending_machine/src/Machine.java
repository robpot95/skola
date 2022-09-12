import java.util.ArrayList;

public class Machine {
    private ArrayList<Product> machine = new ArrayList<Product>();
    private int money = 0;

    public Boolean addProduct(String name, int price) {
        machine.add(new Product(name, price));
        return true;
    }

    public Boolean addMoney(int amount) {
        this.money = amount;
        return true;
    }

    public Boolean buyProduct(String name) {
        final Product product = findProductByName(name);
        if (findProductByName(name) != null) {
            if (money > product.getPrice()) {
                money -= product.getPrice();
                return true;
            } else {
                System.out.println("Du har inte råd med denna produkt.");
            }
        } else {
            System.out.println("Kunde inte hitta produkten.");
        }
        


        return false;
    }

    private Product findProductByName(String name) {
        for (Product product : machine) {
            if (name.equals(product.getName())) {
                return product;
            }
        }

        return null;
    }
    
    public ArrayList<Product> getProducts() {
        return machine;
    }

    public int getMoney() {
        return this.money;
    }

    public void showProducts() {
        for (Product product : machine) {
            System.out.println("Namn: %s - Pris: %d kr".formatted(product.getName(), product.getPrice()));
        }
    }
}
