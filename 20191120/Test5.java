public class Test5{
	public static void main(String[] args){
		outerLabel:for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				System.out.print("["+i+","+j+"]");
				if(i==1&&j==1){
					continue outerLabel;
				}
			}
			System.out.println();
		}
	}
}