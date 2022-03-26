public class TrieNode
{
    TrieNode[] children;
    boolean isEnd;
    TrieNode parent;
    int count;
    TrieNode()
    {
        this.children = new TrieNode[26];
        this.isEnd = false;
        this.count = 0;
        this.parent = null;
    }
}
