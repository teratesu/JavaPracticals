package block3.pract17.task2;

import block3.pract17.Student;

public class DoublyStudentList {
    private Node head;
    private Node tail;

    public DoublyStudentList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(Student student) {
        Node node = new Node(student);

        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    public Student get(int index) {
        Node current = head;
        int i = 0;

        while (current != null) {
            if (i == index) {
                return current.data;
            }
            current = current.next;
            i++;
        }

        return null;
    }

    public boolean remove(int index) {
        if (head == null) {
            return false;
        }

        Node current = head;
        int i = 0;

        while (current != null && i < index) {
            current = current.next;
            i++;
        }

        if (current == null) {
            return false;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }

        return true;
    }

    public void printAll() {
        if (isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }

        Node current = head;
        int number = 1;

        while (current != null) {
            System.out.println(number + ". " + current.data);
            current = current.next;
            number++;
        }
    }

    public void printReverse() {
        if (isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }

        Node current = tail;
        int number = 1;

        while (current != null) {
            System.out.println(number + ". " + current.data);
            current = current.prev;
            number++;
        }
    }

    public void clear() {
        head = null;
        tail = null;
    }
}
