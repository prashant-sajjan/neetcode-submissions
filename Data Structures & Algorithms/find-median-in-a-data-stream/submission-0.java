class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if(maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.isEmpty()) {
            throw new IllegalStateException("No elements to find median");
        }

        if(maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        
        return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
    }
}
