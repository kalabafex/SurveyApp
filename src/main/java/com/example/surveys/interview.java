package com.example.surveys;

import java.util.Stack;

public class interview {

    public static void main(String[] args) {
        String input1 = "{[()]}";
        String input2 = "{[)]}";
        String input3 = "";

        System.out.println( areBracesMatching(input1));

    }

    public static String areBracesMatching(String input) {
        if (input != null && !input.isEmpty()) {
            Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return "First input cannot be closing bracet";
                }
                char lastBrace = stack.pop();
                if (!isMatchingPair(lastBrace, ch)) {
                    return "Input has Non-matching braces";
                }
            }
        }
        return "Input has Matching braces)";
    }
    return "Input is invalid";
    }

    private static boolean isMatchingPair(char opening, char closing){
        return  (opening == '(' && closing == ')') ||
                (opening == '{' && closing == '}') ||
                (opening == '[' && closing == ']');
    }

}
