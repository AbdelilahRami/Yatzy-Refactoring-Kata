import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class YatzyTest {

    @ParameterizedTest
    @MethodSource("scoreSumOfAllDiceProvider")
    @DisplayName("Test chance method with different sets of dice values")
    public void chance_scores_sum_of_all_dice(int[] dice, int expectedScore) {
        assertEquals(expectedScore, Yatzy.scoreChance(new Yatzy(dice)));
    }

    private static Stream<Arguments> scoreSumOfAllDiceProvider() {
        return Stream.of(
            Arguments.of(new int[] {2, 3, 4, 5, 1}, 15),
            Arguments.of(new int[] {3, 3, 4, 5, 1}, 16));
    }

    @ParameterizedTest
    @MethodSource("scoreYatzyProvider")
    @DisplayName("Test yatzy method with different sets of dice values")
    public void yatzy_scores_50(int[] dice, int expectedScore) {
        assertEquals(expectedScore, Yatzy.scoreYatzy(dice));
    }

    private static Stream<Arguments> scoreYatzyProvider() {
        return Stream.of(
            Arguments.of(new int[] {2, 2, 2, 2, 2}, 50),
            Arguments.of(new int[] {3, 3, 3, 3, 1}, 0),
            Arguments.of(new int[] {6, 6, 6, 6, 6}, 50),
            Arguments.of(new int[] {1, 2, 3, 4, 6}, 0));
    }

    @ParameterizedTest
    @MethodSource("scoreOnesProvider")
    @DisplayName("Test ones method with different sets of dice values")
    public void test_ones(int[] dice, int expectedScore) {
        assertEquals(expectedScore, Yatzy.scoreOnes(new Yatzy(dice)));
    }

    private static Stream<Arguments> scoreOnesProvider() {
        return Stream.of(
            Arguments.of(new int[] {2, 2, 2, 2, 2}, 0),
            Arguments.of(new int[] {1, 1, 1, 1, 1}, 5),
            Arguments.of(new int[] {6, 6, 6, 1, 6}, 1),
            Arguments.of(new int[] {1, 2, 1, 4, 1}, 3));
    }

    @ParameterizedTest
    @MethodSource("scoreTwosProvider")
    @DisplayName("Test twos method with different sets of dice values")
    public void test_twos(int[] dice, int expectedScore) {
        assertEquals(expectedScore, Yatzy.scoreTwos(new Yatzy(dice)));
    }

    private static Stream<Arguments> scoreTwosProvider() {
        return Stream.of(
            Arguments.of(new int[] {2, 2, 2, 2, 2}, 10),
            Arguments.of(new int[] {1, 1, 1, 1, 1}, 0),
            Arguments.of(new int[] {6, 6, 6, 1, 6}, 0),
            Arguments.of(new int[] {1, 2, 1, 4, 1}, 2));
    }

    @ParameterizedTest
    @MethodSource("scoreThreesProvider")
    @DisplayName("Test threes method with different sets of dice values")
    public void test_threes(int[] dice, int expectedScore) {
        assertEquals(expectedScore, Yatzy.scoreThrees(new Yatzy(dice)));
    }

    private static Stream<Arguments> scoreThreesProvider() {
        return Stream.of(
            Arguments.of(new int[] {2, 3, 3, 3, 2}, 9),
            Arguments.of(new int[] {1, 1, 1, 1, 1}, 0),
            Arguments.of(new int[] {6, 6, 6, 1, 3}, 3),
            Arguments.of(new int[] {1, 3, 1, 3, 1}, 6));
    }

    @ParameterizedTest
    @MethodSource("scoreFoursProvider")
    @DisplayName("Test fours method with different sets of dice values")
    public void fours_test(int[] dice, int expectedScore) {
        assertEquals(expectedScore, new Yatzy(dice).scoreFours());
    }

    private static Stream<Arguments> scoreFoursProvider() {
        return Stream.of(
            Arguments.of(new int[] {2, 4, 3, 3, 2}, 4),
            Arguments.of(new int[] {4, 4, 4, 4, 4}, 20),
            Arguments.of(new int[] {6, 6, 4, 4, 3}, 8),
            Arguments.of(new int[] {1, 3, 1, 3, 1}, 0));
    }

    @ParameterizedTest
    @MethodSource("scoreFivesProvider")
    @DisplayName("Test fives method with different sets of dice values")
    public void fives(int[] dice, int expectedScore) {
        assertEquals(expectedScore, new Yatzy(dice).scoreFives());
    }

    private static Stream<Arguments> scoreFivesProvider() {
        return Stream.of(
            Arguments.of(new int[] {5, 4, 3, 3, 2}, 5),
            Arguments.of(new int[] {4, 4, 4, 4, 4}, 0),
            Arguments.of(new int[] {5, 6, 5, 5, 5}, 20),
            Arguments.of(new int[] {1, 3, 1, 3, 1}, 0));
    }

    @ParameterizedTest
    @MethodSource("scoreSixesProvider")
    @DisplayName("Test sixes method with different sets of dice values")
    public void sixes_test(int[] dice, int expectedScore) {
        assertEquals(expectedScore, new Yatzy(dice).scoreSixes());
    }

    private static Stream<Arguments> scoreSixesProvider() {
        return Stream.of(
            Arguments.of(new int[] {6, 4, 3, 3, 2}, 6),
            Arguments.of(new int[] {4, 4, 4, 4, 4}, 0),
            Arguments.of(new int[] {5, 6, 6, 5, 5}, 12),
            Arguments.of(new int[] {6, 6, 6, 6, 6}, 30));
    }

    @ParameterizedTest
    @MethodSource("scoreOnePairProvider")
    @DisplayName("Test onePair method with different sets of dice values")
    public void one_pair(int[] dice, int expectedScore) {
        assertEquals(expectedScore, Yatzy.scorePair(new Yatzy(dice)));
    }

    private static Stream<Arguments> scoreOnePairProvider() {
        return Stream.of(
            Arguments.of(new int[] {3,4,3,5,6}, 6),
            Arguments.of(new int[] {5,3,3,3,5}, 10),
            Arguments.of(new int[] {5,3,6,6,5}, 12));
    }

    @ParameterizedTest
    @MethodSource("scoreTwoPairsProvider")
    @DisplayName("Test twoPairs method with different sets of dice values")
    public void two_Pair(int[] dice, int expectedScore) {
        assertEquals(expectedScore, Yatzy.scoreTwoPairs(new Yatzy(dice)));

    }

    private static Stream<Arguments> scoreTwoPairsProvider() {
        return Stream.of(
            Arguments.of(new int[] {3,4,3,5,6}, 0),
            Arguments.of(new int[] {5,3,3,3,5}, 16),
            Arguments.of(new int[] {5,3,6,6,5}, 22));
    }

    @Test
    @DisplayName("Test three of same kind method with different sets of dice values")
    public void three_of_a_kind() {
        assertEquals(9, Yatzy.scoreThreeOfSameKind(new Yatzy(3,3,3,4,5)));
        assertEquals(15, Yatzy.scoreThreeOfSameKind(new Yatzy(5,3,5,4,5)));
        assertEquals(9, Yatzy.scoreThreeOfSameKind(new Yatzy(3,3,3,3,5)));
    }

    @Test
    @DisplayName("Test four of same kind method with different sets of dice values")
    public void four_of_a_knd() {
        assertEquals(12, Yatzy.scoreFourOfSameKind(new Yatzy(3,3,3,3,5)));
        assertEquals(20, Yatzy.scoreFourOfSameKind(new Yatzy(5,5,5,4,5)));
        assertEquals(9, Yatzy.scoreThreeOfSameKind(new Yatzy(3,3,3,3,3)));
    }

    @Test
    @DisplayName("Test smallStraight method with different sets of dice values")
    public void smallStraight() {
        assertEquals(15, Yatzy.scoreSmallStraight(new Yatzy(1,2,3,4,5)));
        assertEquals(15, Yatzy.scoreSmallStraight(new Yatzy(2,3,4,5,1)));
        assertEquals(0, Yatzy.scoreSmallStraight(new Yatzy(1,2,2,4,5)));
    }

    @Test
    @DisplayName("Test largeStraight method with different sets of dice values")
    public void largeStraight() {
        assertEquals(20, Yatzy.scoreLargeStraight(new Yatzy(6,2,3,4,5)));
        assertEquals(20, Yatzy.scoreLargeStraight(new Yatzy(2,3,4,5,6)));
        assertEquals(0, Yatzy.scoreLargeStraight(new Yatzy(1,2,2,4,5)));
    }

    @Test
    @DisplayName("Test fullHouse method with different sets of dice values")
    public void fullHouse() {
        assertEquals(18, Yatzy.scoreFullHouse(new Yatzy(6,2,2,2,6)));
        assertEquals(0, Yatzy.scoreFullHouse(new Yatzy(2,3,4,5,6)));
    }
}
