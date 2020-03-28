给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。

例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。

对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。

那么成功对给定单词列表进行编码的最小字符串长度是多少呢？

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/short-encoding-of-words
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words,(s1,s2)->(s2.length()-s1.length()));
        int res=0;
        Trie t=new Trie();
        for(String word:words){
            res+=t.insert(word);
        }
        return res;
    }
}

class Node{
    int val;
    Node[] child=new Node[26];
    public Node(){
    }
    public Node(int val){
        this.val=val;
    }
}

class Trie{
    Node root=new Node();
    public int insert(String s){
        Node cur=root;
        boolean isNew=false;
        for(int i=s.length()-1;i>=0;i--){
            int c=s.charAt(i)-'a';
            if(cur.child[c]==null){
                isNew=true;
                cur.child[c]=new Node(c);
            }
            cur=cur.child[c];
        }
        return isNew?s.length()+1:0;
    }
}



在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。

给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/k-th-symbol-in-grammar
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int kthGrammar(int N, int K) {
        if(N==1&&K==1){
            return 0;
        }
        int a=kthGrammar(N-1,(K+1)/2);
        int b=a^1;
        if(K%2==1){
            return a;
        }
        return b;
    }
}

class Solution {
    public int kthGrammar(int N, int K) {
        if(N==1){
            return 0;
        }
        int half=(1<<(N-1))/2;
        if(K<=half){
            return kthGrammar(N-1,K);
        }
        return 1^kthGrammar(N-1,K-half);
    }
}

