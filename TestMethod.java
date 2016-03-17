import java.util.*;
public class TestMethod {

	final List<Integer> unique = new ArrayList<Integer>(Arrays.asList());
	final ArrayList<Integer> mel = new ArrayList<Integer>(Arrays.asList());
//	int ae = 2;
//	mel.add(ae);
	// melody.add(4);
	// melody.add(3);
	// melody.add(8);
	// melody.add(5);
	// melody.add(4);
	// melody.add(6);
	// melody.add(2);
	// melody.add(5);
	// melody.add(3);
	// melody.add(6);
	// melody.add(1);
	// melody.add(0);


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(arrayOfUnique());
		int arr[] = new int[] {1, 2, 3, 5, 7, 3, 6, 8, 9, 4, 5, 6, 7, 8, 9, 10};
		int a = 4;//при чем здеь перменная а?
		removeRepeting(arr, a);

	}
	
	
	public boolean compareNotes(Integer a, Integer b){
		//boolean ifEq;
		if(
				a == b
			){
			return true;
		} else{
			return false;
		} //надо будет добавить возможность определять, по скольким параметрам сравнивать
	}//например, использовать не прямые ссылки, а номера пунктов для сравнения

	//public static int[] arrayOfUnique(){
	public static int[] arrayOfUnique(ArrayList<Integer> m){		
		//Melody melody = a;
		int len = 10;
		int[] arrayOfUnique = new int[len];
		for(int i=0; i < len; i++){
			arrayOfUnique[i]=i;
			System.out.println(i);
			
		}
		System.out.println(Arrays.toString(arrayOfUnique));
		return arrayOfUnique;
	}

		public static int[] removeRepeting(int[] a, int c){
			int[] arr = a;
			int[] arr2 = new int[arr.length-1];
			for(int i=0; i < c; i++){
				arr2[i] = arr[i];		
			}
			for(int i=c; i < arr2.length; i++){
				arr2[i] = arr[i+1];
			}
			System.out.println(Arrays.toString(arr2));		
			return arr2;
		}

	public  void orderNotes(ArrayList<Integer> m) {
		//Melody melody = m;
		int len = mel.size();
		int[] arrayOfUnique = arrayOfUnique(m);
		for(int i=0; i <= arrayOfUnique.length; i++){
			for(int j=0; j <= len; j++){
				if(compareNotes(mel.get(arrayOfUnique[i]), mel.get(arrayOfUnique[j]))){
					//если ноты одинаковы, то надо добавить их в ряд (прежде узнав, не добавлена ли она уже
					//melody.notes.get(i);
					unique.add(mel.get(i));//добавление уникальной ноты в ряд
					arrayOfUnique = removeRepeting(arrayOfUnique, j); //и удаление повторяющейся
				} else{
					unique.add(mel.get(i)); //или добавление обеих уник.нот
					unique.add(mel.get(j));
				}
			}
		}
}
	
	
}