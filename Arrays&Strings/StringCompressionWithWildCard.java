/*
Quizá los que han practicado sus habilidades con coding excercises, se hayan topado con el problema de "string compression" utilizando el algoritmo de compresión RLE (run-length encoding), en el que tienes que comprimir un string donde encuentres 2 o más caracteres repetidos. Por ejemplo:
AAABCCCCXPP => 3AB4CX2P
AAAAAAAAAAABXXAAAAAAAAAA => 11AB2X10A
Hace poco, como parte de reclutamiento de una empresa, hice un exámen técnico donde me encontré con una variación interesante de este ejercicio. La variante del ejercicio sugería que eliminando ciertos caracteres antes de comprimir, podríamos obtener una mejor compresión. En el 2do ejemplo de arriba, podemos observar que al quitar el substring BXX el resultado de la compresión final sería 21A.
Entonces, el ejercicio iba más o menos así: Dado un string S y un entero K regresa el mínimo length posible de la representación comprimida de S después de remover K caracteres consecutivos de S.
Ejemplos:
Dado S = ABBBCCDDCCC y K = 3 la función debe regresar 5, ya que después de remover el substring DDC de S nos quedaría ABBBCCCC que al comprimirlo resulta A3B4C de longitud 5.
Dado S = AAAAAAAAAAABXXAAAAAAAAAA y K = 3 la función debe regresar 3, ya que después de remover el substring BXX de Sa nos quedaría que al comprimirlo resulta  nos quedaría AAAAAAAAAAAAAAAAAAAAA que al comprimirlo resulta en 21A de longitud 3.
Dado S = ABCDDDEFG y K = 2 la función debe regresar 6, ya que después de remover el substring EF de Sa nos quedaría ABCDDDG que al comprimirlo resulta en ABC3DG de longitud 6.
Podemos considerar que:
N es un entero en el rango de [1-100,000]
K es un entero en el rango de [0-100,000]
K <= N
S consiste solo de letras en mayúsculas [A-Z]
*/
import java.util.List;
import java.util.ArrayList;

public class StringCompressionWithWildCard {
  public static class Chunk {
    int size;
    String letter;
    public Chunk (int size, String letter) {
      this.size = size;
      this.letter = letter;
    }
  }
  
  public static void main (String[] args) {
    String r = compress("AAABCCCCXPP", 3);
    String s = compress("AAAAAAAAAAABXXAAAAAAAAAA", 3);
    System.out.println("R:" + r);
    System.out.println("S:" + s);
  }
  
  public static String compress (String s, int k) {
    if (s.length() == k) return "";
    if (s.length() < 3) {
      if (k > 0) return "" + s.charAt(0);
      return s;
    }
    if (s.length() == k + 1) {
      return "" + s.charAt(0);
    } else if (s.length() == k + 2) {
      return s.substring(0, 2);
    }
    StringBuilder sb = new StringBuilder();
    List<Chunk> compression = new ArrayList<Chunk>();
    for (int i = 0, j = 1; i < s.length() - 1; i++) {
      if (s.charAt(i) == s.charAt(i + 1)) {
        j++;
      } else {
        Chunk chunk = new Chunk(j, "" + s.charAt(i));
        compression.add(chunk);
        if (chunk.size > 1) sb.append(chunk.size);
        sb.append(chunk.letter);
        j = 1;
      }
      if (s.length() == i + 2) {
        Chunk chunk = new Chunk(j, "" + s.charAt(i + 1));
        compression.add(chunk);
        if (chunk.size > 1) sb.append(chunk.size);
        sb.append(chunk.letter);
      }
    }
    if (k == 0) return sb.toString();
    int index = -1;
    int minLength = sb.toString().length();
    StringBuilder tmp = new StringBuilder(sb.toString());
    for (int i = 0; i < compression.size(); i++) {
      Chunk current = compression.get(i);
      if (current.size <= k) {
        // TODO
        // missing this part...
      } else {
        int chunkLength = Integer.toString(current.size).length();
        int chunkDiff = Integer.toString(current.size - k).length();
        int srtLength = sb.toString().length() - diff;
        if (chunkLength > chunkDiff && minLength > srtLength) {
          index = i;
          minLength = srtLength;
        }
      }
    }
    if (index == -1) return sb.toString(); // Remove line when TODO is fixed
    sb = new StringBuilder();
    Chunk c = compression.remove(index);
    for (Chunk chunk : compression) {
      if (chunk.size > 1) sb.append(chunk.size);
      sb.append(chunk.letter);
    }
    return sb.toString();
  }
}