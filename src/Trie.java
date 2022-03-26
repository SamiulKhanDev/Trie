public class Trie
{
    private TrieNode root;
    Trie()
    {
        this.root = new TrieNode();
    }

    public void insert(String word)
    {
        TrieNode curr = this.root;
        int len = word.length();
        for(int i = 0;i<len;i++)
        {
            char ch = word.charAt(i);
            if(curr.children[ch-'a']==null)
            {
                TrieNode nn = new TrieNode();
                nn.parent = curr;
                curr.children[ch-'a'] = nn;
            }
            curr.children[ch-'a'].count++;
            curr = curr.children[ch-'a'];
        }

        curr.isEnd = true;

    }
    public boolean search(String word)
    {
        TrieNode curr = this.root;
        int len = word.length();
        for(int i = 0;i<len;i++)
        {
            char ch = word.charAt(i);
            if(curr.children[ch-'a']==null)
            {
                return false;
            }
            curr = curr.children[ch-'a'];
        }

        return curr.isEnd;
    }

    public boolean startsWith(String word)
    {
        TrieNode curr = this.root;
        int len = word.length();
        for(int i = 0;i<len;i++)
        {
            char ch = word.charAt(i);
            if(curr.children[ch-'a']==null)
            {
                return false;
            }
            curr = curr.children[ch-'a'];
        }

        return true;
    }

    public int startsWithCount(String word)
    {
        TrieNode curr = this.root;
        int len = word.length();
        for(int i = 0;i<len;i++)
        {
            char ch = word.charAt(i);
            curr = curr.children[ch-'a'];
        }

        return curr.count;
    }
    public void deleteWord(String word)
    {
        if(startsWith(word))
        {
            TrieNode curr = this.root;
            int len = word.length();
            for(int i = 0;i<len;i++)
            {
                char ch = word.charAt(i);
                curr.children[ch-'a'].count--;
                curr = curr.children[ch-'a'];
            }

            deleteWordHelper(curr,word);

        }
        else
        {
            throw new NullPointerException("No word present");
        }
    }

    public void update(String word,String newWord)
    {
        try
        {
            deleteWord(word);
            insert(newWord);
            System.out.println("Word Updated");
        }catch (NullPointerException e)
        {
            System.out.println(e);
        }

    }

    private void deleteWordHelper(TrieNode curr,String word)
    {
        int len = word.length();

        for(int i = len-1;i>=0;i--)
        {
            TrieNode parent = curr.parent;
            char ch = word.charAt(i);
            if(parent.children[ch-'a'].count==0)
            {
                parent.children[ch-'a']=null;
                curr = parent;
            }
            else
            {
                break;
            }

        }
    }
}
