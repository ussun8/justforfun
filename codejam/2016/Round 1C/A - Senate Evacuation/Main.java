import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//Long alternative solution
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            Character partyChar = 'A';
            TreeMap<Integer, List<Character>> partyMap = new TreeMap<>(Collections.<Integer>reverseOrder());
            int partyCount = in.nextInt();
            for(int j=0; j<partyCount; j++) {
                int count = in.nextInt();
                partyMap.putIfAbsent(count, new ArrayList<Character>());
                final List<Character> characters = partyMap.get(count);
                characters.add(partyChar++);
            }
            solve(partyMap, i);
        }
    }

    private static void solve(TreeMap<Integer, List<Character>> partyMap, int i) {
        StringBuilder builder = new StringBuilder();
        while(!partyMap.isEmpty()) {
            final Map.Entry<Integer, List<Character>> entry = partyMap.firstEntry();
            final Integer key = entry.getKey();
            final List<Character> characters = entry.getValue();
            if(characters.size() > 2) {
                if(key == 1) {
                    Character ch1 = characters.get(0);
                    builder.append(ch1);
                    characters.remove(ch1);
                    partyMap.put(key, characters);
                } else {
                    Character ch1 = characters.get(0);
                    Character ch2 = characters.get(1);
                    characters.remove(ch1);
                    characters.remove(ch2);
                    partyMap.put(key, characters);
                    builder.append(ch1).append(ch2);
                    if (key > 1) {
                        partyMap.putIfAbsent(key - 1, new ArrayList<Character>());
                        final List<Character> updCharacters = partyMap.get(key - 1);
                        updCharacters.add(ch1);
                        updCharacters.add(ch2);
                        partyMap.put(key - 1, updCharacters);
                    }
                }
            } else if(characters.size() == 2) {
                partyMap.remove(key);
                builder.append(characters.get(0)).append(characters.get(1));
                if(key>1) {
                    partyMap.putIfAbsent(key - 1, new ArrayList<Character>());
                    final List<Character> updCharacters = partyMap.get(key - 1);
                    updCharacters.addAll(characters);
                    partyMap.put(key-1, updCharacters);
                }
            } else {
                Character singleCh = characters.get(0);
                partyMap.remove(key);
                if(key > 2) {
                    partyMap.putIfAbsent(key - 2, new ArrayList<Character>());
                    final List<Character> updCharacters = partyMap.get(key - 2);
                    updCharacters.add(singleCh);
                    partyMap.put(key - 2, updCharacters);
                    builder.append(singleCh).append(singleCh);
                } else if (key == 2) {
                    builder.append(singleCh).append(singleCh);
                } else {
                    builder.append(singleCh);
                }
            }
            builder.append(" ");
        }
        if(builder.charAt(builder.length()-1) == ' ') {
            builder.setLength(builder.length()-1);
        }
        System.out.println("Case #" + i + ": " + builder.toString());
    }
}
