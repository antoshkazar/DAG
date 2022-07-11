package DAG;


// Физическая точка.
public class Point {
    // Поле, хранящее текущую позицию точки.
    private Coords2D position;
    private BoundBox bounds;
    // Проверяет, лежит ли точка в мировой системе координат.
    private boolean belongsToWSC;
    // Родитель точки.
    public Origin originParent;

    public Point(Coords2D coords2D) {
        position = coords2D;
        bounds = new BoundBox(this);
        belongsToWSC = true;
    }

    public void setOrigin(Origin origin) {
        originParent = origin;
        belongsToWSC = false;
    }

    public Coords2D getPosition() {
        return position;
    }

    public void setPosition(Coords2D newValue) {
        position = newValue;
    }
}
