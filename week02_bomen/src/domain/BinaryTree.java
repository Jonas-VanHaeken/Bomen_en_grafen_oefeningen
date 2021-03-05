package domain;

public class BinaryTree<E> {
    private E data;
    private BinaryTree<E> leftTree, rightTree;

    public BinaryTree(E data) {
        this(data, null, null);
    }

    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        this.data = data;
        this.leftTree = leftTree;
        this.rightTree = rightTree;
    }

    public void printPreorder() {
        System.out.print(this.data + " ");
        if (this.leftTree != null) this.leftTree.printPreorder();
        if (this.rightTree != null) this.rightTree.printPreorder();
    }

    public void printInorder() {
        if (this.leftTree != null) this.leftTree.printInorder();
        System.out.print(this.data + " ");
        if (this.rightTree != null) this.rightTree.printInorder();
    }

    public void printPostorder() {
        if (this.leftTree != null) this.leftTree.printPostorder();
        if (this.rightTree != null) this.rightTree.printPostorder();
        System.out.print(this.data + " ");
    }

    public int countNodes() {
        int count = 1;
        if (this.leftTree != null) {
            count += this.leftTree.countNodes();
        }
        if (this.rightTree != null) {
            count += this.rightTree.countNodes();
        }
        return count;
    }

    public int getDepth() {
        int count = 1;
        if (this.leftTree != null && this.rightTree != null) {
            count += Math.max(this.leftTree.getDepth(), this.rightTree.getDepth());
        } else if (this.leftTree != null) {
            count += this.leftTree.getDepth();
        } else if (this.rightTree != null) {
            count += this.rightTree.getDepth();
        }
        return count;
    }

    public boolean isLeaf() {
        if (this.leftTree != null && this.rightTree != null) {
            return false;
        }
        return true;
    }

    public int countLeaves() {
        int count = 0;
        if (this.leftTree == null && this.rightTree == null) {
            count += 1;
        } else {
            if (this.leftTree != null) {
                count += this.leftTree.countLeaves();
            }
            if (this.rightTree != null) {
                count += this.rightTree.countLeaves();
            }

        }
        return count;
    }

    public void getDataLeaves() {
        if (this.leftTree == null && this.rightTree == null) System.out.print(this.data + " ");
        else {
            if (this.leftTree != null) this.leftTree.getDataLeaves();
            if (this.rightTree != null) this.rightTree.getDataLeaves();

        }
    }

    public boolean contains(String nodeData){
        if (this.data.equals(nodeData)) {
            return true;
        }
        if (this.leftTree != null && this.rightTree != null) {
            return this.leftTree.contains(nodeData) || this.rightTree.contains(nodeData);
        }
        if(this.leftTree != null) {
            return this.leftTree.contains(nodeData);
        }
        if(this.rightTree != null) {
            return this.rightTree.contains(nodeData);
        }
        return false;

    }


}
