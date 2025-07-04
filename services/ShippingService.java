package services;

import java.util.ArrayList;
import java.util.List;
import interfaces.Shippable;

public class ShippingService {
    final static double costPerKg = 22.3;
    
    public static double ship(List<Shippable> items) {
        if (items.isEmpty()) return 0;
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        List<String> uniqueNames = new ArrayList<>();
        List<Integer> itemCounts = new ArrayList<>();

        for (Shippable item : items) {
            totalWeight += item.getWeight();
            String name = item.getName();
            int index = uniqueNames.indexOf(name);
            if (index == -1) {
                uniqueNames.add(name);
                itemCounts.add(1);
            } else {
                itemCounts.set(index, itemCounts.get(index) + 1);
            }
        }

        for (int i = 0; i < uniqueNames.size(); i++) {
            System.out.println(itemCounts.get(i) + "x " + uniqueNames.get(i));
        }

        System.out.printf("Total package weight %.1fkg\n", totalWeight);
        return totalWeight * costPerKg;
    }
}