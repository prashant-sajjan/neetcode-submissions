class Solution {
    private List<List<Integer>> adj = new ArrayList<>();
    private Map<Integer, String> state = new HashMap<>();
    private boolean cycleFound = false;
    private List<Integer> order = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
            state.put(i, "U");
        }

        for (int[] req : prerequisites) {
            int fromNode = req[1];
            int toNode = req[0];

            adj.get(fromNode).add(toNode);
        }

        for (int i = 0; i < numCourses; i++) {
            if (state.get(i).equals("U")) {
                dfs(i);
            }

            if (cycleFound) {
                return new int[0];
            }
        }

        Collections.reverse(order);

       /* int[] result = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            result[i] = order.get(i);
        }*/

        return order.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        //return result;
    }

    private void dfs(int node) {

        if (cycleFound) {
            return;
        }

        if (state.get(node).equals("U")) {
            state.put(node, "V");

            List<Integer> neighbors = adj.get(node);

            for (int nei : neighbors) {
                dfs(nei);

                if (cycleFound) {
                    return;
                }
            }

            state.put(node, "P");
            order.add(node);

        } else if (state.get(node).equals("V")) {
            cycleFound = true;
        }
    }
}
