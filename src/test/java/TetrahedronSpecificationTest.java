import com.epam.task.third.entity.Point;
import com.epam.task.third.entity.Tetrahedron;
import com.epam.task.third.logic.TetrahedronCalculator;
import org.junit.BeforeClass;
import org.junit.Test;

public abstract class TetrahedronSpecificationTest {

    private static final TetrahedronCalculator CALCULATOR = new TetrahedronCalculator();
    private static Tetrahedron regularTetrahedron;

    @BeforeClass
    public static void initialize() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(1, 0, 0);
        Point c = new Point(0.5, 0.866025, 0);
        Point d = new Point(0.5, 0.288675, 0.816496);
        regularTetrahedron = new Tetrahedron(a, b, c, d);
    }

    @Test
    public abstract void testSpecifiedWhenTrue();

    @Test
    public abstract void testSpecifiedWhenFalse();

    public static Tetrahedron getRegularTetrahedron() {
        return regularTetrahedron;
    }


}
