public class App {
    public static void main(String[] args) throws Exception {
        expTree expT=new expTree();
        expT.createExpressionTree("432+/ak-*");
        // 4/(3+2)*(a-k)

        expT.inOrderTraverse(expT.root);
        System.out.println();
        expT.postOrderTraverse(expT.root);
        System.out.println();
        expT.preOrderTraverse(expT.root);

        ikiliAramaAgac myTree=new ikiliAramaAgac();
        myTree.ekle(10);
        myTree.ekle(10);
        myTree.ekle(5);
        myTree.ekle(7);
        myTree.ekle(20);
        myTree.ekle(30);
        myTree.ekle(25);
        myTree.kokOrtadaDolas(myTree.kok);

    }
}
