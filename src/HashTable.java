import java.util.ArrayList;

public class HashTable<K, V> {
    class Entry {
        final K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int DEFAULT_CAPACITY = 10;
    private ArrayList<ArrayList<Entry>> buckets = new ArrayList<ArrayList<Entry>>(DEFAULT_CAPACITY);

    // TODO: Keep track of the load factor and increase the number of buckets
    // when the load factor exceeds a certain threshold

    // TODO: Keep statistics on the number of collisions and the longest chain.

    HashTable() {
        // TODO: Is there a more efficient way to initialize the buckets sto null?
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            buckets.add(null);
        }
    }

    int hash(K key) {
        // TODO: Should we apply some more complex hash function to the result
        // of hashCode()?
        return key.hashCode() % buckets.size();
    }

    public void insert(K key, V value) {
        int index = hash(key);
        ArrayList<Entry> chain = buckets.get(index);
        if (chain == null) {
            chain = new ArrayList<Entry>();
            buckets.set(index, chain);
        }
        // Replace an existing entry.
        for (var e : chain) {
            if (e.key.equals(key)) {
                e.value = value;
                return;
            }
        }
        // No existing entry, make a new one.
        chain.add(new Entry(key, value));
    }

    public void delete(K key) throws Exception {
        int index = hash(key);
        ArrayList<Entry> chain = buckets.get(index);
        if (chain == null) {
            throw new Exception("Key not found");
        }
        for (var e : chain) {
            if (e.key.equals(key)) {
                // Modification is safe because we stop iterating and return.
                chain.remove(e);
                return;
            }
        }

        throw new Exception("Key not found");
    }

    public V lookup(K key) throws Exception {
        int index = hash(key);
        ArrayList<Entry> chain = buckets.get(index);
        if (chain == null) {
            throw new Exception("Key not found");
        }
        for (var e : chain) {
            if (e.key.equals(key)) {
                // Safe because we immediately stop iterating and return
                return e.value;
            }
        }

        throw new Exception("Key not found");
    }
}