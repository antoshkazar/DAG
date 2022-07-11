package DAG;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Coords2DTest {

    @Test
    void getX() {
        Coords2D coords2D = new Coords2D(2,0);
        assertEquals(2,coords2D.getX());
    }

    @Test
    void getY() {
        Coords2D coords2D = new Coords2D(2,0);
        assertEquals(0,coords2D.getY());
    }

    @Test
    void testEquals() {
        Coords2D coords2D = new Coords2D(2,0);
        Coords2D coords2D1 = new Coords2D(2,0);
        Coords2D coords2D2 = new Coords2D(3,1);
        assertEquals(coords2D, coords2D1);
        assertNotEquals(coords2D, coords2D2);
    }
}