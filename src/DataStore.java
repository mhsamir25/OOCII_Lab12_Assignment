import java.util.*;

/**
 * Generic DataStore Class - A flexible, reusable container for any object type
 * 
 * This class implements a generic data structure that can store and retrieve
 * objects of any type (T). It demonstrates:
 * - Type Safety: Enforces compile-time type checking
 * - Reusability: Works with any data type
 * - Encapsulation: Controls access to internal collection
 * 
 */

public class DataStore<T> {
    
    // Internal ArrayList to store objects of type T
    private ArrayList<T> store;
    
    /**
     * Constructor - Initializes an empty DataStore
     */
    public DataStore() {
        this.store = new ArrayList<>();
    }
    
    // ============ BASIC OPERATIONS ============
    
    /**
     * Adds an object to the data store
     * 
     * @param item The object of type T to be added
     * @return true if addition was successful
     */
    public boolean add(T item) {
        return store.add(item);
    }
    
    /**
     * Removes an object from the data store
     * 
     * @param item The object of type T to be removed
     * @return true if removal was successful
     */
    public boolean remove(T item) {
        return store.remove(item);
    }
    
    /**
     * Retrieves an object at a specific index
     * 
     * @param index The index position (0-based)
     * @return The object of type T at the specified index
     * @throws IndexOutOfBoundsException if index is out of range
     */
    public T get(int index) {
        return store.get(index);
    }
    
    /**
     * Returns the total number of items in the data store
     * 
     * @return The size of the store
     */
    public int size() {
        return store.size();
    }
    
    /**
     * Checks if the data store is empty
     * 
     * @return true if store contains no items, false otherwise
     */
    public boolean isEmpty() {
        return store.isEmpty();
    }
    
    /**
     * Clears all items from the data store
     */
    public void clear() {
        store.clear();
    }
    
    // ============ RETRIEVAL & SEARCH OPERATIONS ============
    
    /**
     * Returns all items in the data store as a List
     * 
     * @return A list containing all items of type T
     */
    public List<T> getAll() {
        return new ArrayList<>(store);
    }
    
    /**
     * Checks if a specific item exists in the data store
     * 
     * @param item The item to search for
     * @return true if item is found, false otherwise
     */
    public boolean contains(T item) {
        return store.contains(item);
    }
    
    /**
     * Finds the index of a specific item
     * 
     * @param item The item to search for
     * @return The index if found, -1 if not found
     */
    public int indexOf(T item) {
        return store.indexOf(item);
    }
    
    // ============ ITERATION SUPPORT ============
    
    /**
     * Returns an iterator for traversing all items in the data store
     * Allows for-each loop support
     * 
     * @return An Iterator of type T
     */
    public Iterator<T> iterator() {
        return store.iterator();
    }
    
    /**
     * Returns a string representation of all items in the data store
     * 
     * @return Formatted string of all items
     */
    @Override
    public String toString() {
        return "DataStore [items=" + store.size() + "]";
    }
}
