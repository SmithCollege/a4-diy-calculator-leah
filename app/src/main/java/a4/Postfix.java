package a4;

import java.util.ArrayDeque;

// For Phase 2, you will join the "No Equals" team (see the vintage Hewlett Packard postfix-enthusiast hat in the photo above) and use `Postfix.java` to calculate the solution to a postfix equation.
// For example, "3 2 + 5 \*" corresponds to (3+2)\*5 in our standard infix notation. 

// The first step in processing the input expression will be to parse the tokens and store them in a queue (see Phase 1 above).
// Once you have done that, use the algorithm below to compute the value of the postfix expression:

// * Take a token one at a time from the queue and process it as follows:
//   * If the token is a **number**, `push(...)` it onto the stack
//   * If the token is an **operator**, `pop()` two numbers off the stack, combine them using the **operator**, and `push(...)` the result back onto the stack
// * Once all the tokens have been processed in this way, the stack should contain exactly one element: the result.

// If the stack runs out of elements needed for processing an operator, or if there are too many items on the stack at the end, then the starting expression was malformed and you should throw an exception to report the error.
// The tests assume that you will throw an `IllegalArgumentException` in these cases.

// You should implement this method as a method called `postfix` within the `Postfix.java` class.
// Make sure your postfix calculator is passing all of the tests in the `PostfixTest` class before you move on to Phase 3.

//*Note: Remember that the first `Double` you pop will be the second number in your equation.*
public class Postfix {

    public static Double postfix(ArrayDeque<Object> tokens) {
       ArrayDeque<Double> stack = new ArrayDeque<>();
       
        
        while(!tokens.isEmpty()){
          Object token = tokens.pop();
          if(token instanceof Double){
            stack.push((Double) token);
          }
          else if(token instanceof Character){
            if(stack.size() < 2) {
              throw new IllegalArgumentException("Not enough operands in stack");
            }
            Double secondNum = stack.pop(); 
            Double firstNum = stack.pop(); 
            switch ((Character) token) {
              case '+':
                stack.push(firstNum + secondNum);
                break;
              case '-':
                stack.push(firstNum - secondNum);
                break;
              case '*':
                stack.push(firstNum * secondNum);
                break;
              case '/':
                stack.push(firstNum / secondNum);
                break;
              default:
                throw new IllegalArgumentException("Invalid operator: " + token);
            }
          } 
        }
        if(stack.size() != 1){
          throw new IllegalArgumentException("Too many operands in stack");
        }
       
       
       return queue.pop();
    
    
    
    }
public static void main(String[] args) {

}









}