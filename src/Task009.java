public class Task009 {

    public static class Heap{
        int[] heap;

        public Heap(int[] array) {
            this.heap = array;
        }

        public void sortHeap() {
            int n = this.heap.length;
            for (int i = n / 2 - 1; i >= 0; i--)
                heaping(n, i);
            for (int i = n - 1; i >= 0; i--) {
                int temp = this.heap[0];
                this.heap[0] = this.heap[i];
                this.heap[i] = temp;

                heaping(i, 0);
            }
        }

        private void heaping(int n, int i) {
            int root = i;
            int first = 2 * i + 1;
            int second = 2 * i + 2;

            if (first < n && this.heap[first] > this.heap[root])
                root = first;

            if (second < n && this.heap[second] > this.heap[root])
                root = second;

            if (root != i) {
                int swap = this.heap[i];
                this.heap[i] = this.heap[root];
                this.heap[root] = swap;

                heaping(n, root);
            }
        }

        public void print() {
            for (int element : this.heap) System.out.print(element + " ");
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[] array = {12, 1, 11, 200, 13, 57, 5, 6, -8, 7};

        Heap heap = new Heap(array);
        System.out.print("Оригинальный список: ");
        heap.print();
        heap.sortHeap();
        System.out.print("После HeapSort: ");
        heap.print();
    }
}