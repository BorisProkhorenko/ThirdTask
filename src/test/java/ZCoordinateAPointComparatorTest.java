import com.epam.task.third.comparators.ZCoordinateAPointComparator;
import org.junit.Assert;

public class ZCoordinateAPointComparatorTest extends ComparatorTest {

    private final static ZCoordinateAPointComparator COMPARATOR = new ZCoordinateAPointComparator();

    @Override
    public void testCompareShouldReturnZero() {
        //given
        int expected = 0;
        //when
        int actual = COMPARATOR.compare(ComparatorTest.getTetrahedron(), getTetrahedron());
        //then
        Assert.assertEquals(actual, expected);
    }

    @Override
    public void testCompareShouldReturnNegativeOne() {
        //given
        int expected = -1;
        //when
        int actual = COMPARATOR.compare(getTetrahedron(), getComparableTetrahedron());
        //then
        Assert.assertEquals(actual, expected);
    }

    @Override
    public void testCompareShouldReturnPositiveOne() {
        //given
        int expected = 1;
        //when
        int actual = COMPARATOR.compare(getComparableTetrahedron(), getTetrahedron());
        //then
        Assert.assertEquals(actual, expected);
    }
}
