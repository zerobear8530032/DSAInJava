//211. Design Add and Search Words Data Structure
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Design a data structure that supports adding new words and finding if a string matches any previously added string.
//
//Implement the WordDictionary class:
//
//WordDictionary() Initializes the object.
//void addWord(word) Adds word to the data structure, it can be matched later.
//bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
//
//
//Example:
//
//Input
//["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//Output
//[null,null,null,null,false,true,true,true]
//
//Explanation
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // return False
//wordDictionary.search("bad"); // return True
//wordDictionary.search(".ad"); // return True
//wordDictionary.search("b.."); // return True
//
//
//Constraints:
//
//1 <= word.length <= 25
//word in addWord consists of lowercase English letters.
//word in search consist of '.' or lowercase English letters.
//There will be at most 2 dots in word for search queries.
//At most 104 calls will be made to addWord and search.
package PrefixTree.util;


import java.util.HashMap;

// approch we can use tries to store each and every word
//when searching if the '.' comes we check every single character at that level
//other wise we check is current character present
//time complexity : o(n)
//space complexity : o(n)
class WordDictionary {

    private Trie trie ;
    public WordDictionary() {
        trie= new Trie();
    }
    public void addWord(String word) {
        trie.insert(word);
    }
    public boolean search(String word) {
        return helper(word,0,trie.getRoot());
    }

    private boolean helper(String word , int idx , PrefixTreeNode root){
        if(idx==word.length()){
            return root.isEnd;
        }
        char ch = word.charAt(idx);
        if(ch!='.'){
            HashMap<Character,PrefixTreeNode> childrens= root.childrens;
            if(childrens.containsKey(ch)){
                return helper(word,idx+1,childrens.get(ch));
            }else{
                return false;
            }
        }else{
            HashMap<Character,PrefixTreeNode> childrens= root.childrens;
            for(Character key : childrens.keySet()){
                if(helper(word,idx+1,childrens.get(key))){
                    return true;
                }
            }
            return false;
        }
    }
}

public class DesignAddAndSearchWordsDataStructure_211 {
    public static void main(String[] args) {

    }
}
