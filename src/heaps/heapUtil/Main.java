package heaps.heapUtil;

public class Main {

    public static void main(String[] args) {
         MinHeap heap = new MinHeap();
         heap.insert(23);
         heap.insert(24);
         heap.insert(26);
         heap.insert(22);
         heap.insert(21);

         System.out.println(heap.remove());
    }
}
