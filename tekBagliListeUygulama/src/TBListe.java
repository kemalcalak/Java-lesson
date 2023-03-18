public class TBListe {
    private Dugum ilk;

    public TBListe() {
        this.ilk = null;
    }

    // listenin başına eleman ekleme
    public void basaEkle(int deger) {
        Dugum yeni = new Dugum(deger);
        // Dugum yeni =new Dugum();
        // yeni.setVeri(deger);
        yeni.setSonraki(this.ilk); // yeşil bağlantı
        this.ilk = yeni; // mavi bağlantı
    }

    // listenin sonuna eleman ekleme
    public void sonaEkle(int deger) {
        Dugum yeni = new Dugum(deger);
        if (this.ilk == null) {
            this.ilk = yeni;
            return;
        }
        Dugum temp = this.ilk;
        while (temp.getSonraki() != null) {
            temp = temp.getSonraki();
        }
        // döngü çıkışında temp en son düğüm üzerine konumlanmıştır
        temp.setSonraki(yeni);
    }

    // listenin eleman sayısını hesaplama

    // listedeki tüm elemanların değerlerini ekrana yazma
    public void listele() {
        Dugum temp = this.ilk;
        if (temp == null) {
            System.out.println("Liste boş.");
            return;
        }
        while (temp != null) {
            temp.yazdir();
            // temp=temp.sonraki;
            temp = temp.getSonraki();
        }
        System.out.println("-------------");

    }

}
