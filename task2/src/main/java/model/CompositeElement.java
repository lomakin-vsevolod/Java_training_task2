package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompositeElement implements IElement {
    private List<IElement> elementList = new ArrayList<IElement>();

    public CompositeElement() {
    }

    @Override
    public void addElement(IElement element) {
        elementList.add(element);
    }

    @Override
    public void deleteElement(IElement element) {
        elementList.remove(element);
    }

    @Override
    public void deleteElement(int index) {
        elementList.remove(index);
    }

    @Override
    public IElement getElement(int index) {
        return elementList.get(index);
    }

    @Override
    public Iterator<IElement> getIterator() {
        return elementList.iterator();
    }

    @Override
    public String getString() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setString(String string) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString(){
        StringBuilder wholeString = new StringBuilder();
        for (IElement iElement : elementList){
            wholeString.append(iElement.toString());
        }
        return wholeString.toString();
    }
}
