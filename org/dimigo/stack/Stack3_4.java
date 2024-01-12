package org.dimigo.stack;

import java.util.Stack;

// 중위식 표기법을 후위식 표기법으로 변환하기
public class Stack3_4 {
    // 연산자 우선순위 반환하는 메소드
    public int getPriority(char op) {
        switch (op) {
            case '*': case '/':
                return 3;
            case '+': case '-':
                return 2;
            case '(':
                return 1;
        }
        return -1;
    }

    // 연산자 우선순위 비교하는 메소드
    // op1의 우선순위가 같거나 높으면 true, 낮으면 false를 반환
    public boolean isProceed(char op1, char op2) {
        int op1Priority = getPriority(op1);
        int op2Priority = getPriority(op2);

        return op1Priority >= op2Priority ? true : false;
    }

    // 중위표기법을 후위표기법으로 변환하는 메소드
    public String convertInfixToPostFix(String exp) {
        Stack<Character> stack = new Stack<>();
        int len = exp.length();
        String postFix = "";
        boolean beforeNum = false;

        for (int i = 0; i < len; i++) {
            char ch = exp.charAt(i);
            if (ch >= '0' && ch <= '9') {
                postFix += ch;
                beforeNum = true;
            } else {
                if (ch != ' ' && beforeNum) {
                    //postFix += ' ';
                    beforeNum = false;
                }
                switch (ch) {
                    case '(':
                        stack.push(ch);
                        break;

                    case ')':
                        while (true) {
                            char pop = stack.pop();
                            if (pop == '(')
                                break;
                            postFix += pop;
                            //postFix += ' ';
                        }
                        break;

                    case '+':
                    case '-':
                    case '*':
                    case '/':
                        while (!stack.isEmpty() && isProceed(stack.peek(), ch)) {
                            postFix += stack.pop();
                            //postFix += ' ';
                        }
                        stack.push(ch);
                        break;
                }
            }
        }

        while (!stack.isEmpty()) {
            //postFix += ' ';
            postFix += stack.pop();
        }

        return postFix;
    }

    public static void main(String[] args) {
        Stack3_4 s = new Stack3_4();
        String expr = s.convertInfixToPostFix("1/2*(3+4)+5");
        System.out.println(expr);
    }
}
