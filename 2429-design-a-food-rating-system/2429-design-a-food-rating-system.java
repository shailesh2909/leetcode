import java.util.*;

class FoodRatings {

    private Map<String, Food> foodMap;
    private Map<String, TreeSet<Food>> cuisineMap;

    private static class Food {
        String name;
        String cuisine;
        int rating;

        Food(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodMap = new HashMap<>();
        cuisineMap = new HashMap<>();
        for (int i = 0; i < foods.length; i++) {
            Food food = new Food(foods[i], cuisines[i], ratings[i]);
            foodMap.put(foods[i], food);
            cuisineMap.putIfAbsent(cuisines[i], new TreeSet<>((a, b) -> {
                if (b.rating != a.rating) return b.rating - a.rating;
                return a.name.compareTo(b.name);
            }));
            cuisineMap.get(cuisines[i]).add(food);
        }
    }

    public void changeRating(String foodName, int newRating) {
        Food food = foodMap.get(foodName);
        TreeSet<Food> set = cuisineMap.get(food.cuisine);
        set.remove(food);
        food.rating = newRating;
        set.add(food);
    }

    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).first().name;
    }
}
