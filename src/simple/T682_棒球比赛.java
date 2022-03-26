package simple;

import java.util.Stack;

public class T682_棒球比赛 {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int last = 0;
        int cur = 0;
        for(String os : ops) {
            if (os.equals("+")) {
                cur = last + cur;
                last = cur - last;
                stack.add(cur);
            } else if (os.equals("D")) {
                last = cur;
                cur = cur * 2;
                stack.add(cur);
            } else if (os.equals("C")) {
                stack.pop();
                cur = stack.isEmpty() ? 0: stack.pop();
                last = stack.isEmpty() ? 0 : stack.peek();
                stack.add(cur);
            } else {
                last = stack.isEmpty()?0:stack.peek();
                stack.add(Integer.valueOf(os));
                cur = stack.peek();
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }
}
