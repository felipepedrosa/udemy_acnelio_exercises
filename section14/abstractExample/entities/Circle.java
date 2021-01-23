package section14.abstractExample.entities;

import section14.abstractExample.entities.enums.Color;

public class Circle extends Shape {
    private Double radius;

    public Circle() {
        super();
    }

    public Circle(Color color, Double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public Double area() {
        return Math.PI * Math.pow(this.radius, 2);
    }
}
