public class XorQueryDriver{
 public static void main(String[] args) { 
  
 }
}

class XorQueryTools{
  public int[][] queryArray(int[] input, int[][] queries) {
	
	int[][] result = new int[2][2];
	
	int[] prefixXor = findPrefixXor(input);
	int[] prefixSum = findPrefixSum(input);
	
 } 
 
  private int[] findPrefixXor(int[] input){
	int length = input.length;
	if(length == 1){
		return input;
	}
	int[] prefixXor = new int[length];
	prefixXor[0] = input[0];
	for(int loopIndex = 1; loopIndex < length; loopIndex++){
		prefixXor[loopIndex] = prefixXor[loopIndex - 1] ^ input[loopIndex];
	}
	return prefixXor;	
  }
  
  
  private int[] findPrefixSum(int[] input){
	int length = input.length;
	if(length == 1){
		return input;
	}
	int[] prefixSum = new int[length];
	prefixSum[0] = input[0];
	for(int loopIndex = 1; loopIndex < length; loopIndex++){
		prefixSum[loopIndex] = prefixSum[loopIndex - 1] + input[loopIndex];
	}
	return prefixSum;	
  }
}