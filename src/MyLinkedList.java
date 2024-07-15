import java.util.Iterator;
import java.util.NoSuchElementException;

// Класс c параметром типа T для реализации интерфейса Comparable
public class MyLinkedList<T extends Comparable<T>> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // Вложенный статический класс Node представляющий узел связного списка
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    // Метод для добавления элемента в конец списка
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Метод для получения элемента по индексу
    public T get(int index) {
        checkIndex(index);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Метод для удаления элемента по индексу
    public T remove(int index) {
        checkIndex(index);
        Node<T> current = head;
        Node<T> previous = null;
        for (int i = 0; i < index; i++) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            head = head.next;
        } else {
            previous.next = current.next;
        }
        if (current.next == null) {
            tail = previous;
        }
        size--; //
        return current.data;
    }

    // Метод для добавления всех элементов из другой коллекции
    public void addAll(MyLinkedList<? extends T> collection) {
        for (T item : collection) {
            add(item);
        }
    }

    // Пузырьковая сортировка
    public void bubbleSort() {
        if (size <= 1) return;
        if (isSorted()) {
            System.out.println("Коллекция уже отсортирована.");
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            Node<T> current = head;
            while (current != null && current.next != null) {
                if (current.data.compareTo(current.next.data) > 0) {
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    private boolean isSorted() {
        if (head == null) return true;
        Node<T> current = head;
        while (current.next != null) {
            if (current.data.compareTo(current.next.data) > 0) {
                return false;
            }
            current = current.next;
        }
        return true;
    }

    // Проверка корректен ли индекс
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // Реализация интерфейса Iterable
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    // Метод для получения размера списка
    public int size() {
        return size;
    }
}
