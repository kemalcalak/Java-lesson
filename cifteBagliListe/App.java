import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
       /*  CBListe cbl=new CBListe();

        cbl.listele();
        cbl.arayaEkle(10, 1);
        cbl.basaEkle(20);
        cbl.sonaEkle(30);
        cbl.arayaEkle(40, 2);
        cbl.basaEkle(5);
        cbl.sonaEkle(10);
        cbl.listele();

        cbl.elemanSil(10);
        cbl.listele();

        cbl.elemanSil(10);
        cbl.listele();*/



        LinkedList <String> liste=new LinkedList<>();
        liste.add("Veri");
        liste.addFirst("Yapıları");
        liste.addLast("Matematik");
        System.out.println("Eleman Sayısı: " +liste.size());
        for(int i=0; i<liste.size(); i++){
            System.out.println(liste.get(i).toString());
        }



    }




}
