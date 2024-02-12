import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class YatzyTest {

    @Test
    @DisplayName("Test chance method with different sets of dice values")
    public void chance_scores_sum_of_all_dice() {
        assertEquals(15, Yatzy.scoreChance(new Yatzy(2,3,4,5,1)));
        assertEquals(16, Yatzy.scoreChance(new Yatzy(3,3,4,5,1)));
    }

    @Test
    @DisplayName("Test yatzy method with different sets of dice values")
    public void yatzy_scores_50() {
        assertEquals(50, Yatzy.scoreYatzy(4,4,4,4,4));
        assertEquals(50, Yatzy.scoreYatzy(6,6,6,6,6));
        assertEquals(0, Yatzy.scoreYatzy(6,6,6,6,3));
    }

    @Test
    @DisplayName("Test ones method with different sets of dice values")
    public void test_ones() {
        assertEquals(1, Yatzy.scoreOnes(new Yatzy(1, 2, 3, 4, 5)));
        assertEquals(2, Yatzy.scoreOnes(new Yatzy(1,2,1,4,5)));
        assertEquals(0, Yatzy.scoreOnes(new Yatzy(6,2,2,4,5)));
        assertEquals(4, Yatzy.scoreOnes(new Yatzy(1,2,1,1,1)));
    }

    @Test
    @DisplayName("Test twos method with different sets of dice values")
    public void test_twos() {
        assertEquals(4, Yatzy.scoreTwos(new Yatzy(1,2,3,2,6)));
        assertEquals(10, Yatzy.scoreTwos(new Yatzy(2,2,2,2,2)));
    }

    @Test
    @DisplayName("Test threes method with different sets of dice values")
    public void test_threes() {
        assertEquals(6, Yatzy.scoreThrees(new Yatzy(1,2,3,2,3)));
        assertEquals(12, Yatzy.scoreThrees(new Yatzy(2,3,3,3,3)));
    }

    @Test
    @DisplayName("Test fours method with different sets of dice values")
    public void fours_test() {
        assertEquals(12, new Yatzy(4,4,4,5,5).scoreFours());
        assertEquals(8, new Yatzy(4,4,5,5,5).scoreFours());
        assertEquals(4, new Yatzy(4,5,5,5,5).scoreFours());
    }

    @Test
    @DisplayName("Test fives method with different sets of dice values")
    public void fives() {
        assertEquals(10, new Yatzy(4,4,4,5,5).scoreFives());
        assertEquals(15, new Yatzy(4,4,5,5,5).scoreFives());
        assertEquals(20, new Yatzy(4,5,5,5,5).scoreFives());
    }

    @Test
    @DisplayName("Test sixes method with different sets of dice values")
    public void sixes_test() {
        assertEquals(0, new Yatzy(4,4,4,5,5).scoreSixes());
        assertEquals(6, new Yatzy(4,4,6,5,5).scoreSixes());
        assertEquals(18, new Yatzy(6,5,6,6,5).scoreSixes());
    }

    @Test
    @DisplayName("Test onePair method with different sets of dice values")
    public void one_pair() {
        assertEquals(6, Yatzy.scorePair(new Yatzy(3,4,3,5,6)));
        assertEquals(10, Yatzy.scorePair(new Yatzy(5,3,3,3,5)));
        assertEquals(12, Yatzy.scorePair(new Yatzy(5,3,6,6,5)));
    }

    @Test
    @DisplayName("Test twoPairs method with different sets of dice values")
    public void two_Pair() {
        assertEquals(16, Yatzy.scoreTwoPairs(new Yatzy(3,3,5,4,5)));
        assertEquals(16, Yatzy.scoreTwoPairs(new Yatzy(3,3,5,5,5)));
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
