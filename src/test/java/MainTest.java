import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    public void test1() {
        SumFactorialPrimeNumber main = new SumFactorialPrimeNumber(100);
        BigInteger expected = main.getSumFactorialPrimeNumber();
        ArrayList<BigInteger> number = new ArrayList<>();
        number.ensureCapacity(25);
        number.add(new BigInteger("2"));
        number.add(new BigInteger("6"));
        number.add(new BigInteger("120"));
        number.add(new BigInteger("5040"));
        number.add(new BigInteger("39916800"));
        number.add(new BigInteger("6227020800"));
        number.add(new BigInteger("355687428096000"));
        number.add(new BigInteger("121645100408832000"));
        number.add(new BigInteger("25852016738884976640000"));
        number.add(new BigInteger("8841761993739701954543616000000"));
        number.add(new BigInteger("8222838654177922817725562880000000"));
        number.add(new BigInteger("13763753091226345046315979581580902400000000"));
        number.add(new BigInteger("33452526613163807108170062053440751665152000000000"));
        number.add(new BigInteger("60415263063373835637355132068513997507264512000000000"));
        number.add(new BigInteger("258623241511168180642964355153611979969197632389120000000000"));
        number.add(new BigInteger("4274883284060025564298013753389399649690343788366813724672000000000000"));
        number.add(new BigInteger("138683118545689835737939019720389406345902876772687432540821294940160000000000000"));
        number.add(new BigInteger("507580213877224798800856812176625227226004528988036003099405939480985600000000000000"));
        number.add(new BigInteger("36471110918188685288249859096605464427167635314049524593701628500267962436943872000000000000000"));
        number.add(new BigInteger("850478588567862317521167644239926010288584608120796235886430763388588680378079017697280000000000000000"));
        number.add(new BigInteger("4470115461512684340891257138125051110076800700282905015819080092370422104067183317016903680000000000000000"));
        number.add(new BigInteger("894618213078297528685144171539831652069808216779571907213868063227837990693501860533361810841010176000000000000000000"));
        number.add(new BigInteger("39455239697206586511897471180120610571436503407643446275224357528369751562996629334879591940103770870906880000000000000000000"));
        number.add(new BigInteger("16507955160908461081216919262453619309839666236496541854913520707833171034378509739399912570787600662729080382999756800000000000000000000"));
        number.add(new BigInteger("96192759682482119853328425949563698712343813919172976158104477319333745612481875498805879175589072651261284189679678167647067832320000000000000000000000"));

        BigInteger actual = BigInteger.ZERO;
        for (BigInteger tmp: number) {
            actual = actual.add(tmp);
        }
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        SumFactorialPrimeNumber main = new SumFactorialPrimeNumber(11);
        BigInteger expected = main.getSumFactorialPrimeNumber();
        BigInteger actual = new BigInteger("39921968");
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        SumFactorialPrimeNumber main = new SumFactorialPrimeNumber(1);
        BigInteger expected = main.getSumFactorialPrimeNumber();
        BigInteger actual = BigInteger.ZERO;
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        SumFactorialPrimeNumber main = new SumFactorialPrimeNumber(0);
        BigInteger expected = main.getSumFactorialPrimeNumber();
        BigInteger actual = BigInteger.ZERO;
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        SumFactorialPrimeNumber main = new SumFactorialPrimeNumber(-1);
        BigInteger expected = main.getSumFactorialPrimeNumber();
        BigInteger actual = BigInteger.ZERO;
        assertEquals(expected, actual);
    }
}