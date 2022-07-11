package DAG;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoundBoxTest {
    BoundBox boundBox = new BoundBox(new Point(new Coords2D(-10, 3)), new Point(new Coords2D(4, -3)));

    @Test
    void findBoundBox() {

        Origin origin = new Origin(new Coords2D(2, 2));
        origin.setChildren(new Point(new Coords2D(1, 0)));
        origin.setChildren(new Point(new Coords2D(-5, 3)));
        origin.setChildren(new Point(new Coords2D(4, -3)));
        origin.setChildren(new Point(new Coords2D(0, 0)));
        origin.setChildren(new Point(new Coords2D(-10, 3)));
        origin.setChildren(new Point(new Coords2D(0, -3)));
        Origin orig3 = new Origin(new Coords2D(3,3));
        Origin orig4 = new Origin(new Coords2D(1,1));
        BoundBox boundBox1 = origin.getBound().findBoundBox(origin);
        assertEquals(boundBox1.first.getPosition().getX(),boundBox.first.getPosition().getX());
        assertEquals(boundBox1.first.getPosition().getY(),boundBox.first.getPosition().getY());
        assertEquals(boundBox1.second.getPosition().getX(),boundBox.second.getPosition().getX());
        assertEquals(boundBox1.second.getPosition().getY(),boundBox.second.getPosition().getY());
        origin.setChildren(orig3);
        origin.setChildren(orig4);
        orig3.setChildren(new Point(new Coords2D(1, 3)));
        orig4.setChildren(new Point(new Coords2D(0, -2)));
        orig4.setChildren(new Point(new Coords2D(5, 10)));
        BoundBox boundBox2 = origin.getBound().findBoundBox(origin);
        boundBox = new BoundBox(new Point((new Coords2D(-10,14))), new Point(new Coords2D(9,-3)));
        assertEquals(boundBox2.first.getPosition().getX(),boundBox.first.getPosition().getX());
        assertEquals(boundBox2.first.getPosition().getY(),boundBox.first.getPosition().getY());
        assertEquals(boundBox2.second.getPosition().getX(),boundBox.second.getPosition().getX());
        assertEquals(boundBox2.second.getPosition().getY(),boundBox.second.getPosition().getY());
    }
    @Test
    void setChildren() {
        Origin o = new Origin(new Coords2D(1, 1));
        Point p = new Point(new Coords2D(1, 1));
        o.setChildren(p);
    }
    @Test
    void checkMaxAndMin() {

    }

    @Test
    void bound() {
    }
}