class SmallestInfiniteSet {
    private int curr;
    private TreeSet<Integer> added;

    public SmallestInfiniteSet() {
        curr = 1;
        added = new TreeSet<>();
    }
    
    public int popSmallest() {
        if (!added.isEmpty()) {
            int mn = added.first();
            added.remove(mn);
            return mn;
        }
        return curr++;
    }
    
    public void addBack(int num) {
        if (num < curr && !added.contains(num)) {
            added.add(num);
        }
    }
}
