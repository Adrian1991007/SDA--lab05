package ro.usv.listadiamant;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListGenericaT<T> implements List<T> {
    private Element<T> primul=null, ultimul=null;

    @Override
    public int size() {
        int i = 0;
        for (Iterator<T> iterator = new IteratorLst<>(primul); iterator.hasNext(); i++)
        {
            iterator.next();
        }

        return i;
    }

    @Override
    public boolean isEmpty() {
        return primul != null || ultimul != null;
    }

    @Override
    public boolean contains(Object o) {
        Element<T> PrimulInitialT=primul;
        while (PrimulInitialT.getUrm() != null)
        {
            if(PrimulInitialT.equals(o))
                return true;
            PrimulInitialT = PrimulInitialT.getUrm();
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorLst<>(primul);
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        Element<T> ultimulInitial=ultimul;
        ultimul = new Element(t, null);
        if(ultimulInitial == null) primul = ultimul;
        else
            ultimulInitial.setUrm(ultimul);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Element<T> PrimulInitialT=primul;
        while (PrimulInitialT.getUrm() != null)
        {
            if(PrimulInitialT.getUrm().equals(o))
            {
                PrimulInitialT.setUrm(PrimulInitialT.getUrm().getUrm());
                return true;
            }
            PrimulInitialT = PrimulInitialT.getUrm();
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        primul=ultimul=null;
    }

    @Override
    public T get(int index) {
        int i = 0;
        T info = null;
        for (Iterator<T> iterator = new IteratorLst<>(primul); iterator.hasNext(); i++)
        {
            info = iterator.next();
            if(i == index)
            {
                return info;
            }

        }
        return null;
    }

    @Override
    public T set(int index, T element) {
        Element<T> PrimulInitialT=primul;
        int i = 0;
        while (PrimulInitialT.getUrm() != null)
        {
            if( i == index)
            {
                PrimulInitialT.setInfo(element);
                return PrimulInitialT.getInfo();
            }
            PrimulInitialT = PrimulInitialT.getUrm();
            i++;
        }
        return null;
    }

    @Override
    public void add(int index, T element) {
        Element<T> PrimulInitialT=primul;
        int i = 0;
        while (PrimulInitialT.getUrm() != null)
        {
            if(i == 0)
            {
                Element<T> primulInitial=primul;
                primul=new Element(element, primulInitial);
                if(primulInitial == null) ultimul=primul;
                return;
            }
            if( i == index)
            {
                Element<T> ElementCurent = PrimulInitialT;
                Element<T> newElement = new Element<>(element, ElementCurent.getUrm());

                ElementCurent.setUrm(newElement);
                return;
            }
            PrimulInitialT = PrimulInitialT.getUrm();
            i++;
        }
    }

    @Override
    public T remove(int index) {
        Element<T> PrimulInitialT=primul;
        T info = null;
        int i = 0;
        while (PrimulInitialT.getUrm() != null)
        {
            if( i + 1 == index)
            {
                info = PrimulInitialT.getUrm().getInfo();
                PrimulInitialT.setUrm(PrimulInitialT.getUrm().getUrm());
            }
            PrimulInitialT = PrimulInitialT.getUrm();
            i++;
        }
        return info;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public String toString() {
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
