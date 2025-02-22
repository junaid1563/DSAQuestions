import java.util.ArrayList;

// https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
class RandomizedCollection {
    private ArrayList<Integer> list;

    public RandomizedCollection() {
        this.list = new ArrayList<>();
    }

    public boolean insert(int val) {
        boolean present = true;
        if (list.contains(val)) {
            present = false;
        }
        list.add(val);
        return present;
    }

    public boolean remove(int val) {
        boolean present = false;
        if (list.contains(val)) {
            present = true;
            list.remove(list.indexOf(val));
        }
        return present;
    }

    public int getRandom() {
        int  idx = (int)(Math.random()*this.list.size());
        System.out.println("Random index = "+idx);
        return list.get(idx);
    }
}
