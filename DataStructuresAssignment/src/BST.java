import java.util.ArrayList;
import java.util.List;

public class BST {

    // Private inner class representing each node in the tree
    private static class TreeNode {
        int node;              // Value of the node
        TreeNode left, right;  // Left and right child references

        // Constructor for TreeNode
        public TreeNode(int node){
            this.node = node;
            left = right = null;
        }
    }

    TreeNode root; // Root of the BST

    // Constructor for the BST
    public BST() {
        root = null; // Initialize the tree with an empty root
    }

    // Insert a new node in the tree
    public void insert(int node) {
        root = insertHelper(root, node); // Begin from root and update it
    }

    // Private recursive helper for insertion
    private TreeNode insertHelper(TreeNode current, int node) {
        if (current == null) {
            // If spot is empty, create and return a new node here
            return new TreeNode(node);
        }

        if (node < current.node) {
            // Value is less, go left
            current.left = insertHelper(current.left, node);
        } else if (node > current.node) {
            // Value is greater, go right
            current.right = insertHelper(current.right, node);
        }
        // Duplicate values are ignored (not inserted again)
        return current; // Return the unchanged or updated subtree
    }


    // Public method to search a value in the BST
    public boolean search(int node) {
        return searchHelper(root, node); // Call helper method recursively
    }

    // Private recursive method to perform search
    private boolean searchHelper(TreeNode root, int node) {
        if (root == null)  return false; // value not found

        if (root.node == node) return true; // Value found

        // Search left or right subtree based on value
        return node < root.node ? searchHelper(root.left, node) : searchHelper(root.right, node);
    }

    // Public method to initiate deletion
    public void delete(int node) {
        root = deleteHelper(root, node); // Begin from root and update it
    }

    // Private recursive helper for deletion
    private TreeNode deleteHelper(TreeNode current, int node) {
        if (current == null) {
            // Print to console "Node not found"
            System.out.println("Node not found");
            // Node not found, return null to indicate no change
            return null;
        }

        if (node < current.node) {
            // Value is in left subtree
            current.left = deleteHelper(current.left, node);
        } else if (node > current.node) {
            // Value is in right subtree
            current.right = deleteHelper(current.right, node);
        } else {
            // Node found — handle deletion

            // Case 1: No children (leaf node)
            if (current.left == null && current.right == null) {
                return null; // Remove node by returning null
            }

            // Case 2: One child (left or right)
            if (current.left == null) {
                return current.right; // Replace with right child
            } else if (current.right == null) {
                return current.left; // Replace with left child
            }

            // Case 3: Two children
            // Find the inorder successor (smallest value in right subtree)
            TreeNode successor = findMin(current.right);

            // Replace current node's value with successor's value
            current.node = successor.node;

            // Delete the successor node from the right subtree
            current.right = deleteHelper(current.right, successor.node);
        }

        return current; // Return the updated subtree
    }

    // Helper to find the smallest node in a subtree
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left; // Go as left as possible
        }
        return node;
    }

    // Traverses the tree and returns values based on the given order
    public List<Integer> traverse(String order) {
        switch (order.toLowerCase()){
            case "inorder":
                return inorder(root);   // Inorder traversal
            case "preorder":
                return preorder(root);  // Preorder traversal
            case "postorder":
                return postorder(root); // Postorder traversal
            default:
                System.out.println("Invalid traversal order.");
                return new ArrayList<>(); // Return empty list for invalid input
        }
    }

    // Inorder traversal: Left -> Node -> Right
    private List<Integer> inorder(TreeNode root){
        List<Integer> result = new ArrayList<>(); // Create result list
        if (root != null){
            result.addAll(inorder(root.left));    // Traverse left subtree
            result.add(root.node);                // Visit current node
            result.addAll(inorder(root.right));   // Traverse right subtree
        }
        return result;
    }

    // Preorder traversal: Node -> Left -> Right
    private List<Integer> preorder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if (root != null){
            result.add(root.node);                // Visit current node
            result.addAll(preorder(root.left));   // Traverse left subtree
            result.addAll(preorder(root.right));  // Traverse right subtree
        }
        return result;
    }

    // Postorder traversal: Left -> Right -> Node
    private List<Integer> postorder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if (root != null){
            result.addAll(postorder(root.left));  // Traverse left subtree
            result.addAll(postorder(root.right)); // Traverse right subtree
            result.add(root.node);                // Visit current node
        }
        return result;
    }

    public static void main(String[] args) {

        BST tree = new BST();  // Create an empty binary search tree

        // Insert test
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        tree.insert(70); // Duplicate, should be ignored



        System.out.println("Search 30: " + tree.search(30)); // Expected: true
        System.out.println("Search 100: " + tree.search(100)); // Expected: false



        // Inorder traversal
        System.out.println("Inorder: " + tree.traverse("inorder"));
        // Expected: [20, 30, 40, 50, 60, 70, 80]

        // Delete tests
        tree.delete(20);  // Case 1: Deleting leaf node
        System.out.println("After deleting 20 (leaf): " + tree.traverse("inorder"));
        // Expected: [30, 40, 50, 60, 70, 80]

        tree.delete(30);  // Case 2: Node with one child
        System.out.println("After deleting 30 (one child): " + tree.traverse("inorder"));
        // Expected: [40, 50, 60, 70, 80]

        tree.delete(70);  // Case 3: Node with two children
        System.out.println("After deleting 70 (two children): " + tree.traverse("inorder"));
        // Expected: [40, 50, 60, 80]

        // Invalid delete (node doesn't exist)
        tree.delete(100); // Should print "Node not found"
    }
}
