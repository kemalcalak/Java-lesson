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
        while (temp.getSonraki() != null) {// temp değişkeni liste sonundaki elemana kadar ilerletiliyor
            temp = temp.getSonraki();
        }
        // döngü çıkışında temp en son düğüm üzerine konumlanmıştır
        temp.setSonraki(yeni);
    }

    public void basaEkle(Dugum yeni) {
        yeni.setSonraki(this.ilk); // yeşil bağlantı
        this.ilk = yeni; // mavi bağlantı
    }

    public void sonaEkle(Dugum yeni) {
        if (this.ilk == null) {
            this.ilk = yeni;
            return;
        }
        Dugum temp = this.ilk;
        while (temp.getSonraki() != null) {
            temp = temp.getSonraki();
        }
        temp.setSonraki(yeni);
    }

    
    // listenin eleman sayısını hesaplama
    public int elemanSayisi() {
        int sayac = 0;
        Dugum temp = this.ilk;
        while (temp != null) {
            sayac++;
            temp = temp.getSonraki();
        }
        return sayac;
    }

    // listede eleman bulma
    public Dugum elemanBul(int deger) {
        Dugum temp = this.ilk;
        while (temp != null) {
            if (temp.getVeri() == deger) {
                return temp;
            }
            temp = temp.getSonraki();
        }
        return null;
    }

    // ödev1: aranan değerden listede kaç tane olduğunu geridöndüren fonksiyonu yaz
    public int arananDegerinSayisi(int arananDeger) {
        int sayac = 0;
        Dugum temp = this.ilk;
        while (temp != null) {
            if (temp.getVeri() == arananDeger) {
                sayac++;
            }
            temp = temp.getSonraki();
        }
        return sayac;
    }

    // ödev2: arayaEkle fonksiyonunu sonaEkle fonksişyonu kullanılacak şekilde revize edilmesi
    public void arayaEkle(int index, int deger) {
        if (index < 0 || index > elemanSayisi()) {
            System.out.println("Geçersiz indeks!");
            return;
        }
        if (index == 0) {
            basaEkle(deger);
            return;
        }
        if (index == elemanSayisi()) {
            sonaEkle(deger);
            return;
        }
        Dugum yeni = new Dugum(deger);
        Dugum temp = this.ilk;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.getSonraki();
        }
        yeni.setSonraki(temp.getSonraki());
        temp.setSonraki(yeni);
    }

    // ödev3: sıralıEkle fonksiyonu değerleri sayısal olarak sıralı ekleyecek şekilde yazılacak (indis parametresi olmayan)
    public void sıralıEkle(int deger) {
        Dugum yeni = new Dugum(deger);
        if (this.ilk == null) {
            this.ilk = yeni;
            return;
        }
        if (deger < this.ilk.getVeri()) {
            yeni.setSonraki(this.ilk);
            this.ilk = yeni;
            return;
        }
        Dugum temp = this.ilk;
        while (temp.getSonraki() != null && temp.getSonraki().getVeri() < deger) {
            temp = temp.getSonraki();
        }
        yeni.setSonraki(temp.getSonraki());
        temp.setSonraki(yeni);
    }

    // ödev4: değere ve indise göre eleman silme
    /*
     * public void elemanSil(int deger) {
     * if (this.ilk == null) {
     * System.out.println("Liste boş!");
     * return;
     * }
     * if (this.ilk.getVeri() == deger) { // listenin başındaki eleman silinecek
     * this.ilk = this.ilk.getSonraki();
     * return;
     * }
     * Dugum onceki = this.ilk;
     * Dugum temp = this.ilk.getSonraki();
     * while (temp != null) {
     * if (temp.getVeri() == deger) {
     * onceki.setSonraki(temp.getSonraki());
     * return;
     * }
     * onceki = temp;
     * temp = temp.getSonraki();
     * }
     * System.out.println(deger + " degeri bulunamadi!");
     * }
     * 
     * 
     * public void elemanSil(int index) {
     * if (index < 0 || index >= elemanSayisi()) {
     * System.out.println("Gecersiz indeks!");
     * return;
     * }
     * if (index == 0) { // listenin başındaki eleman silinecek
     * this.ilk = this.ilk.getSonraki();
     * return;
     * }
     * Dugum onceki = this.ilk;
     * Dugum temp = this.ilk.getSonraki();
     * for (int i = 1; i < index; i++) {
     * onceki = temp;
     * temp = temp.getSonraki();
     * }
     * onceki.setSonraki(temp.getSonraki());
     * }
     */

    // sayıları sıralar
    public void sirala() {
        Dugum temp = this.ilk;
        while (temp != null) {
            Dugum innerTemp = this.ilk;
            while (innerTemp != null) {
                if (innerTemp.getSonraki() != null && innerTemp.getVeri() > innerTemp.getSonraki().getVeri()) {
                    int tempData = innerTemp.getVeri();
                    innerTemp.setVeri(innerTemp.getSonraki().getVeri());
                    innerTemp.getSonraki().setVeri(tempData);
                }
                innerTemp = innerTemp.getSonraki();
            }
            temp = temp.getSonraki();
        }
    }

    // değeri, listede herhangi bir indekse eklyen fonksiyon
    public void indekseEkle(int deger, int indeks) {
        if (indeks < 0 || indeks > elemanSayisi()) {
            System.out.println("Geçersiz indeks");
            return;
        }
        Dugum yeni = new Dugum(deger);
        if (indeks == 0) {
            yeni.setSonraki(this.ilk);
            this.ilk = yeni;
            return;
        }
        Dugum temp = this.ilk;
        for (int i = 0; i < indeks - 1; i++) {
            temp = temp.getSonraki();
        }
        yeni.setSonraki(temp.getSonraki());
        temp.setSonraki(yeni);
    }

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
        
    //verilen değeri silme birden fazla varsa ilkini silme
    /* 
     * public void degeriSil(int deger) {
        
        if (this.ilk == null) {
            return;
        }
    
        if (this.ilk.getVeri() == deger) {
            this.ilk = this.ilk.getSonraki();
            return;
        }
    
        Dugum onceki = this.ilk;
        Dugum suanki = onceki.getSonraki();
        while (suanki != null) {
            if (suanki.getVeri() == deger) {
                onceki.setSonraki(suanki.getSonraki());
                return;
            }
            onceki = suanki;
            suanki = suanki.getSonraki();
        }
    }
     */
    
    //ödev4: verilen değeri listeden silen(birden fazla varsa hepsini silmelidir)fonksiyonu yazın
    public void degeriSil(int deger) {
        if (this.ilk == null) {
            return;
        }
        
        Dugum temp = this.ilk;
        Dugum onceki = null;
    
        while (temp != null) {
            if (temp.getVeri() == deger) {
               if (onceki == null) {
                    this.ilk = temp.getSonraki();
                }
                else {
                    onceki.setSonraki(temp.getSonraki());
                }
            }
            else {
                onceki = temp;
            }
            temp = temp.getSonraki();
        }
    }

}
