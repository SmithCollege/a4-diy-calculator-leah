package a4;

import java.util.ArrayDeque;

public class Infix {

    public static Double infixToPostfix(ArrayDeque<Object> tokens) {
        Object token = tokens.pop(); 
        ArrayDeque<Object> outputStack = new ArrayDeque<>();
        ArrayDeque<Object> opStack = new ArrayDeque<>();

        if( token instanceof Double){
            outputStack.push(token);
        
        }
        else if (token instanceof Character) {
            while (!opStack.isEmpty()) {
                    if (pemdas((Character) token) > pemdas((Character) opStack.peek())) {
                        outputStack.push(opStack.pop());
                    } else {
                        outputStack.push(token);
                    }
                    if (token.equals('(')) {
                        opStack.push(token);
                    }
                    else if (token.equals(')')) {
                    while (!opStack.peek().equals('(')) {
                        outputStack.push(opStack.pop());
                    }
                    opStack.pop();
                }

            
            }

        }

        
        
        
    }

    private static int pemdas(Character operator){
        switch (operator) {
            case '(':
                return 0;
            case '^':
                return 1;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 3;
            default:
                return 4;
        }
    }
}

