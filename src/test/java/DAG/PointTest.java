package DAG;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    Point point = new Point(new Coords2D(2,3));
    @Test
    void setOrigin() {
        Origin origin = new Origin(new Coords2D(2,2));
        point.setOrigin(origin);
        assertEquals(origin,point.originParent);
    }

    @Test
    void getPosition() {
        Coords2D coords2D = new Coords2D(2,3);
        assertEquals(coords2D,point.getPosition());
    }

    @Test
    void setPosition() {
        point.setPosition(new Coords2D(4,1));
        assertEquals(new Coords2D(4,1),point.getPosition());
    }
}