import com.epam.task.third.comparators.XCoordinateAPointComparator;
import org.junit.Assert;

public class XCoordinateAPointComparatorTest extends ComparatorTest {

    private final static XCoordinateAPointComparator COMPARATOR = new XCoordinateAPointComparator();

    @Override
    public void testCompareShouldReturnZero() {
        //given
        int expected = 0;
        //when
        int actual = COMPARATOR.compare(getTetrahedron(), getTetrahedron());
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
        int actual = COMPARATOR.compare(getComparableTetrahedron(),getTetrahedron() );
        //then
        Assert.assertEquals(actual, expected);
    }
}
