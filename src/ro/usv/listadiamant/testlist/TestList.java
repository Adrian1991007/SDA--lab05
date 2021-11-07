package ro.usv.listadiamant.testlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import ro.usv.listadiamant.ListGenericaT;
/**
 * @author St.Gh. PENTIUC
 */
public class TestList {
    private static String FORMAT="%d";
    static int N = 100000, Nafisate=10;
    public static void main(String[] args) {
        List<Integer> lst1 = new ArrayList<>();
        List<Integer> lst2 = new LinkedList<>();
        List<Integer> lst3 = new ListGenericaT<>();
        List liste[] = new List[]{lst3, lst2, lst1};
        for(List lst:liste){
            System.out.println("\n================= Demo "
                    + lst.getClass().getSimpleName()
                    + " =====================");
            System.out.printf("%s\n", lst.toString());

           testInserari(lst);
           testEliminari(lst, true); // sau false fara if(..contains(x)..

        }
    }
    static void testInserari(List<Integer> lst) {
        int nrerori = 0;
        int x, y;
        long startTime = System.currentTimeMillis();
        System.out.printf( "Start inserari (i- in fata, I - la urma):\n");
        for (x = 0; x<N ; x += 1){
            if (x > N / 2) {
                lst.add(0, x);
                if ((y = lst.get(0)) != x) {
                    System.out.printf("\n***Eroare. S-a inserat "+FORMAT
                            +" s-a gasit "+FORMAT, x, y);
                    nrerori++;
                }
            } else {
                lst.add(x); //inserare la urma
                if ((y = lst.get( lst.size()-1 )) != x) {
                    System.out.printf("\n***Eroare. S-a inserat "+FORMAT
                            +" s-a gasit "+FORMAT, x, y);
                    nrerori++;
                }
            }
            if (N > Nafisate)
                if ((int) x % 1000 == 0) {
                    System.out.printf("%c", x > N / 2 ? 'i' : 'I');
                }
            if (N <= Nafisate)
                System.out.printf("\ni=%d %s\n", x, lst);
        }
        if(lst.size()!=N)
            System.out.printf("***Eroare. In lista ar trebui sa fie"
                    +" %d elemente",N);
        System.out.printf("\nLista are %d elemente.", lst.size());
        System.out.printf("\nTest inserare incheiat cu %d erori\n", nrerori);
        afisDurataExecutie(startTime);
    }
    static void afisDurataExecutie(long startTime){
        long durata = System.currentTimeMillis() - startTime;
        System.out.printf("Durata test %.3f s\nDurata per element"
                        + " %.6f ms\n\n",
                (float)(durata/1000.), (float)(durata/(double)N));
    }
    static void testEliminari(List<Integer> lst,
                              boolean verificaSiContinut){
        int nrerori=0;
        int x=N;
        long startTime = System.currentTimeMillis();
        System.out.printf("\nStart eliminari (d- primul, D -"
                + " ultimul element):\n");
        while(!lst.isEmpty()) {
            x--;
            if (N<=Nafisate)
                System.out.printf("\nlst(%d elemente): ", lst.size(), lst);
            if(verificaSiContinut && lst.contains(x)==false){
                System.out.printf( "\n*** Eroare inserare info="+FORMAT
                                + "In lista %s sunt %d elemente",x,
                        ((Object)lst), lst.size());
                nrerori++;
            }
            if(x>N/2)
                lst.remove(0);
            else
                lst.remove( lst.size()-1 );
            if(verificaSiContinut && lst.contains(x)!=false) {
                System.out.printf("\n*** Eroare stergere info="+FORMAT
                                + "In lista %s sunt %d elemente",
                        x, lst, lst.size());
                nrerori++;
            } else {
                if (N<=Nafisate)
                    System.out.printf(" S-a eliminat "+FORMAT+" (lst a ramas %s)",
                            x, lst);
                else
                if((int)x%1000==0)
                    System.out.printf("%c", x>N/2 ? 'd':'D');
            }
        }
        System.out.printf("\nTest eliminare incheiat cu %d erori\n",
                nrerori);
        afisDurataExecutie(startTime);
    }
}