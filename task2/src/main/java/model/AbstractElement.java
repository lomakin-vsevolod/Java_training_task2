package model;

import java.util.Iterator;

public abstract class AbstractElement {

   private CompositeType type;

   public void setType(CompositeType compositeType){
      this.type=compositeType;
   }

   public CompositeType getType(){
      return type;
   }
   abstract public void addElement(AbstractElement element);
   abstract public void deleteElement(AbstractElement element);
   abstract public void deleteElement(int index);
   abstract public AbstractElement getElement(int index);
   abstract public Iterator<AbstractElement> getIterator();

   abstract public String getString();
   abstract public void setString(String string);

   abstract public String toString();
}
