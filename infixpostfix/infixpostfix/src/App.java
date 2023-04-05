import java.util.Stack;

public class App {

    public static int oncelik (char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static String infix2Postfix(String infixIfade){
        Stack <Character> s=new Stack<>();
        String postIfade="";
        for(int i=0; i< infixIfade.length() ;i++){
            char c=infixIfade.charAt(i);
            System.out.println(c);
            if(oncelik(c) >0 ) { // c bir operatör ise
               //yiğin işlemleri yapılacak
                while (!s.isEmpty() && (oncelik(c) <= oncelik(s.peek()))){
                    postIfade=postIfade + s.pop();
                }
                s.push(c);
            }
            else{
                //postfix ifadeye ekle
                postIfade=postIfade + c;
            }
        }
        int sBoyut=s.size();
        if(sBoyut >0){   //yiğinda kalanları postfix ifadeye ekle
            for(int i=0; i<sBoyut; i++){
                postIfade=postIfade + s.pop();
            }
        }
        return postIfade;
    }


    public static void main(String[] args) throws Exception {
        String infixIfade="12 + 5 * 3  - 20";

        System.out.println(infix2Postfix(infixIfade));
        


    }
}
