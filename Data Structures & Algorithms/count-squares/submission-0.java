class CountSquares {
    private Map<List<Integer>, Integer> ptsCount;
    private List<List<Integer>> pts;

    public CountSquares() {
        ptsCount = new HashMap<>();
        pts = new ArrayList<>();
    }
    
    public void add(int[] point) {
        List<Integer> p = Arrays.asList(point[0], point[1]);
        ptsCount.put(p, ptsCount.getOrDefault(p, 0) + 1);
        pts.add(p);
    }
    
    public int count(int[] point) {
        int px = point[0], py = point[1];
        int res = 0;

        for(List<Integer> pt : pts) {
            int x = pt.get(0), y = pt.get(1);

            if(Math.abs(px - x) != Math.abs(py - y) || px == x || py == y) {
                continue;
            }

            res += ptsCount.getOrDefault(Arrays.asList(x, py), 0) *
            ptsCount.getOrDefault(Arrays.asList(px, y), 0);
        }
        return res;
    }
}
