import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class DoubleLinkedListTest {

    @Test
    void getSizeEmpty() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        assertEquals(0 , doubleLinkedList.getSize());
    }

    @Test
    void addTailGetSize() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addTail(5);
        doubleLinkedList.addTail(12);
        doubleLinkedList.addTail(22);
        assertEquals(3, doubleLinkedList.getSize());
        assertEquals(5, doubleLinkedList.getAt(0));
        assertEquals(12, doubleLinkedList.getAt(1));
        assertEquals(22, doubleLinkedList.getAt(2));
    }



    @Test
    void addHeadGetSize() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addHead(5);
        doubleLinkedList.addHead(12);
        doubleLinkedList.addHead(22);
        assertEquals(3, doubleLinkedList.getSize());
        assertEquals(5, doubleLinkedList.getAt(2));
        assertEquals(12, doubleLinkedList.getAt(1));
        assertEquals(22, doubleLinkedList.getAt(0));
    }

    @Test
    void addHeadAndTailGetSize() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addHead(3);
        doubleLinkedList.addHead(2);
        doubleLinkedList.addTail(4);
        doubleLinkedList.addHead(1);
        assertEquals(4, doubleLinkedList.getSize());
        assertEquals(1, doubleLinkedList.getAt(0));
        assertEquals(2, doubleLinkedList.getAt(1));
        assertEquals(3, doubleLinkedList.getAt(2));
        assertEquals(4, doubleLinkedList.getAt(3));
    }

    @Test
    void addTailAndHeadGetSize() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addTail(3);
        doubleLinkedList.addHead(2);
        doubleLinkedList.addTail(4);
        doubleLinkedList.addHead(1);
        assertEquals(4, doubleLinkedList.getSize());
        assertEquals(1, doubleLinkedList.getAt(0));
        assertEquals(2, doubleLinkedList.getAt(1));
        assertEquals(3, doubleLinkedList.getAt(2));
        assertEquals(4, doubleLinkedList.getAt(3));
    }

}