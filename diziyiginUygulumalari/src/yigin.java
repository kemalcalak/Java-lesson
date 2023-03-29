public class yigin {
    private int yiginDizi[];
    private int yiginIndex;
    private int yiginBoyut;

    public yigin(int boyut) {
        this.yiginBoyut = boyut;
        this.yiginDizi = new int[this.yiginBoyut];
        this.yiginIndex = -1;
    }

    public boolean isEmpty() {
        return (this.yiginIndex == -1);
    }

    public boolean isFull() {
        return (this.yiginIndex == this.yiginBoyut - 1);
    }

    public int size(){
        return this.yiginIndex + 1;
    }

    public boolean push(int deger){
        if (this.isFull()) {
            System.out.println("Yığın dolu!");
            return false;
        }
        this.yiginIndex++;
        this.yiginDizi[this.yiginIndex] = deger;
        return true;
    }

    

    public int pop(){
        if (this.isEmpty()) {
            System.out.println("Yığın boş!");
            return -1;
        }
        int deger = this.yiginDizi[this.yiginIndex];
        this.yiginIndex--;
        return deger;
    }

    public int peek(){
        if (this.isEmpty()) {
            System.out.println("Yığın boş!");
            return -1;
        }
        return this.yiginDizi[this.yiginIndex];
    }

    
}
