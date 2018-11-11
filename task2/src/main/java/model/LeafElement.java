package model;

import java.util.Iterator;

public class LeafElement implements IElement {
    private String string;

    public LeafElement(String string) {
        this.string = string;
    }

    @Override
    public void addElement(IElement element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteElement(IElement element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteElement(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public IElement getElement(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<IElement> getIterator() {
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
