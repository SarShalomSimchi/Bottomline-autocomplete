package com.bottomline.app.autocomplete.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import lombok.NonNull;

public class Dictionary {
	
	private static class Node {
        Map<Character, Node> children;
        char c;
        boolean isWord;
 
        public Node() {
        	children = new HashMap<>();
        }
        
        public Node(char c) {
            this.c = c;
            children = new HashMap<>();
        }
 
        public void insert(String word) {
            if (StringUtils.isEmpty(word))
                return;
            
            char firstChar = word.charAt(0);
            Node child = children.computeIfAbsent(firstChar, v -> new Node(firstChar));
            
            if (word.length() > 1)
                child.insert(word.substring(1));
            else
                child.isWord = true;
        }
    }
 
    private Node root;
 
    public Dictionary(@NonNull List<String> words) {
        root = new Node();
        words.forEach(root::insert);
    }
 
 
    public List<String> autoComplete(String prefix) {
        List<String> words = new ArrayList<>();
        StringBuffer word = new StringBuffer();
        Node lastNode = root;
        
        for (char c : prefix.toCharArray()) {
            lastNode = lastNode.children.get(c);
            if (lastNode == null)
                return words;
            
            word.append(c);
        }
        
        findSuccessorWords(lastNode, words, word);
        
        return words;
    }
   
 
    private void findSuccessorWords(Node currNode, List<String> words, StringBuffer word) {
        if (currNode.isWord) {
            words.add(word.toString()); 
        }
 
        if (isHasNoChildren(currNode))
            return;
        
        currNode.children.values().forEach(child -> {
        	findSuccessorWords(child, words, word.append(child.c));
            word.setLength(word.length() - 1);
        });
    }


	private boolean isHasNoChildren(Node root) {
		return root.children == null || root.children.isEmpty();
	}
}
