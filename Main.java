// 11/4/23
// Pierce Mohney
// SDEV 200
// Assignment 2-2
// This program will take user inputted triangle lengths and details than output the triangle perimeter, area, and other details. 

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the three sides of the triangle: ");
        double side1 = scanner.nextDouble();
        double side2 = scanner.nextDouble();
        double side3 = scanner.nextDouble();
//Prompts user to enter in traingle side length

        scanner.nextLine(); // Consume newline character

        System.out.print("Enter the color of the triangle: ");
        String color = scanner.nextLine();
//Prompts user to enter triangle color

        System.out.print("Is the triangle filled? (true/false): ");
        boolean filled = scanner.nextBoolean();
//Prompts user to enter whether triangle is filled or not and creates boolean value

        Triangle triangle = new Triangle(side1, side2, side3);
        triangle.setColor(color);
        triangle.setFilled(filled);
//Creates triangle with user input

        // Display the properties of the triangle
        System.out.println("Triangle properties:");
        System.out.println("Area: " + triangle.getArea());
        System.out.println("Perimeter: " + triangle.getPerimeter());
        System.out.println("Color: " + triangle.getColor());
        System.out.println("Filled: " + triangle.isFilled());
//Outputs the properties of the user inputted triangle

        scanner.close();
    }

    public static abstract class GeometricObject {
        private String color = "white";
        private boolean filled;

        protected GeometricObject() {
        }

        protected GeometricObject(String color, boolean filled) {
            this.color = color;
            this.filled = filled;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public boolean isFilled() {
            return filled;
        }

        public void setFilled(boolean filled) {
            this.filled = filled;
        }

        public abstract double getArea();

        public abstract double getPerimeter();
    }
//Geometric object code 

    public static class Triangle extends GeometricObject {
        private double side1;
        private double side2;
        private double side3;

        public Triangle() {
            this.side1 = 1.0;
            this.side2 = 1.0;
            this.side3 = 1.0;
        }
//Default triangle lengths

        public Triangle(double side1, double side2, double side3) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }
//Constructs triangle with each side length

        public double getSide1() {
            return side1;
        }
//Gets side 1

        public double getSide2() {
            return side2;
        }
//Gets side 2 

        public double getSide3() {
            return side3;
        }
//Gets side 3


        public double getArea() {
            double s = (side1 + side2 + side3) / 2;
            return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        }
//Calculates area of the triangle

        public double getPerimeter() {
            return side1 + side2 + side3;
        }
//Calculates perimeter of the triangle

        @Override
        public String toString() {
            return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
//String method for triangle
        }
    }
}
