package datmt.learning.collection.linkedlist;

public class SingLinkListTest {
    public static void main(String[] args) {
        SingLinkList<Integer> list = new SingLinkList<>();
        list.printList();
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        System.out.println("List after add");
        list.printList();
        System.out.println("List after add");
        list.addAfter(2, 4);
        list.printList();
        System.out.println("List after add");
        list.addBefore(2, 5);
        list.printList();
        System.out.println("List after remove");
        list.remove(1);
        list.printList();

    }
}
