class Solution {

    // 0 = unvisited
    // 1 = visiting
    // 2 = completed
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = buildGraph(numCourses, prerequisites);
        int[] state = new int[numCourses];

        for (int course = 0; course < numCourses; course++) {
            if (state[course] == 0 && hasCycle(course, graph, state)) {
                return false;
            }
        }

        return true;
    }

    private List<List<Integer>> buildGraph(
            int numCourses,
            int[][] prerequisites
    ) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);

        for (int course = 0; course < numCourses; course++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int requiredCourse = prerequisite[1];

            graph.get(requiredCourse).add(course);
        }

        return graph;
    }

    private boolean hasCycle(
            int course,
            List<List<Integer>> graph,
            int[] state
    ) {
        if (state[course] == 1) {
            return true;
        }

        if (state[course] == 2) {
            return false;
        }

        state[course] = 1;

        for (int nextCourse : graph.get(course)) {
            if (hasCycle(nextCourse, graph, state)) {
                return true;
            }
        }

        state[course] = 2;
        return false;
    }
}
