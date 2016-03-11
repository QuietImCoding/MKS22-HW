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
    private static void swap(int[]data, int a, int b) {
	int temp = data[b];
	data[b] = data[a];
	data[a] = temp;
    }
    private static int partition(int[]data, int left, int right) {
	int split = left + (int)(Math.random()*(right-left+1));
	int splitval = data[split];
	debug("Split: " + split + " SplitVal: " + splitval);
	swap(data, left, split);
	while(left<right) {
	    debug(left);
	    if(data[left]<splitval) {
		right--;
	    } else {
		swap(data, left, right);
		left++;
	    }
	}	
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
	debug(testarray);
	partition(testarray, 0, testarray.length);
	//swap(testarray, 0, testarray.length-1);
	debug(testarray);
	//System.out.println(quickselect(testarray, 1));
    }
}
	
	
