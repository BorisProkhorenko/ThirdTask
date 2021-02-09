import com.epam.task.third.entity.Point;
import com.epam.task.third.entity.Tetrahedron;
import com.epam.task.third.repo.TetrahedronRepositoryImplementation;
import com.epam.task.third.validation.TetrahedronIsNotRegularException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

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
    public void testAddTetrahedronWhenRegularTetrahedronApplied() throws TetrahedronIsNotRegularException {
        //given
        repo = new TetrahedronRepositoryImplementation();
        Map<Integer, Tetrahedron> repoMap = repo.getRepoMap();
        //when
        repo.addTetrahedron(regularTetrahedron);
        //than
        Assert.assertEquals(repoMap.get(0), regularTetrahedron);
    }

    @Test(expected = TetrahedronIsNotRegularException.class)
    public void testAddTetrahedronWhenIrregularTetrahedronApplied() throws TetrahedronIsNotRegularException {
        //given
        repo = new TetrahedronRepositoryImplementation();
        //when
        repo.addTetrahedron(irregularTetrahedron);

    }

    @Test
    public void testRemoveTetrahedron() throws TetrahedronIsNotRegularException {
        //given
        repo = new TetrahedronRepositoryImplementation();
        Map<Integer, Tetrahedron> repoMap = repo.getRepoMap();
        repo.addTetrahedron(regularTetrahedron);
        //when
        repo.removeTetrahedron(0);
        //than
        Assert.assertFalse(repoMap.containsValue(regularTetrahedron));
    }

    @Test
    public void testReplaceTetrahedronWhenRegularTetrahedronApplied() throws TetrahedronIsNotRegularException {
        //given
        repo = new TetrahedronRepositoryImplementation();
        Map<Integer, Tetrahedron> repoMap = repo.getRepoMap();
        repo.addTetrahedron(regularTetrahedron);
        //when
        repo.replaceTetrahedron(0, regularTetrahedronForReplacement);
        //than
        Assert.assertEquals(repoMap.get(0), regularTetrahedronForReplacement);
    }

    @Test(expected = TetrahedronIsNotRegularException.class)
    public void testReplaceTetrahedronWhenIrregularTetrahedronApplied() throws TetrahedronIsNotRegularException {
        //given
        repo = new TetrahedronRepositoryImplementation();
        repo.addTetrahedron(regularTetrahedron);
        //when
        repo.replaceTetrahedron(0, irregularTetrahedron);

    }

}
