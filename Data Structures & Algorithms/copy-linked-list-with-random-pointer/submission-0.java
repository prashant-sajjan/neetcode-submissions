/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToCopy = new HashMap<>();
        oldToCopy.put(null, null);

        Node cur = head;
        while(cur != null) {
            Node copy = getCopy(cur, oldToCopy);
            copy.next = getCopy(cur.next, oldToCopy);
            copy.random = getCopy(cur.random, oldToCopy);
            cur = cur.next;
        }
        return getCopy(head, oldToCopy);
    }

    private Node getCopy(Node node, Map<Node, Node> map) {
        if(node == null) {
            return null;
        }
        return map.computeIfAbsent(node, n -> new Node(n.val));
    }
}
