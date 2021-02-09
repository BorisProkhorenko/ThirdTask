import com.epam.task.third.entity.Point;
import com.epam.task.third.entity.Tetrahedron;
import com.epam.task.third.logic.TetrahedronCalculator;
import com.epam.task.third.validation.TetrahedronIsNotRegularException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TetrahedronCalculatorTest {

    private static final TetrahedronCalculator CALCULATOR = new TetrahedronCalculator();
    private static final double THRESHOLD = 0.0001;
    private static Tetrahedron regular;
    private static Tetrahedron irregular;


    @BeforeClass
    public static void initialize() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(1, 0, 0);
        Point c = new Point(0.5, 0.866025, 0);
        Point d = new Point(0.5, 0.288675, 0.816496);
        Point w = new Point(5, 7, 5);
        regular = new Tetrahedron(a, b, c, d);
        irregular = new Tetrahedron(a, b, c, w);

    }

    @Test
    public void testCalculateDistanceBetweenTwoPoints() {
        //given
        Point a = new Point(1, 2, 3);
        Point b = new Point(1, -1, 1);
        double expected = 3.6055;
        //when
        double actual = CALCULATOR.calculateDistanceBetweenTwoPoints(a, b);
        //then
        Assert.assertEquals(expected, actual, THRESHOLD);
    }

    @Test
    public void testCalculateRegularTetrahedronsEdgeLengthWhenRegularTetrahedronApplied()
            throws TetrahedronIsNotRegularException {
        //given
        double expected = 1;
        //when
        double actual = CALCULATOR.calculateRegularTetrahedronsEdgeLength(regular);
        //then
        Assert.assertEquals(expected, actual, THRESHOLD);
    }

    @Test(expected = TetrahedronIsNotRegularException.class)
    public void testCalculateRegularTetrahedronsEdgeLengthWhenIrregularTetrahedronApplied()
            throws TetrahedronIsNotRegularException {
        //when
        double actual = CALCULATOR.calculateRegularTetrahedronsEdgeLength(irregular);
    }

    @Test
    public void testCalculateTetrahedronAreaWhenRegularTetrahedronApplied()
            throws TetrahedronIsNotRegularException {
        //given
        double expected = 1.7320;
        //when
        double actual = CALCULATOR.calculateTetrahedronArea(regular);
        //then
        Assert.assertEquals(expected, actual, THRESHOLD);
    }

    @Test(expected = TetrahedronIsNotRegularException.class)
    public void testCalculateTetrahedronAreaWhenIrregularTetrahedronApplied()
            throws TetrahedronIsNotRegularException {
        //when
        double actual = CALCULATOR.calculateTetrahedronArea(irregular);
    }

    @Test
    public void testCalculateTetrahedronVolumeWhenRegularTetrahedronApplied()
            throws TetrahedronIsNotRegularException {
        //given
        double expected = 0.1178;
        //when
        double actual = CALCULATOR.calculateTetrahedronVolume(regular);
        //then
        Assert.assertEquals(expected, actual, THRESHOLD);
    }

    @Test(expected = TetrahedronIsNotRegularException.class)
    public void testCalculateTetrahedronVolumeWhenIrregularTetrahedronApplied()
            throws TetrahedronIsNotRegularException {
        //when
        double actual = CALCULATOR.calculateTetrahedronVolume(irregular);
    }

    @Test
    public void testIsTetrahedronsFoundationIsOnXOYPlaneWhenTrue() {
        //given
        Point a = new Point(1, 1, 0);
        Point b = new Point(4, 12, 0);
        Point c = new Point(3, 1, 7);
        Point d = new Point(1, 3, 0);
        Tetrahedron tetrahedron = new Tetrahedron(a, b, c, d);
        //when
        boolean actual = CALCULATOR.isTetrahedronsFoundationIsOnXOYPlane(tetrahedron);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsTetrahedronsFoundationIsOnXOYPlaneWhenFalse() {
        //given
        Point a = new Point(1, 1, 3);
        Point b = new Point(0, 12, 3);
        Point c = new Point(0, 1, 5);
        Point d = new Point(1, 3, 7);
        Tetrahedron tetrahedron = new Tetrahedron(a, b, c, d);
        //when
        boolean actual = CALCULATOR.isTetrahedronsFoundationIsOnXOYPlane(tetrahedron);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsTetrahedronsFoundationIsOnXOZPlaneWhenTrue() {
        //given
        Point a = new Point(1, 0, 4);
        Point b = new Point(4, 0, 3);
        Point c = new Point(3, 0, 7);
        Point d = new Point(1, 3, 0);
        Tetrahedron tetrahedron = new Tetrahedron(a, b, c, d);
        //when
        boolean actual = CALCULATOR.isTetrahedronsFoundationIsOnXOZPlane(tetrahedron);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsTetrahedronsFoundationIsOnXOZPlaneWhenFalse() {
        //given
        Point a = new Point(1, 1, 3);
        Point b = new Point(0, 12, 3);
        Point c = new Point(0, 1, 5);
        Point d = new Point(1, 3, 7);
        Tetrahedron tetrahedron = new Tetrahedron(a, b, c, d);
        //when
        boolean actual = CALCULATOR.isTetrahedronsFoundationIsOnXOZPlane(tetrahedron);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsTetrahedronsFoundationIsOnYOZPlaneWhenTrue() {
        //given
        Point a = new Point(0, 5, 4);
        Point b = new Point(9, 6, 3);
        Point c = new Point(0, 7, 7);
        Point d = new Point(0, 3, 0);
        Tetrahedron tetrahedron = new Tetrahedron(a, b, c, d);
        //when
        boolean actual = CALCULATOR.isTetrahedronsFoundationIsOnYOZPlane(tetrahedron);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsTetrahedronsFoundationIsOnYOZPlaneWhenFalse() {
        //given
        Point a = new Point(1, 1, 3);
        Point b = new Point(0, 12, 3);
        Point c = new Point(0, 1, 5);
        Point d = new Point(1, 3, 7);
        Tetrahedron tetrahedron = new Tetrahedron(a, b, c, d);
        //when
        boolean actual = CALCULATOR.isTetrahedronsFoundationIsOnYOZPlane(tetrahedron);
        //then
        Assert.assertFalse(actual);
    }


}
