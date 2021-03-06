package domain;

import java.util.ArrayList;

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

    public boolean contains(E nodeData){
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

    public int count(E geg) {
        if (geg == null) {
            return 0;
        }
        return (this.data.equals(geg) ? 1 : 0)
                + (this.leftTree != null ? this.leftTree.count(geg) : 0)
                + (this.rightTree != null ? this.rightTree.count(geg) : 0);
    }

    public ArrayList<E> getNodesAtDistance(int k) {
        if (k < 0) {
            throw new IllegalArgumentException("Foute waarde voor afstand!");
        }
        ArrayList<E> res = new ArrayList<>();
        if (k == 0) {
            res.add(this.data);
        } else {
            if (this.leftTree != null) {
                res = this.leftTree.getNodesAtDistance(k - 1);
            }
            if (this.rightTree != null) {
                ArrayList<E> rechtsteLijst = this.rightTree.getNodesAtDistance(k - 1);
                res.addAll(rechtsteLijst);
            }
        }
        return res;
    }

    public ArrayList<E> mystery() {
        ArrayList<E> lijst = new ArrayList<>();
        if (this.leftTree != null) lijst.add(this.leftTree.data);
        if (this.rightTree != null) lijst.add(this.rightTree.data);
        return lijst;
    }
    public ArrayList<E> mystery(int g) {
        if (g == 1) {
            return this.mystery();
        } else {
            ArrayList<E> links = new ArrayList<>();
            if (this.leftTree != null) links = this.leftTree.mystery(g - 1);
            ArrayList<E> rechts = new ArrayList<>();
            if (this.rightTree != null) rechts = this.rightTree.mystery(g - 1);
            links.addAll(rechts);
            return links;
        }
    }

    public BinaryTree<E> deelZonder(E wortelInfo) {
        if (wortelInfo == null || !this.contains(wortelInfo))
            return null;
        // wortelInfo == data, dus hele boom verwijderen
        if (this.data == wortelInfo) {
            return null;
        }
        // wortelInfo = linkerkind van data, dus hele linkertak verwijderen
        if (this.leftTree!=null && this.leftTree.data.equals(wortelInfo)){
            return new BinaryTree(this.data,null,this.rightTree);
        }
        // wortelInfo == rechterkind van data, dus hele rechtertak verwijderen
        if (this.rightTree!= null && this.rightTree.equals(wortelInfo)){
            return new BinaryTree(this.data,this.rightTree,null);
        }
        BinaryTree newLeftTree, newRightTree;
        // als wortelInfo in linkertak zit: nieuwe linkertak maken zonder wortelInfo
        if (this.leftTree != null && this.leftTree.contains(wortelInfo))
            newLeftTree = this.leftTree.deelZonder(wortelInfo);
        // anders linkertak behouden
        else newLeftTree = this.leftTree;
        // idem voor rechtertak
        if (this.rightTree!=null && this.rightTree.contains(wortelInfo))
            newRightTree = this.rightTree.deelZonder(wortelInfo);
        else
            newRightTree = this.rightTree;
        // resulterende boom terug samenstellen
        return new BinaryTree<>(this.data,newLeftTree,newRightTree);
    }

    public boolean isStrict() {
        // wortel == blaadje
        if (this.isLeaf())
            return true;
        // wortel heeft linker- en rechtertak, dus rest van boom controleren
        if ((this.leftTree != null && this.rightTree != null)) {
            return this.leftTree.isStrict() && this.rightTree.isStrict();
        }
        // bij wortel ontbreekt linker- of rechtertak
        return false;
    }
}
