/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> curItems;
    Iterator<Integer> curItor;
    int curIndex;

    public NestedIterator(List<NestedInteger> nestedList) {
        curItems = new ArrayList<Integer>();
        for(NestedInteger ni : nestedList){
            if(ni.isInteger())
                curItems.add(ni.getInteger());
            else{
                addNestedInteger(ni.getList());
            }
        }
        curItor = curItems.iterator();
    }
    
    void addNestedInteger(List<NestedInteger> nestedList){
        for(NestedInteger ni : nestedList){
            if(ni.isInteger())
                curItems.add(ni.getInteger());
            else{
                addNestedInteger(ni.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return curItor.next();
    }

    @Override
    public boolean hasNext() {
        return curItor.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */