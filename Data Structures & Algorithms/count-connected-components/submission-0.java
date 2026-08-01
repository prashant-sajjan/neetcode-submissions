class Solution {
    public int countComponents(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n ; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();

        int count = 0;

        for(int i = 0; i < n; i++) {
            if(!visited.contains(i)) {
                count++;
                dfs(adj, visited, i, -1);
            }
        }

        return count;
    }

    private void dfs(List<List<Integer>> adj, Set<Integer> visited, int node, int parent) {
        visited.add(node);

        for(int neighbor: adj.get(node)) {
            if(neighbor == parent) {
                continue;
            }

            if(!visited.contains(neighbor)) {
                dfs(adj, visited, neighbor, node);
            }

        }
    }
}
