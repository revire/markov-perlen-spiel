
import java.util.*;
public class Note {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		данный класс описывает саму ноту. 
//		представление ноты: 
//			1-8 - название ноты, где 8 - пауза
//			octave (0...7)
//			accidental(), где 8 пауза 1 flat 2 бемоль 3 диез
//			note_value
//				semibreve целая
//				minima половинная
//				semiminima четвертная
//				croma восьмая 
//				semisroma шестнадцатая
//				biscroma тридцатьвторая
//		сделаю паузу нотой!  
	}

		int noteName;
		int octave;
		String value;
		int accidental;
		
		
		Note(int a, int b, String c, int d){
			noteName = a;
			octave = b;
			value = c;
			accidental = d; 
		}
		


}
