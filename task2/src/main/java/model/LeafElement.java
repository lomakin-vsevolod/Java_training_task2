package model;

import java.util.Iterator;

public class LeafElement extends AbstractElement {
    private String string;

    public LeafElement(String string) {
        this.string = string;
    }

    @Override
    public void addElement(AbstractElement element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteElement(AbstractElement element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteElement(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public AbstractElement getElement(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<AbstractElement> getIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getString() {
        return string;
    }

    @Override
    public void setString(String string) {
        this.string=string;
    }

    @Override
    public String toString(){
        return string;
    }
}
