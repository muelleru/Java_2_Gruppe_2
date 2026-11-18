package algodat.iteratoren;

import java.util.Arrays;

// <T extends Number > mit Einschränkung T muss von Number abgeleitet sein
public class MyArrayList<T> {

    // private T[] array;
    private Object[] array;
    private int size; // Aktuelle Groesse des array
    private int pos; // Erste freie Position im array

    public MyArrayList() {
        pos= 0;
        size = 10;
        //array = new T[size];
        array = new Object[size];
    }
    public void add(T item) {
        // item an der ersten freien Stelle einfügen (falls es Platz hat)
        // wenn das array zu klein ist => array verdoppeln und dann einfügen
        if(pos >= size) {
            // Neues Array ...
            Object newArray[] = Arrays.copyOf(array,size*2);
            array = newArray; // Altes durch Neues ersetzen
            size*=2;
        }
        array[pos] = item;
        pos++;
    }
    public void remove(int index) {
        if(index<0 || index >= pos) {
            return;
        }
        // array[index] = null;
        for(int i = index; i < pos-1 && i+1 < size; i++) {
            //if(i+1 < size) {
                array[i] = array[i + 1];
            //}
        }
        array[pos-1] = null;
        pos--;
    }
    public void remove(T item) {
        int index = indexOf(item);
        if(index != -1) {
            remove(index);
        }
    }

    public int indexOf(T item) {
        for(int i = 0; i<pos;i++) {
            if(array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public T get(int pos) {

    }
}
