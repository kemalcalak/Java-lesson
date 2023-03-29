public class App {

    public static void main(String[] args) {
        yigin myStack = new yigin(5);

        if (myStack.isEmpty()) {
            System.out.println("Yığın boş!");
        }
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);

        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println("Yığın boyutu:" + myStack.size());

        myStack.push(40);
        myStack.push(50);
        myStack.push(60);
        myStack.push(70);

        if (myStack.isFull()) {
            System.out.println("Yığın dolu!");
        }
        myStack.push(80);
        System.out.println("Yığın boyutu:" + myStack.size());
    }

}
