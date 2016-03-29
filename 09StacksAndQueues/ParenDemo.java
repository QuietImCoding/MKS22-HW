public class ParenDemo {

    public static void main(String[]args){
	String input = "()()(([[]]))";
	if(args.length > 0){
	    input = args[0];
	    System.out.println( isMatching(input)); 
	}else{
	    System.out.println("Usage:"); 
	    System.out.println("java ParenDemo \"text\""); 
	}
    }

    public static boolean isOpposite(char a, char b) {
	return (a == '(' && b==')' || a == ')' && b=='('||
		a == '[' && b==']' || a == ']' && b=='['||
		a == '{' && b=='}' || a == '}' && b=='{');
    }

    public static boolean isMatching(String s) {
	MyStack<Character> Stack = new MyStack<Character>();

	for(int i = 0; i < s.length(); i++) {
	    char c = s.charAt(i);
	    if(c=='('||c=='{'||c=='['){
		Stack.push(s.charAt(i));
	    }
	    if(isOpposite(Stack.peek(), c)){
		Stack.pop();	    
	    }
	}
	return Stack.isEmpty();
    }
}
