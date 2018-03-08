public class LRUCache {
    class DoubleLinkedListNode {
        int val, key;
        DoubleLinkedListNode pre, post;

        public DoubleLinkedListNode(int key, int value) {
            this.val = value;
            this.key = key;
        }
    }

    Map<Integer, LRUCache.DoubleLinkedListNode> table;
    DoubleLinkedListNode head, end;
    int capacity, len;

    public LRUCache(int capacity) {
        this.table = new HashMap<Integer, LRUCache.DoubleLinkedListNode>();
        this.capacity = capacity;
        this.len = 0;
    }

    public int get(int key) {
        if (!table.containsKey(key)) return -1;
        removeNode(table.get(key));
        setHead(table.get(key));
        return table.get(key).val;
    }

    public void put(int key, int value) {
        if (table.containsKey(key)) {
            DoubleLinkedListNode cur = table.get(key);
            cur.val = value;
            removeNode(cur);
            setHead(cur);
        } else {
            DoubleLinkedListNode cur = new DoubleLinkedListNode(key, value);
            if (len < capacity) {
                setHead(cur);
                table.put(key, cur);
                len++;
            } else {
                table.remove(end.key);
                end = end.pre;
                if (end != null)
                    end.post = null;
                setHead(cur);
                table.put(key, cur);
            }
        }
    }

    void removeNode(DoubleLinkedListNode node) {
        DoubleLinkedListNode cur = node, pre = cur.pre, post = cur.post;
        // Link to pre
        if (pre != null) {
            pre.post = post;
        } else {
            head = post;
        }
        // Link to post
        if (post != null) {
            post.pre = pre;
        } else {
            end = pre;
        }
    }

    void setHead(DoubleLinkedListNode node) {
        node.post = head;
        node.pre = null;
        if (head != null) head.pre = node; // check head
        if (end == null) end = node; // check end
        head = node;
    }
}
