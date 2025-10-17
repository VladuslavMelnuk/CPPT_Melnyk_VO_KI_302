package KI302.Melnyk.Lab6;

import java.util.ArrayList;
import java.util.List;

/**
 * A generic Dictionary class that stores key-value pairs.
 * The value type 'V' is constrained to be comparable to find the maximum value.
 *
 * @param <K> The type of the keys.
 * @param <V> The type of the values, must implement Comparable.
 *
 * @author Vladyslav Melnyk
 * @version 1.0
 */
public class Dictionary<K, V extends Comparable<V>> {

    private List<Pair<K, V>> entries;

    /**
     * Inner private class to represent a key-value pair.
     */
    private static class Pair<K, V> {
        K key;
        V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Key: " + key + ", Value: " + value.toString();
        }
    }

    /**
     * Default constructor. Initializes an empty dictionary.
     */
    public Dictionary() {
        this.entries = new ArrayList<>();
    }

    /**
     * Adds a new key-value pair to the dictionary.
     * @param key The key.
     * @param value The value.
     */
    public void add(K key, V value) {
        entries.add(new Pair<>(key, value));
        System.out.println("Added: " + value.toString());
    }

    /**
     * Removes a key-value pair by its key.
     * @param key The key of the entry to remove.
     */
    public void remove(K key) {
        entries.removeIf(pair -> pair.key.equals(key));
    }

    /**
     * Retrieves a value by its key.
     * @param key The key of the entry to retrieve.
     * @return The value associated with the key, or null if not found.
     */
    public V get(K key) {
        for (Pair<K, V> pair : entries) {
            if (pair.key.equals(key)) {
                return pair.value;
            }
        }
        return null;
    }

    /**
     * Finds the maximum value among all entries in the dictionary.
     * This method works because the value type 'V' is constrained to be Comparable.
     * @return The maximum value, or null if the dictionary is empty.
     */
    public V findMax() {
        if (entries.isEmpty()) {
            return null;
        }

        V max = entries.get(0).value;
        for (Pair<K, V> pair : entries) {
            if (pair.value.compareTo(max) > 0) {
                max = pair.value;
            }
        }
        return max;
    }

    /**
     * Displays all entries in the dictionary.
     */
    public void display() {
        System.out.println("--- Dictionary Contents ---");
        for (Pair<K, V> pair : entries) {
            System.out.println(pair);
        }
        System.out.println("-------------------------");
    }
}