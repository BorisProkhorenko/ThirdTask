import com.epam.task.third.entity.Point;
import com.epam.task.third.entity.Tetrahedron;
import com.epam.task.third.repo.TetrahedronRepositoryImplementation;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class TetrahedronRepositoryImplementationTest {
    private static final TetrahedronRepositoryImplementation REPO = new TetrahedronRepositoryImplementation();
    private static Tetrahedron regularTetrahedron;
    private static Tetrahedron irregularTetrahedron;
    private static Tetrahedron regularTetrahedronForReplacement;
    private TetrahedronRepositoryImplementation repo;

    @BeforeClass
    public static void initialize() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(1, 0, 0);
        Point c = new Point(0.5, 0.866025, 0);
        Point d = new Point(0.5, 0.288675, 0.816496);
        Point q = new Point(0.5, 0.288675, -0.816496);
        Point w = new Point(1, 1, 1);

        regularTetrahedron = new Tetrahedron(a, b, c, d);
        irregularTetrahedron = new Tetrahedron(w, b, c, q);
        regularTetrahedronForReplacement = new Tetrahedron(a, b, c, q);
    }

    @Test
    public void testAddTetrahedronWhenRegularTetrahedronApplied()  {
        //given
        repo = new TetrahedronRepositoryImplementation();
        //when
        repo.addTetrahedron(regularTetrahedron);
        //than
        Assert.assertEquals(repo.getTetrahedronById(0), regularTetrahedron);
    }



    @Test
    public void testRemoveTetrahedron() {
        //given
        repo = new TetrahedronRepositoryImplementation();
        repo.addTetrahedron(regularTetrahedron);
        //when
        repo.removeTetrahedron(0);
        //than
        Assert.assertNull(repo.getTetrahedronById(0));
    }

    @Test
    public void testReplaceTetrahedronWhenRegularTetrahedronApplied(){
        //given
        repo = new TetrahedronRepositoryImplementation();
        repo.addTetrahedron(regularTetrahedron);
        //when
        repo.replaceTetrahedron(0, regularTetrahedronForReplacement);
        //than
        Assert.assertEquals(repo.getTetrahedronById(0), regularTetrahedronForReplacement);
    }


}
