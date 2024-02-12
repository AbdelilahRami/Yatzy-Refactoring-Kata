import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record Yatzy(int d1, int d2, int d3, int d4, int d5) {

    public Yatzy(int[] dice) {
        this(dice[0], dice[1], dice[2], dice[3], dice[4]);
    }

    public static int scoreChance(Yatzy yatzy) {
        return Stream.of(yatzy.d1(),yatzy.d2(),yatzy.d3(),yatzy.d4(),yatzy.d5())
                     .reduce(0, Integer::sum);
    }

    public static int scoreYatzy(int... dice) {
        return Arrays.stream(dice).distinct().count() == 1 ? 50 :0;
    }

    public static int scoreOnes(Yatzy yatzy) {
        return getSumOf(yatzy,1);
    }

    public static int scoreTwos(Yatzy yatzy) {
        return getSumOf(yatzy,2);
    }

    public static int scoreThrees(Yatzy yatzy) {
        return getSumOf(yatzy,3);
    }

    private static int getSumOf(Yatzy yatzy, int target) {
        return (int) Stream.of(yatzy.d1(),yatzy.d2(),yatzy.d3(),yatzy.d4(),yatzy.d5())
            .filter(dice -> dice.equals(target)).count() * target;
    }

    public int scoreFours() {
        return getOccurrenceOf(4) * 4;
    }

    public int scoreFives() {
        return getOccurrenceOf(5) * 5;
    }

    public int scoreSixes() {
        return getOccurrenceOf(6) * 6;
    }

    private  int getOccurrenceOf(int target) {
        List<Integer> occurrences = Stream.of(d1,d2,d3,d4,d5)
            .filter(value -> value == target)
            .toList();
        return occurrences.size() ;
    }


    public static int scorePair(Yatzy yatzy) {
        return getDiceWithOccurrences(yatzy,2)
                            .stream()
                            .max(Comparator.comparingInt(o -> o))
                            .orElse(0) * 2;
    }

    public static int scoreTwoPairs(Yatzy yatzy) {
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

    public static int scoreFourOfSameKind(Yatzy yatzy) {
        return getDiceWithOccurrences(yatzy,4)
            .stream()
            .findFirst()
            .orElse(0) * 4;
    }

    public static int scoreThreeOfSameKind(Yatzy yatzy) {
        return getDiceWithOccurrences(yatzy,3)
            .stream()
            .findFirst()
            .orElse(0) * 3;
    }

    public static int scoreSmallStraight(Yatzy yatzy) {
        return getStraight(yatzy,15,1,5);
    }

    public static int scoreLargeStraight(Yatzy yatzy) {
        return getStraight(yatzy,20,2,6);
    }

    private static int getStraight(Yatzy yatzy, int result, int start, int end) {
        List<Integer> list = Stream.of(yatzy.d1(),yatzy.d2(),yatzy.d3(),yatzy.d4(),yatzy.d5())
                                   .distinct()
                                   .sorted()
                                   .toList();
        return (!list.isEmpty() && list.getFirst() == start && list.getLast() == end && list.size() == 5) ? result : 0;
    }

    public static int scoreFullHouse(Yatzy yatzy) {
        List<Integer> distinctDices = Stream.of(yatzy.d1(), yatzy.d2(), yatzy.d3(), yatzy.d4(), yatzy.d5())
            .collect(Collectors.groupingBy(integer -> integer, Collectors.counting()))
            .keySet()
            .stream()
            .toList();
        return distinctDices.size() == 2 ? scoreChance(yatzy) : 0;
    }
}



