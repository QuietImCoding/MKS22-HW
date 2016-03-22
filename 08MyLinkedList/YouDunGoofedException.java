public class YouDunGoofedException extends Exception {
    YouDunGoofedException() {
	super("You tried to access an index in the list that doesn't exist yet. Try adding some elements? You should be ashamed of yourself");
    }
    YouDunGoofedException(String message) {
	super(message);
    }
}
