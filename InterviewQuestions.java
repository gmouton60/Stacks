//Student Name: Gerald Mouton
//LSU ID: 894569516
//Lab Section: 1
//Assignment:Lab 9
//Submission Time: 5:00

package interviewquestions;
import java.util.*;
public class InterviewQuestions {

    public static void main(String[] args) {
        //Tests isPalendrome
        System.out.println(isPalendrome("Racecar"));
        System.out.println(isPalendrome("steve"));
        //Tests isBalancedEquation
        System.out.println(isBalancedExpression("{}{}({()})") );
        System.out.println(isBalancedExpression("((){}{}") );
        //Tests EvaluateExpression
        System.out.println(EvaluateExpression("42+351-*+"));
        System.out.println(EvaluateExpression("545*+5/"));
    }
    
    //determines whether or not a string is a palendrome
    public static boolean isPalendrome(String input){
        char[] chars = input.toCharArray();
        Stack<Character> myStack = new Stack<>();
        //push the entire word onto the stack
        for(int i = 0; i < chars.length; i++){
            myStack.push(chars[i]);
        }
        String reverse = "";
        //pop the entire word off the stack so it is now in reverse order
        for(int i = 0; i< chars.length; i++){
            reverse+= myStack.pop();
        }
        //if forward and reverse are the same it is a palendrome
        if(input.toLowerCase().equals(reverse.toLowerCase()))
            return true;
        return false;
    }
    
    //determines whether an equation has balanced parentheses and brackets
    public static boolean isBalancedExpression(String expression){
        char[] chars = expression.toCharArray();
        Stack<Character> myStack = new Stack<>();
        
        //if it is a ( or { put it on the stack
        for(int i = 0; i<chars.length; i++){
            if(chars[i] == '(' || chars[i] == '{')
                myStack.push(chars[i]);
            //if it is a ) or } pop off the stack
            else if(chars[i] == ')' || chars[i] == '}'){
                char op = myStack.pop();
                //the character popped must correspond to the ) or } that was popped
                if((op == '(' && chars[i] != ')')|| (op == '{' && chars[i] != '}')){
                    return false;
                }
            }
        }
        //if the stack is empty at the end it is balanced
        if(myStack.isEmpty())
            return true;
        return false;
    }
    
    public static int EvaluateExpression(String expression){
        char[] chars = expression.toCharArray();
        Stack<Integer> myStack = new Stack<>();
        //push digits in the expression on to the stack
        for(int i = 0; i<chars.length; i++){
            if(Character.isDigit(chars[i])){
                myStack.push(Character.getNumericValue(chars[i]));
            }
            //get the numbers and perform the next operation on those two numbers
            else if(chars[i]== '+' || chars[i]== '-' || chars[i]== '*' || chars[i]== '/'){
                int num1 = myStack.pop();
                int num2 = myStack.pop();
                if(chars[i] == '+')
                    myStack.push(num2+num1);
                if(chars[i] == '-')
                    myStack.push(num2-num1);
                if(chars[i] == '*')
                    myStack.push(num2*num1);
                if(chars[i] == '/')
                    myStack.push(num2/num1);
            }
        }
        //return the value left in the stack as this is the solution
        return myStack.pop();
    }
}
