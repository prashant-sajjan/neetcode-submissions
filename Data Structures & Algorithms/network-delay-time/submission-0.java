class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : times) {
            int u = edge[0] - 1, v = edge[1] - 1, w = edge[2];
            graph.get(u).add(new int[]{v,w});
        }

        int[] distance = computeDistance(graph, k-1);

        int ma = Integer.MIN_VALUE;
        for(int d : distance) {
            ma = Math.max(ma, d);
        }

        return ma == Integer.MAX_VALUE ? -1 : ma;
    }

    private int[] computeDistance(List<List<int[]>> graph, int k) {
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] -b[1]);
        pq.offer(new int[]{k, 0});

        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int top = current[0];
            int currentDist = current[1];

            if(dist[top] > currentDist) {
                dist[top] = currentDist;

                for(int[] edge: graph.get(top)) {

                    int v = edge[0];
                    int w = edge[1];
                    if(dist[v] > currentDist + w) {
                        pq.offer(new int[] {v,  currentDist + w});
                    }
                }
            }
        }
        return dist;
    }

}
