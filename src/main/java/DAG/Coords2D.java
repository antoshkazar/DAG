package DAG;

// "Математические точки" 2D-пространства.
public class Coords2D {
    private final double x;
    private final double y;

    public Coords2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    /**
     * Геттер координаты У.
     * @return
     */
    public double getY() {
        return y;
    }

    /**
     * По ТЗ сравнение обЪектов типа Coords2d производится путем сравнения их координат, поэтому
     * перегружаем оператор.
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        Coords2D other = (Coords2D) obj;
        return this.x == other.x && this.y == other.y;
    }
}