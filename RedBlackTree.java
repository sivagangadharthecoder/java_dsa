class RedBlackTree {

    static final boolean RED = true;
    static final boolean BLACK = false;

    static class Node {
        int data;
        Node left, right, parent;
        boolean color;

        Node(int data) {
            this.data = data;
            this.color = RED;
        }
    }

    private Node root;

    // Left rotate
    private void rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != null)
            y.left.parent = x;

        y.parent = x.parent;
        if (x.parent == null)
            root = y;
        else if (x == x.parent.left)
            x.parent.left = y;
        else
            x.parent.right = y;

        y.left = x;
        x.parent = y;
    }

    // Right rotate
    private void rotateRight(Node y) {
        Node x = y.left;
        y.left = x.right;
        if (x.right != null)
            x.right.parent = y;

        x.parent = y.parent;
        if (y.parent == null)
            root = x;
        else if (y == y.parent.left)
            y.parent.left = x;
        else
            y.parent.right = x;

        x.right = y;
        y.parent = x;
    }

    // Fix insertion
    private void fixInsert(Node k) {
        Node parent, grandParent;

        while (k != root && k.parent.color == RED) {
            parent = k.parent;
            grandParent = parent.parent;

            if (parent == grandParent.left) {
                Node uncle = grandParent.right;
                if (uncle != null && uncle.color == RED) {
                    grandParent.color = RED;
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    k = grandParent;
                } else {
                    if (k == parent.right) {
                        k = parent;
                        rotateLeft(k);
                    }
                    parent.color = BLACK;
                    grandParent.color = RED;
                    rotateRight(grandParent);
                }
            } else {
                Node uncle = grandParent.left;
                if (uncle != null && uncle.color == RED) {
                    grandParent.color = RED;
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    k = grandParent;
                } else {
                    if (k == parent.left) {
                        k = parent;
                        rotateRight(k);
                    }
                    parent.color = BLACK;
                    grandParent.color = RED;
                    rotateLeft(grandParent);
                }
            }
        }

        root.color = BLACK;
    }

    // Insert a new node
    public void insert(int data) {
        Node newNode = new Node(data);
        Node temp = root, parent = null;

        while (temp != null) {
            parent = temp;
            if (newNode.data < temp.data)
                temp = temp.left;
            else
                temp = temp.right;
        }

        newNode.parent = parent;
        if (parent == null)
            root = newNode;
        else if (newNode.data < parent.data)
            parent.left = newNode;
        else
            parent.right = newNode;

        fixInsert(newNode);
    }

    // Transplant (used in deletion)
    private void transplant(Node u, Node v) {
        if (u.parent == null)
            root = v;
        else if (u == u.parent.left)
            u.parent.left = v;
        else
            u.parent.right = v;

        if (v != null)
            v.parent = u.parent;
    }

    // Find minimum in subtree
    private Node minimum(Node node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    // Fix deletion
    private void fixDelete(Node x) {
        while (x != root && getColor(x) == BLACK) {
            if (x == x.parent.left) {
                Node s = x.parent.right;
                if (getColor(s) == RED) {
                    s.color = BLACK;
                    x.parent.color = RED;
                    rotateLeft(x.parent);
                    s = x.parent.right;
                }

                if (getColor(s.left) == BLACK && getColor(s.right) == BLACK) {
                    s.color = RED;
                    x = x.parent;
                } else {
                    if (getColor(s.right) == BLACK) {
                        s.left.color = BLACK;
                        s.color = RED;
                        rotateRight(s);
                        s = x.parent.right;
                    }
                    s.color = x.parent.color;
                    x.parent.color = BLACK;
                    s.right.color = BLACK;
                    rotateLeft(x.parent);
                    x = root;
                }
            } else {
                Node s = x.parent.left;
                if (getColor(s) == RED) {
                    s.color = BLACK;
                    x.parent.color = RED;
                    rotateRight(x.parent);
                    s = x.parent.left;
                }

                if (getColor(s.left) == BLACK && getColor(s.right) == BLACK) {
                    s.color = RED;
                    x = x.parent;
                } else {
                    if (getColor(s.left) == BLACK) {
                        s.right.color = BLACK;
                        s.color = RED;
                        rotateLeft(s);
                        s = x.parent.left;
                    }

                    s.color = x.parent.color;
                    x.parent.color = BLACK;
                    s.left.color = BLACK;
                    rotateRight(x.parent);
                    x = root;
                }
            }
        }
        if (x != null)
            x.color = BLACK;
    }

    private boolean getColor(Node node) {
        return node == null ? BLACK : node.color;
    }

    // Delete a node
    public void delete(int key) {
        Node z = root, x, y;
        while (z != null) {
            if (z.data == key)
                break;
            else if (key < z.data)
                z = z.left;
            else
                z = z.right;
        }

        if (z == null)
            return;

        y = z;
        boolean yOriginalColor = y.color;
        if (z.left == null) {
            x = z.right;
            transplant(z, z.right);
        } else if (z.right == null) {
            x = z.left;
            transplant(z, z.left);
        } else {
            y = minimum(z.right);
            yOriginalColor = y.color;
            x = y.right;
            if (y.parent == z) {
                if (x != null)
                    x.parent = y;
            } else {
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }

        if (yOriginalColor == BLACK && x != null)
            fixDelete(x);
    }

    // In-order traversal
    public void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    public void printTree() {
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
    }

    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();
        int[] nums = { 10, 20, 30, 15, 25, 5 };

        for (int num : nums)
            rbt.insert(num);

        rbt.printTree();

        rbt.delete(20);
        rbt.printTree();
    }
}
