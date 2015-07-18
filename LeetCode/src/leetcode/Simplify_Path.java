package leetcode;

import java.util.Stack;

/**
 *
 * @author Sunshine
 */
public class Simplify_Path {
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String array[] = path.split("/");
        for (int i = 0; i < array.length; i++){
            String str = array[i].trim();
            if(str.length() != 0 && !str.equals(".")){
                if (str.equals("..")){
                    if (!stack.empty())
                        stack.pop();
                }
                else{
                    stack.push(str);
                }
            }
        }
        if (stack.size() == 0)
            return "/";
        System.out.println(stack.size());
        StringBuilder str = new StringBuilder();
        while (stack.size() > 0){
            str.insert(0, stack.pop());
            str.insert(0, "/");
        }
        return str.toString();
    }
    
    public static void main(String[] args) {
        String path = "/abc/...";
        System.out.println(simplifyPath(path));
    }
}
