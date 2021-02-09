import com.epam.task.third.entity.Point;
import com.epam.task.third.entity.Tetrahedron;
import org.junit.BeforeClass;
import org.junit.Test;

public abstract class ComparatorTest {

    private static Tetrahedron tetrahedron;
    private static Tetrahedron comparableTetrahedron;

    @BeforeClass
    public static void initialize() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(1, 0, 0);
        Point c = new Point(0.5, 0.866025, 0);
        Point d = new Point(0.5, 0.288675, 0.816496);
        Point comparableAPoint = new Point(1, 1, 1);
        tetrahedron = new Tetrahedron(a, b, c, d);
        comparableTetrahedron = new Tetrahedron(comparableAPoint, b, c, d);
    }

    @Test
    public abstract void testCompareShouldReturnZero();

    @Test
    public abstract void testCompareShouldReturnNegativeOne();

    @Test
    public abstract void testCompareShouldReturnPositiveOne();

    public static Tetrahedron getTetrahedron() {
        return tetrahedron;
    }

    public static Tetrahedron getComparableTetrahedron() {
        return comparableTetrahedron;
    }
}
