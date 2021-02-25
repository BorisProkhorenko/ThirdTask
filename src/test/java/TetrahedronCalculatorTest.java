import com.epam.task.third.entity.Point;
import com.epam.task.third.entity.Tetrahedron;
import com.epam.task.third.logic.TetrahedronCalculator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TetrahedronCalculatorTest {

    private static final TetrahedronCalculator CALCULATOR = new TetrahedronCalculator();
    private static final double THRESHOLD = 0.0001;
    private static Tetrahedron regular;


    @BeforeClass
    public static void initialize() {
        Point pointA = new Point(0, 0, 0);
        Point pointB = new Point(1, 0, 0);
        Point pointC = new Point(0.5, 0.866025, 0);
        Point pointD = new Point(0.5, 0.288675, 0.816496);
        regular = new Tetrahedron(pointA, pointB, pointC, pointD);

    }

    @Test
    public void testCalculateDistanceBetweenTwoPoints() {
        //given
        Point pointA = new Point(1, 2, 3);
        Point pointB = new Point(1, -1, 1);
        double expected = 3.6055;
        //when
        double actual = CALCULATOR.calculateDistanceBetweenTwoPoints(pointA, pointB);
        //then
        Assert.assertEquals(expected, actual, THRESHOLD);
    }

    @Test
    public void testCalculateRegularTetrahedronsEdgeLengthWhenRegularTetrahedronApplied() {
        //given
        double expected = 1;
        //when
        double actual = CALCULATOR.calculateRegularTetrahedronsEdgeLength(regular);
        //then
        Assert.assertEquals(expected, actual, THRESHOLD);
    }

    @Test
    public void testCalculateTetrahedronVolumeWhenRegularTetrahedronApplied() {
        //given
        double expected = 0.1178;
        //when
        double actual = CALCULATOR.calculateTetrahedronVolume(regular);
        //then
        Assert.assertEquals(expected, actual, THRESHOLD);
    }


    @Test
    public void testIsTetrahedronsFoundationIsOnXoyPlaneWhenTrue() {
        //given
        Point pointA = new Point(1, 1, 0);
        Point pointB = new Point(4, 12, 0);
        Point pointC = new Point(3, 1, 7);
        Point pointD = new Point(1, 3, 0);
        Tetrahedron tetrahedron = new Tetrahedron(pointA, pointB, pointC, pointD);
        //when
        boolean actual = CALCULATOR.isTetrahedronsFoundationIsOnXoyPlane(tetrahedron);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsTetrahedronsFoundationIsOnXoyPlaneWhenFalse() {
        //given
        Point pointA = new Point(1, 1, 0);
        Point pointB = new Point(0, 12, 3);
        Point pointC = new Point(0, 1, 5);
        Point pointD = new Point(1, 3, 7);
        Tetrahedron tetrahedron = new Tetrahedron(pointA, pointB, pointC, pointD);
        //when
        boolean actual = CALCULATOR.isTetrahedronsFoundationIsOnXoyPlane(tetrahedron);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsTetrahedronsFoundationIsOnXozPlaneWhenTrue() {
        //given
        Point pointA = new Point(1, 0, 4);
        Point pointB = new Point(4, 0, 3);
        Point pointC = new Point(3, 0, 7);
        Point pointD = new Point(1, 3, 0);
        Tetrahedron tetrahedron = new Tetrahedron(pointA, pointB, pointC, pointD);
        //when
        boolean actual = CALCULATOR.isTetrahedronsFoundationIsOnXozPlane(tetrahedron);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsTetrahedronsFoundationIsOnXozPlaneWhenFalse() {
        //given
        Point pointA = new Point(1, 1, 3);
        Point pointB = new Point(0, 12, 3);
        Point pointC = new Point(0, 1, 5);
        Point pointD = new Point(1, 3, 7);
        Tetrahedron tetrahedron = new Tetrahedron(pointA, pointB, pointC, pointD);
        //when
        boolean actual = CALCULATOR.isTetrahedronsFoundationIsOnXozPlane(tetrahedron);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsTetrahedronsFoundationIsOnYozPlaneWhenTrue() {
        //given
        Point pointA = new Point(0, 5, 4);
        Point pointB = new Point(9, 6, 3);
        Point pointC = new Point(0, 7, 7);
        Point pointD = new Point(0, 3, 0);
        Tetrahedron tetrahedron = new Tetrahedron(pointA, pointB, pointC, pointD);
        //when
        boolean actual = CALCULATOR.isTetrahedronsFoundationIsOnYozPlane(tetrahedron);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsTetrahedronsFoundationIsOnYozPlaneWhenFalse() {
        //given
        Point pointA = new Point(1, 1, 3);
        Point pointB = new Point(0, 12, 3);
        Point pointC = new Point(0, 1, 5);
        Point pointD = new Point(1, 3, 7);

        Tetrahedron tetrahedron = new Tetrahedron(pointA, pointB, pointC, pointD);
        //when
        boolean actual = CALCULATOR.isTetrahedronsFoundationIsOnYozPlane(tetrahedron);
        //then
        Assert.assertFalse(actual);
    }


}
