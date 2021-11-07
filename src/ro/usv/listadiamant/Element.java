package ro.usv.listadiamant;

import java.util.Objects;

class Element<T> {
    private T info;
    private Element<T> urm;
    public Element<T> getUrm() {
        return urm;
    }
    public void setUrm(Element<T> urm) {
        this.urm = urm;
    }

    public Element(T info, Element<T> urm) {
        this.info = info;
        this.urm=urm;
    }
    public T getInfo(){
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Element)) return false;
        Element<?> element = (Element<?>) o;
        return getInfo().equals(element.getInfo()) && getUrm().equals(element.getUrm());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInfo(), getUrm());
    }


}

