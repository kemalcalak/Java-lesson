public class ikiliAramaAgac {
    public ikiliAgacDugum kok;

    public ikiliAramaAgac(){
        this.kok=null;
    }

    public void ekle(int deger){
        ikiliAgacDugum yeni=new ikiliAgacDugum(deger);

        if(this.kok == null){
            this.kok=yeni;
            System.out.println("Kok:" + deger);
            return;
        }

        ikiliAgacDugum parent=null;
        ikiliAgacDugum temp=this.kok;

        while(true){
            parent=temp;
            if(deger < temp.veri){
                temp=temp.sol;
                if(temp==null){
                    parent.sol=yeni;
                    System.out.println("Parent:" + parent.veri + "  soluna " + yeni.veri + "  eklendi");
                    return;
                }
            }
            else if(deger > temp.veri){
                temp=temp.sag;
                if(temp==null){
                    parent.sag=yeni;
                    System.out.println("Parent:" + parent.veri + "  sağına " + yeni.veri + "  eklendi");
                    return;
                }
            }
            else{
                System.out.println("Bu değer var");
                return;
            }


        }
    }


    public void kokOrtadaDolas(ikiliAgacDugum localRoot){
        if(localRoot != null){
            kokOrtadaDolas(localRoot.sol);
            localRoot.yazdir();
            kokOrtadaDolas(localRoot.sag);
        }
    }




    
}
