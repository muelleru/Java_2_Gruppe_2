package uebungen.todo;

import java.util.ArrayList;

public class ToDoList {

    // Liste von ListItem

    private ArrayList<ListItem> itemsList;

    public ToDoList() {
        // Listen-Objekten
        itemsList = new ArrayList<>();

    }
    public void checkItem(String entry) {
        for(var item : itemsList) {
            if(item.getEntry().equals(entry)) {
                item.setChecked();
            }
        }
        // throws new
    }
    public void addItem(ListItem item) {
        itemsList.add(item); // Delegation
    }

}
