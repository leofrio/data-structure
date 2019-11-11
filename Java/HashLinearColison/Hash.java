
public class Hash {
	public static void main(String[] args) {
		Integer[] array=new Integer[20];  
		for(int i=0;i < array.length;i++) { 
			int random=Math.round((int) (Math.random() * 100)); 
			Integer number=new Integer(random);
			int pos=h(random,array.length);  
			if(array[pos] == null) {
				array[pos]=number;
			} 
			else { 
				for(int j=1;true;j++) {
					pos=(h(random,array.length) + j)%array.length; 
					if(array[pos] == null) {
						array[pos]=number;
						break;
					}
				}
			}
		} 
		for(int i=0;i< array.length;i++) { 
			System.out.print(array[i].intValue() + ",");
		}
	}
	public static int h(int pos,int length) {
		int hash=pos % length;
		return hash;
	}
}
