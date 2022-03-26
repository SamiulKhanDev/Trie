import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Trie trie = new Trie();
        Scanner scan = new Scanner(System.in);
        while (true)
        {
            String str = scan.nextLine();
            String[] arr = str.split(" ");
            String word = arr[1];
            if(arr[0].equals("insert"))
            {
                trie.insert(word);
            }
            else if(arr[0].equals("search"))
            {
                System.out.println(trie.search(word));
            }
            else if(arr[0].equals("startsWith"))
            {
                System.out.println(trie.startsWith(word));
            }
            else if(arr[0].equals("startsWithCount"))
            {
                try {
                    System.out.println(trie.startsWithCount(word));
                }catch (NullPointerException e)
                {
                    System.out.println("No words Starts with the given prefix");
                }
            }
            else if(arr[0].equals("delete"))
            {
                try
                {
                    trie.deleteWord(word);
                    System.out.println("word has been deleted");
                }catch (NullPointerException e)
                {
                    System.out.println(e);
                }

            }
            else if(arr[0].equals("update"))
            {
                trie.update(arr[1],arr[2]);
            }
        }

    }
}
