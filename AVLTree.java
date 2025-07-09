import java.util.*;

public class AVLTree {

    // TreeNode class representing each node of the AVL Tree
    static class TreeNode {
        String data;
        TreeNode left, right;
        int height;

        TreeNode(String data) {
            this.data = data;
            this.height = 1;
        }
    }

    // Get height of node
    public static int getHeight(TreeNode node) {
        return node == null ? 0 : node.height;
    }

    // Get balance factor
    public static int getBalance(TreeNode node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    // Right rotation
    public static TreeNode rightRotate(TreeNode y) {
        System.out.println("Rotate right on node " + y.data);
        TreeNode x = y.left;
        TreeNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));

        return x;
    }

    // Left rotation
    public static TreeNode leftRotate(TreeNode x) {
        System.out.println("Rotate left on node " + x.data);
        TreeNode y = x.right;
        TreeNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));

        return y;
    }

    // Insert a node
    public static TreeNode insert(TreeNode node, String data) {
        if (node == null)
            return new TreeNode(data);

        if (data.compareTo(node.data) < 0)
            node.left = insert(node.left, data);
        else if (data.compareTo(node.data) > 0)
            node.right = insert(node.right, data);
        else
            return node; // No duplicates

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);

        // Balancing cases
        if (balance > 1 && data.compareTo(node.left.data) < 0)
            return rightRotate(node);

        if (balance > 1 && data.compareTo(node.left.data) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && data.compareTo(node.right.data) > 0)
            return leftRotate(node);

        if (balance < -1 && data.compareTo(node.right.data) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Find the node with minimum value (used for delete)
    public static TreeNode minValueNode(TreeNode node) {
        TreeNode current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    // Delete a node
    public static TreeNode delete(TreeNode root, String data) {
        if (root == null)
            return root;

        if (data.compareTo(root.data) < 0)
            root.left = delete(root.left, data);
        else if (data.compareTo(root.data) > 0)
            root.right = delete(root.right, data);
        else {
            // Node with one or no child
            if (root.left == null || root.right == null) {
                TreeNode temp = (root.left != null) ? root.left : root.right;

                if (temp == null)
                    return null;
                else
                    return temp;
            }

            // Node with two children: Get inorder successor (smallest in right subtree)
            TreeNode temp = minValueNode(root.right);
            root.data = temp.data;
            root.right = delete(root.right, temp.data);
        }

        // Update height and balance
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        int balance = getBalance(root);

        // Rebalance tree
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // Inorder traversal
    public static void inOrderTraversal(TreeNode node, List<String> result) {
        if (node == null)
            return;
        inOrderTraversal(node.left, result);
        result.add(node.data);
        inOrderTraversal(node.right, result);
    }

    // Main method
    public static void main(String[] args) {
        TreeNode root = null;

        String[] letters = { "C", "B", "E", "A", "D", "H", "G", "F" };
        for (String letter : letters)
            root = insert(root, letter);

        List<String> result = new ArrayList<>();
        inOrderTraversal(root, result);
        System.out.println("InOrder after insertion: " + String.join("-> ", result));

        // Now delete some nodes
        root = delete(root, "E");
        root = delete(root, "F");

        result.clear();
        inOrderTraversal(root, result);
        System.out.println("InOrder after deletion: " + String.join("-> ", result));
    }
}
