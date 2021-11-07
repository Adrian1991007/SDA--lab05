package ro.usv.listadiamant;

import java.util.Iterator;

public class ListaGenerica2<T> extends ListaGenerica<T>{

    public T eliminaPrimul()
    {
        if(isEmpty())
        {
            Element<T> PrimulInitialT=getPrimul();
            if(PrimulInitialT == getUltimul())
            {
                eliminaToateElementele();
                return PrimulInitialT.getInfo();
            }
            setPrimul(PrimulInitialT.getUrm());
            return PrimulInitialT.getInfo();
        }
        return null;
    }

    public T eliminaUltimul()
    {
        if(isEmpty())
        {
            Element<T> PrimulInitialT=getPrimul();
            if(PrimulInitialT == getUltimul())
            {
                eliminaToateElementele();
                return PrimulInitialT.getInfo();
            }

            while(PrimulInitialT.getUrm().getUrm() != null)
            {
                PrimulInitialT = PrimulInitialT.getUrm();
            }
            Element<T> Ultimul =getUltimul();
            PrimulInitialT.setUrm(null);
            setUltimul(PrimulInitialT);
            return Ultimul.getInfo();
        }
        return null;
    }

    @Override
    public String toString(){
        StringBuilder rez=new StringBuilder();
        for(Iterator<T> it = new IteratorLst(getPrimul()); it.hasNext();) {
            T info = it.next();
            rez.append( info==null ? "" : info.toString() );
            if(it.hasNext())
                rez.append(" ");
        }
        return rez.toString();
    }
}
