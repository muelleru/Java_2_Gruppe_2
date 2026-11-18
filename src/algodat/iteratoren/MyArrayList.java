package algodat.iteratoren;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

// <T extends Number > mit Einschränkung T muss von Number abgeleitet sein
public class MyArrayList<T> implements Iterable<T>{

    class MyArrayListIterator<T> implements Iterator<T> {
        private int itPos = 0;
        @Override
        public boolean hasNext() {
            return itPos < pos; // man kann auf die Felder von MyArrayList zugreifen
        }
        @Override
        public T next() {
            T elem = (T)array[itPos++];
            return elem;
            // return (T)array[itPos++];
        }
    }

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

    public T get(int index) {
        if(index >=0 && index < pos) {
            return (T)array[index];
        }
        return null;
        // throw new NoSuchElementException();
        // throw new IndexOutOfBoundsException();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator<T>();// IteratorObject
    }
}
