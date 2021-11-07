package ro.usv.listadiamant;

import java.util.Iterator;

public class ListaGenerica<T> implements Iterable<T> {
    private Element<T> primul=null, ultimul=null;
    @Override
    public Iterator<T> iterator() {
        return new IteratorLst<>(primul);
    }
    public void insertInFata(T x){
        Element<T> primulInitial=primul;
        primul=new Element(x, primulInitial);
        if(primulInitial == null) ultimul=primul;
    }
    public void insertLaUrma(T x){
        Element<T> ultimulInitial=ultimul;
        ultimul = new Element(x, null);
        if(ultimulInitial == null) primul = ultimul;
        else
            ultimulInitial.setUrm(ultimul);
    }
    public void eliminaToateElementele(){
        primul=ultimul=null;
    }

    public int size()
    {
        int i = 0;
        for (Iterator<T> iterator = new IteratorLst<>(primul); iterator.hasNext(); i++)
        {
            iterator.next();
        }

        return i;
    }

    public boolean isEmpty()
    {
        return primul != null || ultimul != null;
    }

    public Element<T> getPrimul() {
        return primul;
    }

    public Element<T> getUltimul() {
        return ultimul;
    }

    public void setPrimul(Element<T> primul) {
        this.primul = primul;
    }

    public void setUltimul(Element<T> ultimul) {
        this.ultimul = ultimul;
    }

    @Override
    public String toString(){
        StringBuilder rez=new StringBuilder("[");
        for(Iterator<T> it=new IteratorLst(primul); it.hasNext();) {
            T info = it.next();
            rez.append( info==null ? "null" : info.toString() );
            if(it.hasNext())
                rez.append(", ");
        }
        rez.append(']');
        return rez.toString();
    }
}
