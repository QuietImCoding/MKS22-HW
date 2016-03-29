public class ParenDemo {
    public static void main(String[]args) {
	System.out.println("not done yet");
    }

    public static boolean isOpposite(char a, char b) {
	return (a == '(' && b==')' || a == ')' && b=='('||
		a == '[' && b==']' || a == ']' && b=='['||
		a == '{' && b=='}' || a == '}' && b=='{');
    }

    public static boolean isMatching(String s) {
	MyStack<char> Stack = new MyStack<char>();

	for(int i = 0; i < s.length(); i++) {
	    if (s.charAt(i)=='('||s.charAt(i)==')'||
		s.charAt(i)=='['||s.charAt(i)==']'||
		s.charAt(i)=='{'||s.charAt(i)=='}'){
		if(Stack.push
		Stack.push(s.charAt(i));
	    }
	}

	while(Stack.size()>0 && Stack.size()%2==0){
	    char current = Stack.pop();
	    if (Stack.peek().isOpposite(current)) {
		Stack.pop();
	    }
	}
	
    }
}
