package uebungen.todo;

import global.Workable;

public class ToDoTest implements Workable {

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void doWork() {
        ShoppingList meineListe = new ShoppingList();

        meineListe.addItem(new ShoppingItem("Apfel",3));
        meineListe.addItem(new ShoppingItem("Birnen",1));
        meineListe.addItem(new ShoppingItem("Toastbrot",2));
        meineListe.addItem(new ShoppingItem("Birnenbaum",2));

        System.out.println("*****************");
        for(ShoppingItem item : meineListe.getList()) {
            System.out.println(item);
        }

        System.out.println("*****************");
        for(var kvp : meineListe.getKeyValueList()) {
            System.out.println(kvp.getKey() +
                    ": " + kvp.getValue());

        }

        meineListe.checkItem("Birnen");

        System.out.println("*****************");
        for(ShoppingItem item : meineListe) {
            System.out.println(item);
        }

        System.out.println(meineListe);

    }
}
