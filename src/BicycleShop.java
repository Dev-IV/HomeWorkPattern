import java.util.*;
import java.util.stream.Collectors;

public class BicycleShop {
    private final Map<String, Product> products = new HashMap<>();
    private static BicycleShop INSTANCE = null;

    public static BicycleShop getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BicycleShop();
        }
        return INSTANCE;
    }

    private BicycleShop() {
    }

    public void initProducts() {
        products.put("Bp068", new Product("Подшипник", 16));
        products.put("Bs084", new Product("Спица", 180));
        products.put("Bk113", new Product("Колесо", 30));
        products.put("Bt698", new Product("Тормоза", 54));
        products.put("Bt997", new Product("Тросс", 8));
        products.put("Br006", new Product("Рама", 4));
        products.put("Bs075", new Product("Шина", 12));
        products.put("Ba106", new Product("Амортизотор", 3));
        products.put("Bp305", new Product("Педаль", 91));
        products.put("Bс066", new Product("Цепь", 19));
    }

    public Map<String, Product> getProducts() {
        return products;
    }

    public Product getProduct(String id) {
        return products.get(id);
    }

    public void print() {
        Map<String, Product> temp = products.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors
                        .toMap(Map.Entry::getKey,
                                Map.Entry::getValue,
                                (t1, t2) -> t1, LinkedHashMap::new));
        temp.forEach((k, v) -> System.out.println("Артикул " + k + v));
    }

}
