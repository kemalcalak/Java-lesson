public class TBListe {
    private  Dugum ilk;  // listenin başlangıcını tutan değişken

    public TBListe(){
        this.ilk=null;   //liste boş olarak yaratılır
    }

    //listenin başına eleman ekleme
    public void basaEkle(int deger){
        Dugum yeni=new Dugum(deger); 
        //Dugum yeni=new Dugum();
        //yeni.setVeri(deger);
        yeni.setSonraki(this.ilk); //yeşil bağlantı
        this.ilk=yeni; //mavi bağlantı
    }

    public void basaEkle(Dugum yeni){
        yeni.setSonraki(this.ilk); //yeşil bağlantı
        this.ilk=yeni; //mavi bağlantı
    }


    //listenin sonuna eleman ekleme
    public void sonaEkle(int deger){
        Dugum yeni=new Dugum(deger);
        if(this.ilk==null){
            this.ilk=yeni;
            return;
        }
        Dugum temp=this.ilk;
        while(temp.getSonraki()!=null){ //temp değişkeni liste sonundaki elemana kadar ilerletiliyor
            temp=temp.getSonraki();
        }
        //döngü çıkışında temp en son düğüm üzerine konumlanmıştır
        temp.setSonraki(yeni);
    }

    public void sonaEkle(Dugum yeni){
        if(this.ilk==null){
            this.ilk=yeni;
            return;
        }
        Dugum temp=this.ilk;
        while(temp.getSonraki()!=null){
            temp=temp.getSonraki();
        }
        //döngü çıkışında temp en son düğüm üzerine konumlanmıştır
        temp.setSonraki(yeni);
    }
    
    //listedeki eleman sayısını hesaplama
    public int listeElemanSayısı(){
        int sayac=0;
        Dugum temp=this.ilk;
        while (temp!=null){
            sayac++; 
            temp=temp.getSonraki();
        }
        return sayac;
    }

    //listedeki tüm elemanların değerlerini ekrana yazma
    public void listele(){
        Dugum temp=this.ilk;
        if(temp==null){
            System.out.println("Liste boş");
            return;
        }
        while (temp!=null){
            temp.yazdir();
            //temp=temp.sonraki;
            temp=temp.getSonraki();
        }
        System.out.println("-----------------");
    }

    //listede bir değeri arar ve bulduğunda o düğümü geri döndürür
    public Dugum elemanBul(int deger){
        Dugum temp=this.ilk;
        Dugum bulunan=null;
        while (temp!=null){
            if(temp.getVeri()!=deger) {
                temp=temp.getSonraki();
            }
            else{
                bulunan=temp;
                break;
            }  
        }
        return bulunan;
    }

    //odev1 : aranan değerden listede kaç tane olduğunu geri döndüren fonksiyonu kodlayınız

    //değeri, listede herhangi bir indekse ekleyen fonksiyon
    public void arayaEkle(int deger, int indis){
        if ((this.ilk==null) || (indis==1)){ //liste boş ise
             this.basaEkle(deger);
             return;
        }
        Dugum yeni=new Dugum(deger);
        Dugum temp=this.ilk;
        int sayac=1;

        while(temp.getSonraki()!=null){  //eklenecek yerin bir önceki düğümüne tempin konumlandırılması
            if(sayac+1==indis){
                break;
            }
            sayac++;
            temp=temp.getSonraki();
        }
        yeni.setSonraki(temp.getSonraki()); //yeşil bağlantı
        temp.setSonraki(yeni);   //mavi bağlantı
    }

//ödev2: araya ekle fonksiyonunun sonaEkle fonksiyonu kullanılacak şekilde revize edilmesi

//ödev 3: sıralıEkle fonksiyonu değerleri sayısal olarak sıralı ekleyecek şekilde yazılacak (indis parametresi olmayan)

//ödev 4: verilen değeri listeden silen (birden fazla varsa hepsini silmelidir) fonk kodlayınız
    


    //verilen değeri listeden silen fonk (birden fazla var ise ilk bulduğunu siler)
    //1. liste boş olabilir
    //2. listenin ilk elemanı silinirse liste başı değişecektir
    //3. silinecek değer listede yoktur, silme işlemi gerçekleşmez
    //4. deger listede vardır ve silinir    
    //silme işlemi başarılı ise fonksiyon geriye 0 döndürsün
    //liste boş ise -1 döndürsün
    //eleman bulunamazsa (dolayısı ile silinemezse) -2 döndürsün
    public  int elemanSil(int deger){
        if(this.ilk == null){ //liste boş ise
            return -1;
        }
        if(this.ilk.getVeri() == deger){ // listenin ilk elamanı silinecek se
            this.ilk=this.ilk.getSonraki();
            return 0;
        }
        Dugum temp=this.ilk;
        while(temp.getSonraki().getVeri() != deger){
            if(temp.getSonraki().getSonraki() == null){  //liste sonuna kadar arama yapıldı, listede eleman yoktur silinemez
                return -2;
            }
            temp=temp.getSonraki();
        }
        //eleman silme işlemi ile ilgili kod
        temp.setSonraki(temp.getSonraki().getSonraki());
        return 0;
    }

    
}
 