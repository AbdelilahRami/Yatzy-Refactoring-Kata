import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record Yatzy(int d1, int d2, int d3, int d4, int d5) {

    public static int chance(Yatzy yatzy) {
        return Stream.of(yatzy.d1(),yatzy.d2(),yatzy.d3(),yatzy.d4(),yatzy.d5())
                     .reduce(0, Integer::sum);
    }

    public static int yatzy(int... dice) {
        return Arrays.stream(dice).distinct().count() == 1 ? 50 :0;
    }

    public static int ones(Yatzy yatzy) {
        return getSumOf(yatzy,1);
    }

    public static int twos(Yatzy yatzy) {
        return getSumOf(yatzy,2);
    }

    public static int threes(Yatzy yatzy) {
        return getSumOf(yatzy,3);
    }

    private static int getSumOf(Yatzy yatzy, int target) {
        return (int) Stream.of(yatzy.d1(),yatzy.d2(),yatzy.d3(),yatzy.d4(),yatzy.d5())
            .filter(dice -> dice.equals(target)).count() * target;
    }

    public int fours() {
        return getOccurrenceOf(4);
    }

    public int fives() {
        return getOccurrenceOf(5);
    }

    public int sixes() {
        return getOccurrenceOf(6);
    }

    private  int getOccurrenceOf(int target) {
        List<Integer> occurrences = Stream.of(d1,d2,d3,d4,d5)
            .filter(value -> value == target)
            .toList();
        return occurrences.size() * target;
    }


    public static int scorePair(Yatzy yatzy) {
        return getDiceWithOccurrences(yatzy,2)
                            .stream()
                            .max(Comparator.comparingInt(o -> o))
                            .orElse(0) * 2;
    }

    public static int twoPairs(Yatzy yatzy) {
        List<Integer> pairs = getDiceWithOccurrences(yatzy,2);
        return pairs.size() >=2 ? pairs.stream().reduce(0, Integer::sum)*2 : 0;
    }

    private static List<Integer> getDiceWithOccurrences(Yatzy yatzy, int minOccurrence) {
        return Stream.of(yatzy.d1(),yatzy.d2(),yatzy.d3(),yatzy.d4(),yatzy.d5())
                     .collect(Collectors.groupingBy(dice -> dice, Collectors.counting()))
                     .entrySet()
                     .stream()
                     .filter(integerLongEntry -> integerLongEntry.getValue() >= minOccurrence)
                     .map(Map.Entry::getKey)
                     .toList();
    }

    public static int fourOfSameKind(Yatzy yatzy) {
        return getDiceWithOccurrences(yatzy,4)
            .stream()
            .findFirst()
            .orElse(0) * 4;
    }

    public static int threeOfSameKind(Yatzy yatzy) {
        return getDiceWithOccurrences(yatzy,3)
            .stream()
            .findFirst()
            .orElse(0) * 3;
    }

    public static int smallStraight(Yatzy yatzy) {
        return getStraight(yatzy,15,1,5);
    }

    public static int largeStraight(Yatzy yatzy) {
        return getStraight(yatzy,20,2,6);
    }

    private static int getStraight(Yatzy yatzy, int result, int start, int end) {
        List<Integer> list = Stream.of(yatzy.d1(),yatzy.d2(),yatzy.d3(),yatzy.d4(),yatzy.d5())
                                   .distinct()
                                   .sorted()
                                   .toList();
        return (!list.isEmpty() && list.getFirst() == start && list.getLast() == end && list.size() == 5) ? result : 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;




        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i+1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i+1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}



