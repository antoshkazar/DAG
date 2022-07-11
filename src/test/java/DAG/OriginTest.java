package DAG;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OriginTest {

    @Test
    void getBound() {
    }

    @Test
    void getPosition() {
    }

    @Test
    void setPosition() {
    }

    @Test
    void getChildren() {
        Origin origin = new Origin(new Coords2D(2, 2));
        Point point = new Point(new Coords2D(1, 0));
        origin.setChildren(point);
        Set<Point> children = new HashSet<>();
        children.add(point);
        assertEquals(children, origin.getChildren());
    }
}