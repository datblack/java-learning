package datmt.learning.collection.linkedlist;

/**
 * Cấu trúc single linked List:
 * head: phần tử đầu tiên của list
 * tail: phần tử cuối cùng của list
 * node: các phần tử bên trong list
 *      data: dữ liệu của 1 node
 *      next: node tiếp theo
 * định nghĩa: linked list là một danh sách tuyến tính bao gồm các node
 * với mỗi node sẽ lưu trữ data và một địa chỉ cho node tiếp theo các node được
 * móc nối với nhau theo dạng tuyến tính.
 */
public class SingLinkList <T> {
    private Node head;
    private Node tail;
    private boolean empty;
    private class Node{
        public T data;
        private int index;
        public Node next;
        public Node(T data, Node next) {
            if (head == null) index = 0;
            else index = ++head.index;
            this.data = data;
            this.next = next;
        }
    }
    public SingLinkList(){
        empty = true;
    }
    public void printList(){
        Node temp = head;
        if (empty) System.out.println("List empty !");
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void add(T data) { // thêm vào đầu list
        Node node = new Node(data, null);
        if (head == null) { // khiểm tra nếu phần tử đầu tiên = null => list rỗng
            head = node;
            tail = node;
            empty = false;
        } else {
            node.next = head;
            head = node;
        }
    }
    public void addBefore(int index, T data) { // chèn vào trước phần tử
        Node newNode = new Node(data, null);
        Node nodeCurrent = findNoteByData(index);
        if (head == nodeCurrent) { // nếu node cần chèn là head
            head = newNode;
            newNode.next = nodeCurrent;
        } else { // tìm phần tử trước node cần chèn
            Node nodeBefore = findBefore(nodeCurrent);
            assert nodeBefore != null;// không tìm thấy thì node = null
            nodeBefore.next = newNode;// chèn next của node trước = new node
            newNode.next = nodeCurrent;// chèn next của newNode = node cần chèn
        }
    }
    public void addAfter(int index, T data) { // chèn vào sau phần tử
        Node newNode = new Node(data, null);
        Node nodeCurrent = findNoteByData(index);
        if (tail == nodeCurrent) { // nếu node cần chèn là tail
            tail = newNode;
            newNode.next = nodeCurrent;
        } else { // tìm phần tử trước node cần chèn
            Node nodeAfter = findAffter(nodeCurrent);
            assert nodeAfter != null;// không tìm thấy thì node = null
            assert nodeCurrent != null;
            nodeCurrent.next = newNode;// chèn next của node cần chèn = new node
            newNode.next = nodeAfter;// chèn next của node mới = node sau
        }
    }
    public void remove(int index){
        Node nodeToRemove = findNoteByData(index);
        if (head == nodeToRemove) head = head.next;
        else if (tail == nodeToRemove) tail = findBefore(tail);
        else {
            Node nodeBefore = findBefore(nodeToRemove);
            assert nodeBefore != null;
            nodeBefore.next = findAffter(nodeToRemove);
        }
    }

    private Node findAffter(Node nodeCurrent) {
        Node temp = head;
        while (temp != null) {
            assert nodeCurrent != null;
            if (nodeCurrent.next == temp) return temp;
            temp = temp.next;
        }
        return null;
    }

    private Node findNoteByData(int index) {
        Node temp = head;
        while (temp != null) {
            if (temp.index == index) return temp;
            temp = temp.next;
        }
        return null;
    }

    private Node findBefore(Node node) {
        Node temp = head;
        while (temp != null) {
            if (temp.next == node) return temp;
            temp = temp.next;
        }
        return null;
    }
}
