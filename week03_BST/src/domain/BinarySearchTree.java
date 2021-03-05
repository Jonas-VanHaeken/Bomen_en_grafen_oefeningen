package domain;

import java.util.ArrayList;

/*
Update the BinaryTree class in the domain folder with the BinaryTree of week 02
* */
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

    public BinarySearchTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
        super(data, leftTree, rightTree);
    }

    public BinarySearchTree(E data) {
        super(data);
    }

    public boolean lookup(E data) {
    	if(data == null) throw new IllegalArgumentException();
        if (data.compareTo(this.data) == 0) return true;
        else {
            if (data.compareTo(this.data) > 0) {
                if (this.leftTree.data == null) return false;
                else return this.leftTree.lookup(data);
            } else {
                if (this.rightTree.data == null) {
                    return false;
                } else return this.rightTree.lookup(data);
            }
        }
    }

    public boolean addNode(E data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        if (this.data.compareTo(data) == 0) {
            return false; //geen twee keer zelfde data in BST
        } else if (this.data.compareTo(data) > 0) {//ga naar linkersubboom
            if (this.leftTree == null) {
                this.leftTree = new BinarySearchTree<>(data);
                return true;
            } else return (this.leftTree.addNode(data));
        } else if (this.rightTree == null) {
            this.rightTree = new BinarySearchTree<>(data);
            return true;
        } else return (this.rightTree.addNode(data));
    }

    public boolean removeNode(E data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        if (this.data == null) {
            return false;
        }
        if (this.data.compareTo(data) == 0) {//data gevonden
            if (this.isLeaf()) {
                this.data = null;
                return true;
// in dit geval blijft een leeg blaadje achter
// clean kan dan enkel via gehele boom
            } else {
                if (this.leftTree != null) {//linkerboom is niet leeg
                    E grootsteLinks = this.leftTree.searchGreatest();
                    this.data = grootsteLinks;
                    boolean verwijderenGelukt = this.leftTree.removeNode(grootsteLinks);
                    if (verwijderenGelukt) {
                        this.leftTree.cleanUp();
                    }
                    return verwijderenGelukt;
                } else {//rechterboom is niet leeg
                    E kleinsteRechts = this.rightTree.searchGreatest();
                    this.data = kleinsteRechts;
                    boolean verwijderenGelukt = this.rightTree.removeNode(kleinsteRechts);
                    if (verwijderenGelukt) {
                        this.rightTree.cleanUp();
                    }
                    return verwijderenGelukt;
                }
            }
        } else {
            if (this.data.compareTo(data) > 0) {//zoek in linkerboom
                return (this.leftTree == null ? false : this.leftTree.removeNode(data));
            } else {//zoek in rechterboom
                return (this.rightTree == null ? false : this.rightTree.removeNode(data));
            }
        }
    }

    public E searchSmallest() {
        if (this.leftTree == null) {
            return this.data;
        } else {
            return this.leftTree.searchSmallest();
        }
    }

    public E searchGreatest() {
        if (this.rightTree == null) {
            return this.data;
        } else {
            return this.rightTree.searchGreatest();
        }
    }

    public void cleanUp() {
        if (this.data != null) {
            if (this.leftTree != null) {
                if (this.leftTree.data == null) {
                    this.leftTree = null;
                } else {
                    this.leftTree.cleanUp();
                }
            }
            if (this.rightTree != null) {
                if (this.rightTree.data == null) {
                    this.rightTree = null;
                } else {
                    this.rightTree.cleanUp();
                }
            }
        }
    }

    public ArrayList<E> getPath(E data) {
        if (!lookup(data)) {//data komt niet voor in BST
            return null;
        }
        ArrayList<E> pad = new ArrayList<>();
        if (this.data.compareTo(data) == 0) {
            pad.add(data);
            return pad;
        } else {
            pad.add(this.data);
            if (this.data.compareTo(data) > 0) {//ga links, data komt zeker voor!
                pad.addAll(this.leftTree.getPath(data));
            } else {// ga rechts, data zit daar gegarandeerd
                pad.addAll((this.rightTree.getPath(data)));
            }
        }
        return pad;
    }
}


