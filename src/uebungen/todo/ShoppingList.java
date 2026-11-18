package uebungen.todo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Iterable<Map.Entry<String,ShoppingItem>>
public class ShoppingList
        implements Iterable<ShoppingItem> {

    // Liste von ShoppingItem
    private Map<String, ShoppingItem> shoppingList;

    public ShoppingList() {
        shoppingList = new HashMap<>();
    }

    public void checkItem(String entry) {
        if(shoppingList.containsKey(entry)) {
            shoppingList.get(entry).setChecked();
        }
    }

    public void addItem(ShoppingItem item) {
        // Key => entry, Value => Shoppingitem
        shoppingList.put(item.getEntry() , item);
    }

    public Iterable<ShoppingItem> getList() {
        return shoppingList.values();
    }

    public  Iterable<Map.Entry<String, ShoppingItem>> getKeyValueList() {
        return shoppingList.entrySet();
    }

    @Override
    public Iterator<ShoppingItem> iterator() {
        return  shoppingList.values().iterator();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("*********** SHOPPINGLIST ****--\n");
        for(ShoppingItem item : shoppingList.values()) {
            sb.append(item.toString()).append("\n");
        }
        sb.append("**************************");
        return sb.toString();
    }

}
