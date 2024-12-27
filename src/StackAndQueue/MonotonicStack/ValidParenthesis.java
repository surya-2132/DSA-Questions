package StackAndQueue.MonotonicStack;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String  str = "{[()]}}";
        System.out.println(isValid(str));
    }

    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for(char ch : str.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }
            else{
                //if we have only one char left (which is closing char) then directly return false
                //because without char if we try to pop() it will throw exception -> str start with ), }, ]
                if(stack.isEmpty()) return false;
                char lastPop = stack.pop();
                if(lastPop == '(' && ch == ')' ||
                   lastPop == '[' && ch == ']' ||
                   lastPop == '{' && ch == '}'){
                    continue;
                }else {
                    return false;
                }
            }
        }

        //if empty return true, else false;
        return stack.isEmpty();
    }
}
