public class MyArrayList<T extends Comparable<T>> {
    private Object[] elements;
    private int size;
    private static final int DefCapacity = 10;

    public MyArrayList() {
        elements = new Object[DefCapacity];
    }


    public void add(T data) {
        ensureCapacity(size + 1);
        elements[size++] = data;
    }


    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }


    public T remove(int index) {
        checkIndex(index);
        T oldValue = (T) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
        return oldValue;
    }


    public void addAll(MyArrayList<? extends T> collection) {
        for (int i = 0; i < collection.size(); i++) {
            add(collection.get(i));
        }
    }

    // Пузырьковая сортировка
    public void bubbleSort() {
        if (isSorted()) {
            System.out.println("Коллекция уже отсортирована.");
            return;
        }
        if (size <= 1) return;
        boolean swapped;
        do {
            swapped = false; // Сбрасываем флаг
            for (int i = 1; i < size; i++) {
                T first = (T) elements[i - 1];
                T second = (T) elements[i];
                if (first.compareTo(second) > 0) {
                    elements[i - 1] = second;
                    elements[i] = first;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    private boolean isSorted() {
        for (int i = 1; i < size; i++) {
            T first = (T) elements[i - 1];
            T second = (T) elements[i];
            if (first.compareTo(second) > 0) {
                return false;
            }
        }
        return true;
    }

    // Метод для проверки достаточной емкости массива
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = elements.length * 2;
            Object[] newElements = new Object[newCapacity];
            arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    // Проверка корректен ли индекс
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // Метод для копирования элементов массива
    private void arraycopy(Object[] src, int srcPos, Object[] dest, int destPos, int length) {
        for (int i = 0; i < length; i++) {
            dest[destPos + i] = src[srcPos + i];
        }
    }

    // Метод для получения размера списка
    public int size() {
        return size;
    }
}
