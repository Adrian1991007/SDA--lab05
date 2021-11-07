package ro.usv.listadiamant;

public class AplicatieListaGen {

    public static void main(String[] args) {
        ListaGenerica2<String> lst= new ListaGenerica2<>();
        lst.insertLaUrma("Bucuresti");
        lst.insertInFata("Suceava");
        lst.insertLaUrma("Iasi");
        System.out.println("Orasele din lista:"+lst);

        lst.eliminaToateElementele();
        for(int i=0;i<21;i++) {
            String o=Integer.toString(i); // o=""+i
            if(i%2 !=0)
                lst.insertInFata(o);
            else
                lst.insertLaUrma(o);
        }
        System.out.println("Numerele din lsta:"+lst);

        System.out.print("Intregii din lsta x10: ");
        for(String el:lst){
            System.out.print((Integer.parseInt(el)*10) + ", ");
        }
        System.out.println("\nLungimea listei este " + lst.size());

//        System.out.println("================ Demo eliminaPrimul() ==================");
//        do {
//            System.out.println("Numerele din lsta:(" + lst.size() + "): " + lst.eliminaPrimul() + " " + lst);
//        }while(lst.isEmpty());
//        System.out.println("Numerele din lsta:(" + lst.size() + "): "  + lst);

//        System.out.println("================ Demo eliminaUltimul() ==================");
//        do {
//            System.out.println("Numerele din lsta:(" + lst.size() + "): " + lst + " " + lst.eliminaUltimul());
//        }while(lst.isEmpty());
//        System.out.println("Numerele din lsta:(" + lst.size() + "): "  + lst);

        System.out.println("================ Demo elimina Primul si Ultimul alternativ =======================");

        int i = lst.size();
        String rez1 = null, rez2 = null;
        do {
            if(i % 2 == 0)
            {
                rez2 = lst.eliminaUltimul();
                System.out.println("Numerele din lsta:(" + i + ") <" +  rez1 + "> :" + lst + " " + rez2);
            }
            else
            {
                rez1 = lst.eliminaPrimul();
                System.out.println("Numerele din lsta:(" + i  + ") <" + (i == 21 ? "init"  : rez2) + "> :" + rez1 + " " + lst);
            }
            i--;
        }while(lst.isEmpty());
        System.out.println("Numerele din lsta:(" + i + ") <" + rez1 + "> :"  + lst);
    }
}
