public class Recursion {

    public String name() {
	return "Monteagudo,Daniel";
    }

    public double sqrt(double n) {
	return pleaseHelpMeSquareRootsAreHardOMG(n, n/2);
    }

    public double pleaseHelpMeSquareRootsAreHardOMG(double n, double guess) {
	if (Math.abs((guess * guess)-n) < .0000001 * n) {
	    return guess;
	} else {
	    return pleaseHelpMeSquareRootsAreHardOMG(n, (n/guess + guess) / 2);
	}
    }
}
