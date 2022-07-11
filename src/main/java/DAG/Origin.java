package DAG;

import java.util.HashSet;
import java.util.Set;

public class Origin extends Point {
    // Смещение этой системы координат относительно другой системы координат.
    private Coords2D position;
    private Set<Point> children = new HashSet<>();
    private BoundBox bound;
    private Coords2D posWithParentSum;

    public BoundBox getBound() {
        this.bound = bound.findBoundBox(this);
        return bound;
    }

    public Origin(Coords2D coords2D) {
        super(coords2D);
        this.position = coords2D;
        // Фиктивное поле, чтобы при вызове метода для поиска в последствии не вызывать bound.findBoundBox
        //при bound = null.
        bound = new BoundBox(new Point(new Coords2D(0, 0)));
        posWithParentSum = position;
    }

    @Override
    public Coords2D getPosition() {
        return position;
    }

    @Override
    public void setPosition(Coords2D newValue) {
        position = newValue;
    }

    public Set<Point> getChildren() {
        return children;
    }

    // Зациклован ли граф.
    private boolean isCycled = false;

    /**
     * Проверка на то, что в children текущего child нет его родителя.
     * @param child
     */
    private void checkOriginsChildren(Origin child) {
        for (var ch : child.children) {
            if (ch.getPosition().equals(this.getPosition())) {
                isCycled = true;
                return;
            }
            if (ch instanceof Origin) {
                checkOriginsChildren((Origin) ch);
            }
        }
    }

    /**
     * Добавление ребенка с проврекой
     * @param child
     */
    public void setChildren(Point child) {
        // Если координаты совпадают, то не добавляем.
        if (child.getPosition().equals(this.getPosition()) || child.getPosition().equals(new Coords2D(0, 0))) {
            System.out.println("Object can't be self-childed");
            return;
        }
        if (children.contains(child)) {
            System.out.println("Origin's children already contain this child!");
            return;
        }
        if (child instanceof Origin) {
            checkOriginsChildren((Origin) child);
            if (isCycled) {
                System.out.println("You can't add this child because it cycles the DAG");
                throw new DAGConstraintException();
            }
        }
        child.setOrigin(this);
        this.children.add(child);
    }
}
