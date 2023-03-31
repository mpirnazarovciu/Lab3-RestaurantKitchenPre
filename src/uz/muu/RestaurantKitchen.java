package uz.muu;

import java.util.LinkedList;
import java.util.List;

public class RestaurantKitchen {

    List<Meal> mealList = new LinkedList<>();
    List<MealRecipe> mealRecipeList = new LinkedList<>();
    List<Product> productList = new LinkedList<>();

    public void addMeal(int id, String name, double price) {
        mealList.add(new Meal(id, name, price));
    }

    public double getPrice(int mealId) {
        for (Meal mr :
                mealList) {
            if (mr.getId()==mealId){
                return mr.getPrice();
            }
        }
        return -1.0;
    }

    public void addRecipe(int mealId, String productName, double amount) {
        mealRecipeList.add(new MealRecipe(mealId, productName, amount));
    }

    public boolean sell(int mealId) {
        return false;
    }

    public void refillProduct(String productName, int amount) {
        for (Product product :
                productList) {
            if (product.getProductName().equals(productName)){
                product.setAmount(product.getAmount() + amount);
                return;
            }
        }
        productList.add(new Product(productName, amount));
    }

    public boolean availableMeal(int mealID) {
        List<MealRecipe> mealRecipeCurrent = filterMealRecipeByMealID(mealID);
        for (MealRecipe mealRecipe :
                mealRecipeCurrent) {
            for (Product product :
                    productList) {
                if (mealRecipe.getProductName().equals(product.getProductName())){
                    if (product.getAmount() < mealRecipe.getAmount()){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private List<MealRecipe> filterMealRecipeByMealID(int mealID) {
        List<MealRecipe> mealRecipesNew = new LinkedList<>();

        for (MealRecipe mealRecipe:
             mealRecipeList) {
            if (mealRecipe.getMealID() == mealID){
                mealRecipesNew.add(mealRecipe);
            }
        }
        return mealRecipesNew;
    }

    public double availableProduct(String productName) {
        return -1;
    }

    public List<Meal> preparedMeal(){
        return null; }
}
