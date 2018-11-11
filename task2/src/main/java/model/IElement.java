package model;

import java.util.Iterator;

public interface IElement {
    public void addElement(IElement element);
    public void deleteElement(IElement element);
    public void deleteElement(int index);
    public IElement getElement(int index);
    public Iterator<IElement> getIterator();

    public String getString();
    public void setString(String string);

    public String toString();
}
