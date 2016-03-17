import java.lang.Object;
import java.util.*;
public class TheMarkov {

	//private final Scanner sc;
	private List<Note> unique; //список уникальных нот, куда будет складываться, после анализа
	private final Melody melody;
	private final int len = melody.notes.size();
	private Object[][] theMatrix = new Object[0][0];
//	public TheMarkov(){
//		sc = new Scanner(System.in);
//	}
//создать класс с данными	
	
	public void run(){
		System.out.println("введите мелодию для анализа");
		Melody melody;		
	}
	
	public void orderNotes() {
		//int len = melody.notes.size();
		int[] arrayOfUnique = arrayOfUnique();
		for(int i=0; i <= arrayOfUnique.length; i++){
			for(int j=0; j <= len; j++){
				if(compareNotes(melody.notes.get(arrayOfUnique[i]), melody.notes.get(arrayOfUnique[j]))){
					//если ноты одинаковы, то надо добавить их в ряд (прежде узнав, не добавлена ли она уже
					//melody.notes.get(i);
					unique.add(melody.notes.get(i));//добавление уникальной ноты в ряд
					arrayOfUnique = removeRepeting(arrayOfUnique, j); //и удаление повторяющейся
				} else{
					unique.add(melody.notes.get(i)); //или добавление обеих уник.нот
					unique.add(melody.notes.get(j));
				}
			}
		}
		//return i;
		//в итоге: в этой функции прошлись по списку нот и отобрали уникальные из них
	}
	
	public void buildMat(){
		int unSize = unique.size();
		theMatrix = new Object[unSize+1][unSize+2];
		theMatrix[0][0] = "The Transition Matrix";
		//добавление данных в первый столбец
		for(int i = 0; i<=unSize; i++){
			theMatrix[i+1][0]=unique.get(i).noteName; 
		}
		//добавление в первую строку
		for(int i = 0; i<=unSize; i++){
			theMatrix[0][i+1]=unique.get(i).noteName; 
		}	
	}
	//эта функция подсчитывает частоты пар
	//если менять порядок матрицы перехода, то вместо melody.notes.get
	//надо создавать список пар, и части в unique - это тоже пары
	//какой должен быть list пар в unique, чтобы можно было делать проверку?
	//на данный момент есть матрица, расчерченная на ноты и частоты переходов
	// 
	public void freqNotes(){
		for(int i=0; i<=len;i++){
			int frRow = 0;
			int frCol = 0;
			for(int j=0;j<=unique.size();j++){
				if(unique.get(j).noteName == melody.notes.get(i).noteName){
					frCol = j+1;
				}
				if(unique.get(j).noteName == melody.notes.get(i+1).noteName){
					frRow = j+1;
				}
				
			}
			theMatrix[frRow][frCol]=+ 1;
		}
	}
	
	
	
	public boolean compareNotes(Note a, Note b){
		boolean ifEq;
		if(
				a.noteName == b.noteName &&
				a.octave == b.octave &&
				a.value == b.value &&
				a.accidental == b.accidental
			){
			return true;
		} else{
			return false;
		} //надо будет добавить возможность определять, по скольким параметрам сравнивать
	}//например, использовать не прямые ссылки, а номера пунктов для сравнения
	
	public int[] arrayOfUnique(){
		int[] arrayOfUnique = new int[len];
		for(int i=0; i < len; i++){
			arrayOfUnique[i]=i;			
		}
		//проверка массива
		//System.out.println(Arrays.toString(arrayOfUnique));
		return arrayOfUnique;
	}
	
	public int[] removeRepeting(int[] a, int c){
		int[] arr = a;
		int[] arr2 = new int[arr.length-1];
		for(int i=0; i < c; i++){
			arr2[i] = arr[i];		
		}
		for(int i=c; i < arr2.length; i++){
			arr2[i] = arr[i+1];
		}
		//System.out.println(Arrays.toString(arr2));		
		return arr2;
	}
}
	
	//идея класса: 
//	- обработать List<Notes>
//	- достать неповторяющююся комбинацию n порядка, сделать из нее матрицу
// для каждой комбинации найти следующую ноту(?), 
	// посчитать частоту перехода
	//заполнить частотами ячейки таблицы перехода
	//далее сделать новый list<Notes> по переходам (это, наверное, отдельная функция)
	//
	

