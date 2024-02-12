import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class YatzyTest {

    @Test
    @DisplayName("Test chance method with different sets of dice values")
    public void chance_scores_sum_of_all_dice() {
        int expected = 15;
        int actual = Yatzy.chance(new Yatzy(2,3,4,5,1));
        assertEquals(expected, actual);
        assertEquals(16, Yatzy.chance(new Yatzy(3,3,4,5,1)));
    }

    @Test
    @DisplayName("Test yatzy method with different sets of dice values")
    public void yatzy_scores_50() {
        int expected = 50;
        int actual = Yatzy.yatzy(4,4,4,4,4);
        assertEquals(expected, actual);
        assertEquals(50, Yatzy.yatzy(6,6,6,6,6));
        assertEquals(0, Yatzy.yatzy(6,6,6,6,3));
    }

    @Test
    @DisplayName("Test ones method with different sets of dice values")
    public void test_ones() {
        assertEquals(1, Yatzy.ones(new Yatzy(1, 2, 3, 4, 5)));
        assertEquals(2, Yatzy.ones(new Yatzy(1,2,1,4,5)));
        assertEquals(0, Yatzy.ones(new Yatzy(6,2,2,4,5)));
        assertEquals(4, Yatzy.ones(new Yatzy(1,2,1,1,1)));
    }

    @Test
    @DisplayName("Test twos method with different sets of dice values")
    public void test_twos() {
        assertEquals(4, Yatzy.twos(new Yatzy(1,2,3,2,6)));
        assertEquals(10, Yatzy.twos(new Yatzy(2,2,2,2,2)));
    }

    @Test
    @DisplayName("Test threes method with different sets of dice values")
    public void test_threes() {
        assertEquals(6, Yatzy.threes(new Yatzy(1,2,3,2,3)));
        assertEquals(12, Yatzy.threes(new Yatzy(2,3,3,3,3)));
    }

    @Test
    @DisplayName("Test fours method with different sets of dice values")
    public void fours_test() {
        assertEquals(12, new Yatzy(4,4,4,5,5).fours());
        assertEquals(8, new Yatzy(4,4,5,5,5).fours());
        assertEquals(4, new Yatzy(4,5,5,5,5).fours());
    }

    @Test
    @DisplayName("Test fives method with different sets of dice values")
    public void fives() {
        assertEquals(10, new Yatzy(4,4,4,5,5).fives());
        assertEquals(15, new Yatzy(4,4,5,5,5).fives());
        assertEquals(20, new Yatzy(4,5,5,5,5).fives());
    }

    @Test
    @DisplayName("Test sixes method with different sets of dice values")
    public void sixes_test() {
        assertEquals(0, new Yatzy(4,4,4,5,5).sixes());
        assertEquals(6, new Yatzy(4,4,6,5,5).sixes());
        assertEquals(18, new Yatzy(6,5,6,6,5).sixes());
    }

    @Test
    public void one_pair() {
        assertEquals(6, Yatzy.scorePair(new Yatzy(3,4,3,5,6)));
        assertEquals(10, Yatzy.scorePair(new Yatzy(5,3,3,3,5)));
        assertEquals(12, Yatzy.scorePair(new Yatzy(5,3,6,6,5)));
    }

    @Test
    public void two_Pair() {
        assertEquals(16, Yatzy.twoPairs(new Yatzy(3,3,5,4,5)));
        assertEquals(16, Yatzy.twoPairs(new Yatzy(3,3,5,5,5)));
    }

    @Test
    public void three_of_a_kind() 
    {
        assertEquals(9, Yatzy.threeOfSameKind(new Yatzy(3,3,3,4,5)));
        assertEquals(15, Yatzy.threeOfSameKind(new Yatzy(5,3,5,4,5)));
        assertEquals(9, Yatzy.threeOfSameKind(new Yatzy(3,3,3,3,5)));
    }

    @Test
    public void four_of_a_knd() {
        assertEquals(12, Yatzy.fourOfSameKind(new Yatzy(3,3,3,3,5)));
        assertEquals(20, Yatzy.fourOfSameKind(new Yatzy(5,5,5,4,5)));
        assertEquals(9, Yatzy.threeOfSameKind(new Yatzy(3,3,3,3,3)));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, Yatzy.smallStraight(new Yatzy(1,2,3,4,5)));
        assertEquals(15, Yatzy.smallStraight(new Yatzy(2,3,4,5,1)));
        assertEquals(0, Yatzy.smallStraight(new Yatzy(1,2,2,4,5)));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, Yatzy.largeStraight(new Yatzy(6,2,3,4,5)));
        assertEquals(20, Yatzy.largeStraight(new Yatzy(2,3,4,5,6)));
        assertEquals(0, Yatzy.largeStraight(new Yatzy(1,2,2,4,5)));
    }

    @Test
    public void fullHouse() {
        assertEquals(18, Yatzy.fullHouse(6,2,2,2,6));
        assertEquals(0, Yatzy.fullHouse(2,3,4,5,6));
    }
}
