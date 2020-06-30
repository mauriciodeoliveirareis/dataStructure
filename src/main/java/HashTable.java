public class HashTable<TKey, TValue> {
    //TValue[] table = (TValue[]) new Object[4];
    TableNode<TKey, TValue>[] table = new TableNode[4];

    public int hash(TKey key) {
        if(key == null) throw new RuntimeException("null key was sent to hash function!");
        int hashValue = 0;
        for (char c : key.toString().toCharArray()) {
            hashValue += c;
        }
        return hashValue;
    }

    private int Index(TKey key) {
        return hash(key) % table.length;
    }


    public TValue getValue(TKey key) {
        TableNode<TKey, TValue> node = table[Index(key)];
        if (node == null) throw new RuntimeException("Key Not FoundException");
        return node.getValue(key);
    }

    public void setValue(TKey key, TValue value) {
        int calculatedIndex = Index(key);
        if(table[calculatedIndex] == null) {
            table[calculatedIndex] = new TableNode<>();
        }
        table[calculatedIndex].setValue(key, value);
    }

    private class TableNode<TKey, TValue> {
        private TKey key;
        private TValue value;
        private TableNode<TKey, TValue> next;

        public TValue getValue(TKey key) {
            if (this.key.equals(key)) return value;
            else if (this.next != null) return this.next.getValue(key);
            else throw new RuntimeException("Key Not Found");
        }

        public void setValue(TKey key, TValue value) {
            if (this.key == null) {
                this.key = key;
                this.value = value;
            } else {
                if (this.next == null) this.next = new TableNode<>();
                next.setValue(key,value);
            }
        }

        @Override
        public String toString() {
            String key = next != null && next.key != null ? next.key.toString() : "";
            //TValue value = next.value;
            return "TableNode{" +
                    "key=" + this.key +
                    ", value=" + this.value +
                    ", nextKey=" + key +
              //      ", nextValue=" + value +
                    '}';
        }
    }
}
