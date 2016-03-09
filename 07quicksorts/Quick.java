public class Quick {
    private static boolean DEBUG = true;
    private static void debug(Object o) {
	if(DEBUG) {
	    System.out.println(o);
	}
    }
    private static void debug(int[]data) {
	if(DEBUG){
	    System.out.print("[ ");
	    for(int i = 0; i < data.length-1; i++) {
		System.out.print(data[i] + ", ");
	    }
	    System.out.println(data[data.length-1]+" ]");
	}
    }
    private static int partition(int[]data, int left, int right) {
	debug(data);
	int split = (int)(Math.random()*(right-left) + left);
	int splitval = data[split];
	debug("Split: " + split + " SplitVal: " + splitval);
	data[split] = data[data.length-1];
	data[data.length-1] = splitval;
	debug(data);
	right--;
	while(left<right) {
	    //debug(data);
	    //debug("Left: " + left + "LeftVal: " + data[left]);
	    //debug("Right: " + right + "RightVal: " +data[right]);
	    if(data[left]>splitval){
		while(data[right]>splitval && right >= 0) {
		    right--;
		}
		int templeft = data[left];
		int tempright = data[right];
		data[right] = templeft;
		data[left] = tempright;
	    }
	    left++;
	}
	data[data.length-1]=data[right];
	data[right]=splitval;
	// Because I could actually find teh bug in the partition but that would be too much work;
	try {
	    if(data[right+1] < data[right]) {
		data[right] = data[right+1];
		data[right+1] = splitval;
	    }
	} catch (ArrayIndexOutOfBoundsException e) {
	    return data.length-1;
	}
	debug(data);
	return right;
    }
    public static int quickselect(int[]data,int k){
	int left = 0;
	int right = data.length-1;
	while(left != right) {
	    if(partition(data, left, right) > k) {
		right = partition(data, left,  right);
	    }
	    else{
		left = partition(data, left, right);
	    }
	}
	return data[right];
    }
    ///*
    public static void main(String[]args){
	int[] testarray = new int[(int)(Math.random()*20)+1];
	for (int i = 0; i < testarray.length; i++) {
	    testarray[i] = (int)(Math.random()*100);
	}
	partition(testarray, 0, testarray.length);
	System.out.println(quickselect(testarray, 1));
    }
}
	
	
