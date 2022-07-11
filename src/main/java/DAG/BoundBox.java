package DAG;


public class BoundBox {
    public final Point first;
    public final Point second;
    // Если бокс вырожденный.
    public BoundBox(Point point) {
        this.first = this.second = point;
    }
    //Если бокс нормальный и состоит из 2 точек.
    public BoundBox(Point first, Point second) {
        this.first = first;
        this.second = second;
    }

    private double maxX = Double.MIN_VALUE, minX = Double.MAX_VALUE;
    private double maxY = Double.MIN_VALUE, minY = Double.MAX_VALUE;

    /**
     * Поиск бокса для данного origin
     * @param origin
     * @return
     */
    public BoundBox findBoundBox(Origin origin) {
        if (origin.getChildren().size() == 0) {
            // Фиктивный бокс.
            return new BoundBox(new Point(new Coords2D(0, 0)));
        }
        //Вырожденный бокс.
        if (origin.getChildren().size() == 1 && !(origin.getChildren().toArray()[0] instanceof Origin)) {
            //Поиск нормального бокса.
            return new BoundBox((Point) (origin.getChildren().toArray()[0]));
        } else if (origin.getChildren().size() > 1) {
            return bound(origin);
        } else {
            System.out.println("Origin has no children, can't form Boundbox!");
            return null;
        }
    }
    // Вынес в отдельный метод чтобы не загружать следующий.
    public void CheckMaxAndMin(Point point) {
        if (point.getPosition().getX() > maxX) {
            maxX = point.getPosition().getX();
        } else if (point.getPosition().getX() < minX) {
            minX = point.getPosition().getX();
        }
        if (point.getPosition().getY() > maxY) {
            maxY = point.getPosition().getY();
        } else if (point.getPosition().getY() < minY) {
            minY = point.getPosition().getY();
        }
    }

    /**
     * Поиск бокса для системы координат с количеством детей больше 1.
     * @param currentOtigin
     * @return
     */
    public BoundBox bound(Origin currentOtigin) {
        for (Point child : currentOtigin.getChildren()) {
            if (child instanceof Origin origin) {
                BoundBox curOrigin = bound(origin);
                Point firstPoint = new Point(new Coords2D(curOrigin.first.getPosition().getX() + origin.getPosition().getX(),
                        curOrigin.first.getPosition().getY() + origin.getPosition().getY()));
                Point secPoint = new Point(new Coords2D(curOrigin.second.getPosition().getX() + origin.getPosition().getX(),
                        curOrigin.second.getPosition().getY() + origin.getPosition().getY()));
                if (firstPoint.getPosition().getX() < minX) {
                    minX = firstPoint.getPosition().getX();
                }
                if (secPoint.getPosition().getY() < minY) {
                    minY = secPoint.getPosition().getY();
                }
                if (firstPoint.getPosition().getY() > maxY) {
                    maxY = firstPoint.getPosition().getY();
                }
                if (secPoint.getPosition().getX() > maxX) {
                    maxX = secPoint.getPosition().getX();
                }
            } else {
                CheckMaxAndMin(child);
            }
        }
        return new BoundBox(new Point(new Coords2D(minX, maxY)), new Point(new Coords2D(maxX, minY)));
    }
}

