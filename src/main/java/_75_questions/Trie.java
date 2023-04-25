package _75_questions;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    Node node = new Node();

    public Trie() {

    }

    public void insert(String word) {
        insertHelper(word,node,0);
    }

    public void insertHelper(String word, Node parent, int indexOfWord) {
        if(indexOfWord == word.length()) {
            parent.isEndWord = true;
            return;
        }
        char c = word.charAt(indexOfWord);
        List<Node> childs = parent.childs;
        boolean isExisting = false;
        for (Node children : childs) {
            if (c == children.character) {
                isExisting = true;
                insertHelper(word, children, indexOfWord + 1);
            }
        }
        if(!isExisting) {
            Node newChildren = new Node();
            newChildren.character = c;
            parent.childs.add(newChildren);
            insertHelper(word, newChildren, indexOfWord + 1);
        }

    }

    public boolean search(String word) {
        return false;
    }

    public boolean startsWith(String prefix) {
        return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("ask");
        trie.search("apple");
    }
}

class Node {
    char character = ' ';
    List<Node> childs = new ArrayList<>();

    boolean isEndWord = false;

    public Node() {

    }

    public Node(char character, List<Node> childs) {
        this.character = character;
        this.childs = childs;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }
}