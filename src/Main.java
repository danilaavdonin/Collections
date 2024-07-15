public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(3);
        linkedList.add(1);
        linkedList.add(2);
        MyLinkedList<Integer> additionalList = new MyLinkedList<>();
        additionalList.add(5);
        additionalList.add(4);
        additionalList.add(6);
        linkedList.addAll(additionalList);
        System.out.println("MyLinkedList до сортировки:");
        for (int i : linkedList) {
            System.out.print(i + " ");
        }
        System.out.println();
        linkedList.bubbleSort();
        System.out.println("После сортировки:");
        for (int i : linkedList) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Элемент с индексом 2: " + linkedList.get(2));
        linkedList.remove(2);
        System.out.println("После удаления элемента с индексом 2:");
        for (int i : linkedList) {
            System.out.print(i + " ");
        }
        System.out.println();


        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        MyArrayList<Integer> additionalArrayList = new MyArrayList<>();
        additionalArrayList.add(4);
        additionalArrayList.add(5);
        additionalArrayList.add(6);
        arrayList.addAll(additionalArrayList);
        System.out.println("MyArrayList до сортировки:");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println();
        arrayList.bubbleSort();
        System.out.println("MyArrayList после сортировки:");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println();


        MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add("pineapple");
        stringList.add("tomato");
        stringList.add("corn");
        System.out.println("MyArrayList для строк до сортировки:");
        for (int i = 0; i < stringList.size(); i++) {
            System.out.print(stringList.get(i) + " ");
        }
        System.out.println();
        stringList.bubbleSort();
        System.out.println("MyArrayList для строк после сортировки:");
        for (int i = 0; i < stringList.size(); i++) {
            System.out.print(stringList.get(i) + " ");
        }
        System.out.println();
    }
}
