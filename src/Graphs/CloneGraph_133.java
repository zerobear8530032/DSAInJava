package Graphs;

public class CloneGraph_133 {
    /*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
// approch :
//    create a hashmap mapping each original node to the copynode
//    then just go through each entry set and fill neighbours with hashmap
//    time complexity : O(E+V)
//    space complexity : O(N) // n is the number of nodes
    public Node cloneGraph(Node node) {
        HashMap<Node,Node> copyMap= new HashMap();
        copyNodeWithMapping(node,copyMap);
        for(Map.Entry<Node,Node> entry:copyMap.entrySet()){
            Node original = entry.getKey();
            Node copy = entry.getValue();
            List<Node> originalNeighbor = original.neighbors;
            List<Node> copyNeighbor = copy.neighbors;
            for(Node neighbour: originalNeighbor){
                copyNeighbor.add(copyMap.get(neighbour));
            }
            }
        }
        return copyMap.getOrDefault(node,null);
    }

    public void copyNodeWithMapping(Node node,HashMap<Node,Node> copyMap) {
        if (node == null) {
            return;
        }
        if (copyMap.containsKey(node)) {
            return;
        }
        List<Node> neighbors = node.neighbors;
        copyMap.put(node, new Node(node.val, new ArrayList()));
        for (Node neighbor : neighbors) {
            copyNodeWithMapping(neighbor, copyMap);
        }
    }

    public static void main(String[] args) {

    }
}
