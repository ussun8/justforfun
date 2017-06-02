import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            StringBuilder builder = new StringBuilder();
            String word = in.next();
            int[] letArr = createArr(word);
            int[] countArr = new int[10];
            Map<Integer, String> numMap = createNumMap();
            Map<Integer, Character> unMap = createUniqueMap();
            List<Integer> numList = createList();
            for(int num : numList) {
                char ch = unMap.get(num);
                int count = letArr[ch-'A'];
                countArr[num]+= count;
                String str = numMap.get(num);
                for (char removedCh : str.toCharArray()) {
                    letArr[removedCh - 'A'] -= count;
                }
            }
            for(int co=0; co<10; co++) {
                for(int )
                builder.append(i);
            }
            System.out.println("Case #" + i + ": " + builder.toString());
        }
    }

    private static List<Integer> createList() {
        List<Integer> numList = new ArrayList<>();
        numList.addAll(Arrays.asList(0,2,4,6,8,1,3,5,7,9));
        return numList;
    }

    private static Map<Integer, Character> createUniqueMap() {
        Map<Integer, Character> letMap = new HashMap<Integer, Character>();
        letMap.put(0, 'Z');
        letMap.put(1, 'O');
        letMap.put(2, 'W');
        letMap.put(3, 'H');
        letMap.put(4, 'U');
        letMap.put(5, 'F');
        letMap.put(6, 'X');
        letMap.put(7, 'S');
        letMap.put(8, 'G');
        letMap.put(9, 'I');
        return letMap;
    }

    private static Map<Integer, String> createNumMap() {
        Map<Integer, String> letMap = new HashMap<Integer, String>();
        letMap.put(0, "ZERO");
        letMap.put(1, "ONE");
        letMap.put(2, "TWO");
        letMap.put(3, "THREE");
        letMap.put(4, "FOUR");
        letMap.put(5, "FIVE");
        letMap.put(6, "SIX");
        letMap.put(7, "SEVEN");
        letMap.put(8, "EIGHT");
        letMap.put(9, "NINE");
        return letMap;
    }

    private static int[] createArr(String word) {
        int[] letArr = new int[26];
        for(char ch : word.toCharArray()) {
            letArr[ch - 'A']++;
        }
        return letArr;
    }
}
