import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void hashFoo() {
        HashTable<String, String> stringStringHashTable = new HashTable<>();
        assertEquals( 324,stringStringHashTable.hash("foo"));
        assertEquals(324, stringStringHashTable.hash("oof"));
        assertEquals(324, stringStringHashTable.hash("ofo"));
    }

    @Test
    void hashSetAndGetValue() {
        HashTable<String, String> stringStringHashTable = new HashTable<>();
        String testKey = "foo";
        String testValue = "valueFoo";
        String testKey2 = "foo2";
        String testValue2 = "valueFoo2";
        String conflictTestKey = "oof";
        String conflictTestValue = "conflictValueFoo";

        stringStringHashTable.setValue(testKey, testValue);
        stringStringHashTable.setValue(testKey2, testValue2);
        stringStringHashTable.setValue(conflictTestKey, conflictTestValue);
        assertEquals(testValue, stringStringHashTable.getValue(testKey));
        assertEquals(testValue2, stringStringHashTable.getValue(testKey2));
        assertEquals(conflictTestValue, stringStringHashTable.getValue(conflictTestKey));
    }


}