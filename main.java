// Abstract base class for 3D shapes
abstract class Shape3D {
    private String name;

    public Shape3D(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Abstract method that every 3D shape must implement
    public abstract double calculateVolume();
}

// Sphere Class
class Sphere extends Shape3D {
    private double radius;

    public Sphere(double radius) {
        super("Sphere");
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            throw new IllegalArgumentException("Radius must be greater than zero.");
        }
    }

    @Override
    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }
}

// Cube Class
class Cube extends Shape3D {
    private double side;

    public Cube(double side) {
        super("Cube");
        setSide(side);
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        if (side > 0) {
            this.side = side;
        } else {
            throw new IllegalArgumentException("Side length must be greater than zero.");
        }
    }

    @Override
    public double calculateVolume() {
        return Math.pow(side, 3);
    }
}

// Cylinder Class
class Cylinder extends Shape3D {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        super("Cylinder");
        setRadius(radius);
        setHeight(height);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            throw new IllegalArgumentException("Radius must be greater than zero.");
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("Height must be greater than zero.");
        }
    }

    @Override
    public double calculateVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }
}

// Cone Class
class Cone extends Shape3D {
    private double radius;
    private double height;

    public Cone(double radius, double height) {
        super("Cone");
        setRadius(radius);
        setHeight(height);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            throw new IllegalArgumentException("Radius must be greater than zero.");
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("Height must be greater than zero.");
        }
    }

    @Override
    public double calculateVolume() {
        return (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * height;
    }
}

// Rectangular Prism Class
class RectangularPrism extends Shape3D {
    private double length;
    private double width;
    private double height;

    public RectangularPrism(double length, double width, double height) {
        super("Rectangular Prism");
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    public double getLength() { return length; }
    public void setLength(double length) {
        if (length > 0) this.length = length;
        else throw new IllegalArgumentException("Length must be greater than zero.");
    }

    public double getWidth() { return width; }
    public void setWidth(double width) {
        if (width > 0) this.width = width;
        else throw new IllegalArgumentException("Width must be greater than zero.");
    }

    public double getHeight() { return height; }
    public void setHeight(double height) {
        if (height > 0) this.height = height;
        else throw new IllegalArgumentException("Height must be greater than zero.");
    }

    @Override
    public double calculateVolume() {
        return length * width * height;
    }
}

// Main Execution Class demonstrating Polymorphism
public class Main {
    public static void main(String[] args) {
        // Create an array of Shape3D objects (Polymorphism)
        Shape3D[] shapes = {
            new Sphere(4.0),
            new Cube(3.0),
            new Cylinder(2.0, 5.0),
            new Cone(3.0, 6.0),
            new RectangularPrism(2.0, 3.0, 4.0)
        };

        // Iterate through the shapes and calculate volumes dynamically
        for (Shape3D shape : shapes) {
            try {
                System.out.printf("Shape: %s | Volume: %.2f\n", shape.getName(), shape.calculateVolume());
            } catch (IllegalArgumentException e) {
                System.out.println("Error for " + shape.getName() + ": " + e.getMessage());
            }
        }
    }
}