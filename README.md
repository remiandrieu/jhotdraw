# jhotdraw

[![Java CI with Maven](https://github.com/wumpz/jhotdraw/actions/workflows/maven.yml/badge.svg)](https://github.com/wumpz/jhotdraw/actions/workflows/maven.yml)

## Introduction

JHotDraw is a Java library for creating structured drawing editors. It provides a framework for building applications that allow users to create, edit, and manipulate graphical figures such as rectangles, ellipses, and custom shapes. Common use cases include simple doodle programs, diagramming tools or vector graphics editors.

## News

> **ATTENTION**: Due to the refactoring in 10.0-SNAPSHOT this version breaks API of JHotdraw. Some adaptions are needed, e.g.: attributes now using `attr()`, ...

* heavy restructuring of classes and interfaces and cleanup
  * removed FigureListener from some Figures and Handles
  * complete attribute handling of Figure moved in class Attributes, access over **attr()**
  * Drawing has no dependency to CompositeFigure anymore and implementations do not use 
   AbstractCompositeFigure implementations
  * Drawing has its own listener DrawingListener now instead of FigureListener and CompositeFigureListener
  * contains(point, scale) is now called to take view scale into account for finding figures
  * removed DEBUG mode and introduced some logging instead
  * removed DOMStorable from Drawing, Figure
  * introduced a new module **jhotdraw-io** for input output and dom storables
* JDK 17
* maven build process
* restructured project layout
  * introduced submodules

## Quickstart

**Prerequisites**: Java Development Kit (JDK) 17 or later, Apache Maven 3.6 or later.

This projects jars are not yet published to maven central or GitHub packages. To use those you first need to build it with **maven** using: `mv clean install`. Now all jars are published to your local maven repository. And you can include those artifacts using e.g.

```xml
<dependency>
  <groupId>org.jhotdraw</groupId>
  <artifactId>jhotdraw-core</artifactId>
  <version>10.0-SNAPSHOT</version>
</dependency>
```

In module `jhotdraw-samples-mini` are small examples mostly highlighting one aspect of JHotdraw usage.
Additional to that are in module `jhotdraw-samples-misc` more sophisticated examples of using this library.

## Development

### Adding a New Rectangular Figure

JHotDraw allows easy addition of custom figures. For a figure representable in a rectangle (e.g., rectangle, ellipse, image):

1. **Choose base class**:
   - Extend `AbstractAttributedFigure` for simple figures.
   - Extend `AbstractAttributedDecoratedFigure` for figures with borders/decorations.

2. **Implement abstract methods**:
   - `drawFill(Graphics2D g)`: Draw fill.
   - `drawStroke(Graphics2D g)`: Draw stroke.
   - `contains(Point2D.Double p, double scale)`: Check point containment.
   - `setBounds(Point2D.Double anchor, Point2D.Double lead)`: Set bounds.
   - `getBounds(double scale)`: Get bounds.

3. **Reuse common methods**:
   - Copy `transform(AffineTransform tx)` and `setBounds` from existing classes like `RectangleFigure`

See `RectangleFigure.java`, `EllipseFigure.java`, or `ImageFigure.java` for examples.

## License

* LGPL V2.1
* Creative Commons Attribution 2.5 License

## History 

This is a fork of jhotdraw from http://sourceforge.net/projects/jhotdraw.
