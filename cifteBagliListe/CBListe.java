public class CBListe {
    private Dugum ilk;

    public CBListe(){
        this.ilk=null;
    }

    public void basaEkle(int deger){
        Dugum yeni=new Dugum(deger);

        if(this.ilk==null){
            this.ilk=yeni;
            return;
        }

        this.ilk.setOnceki(yeni);  //listenin başındakinden önceki eleman yeni değişkeni olur
        yeni.setSonraki(this.ilk);
        
        this.ilk=yeni;

    }


    

    
}
