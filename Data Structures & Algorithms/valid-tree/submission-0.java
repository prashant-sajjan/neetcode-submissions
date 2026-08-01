class Solution {
    public boolean validTree(int n, int[][] edges) {

       List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();

        if(!dfs(adj, visited,0,-1)) {
            return false;
        }

        return visited.size() == n;
    }

    private boolean dfs(List<List<Integer>> adj, Set<Integer> visited, int node, int parent) {
        visited.add(node);

        for(int neighbor: adj.get(node)) {
            if(neighbor == parent) {
                continue;
            }

            if(visited.contains(neighbor)) {
                return false;
            }

            if(!dfs(adj, visited, neighbor, node)) {
                return false;
            }
        }
        return true;
    }

}
