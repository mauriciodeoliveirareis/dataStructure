public class DoubleLinkedList {

    private int size = 0;
    //private int[] nodes = new int[2];
    //private DoubleLinkedListNode[] nodes = new DoubleLinkedListNode[2];
    private DoubleLinkedListNode head;
    private DoubleLinkedListNode tail;

    public int getSize(){
        return size;
    }


    public void addHead(int nodeValue) {
        DoubleLinkedListNode newHead = createHead(nodeValue, this.head);
        if (head != null) head.setPrevious(newHead);
        if(size == 1) tail = head;
        this.head = newHead;
        if(size == 0) {
            tail = createTail(nodeValue, this.head);
            this.head.setNext(tail);
        }
        size++;
    }

    private DoubleLinkedListNode createHead(int nodeValue, DoubleLinkedListNode nextNode) {
        return new DoubleLinkedListNode(nextNode, null, nodeValue);
    }

    public void addTail(int nodeValue) {
        DoubleLinkedListNode newTail = createTail(nodeValue, tail);
        if(tail != null) tail.setNext(newTail);
        if(size == 1) head = tail;
        tail = newTail;
        if(size == 0) {
            head = createHead(nodeValue, tail);
            tail.setPrevious(head);
        }

        size++;
    }

    private DoubleLinkedListNode createTail(int nodeValue,  DoubleLinkedListNode previousNode) {
        return new DoubleLinkedListNode(null, previousNode, nodeValue);
    }


    public int getAt(int nodeIndex) {
        if (nodeIndex == 0) {
            return head.getValue();
        }
        DoubleLinkedListNode currentNode = head.next;
        for (int i = 1; i < nodeIndex; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getValue();
    }

    private class DoubleLinkedListNode {
        private DoubleLinkedListNode next;
        private DoubleLinkedListNode previous;
        private int value;

        public DoubleLinkedListNode(DoubleLinkedListNode next, DoubleLinkedListNode previous, int value) {
            this.next = next;
            this.previous = previous;
            this.value = value;
        }

        public DoubleLinkedListNode getNext() {
            return next;
        }

        public void setNext(DoubleLinkedListNode next) {
            this.next = next;
        }

        public DoubleLinkedListNode getPrevious() {
            return previous;
        }

        public void setPrevious(DoubleLinkedListNode previous) {
            this.previous = previous;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            Integer value = next != null ? next.getValue() : null;
            Integer previousValue = previous != null ? previous.getValue() : null;
            return "DoubleLinkedListNode{" +
                    "next=" + value +
                    ", previous=" + previousValue +
                    ", value=" + this.value +
                    '}';
        }
    }
}
