package sort.heap;

import java.util.ArrayList;
import java.util.List;

public class BinaryMinHeap {

    private List<Integer> items = new ArrayList<>();

    public BinaryMinHeap() {
        // null을 넣어서 인덱스를 1부터 시작
        items.add(null);
    }

    public int size() {
        return items.size() - 1;
    }

    private void percolateUp() {
        int cur = size();
        int parent = cur / 2;

        while (parent > 0) {
            if (items.get(cur) < items.get(parent)) {
                swap(cur, parent);
            }
            cur = parent;
            parent = cur / 2;
        }
    }

    private void percolateDown(int cur) {
        int smallest = cur;
        int left = 2 * cur;
        int right = 2 * cur + 1;

        if (left <= size() && items.get(left) < items.get(smallest)) {
            smallest = left;
        }

        if (right <= size() && items.get(right) < items.get(smallest)) {
            smallest = right;
        }

        if (smallest != cur) {
            swap(cur, smallest);
            percolateDown(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = items.get(i);
        items.set(i, items.get(j));
        items.set(j, temp);
    }

    public void insert(int k) {
        items.add(k);
        percolateUp();
    }

    public Integer extract() {
        if (size() < 1) {
            return null;
        }

        int root = items.get(1);
        items.set(1,items.get(items.size()-1));
        items.remove(size());
        percolateDown(1);

        return root;
    }
}


