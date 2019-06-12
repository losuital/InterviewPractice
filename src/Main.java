import com.di.wang.datastructure.BST;

public class Main
{
    public static void main(String[] args)
    {
        BST.Node root = BST.initNode(10);
        BST.insert(root, 9);
        BST.insert(root, 20);
        BST.insert(root, 21);
        BST.insert(root, 19);
        BST.insert(root, 19);
        BST.insert(root, 19);
        BST.insert(root, 19);

        System.out.println(BST.search(root, 10));

        System.out.println(BST.printNode(root));
    }
}
