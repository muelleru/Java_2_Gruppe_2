package uebungen.todo;

public class ListItem {
    // Felder

    private String entry;
    private Boolean checked;

    // Konstruktor
    public ListItem(String entry, boolean checked) {
        setEntry(entry); // this.entry = entry
        setChecked(checked); // this.checked = checked;
    }
    public ListItem(String entry) {
        this(entry,false);
    }
    // Getter/Setter

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public Boolean getChecked() {
        return checked;
    }

    public Boolean isChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
    public void setChecked() {
        this.checked = true;
    }
    public void setUnchecked() {
        this.checked = false;
    }

    // toString
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ListItem{");
        sb.append("entry='").append(entry).append('\'');
        sb.append(", checked=").append(checked);
        sb.append('}');
        return sb.toString();
    }
}
