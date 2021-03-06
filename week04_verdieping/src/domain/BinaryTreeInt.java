package domain;

public class BinaryTreeInt {
    private int data;
    private BinaryTreeInt leftTree, rightTree;
    public BinaryTreeInt(int data) {
        this(data, null, null);
    }
    public BinaryTreeInt(int data, BinaryTreeInt leftTree, BinaryTreeInt rightTree) {
        this.data = data;
        this.leftTree = leftTree;
        this.rightTree = rightTree;
    }
    public boolean kinderSom() {
// Controleer of wortel voldoet aan voorwaarden van kindersom
        // Als wortel een blaadje is, voldoet hij
        if (this.isLeaf())
// bij een blaadje is kinderSom altijd true
            return true;
// Als wortel geen blaadje is: controle uitvoeren
        else {
// Bereken som van de waardes van de kinderen
// De somwaarde van een kind is gelijk aan zijn waarde,
// tenzij het kind niet bestaat. Dan is de somwaarde gelijk aan 0
            int left_value = (this.leftTree != null ? this.leftTree.data : 0);
            int right_value = (this.rightTree != null ? this.rightTree.data : 0);
// Als de som niet juist is, voldoet de boom niet aan de voorwaarden
// Methode kan afgebroken worden
            if (this.data != left_value + right_value)
                return false;
        }
// Als wortel wel voldoet aan voorwaarden, moet de rest van de boom gecontroleerd worden
        return (this.leftTree != null ? this.leftTree.kinderSom() : true) &&
                (this.rightTree != null ? this.rightTree.kinderSom() : true);
    }

    public boolean isLeaf() {
        if (this.leftTree != null && this.rightTree != null) {
            return false;
        }
        return true;
    }
}
