public class Recursion {

    public String name() {
	return "Monteagudo,Daniel";
    }

    public double sqrt(double n) {
	if (n > 0) {
	    return pleaseHelpMeSquareRootsAreHardOMG(n, n/2);
	}
	return 0;
    }

    public double pleaseHelpMeSquareRootsAreHardOMG(double n, double guess) {
	if (Math.abs((guess * guess)-n) < .0000001 * n) {
	    return guess;
	} else {
	    return pleaseHelpMeSquareRootsAreHardOMG(n, (n/guess + guess) / 2);
	}
    }
}
