package domain;

import java.util.ArrayList;

public class BinaryMinHeap<E extends Comparable<E>> {
    private ArrayList<E> values;

    private boolean isEmpty() {
        return values == null || values.size() == 0;
    }

    public void print() {
        if (this.isEmpty())
            System.out.println("De heap is leeg");
        else
            System.out.println(values);
    }

    public E getMin() {
        E min;
        if (this.isEmpty()) {
            throw new IllegalStateException("Kan niet zoeken in een lege heap");
        } else {
            return this.values.get(0);
        }
    }

    public boolean addValue(E value) {
        // geen null toevoegen aan de heap
        if (value == null) throw new IllegalArgumentException();
        // indien de heap leeg is: eerst initialiseren
        if (this.isEmpty())
            values = new ArrayList<E>();

        values.add(value);//achteraan toevoegen
        this.bubbleUp();//bubbleUp vanaf de laatste zie slides theorie
        return true;
    }

    private void bubbleUp() {
        int index = this.values.size() - 1;

        while (heeftOuder(index) && ouder(index).compareTo(values.get(index)) > 0) {
            this.wisselOm(index, ouderIndex(index));
            index = ouderIndex(index);
        }
    }

    private void wisselOm(int i, int j) {
        E hulp = this.values.get(i);
        this.values.set(i, this.values.get(j));
        this.values.set(j, hulp);
    }

    private int ouderIndex(int index) {
        return (index - 1) / 2;
    }

    private E ouder(int index) {
        return values.get(ouderIndex(index));
    }

    private boolean heeftOuder(int index) {
        return index >= 1;
    }

    public E removeSmallest() {
        if (this.isEmpty())
            throw new IllegalStateException("Kan niets verwijderen uit een lege boom");
        E res = this.getMin();// res bevat de kleinste = eerste element van de lijst
        this.values.set(0, this.values.get(this.values.size() - 1));// verwissel eerste met de laatste
        this.values.remove(this.values.size() - 1); // verwijder de laatste
        this.bubbleDown(); // bubble down van eerste naar beneden zie theorie
        return res;
    }

    private void bubbleDown() {
        int index = 0; //start met de wortel
        boolean wisselOK = true;
        while (heeftLinkerKind(index) && wisselOK) {
            int indexKleinsteKind = indexLinkerKind(index);
            if (heeftRechterKind(index)
                    && values.get(indexKleinsteKind).compareTo(values.get(indexRechterKind(index))) > 0) {
                indexKleinsteKind = indexRechterKind(index);
            }
            if (values.get(index).compareTo(values.get(indexKleinsteKind)) > 0) {

                this.wisselOm(index, indexKleinsteKind);
            } else {
                wisselOK = false;
            }
            index = indexKleinsteKind;
        }
    }

    private int indexRechterKind(int index) {
        return 2 * index + 2;
    }

    private boolean heeftRechterKind(int index) {
        return indexRechterKind(index) < values.size();
    }

    private int indexLinkerKind(int index) {
        return 2 * index + 1;
    }

    private boolean heeftLinkerKind(int index) {
        return indexLinkerKind(index) < values.size();
    }

    public ArrayList<E> getPath(E value) {
        int index = this.values.indexOf(value);
        if (index == -1) {
            return null;
        } else {
            ArrayList<E> pad = new ArrayList<>();
            pad.add(value);
            while (index > 0) {
                index = (index - 1) / 2; //ouder
                pad.add(0, this.values.get(index));
            }
            return pad;
        }
    }
}
