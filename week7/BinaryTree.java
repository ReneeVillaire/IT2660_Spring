public class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public boolean insert(Listing newListing) {
        TreeNodeWrapper parent = new TreeNodeWrapper();
        TreeNodeWrapper child = new TreeNodeWrapper();
        TreeNode newNode = new TreeNode();

        if(newNode == null)
            return false;
        else {
            newNode.node = newListing.deepCopy();
            newNode.leftChild = null;
            newNode.rightChild = null;

            if(root == null)
                root = newNode;
            else {
                findNode(newListing.getKey(), parent, child);

                if(newListing.getKey().compareTo(parent.get().node.getKey()) < 0)
                    parent.get().leftChild = newNode;
                else
                    parent.get().rightChild = newNode;
            }

            return true;
        }
    }

    public Listing fetch(String key) {
        TreeNodeWrapper parent = new TreeNodeWrapper();
        TreeNodeWrapper child = new TreeNodeWrapper();
        boolean found = findNode(key, parent, child);

        if(found)
            return child.get().node.deepCopy();
        else
            return null;
    }

    public boolean delete(String key) {
        TreeNodeWrapper parent = new TreeNodeWrapper();
        TreeNodeWrapper child = new TreeNodeWrapper();
        TreeNode largest;
        TreeNode nextLargest;
        boolean found = findNode(key, parent, child);

        if(!found)
            return false;
        else {
            if(child.get().leftChild == null && child.get().rightChild == null) {
                if(parent.get().leftChild == child.get())
                    parent.get().leftChild = null;
                else
                    parent.get().rightChild = null;
            }//Case 1 End
            else if(child.get().leftChild == null || child.get().rightChild == null) {
                if(parent.get().leftChild == child.get()) {
                    if(child.get().leftChild != null)
                        parent.get().leftChild = child.get().leftChild;
                    else
                        parent.get().leftChild = child.get().rightChild;
                }
                else {
                    if(child.get().leftChild != null)
                        parent.get().rightChild = child.get().leftChild;
                    else
                        parent.get().rightChild = child.get().rightChild;
                }
            }
            else {
                nextLargest = child.get().leftChild;
                largest = nextLargest.rightChild;

                if(largest != null) {
                    while(largest.rightChild != null) {
                        nextLargest = largest;
                        largest = largest.rightChild;
                    }

                    child.get().node = largest.node;
                    nextLargest.rightChild = largest.leftChild;
                }
                else {
                    nextLargest.rightChild = child.get().rightChild;

                    if(parent.get().leftChild == child.get())
                        parent.get().leftChild = nextLargest;
                    else
                        parent.get().rightChild = nextLargest;
                }
            }
            return true;
        }
    }

    public boolean update(String key, Listing newListing) {
        boolean updated = delete(key);

        if(updated)
            updated = insert(newListing);

        return updated;
    }

    public class TreeNode {
        private Listing node;
        private TreeNode leftChild;
        private TreeNode rightChild;

        public TreeNode() {}
    }

    private boolean findNode(String key, TreeNodeWrapper parent, TreeNodeWrapper child) {
        parent.set(root);
        child.set(root);

        if(root == null)
            return true;

        while(child.get() != null) {
            if(child.get().node.compareTo(key) == 0)
                return true;
            else {
                parent.set(child.get());

                if(key.compareTo(child.get().node.getKey()) < 0)
                    child.set(child.get().leftChild);
                else
                    child.set(child.get().rightChild);
            }
        }

        return false;
    }

    public class TreeNodeWrapper {
        TreeNode treeRef = null;

        public TreeNodeWrapper() {}
        public TreeNode get() { return treeRef; }
        public void set(TreeNode node) {treeRef = node; }
    }
}
