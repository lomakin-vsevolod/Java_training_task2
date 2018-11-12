package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompositeElement extends AbstractElement {
    private List<AbstractElement> elementList = new ArrayList<AbstractElement>();

    public CompositeElement() {
    }

    @Override
    public void addElement(AbstractElement element) {
        elementList.add(element);
    }

    @Override
    public void deleteElement(AbstractElement element) {
        elementList.remove(element);
    }

    @Override
    public void deleteElement(int index) {
        elementList.remove(index);
    }

    @Override
    public AbstractElement getElement(int index) {
        return elementList.get(index);
    }

    @Override
    public Iterator<AbstractElement> getIterator() {
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
        for (AbstractElement abstractElement : elementList){
            wholeString.append(abstractElement.toString());
        }
        return wholeString.toString();
    }
}
