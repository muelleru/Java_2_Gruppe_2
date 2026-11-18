package uebungen.todo;

public class ShoppingItem extends ListItem {
    // Felder
    private int amount;

    // Konstruktor

    public ShoppingItem(String entry, int amount) {
        super(entry); // checked als Standard
        this.amount = amount;
    }

    // Getter/Setter


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ShoppingItem{");
        sb.append("amount=").append(amount);
        sb.append(", entry='").append(getEntry()).append('\'');
        sb.append(", checked=").append(isChecked());
        sb.append('}');
        return sb.toString();
    }

}

