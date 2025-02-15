package FoodDeliverySystem;

import java.util.ArrayList;
import java.util.List;

enum FoodMenu {
    Veg,NonVeg,Desert;


}
class Food {
    String name;

    public Food(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
abstract class Menu {
    List<Food> foodList;
    Menu(List<Food> foodList) {
        this.foodList = foodList;
    }

    void addFood(Food food) {
        foodList.add(food);
    }
    List<Food> getMenuList() {
        return foodList;
    }

    abstract String getMenuName();
}
class Veg extends Menu {

    String menuName;
    Veg(List<Food> foodList) {
        super(foodList);
        this.menuName = String.valueOf(FoodMenu.Veg);
    }

    @Override
    String getMenuName() {
        return menuName;
    }
}
class NonVeg extends Menu {
    String menuName;
    NonVeg(List<Food> foodList) {
        super(foodList);
        this.menuName = String.valueOf(FoodMenu.NonVeg);
    }
    String getMenuName() {
        return menuName;
    }
}
class Deserts extends Menu {
    String menuName;
    Deserts(List<Food> foodList) {
        super(foodList);
        this.menuName = String.valueOf(FoodMenu.Desert);
    }

    String getMenuName() {
        return menuName;
    }
}
public class main {
    public static void main(String [] args) {
        Food dal = new Food("dal");
        Food chicken = new Food("chicken");
        Food iceCream = new Food("Ice Cream");
        List<Food> vegList = new ArrayList<>();
        List<Food> nonVegList = new ArrayList<>();
        List<Food> desertList = new ArrayList<>();
        vegList.add(dal);
        nonVegList.add(chicken);
        desertList.add(iceCream);
        Menu veg = new Veg(vegList);
        Menu nonVeg = new NonVeg(nonVegList);
        Menu desert = new Deserts(desertList);
        System.out.println(veg.getMenuList().get(0).getName());
        System.out.println(nonVeg.getMenuList().get(0).getName());
        System.out.println(desert.getMenuList().get(0).getName());
        Food mutton = new Food("Mutton");
        nonVeg.addFood(mutton);
        System.out.println(nonVeg.getMenuList().get(1).getName());
        System.out.println(veg.getMenuName());
    }
}
