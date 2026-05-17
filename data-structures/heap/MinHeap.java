public class MinHeap {
    private int capacity;
    private int size;
    private int[] heap;

    public MinHeap(int capacity)
    {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    private int getParentIndex(int pos) { return (pos - 1) / 2; }
    private int getLeftChildIndex(int pos) { return (2 * pos) + 1; }
    private int getRightChildIndex(int pos) { return (2 * pos) + 2; }

    private boolean hasParent(int pos) { return getParentIndex(pos) >= 0; }
    private boolean hasLeftChild(int pos) { return getLeftChildIndex(pos) < size; }
    private boolean hasRightChild(int pos) { return getRightChildIndex(pos) < size; }

    private int parent(int pos) { return heap[getParentIndex(pos)]; }
    private int leftChild(int pos) { return heap[getLeftChildIndex(pos)]; }
    private int rightChild(int pos) { return heap[getRightChildIndex(pos)]; }

    private void swap(int pos1, int pos2)
    {
        int temp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temp;
    }

    private void ensureExtraCapacity()
    {
        if (size == capacity)
        {
            int[] newHeap = new int[capacity * 2];
            System.arraycopy(heap, 0, newHeap, 0, capacity);
            heap = newHeap;
            capacity *= 2;
        }
    }

    public int peek()
    {
        if (size == 0) throw new IllegalStateException();
        return heap[0];
    }

    public int poll()
    {
        if (size == 0) throw new IllegalStateException();
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
        return min;
    }

    public void add(int item)
    {
        ensureExtraCapacity();
        heap[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp()
    {
        int index = size - 1;
        while (hasParent(index) && parent(index) > heap[index])
        {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown()
    {
        int index = 0;
        while (hasLeftChild(index))
        {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index))
            {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (heap[index] < heap[smallerChildIndex])
            {
                break;
            }
            else
            {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }
}
