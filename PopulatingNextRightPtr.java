/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class PopulatingNextRightPtr {
    public Node connect(Node root) {
        
        if(root == null){
            return root;
        }
        
        // Start with the root node. There are no next pointers
        // that need to be set up on the first level
        Node leftMost = root;
        
        // Once we reach the final level, we are done
        while(leftMost.left != null){
            
            // Iterate the "linked list" starting from the head
            // node and using the next pointers, establish the 
            // corresponding links for the next level
            Node head = leftMost;
            
            while(head != null){
                
                //Connection 1:- If 2 neighboring nodes belong to same parent
                head.left.next = head.right;
                
                //Connection 2:- If 2 neighboring nodes belong to different parent
                //Parent has a neighbor then right node of parent will point to neighbors 
                if(head.next != null){
                    head.right.next = head.next.left;
                }
                
                head = head.next;
            }
            
            // Move onto the next level
            leftMost = leftMost.left;
        }
        
        return root;
        
    }
}
