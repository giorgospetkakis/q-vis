package gfx.layers;

import gfx.geometry.Point;
import gfx.util.Math;

public abstract class Layer {
  private Point anchor;

  private Point topLeft;
  private Point topRight;
  
  private Point bottomLeft;
  private Point bottomRight;
  
  private float scaleX;
  private float scaleY;
  
  private float rotation;
  
  private float transparency;
  
  /**
   * Plane instant521iation constructor.
   * 
   * @param width The width of the layer.
   * @param height The height of the layer.
   * @param anchor The anchor point of the layer.
   */
  public Layer(int width, int height, Point anchor) {
    setAnchor(anchor);
    
    setLeftBound((Math.fastfloor(this.anchor.getX()) - width));
    setTopBound((Math.fastfloor(this.anchor.getY()) - height));
    
    setRightBound((Math.fastfloor(this.anchor.getX()) + width));
    setBottomBound((Math.fastfloor(this.anchor.getY()) + height));
    
    setScaleX(1);
    setScaleY(1);
    
    setRotation(0);
    
    setTransparency(1);
  }
  
  public void setTopBound(float ybound) {
    this.topLeft = new Point(this.topLeft.getX(), ybound);
  }
  
  public void setBottomBound(float ybound) {
    this.topLeft = new Point(this.bottomLeft.getX(), ybound);
  }
  
  public void setLeftBound(float xbound) {
    this.topLeft = new Point(xbound, this.topLeft.getY());
  }
  
  public void setRightBound(float xbound) {
    this.topLeft = new Point(xbound, this.bottomLeft.getY());
  }
  
  public Point getTopLeft() {
    return topLeft;
  }

  public Point getTopRight() {
    return topRight;
  }

  public Point getBottomLeft() {
    return bottomLeft;
  }

  public Point getBottomRight() {
    return bottomRight;
  }

  public double getScaleX() {
    return scaleX;
  }

  public void setScaleX(float scaleX) {
    this.scaleX = scaleX;
  }

  public double getScaleY() {
    return scaleY;
  }

  public void setScaleY(float scaleY) {
    this.scaleY = scaleY;
  }

  public double getRotation() {
    return rotation;
  }
  
  /**
   * Set layer rotation.
   * @param rotation The new rotation.
   */
  public void setRotation(float rotation) {
    float angle = rotation - this.rotation;
    
    float sin = (float) java.lang.Math.sin(angle);
    float cos = (float) java.lang.Math.cos(angle);
    
    float minX = topLeft.getX() - anchor.getX();
    float minY = topLeft.getY() - anchor.getY();
    
    float maxX = bottomRight.getX() - anchor.getX();
    float maxY = bottomRight.getY() - anchor.getY();
    
    this.topLeft = new Point(
        (minX * cos - minY * sin) + anchor.getX(),
        (minX * sin + minY * cos) + anchor.getY());
    this.topRight = new Point(
        (maxX * cos - minY * sin) + anchor.getX(),
        (maxX * sin + minY * cos) + anchor.getY());
    this.bottomLeft = new Point(
        (minX * cos - maxY * sin) + anchor.getX(),
        (minX * sin + maxY * cos) + anchor.getY());
    this.bottomRight = new Point(
        (maxX * cos - maxY * sin) + anchor.getX(), 
        (maxX * sin + maxY * cos) + anchor.getY());
    
    this.rotation = rotation;
  }

  public float getTransparency() {
    return transparency;
  }
  
  /**
   * Set layer transparency. Clamped to range 0.0 -> 1.0.
   * @param transparency The new transparency.
   */
  public void setTransparency(float transparency) {
    if (transparency > 1.0) {
      this.transparency = 1.0f;
    } else if (transparency < 0) {
      this.transparency = 0;
    } else {
      this.transparency = transparency;
    }
  }

  public Point getAnchor() {
    return anchor;
  }

  public void setAnchor(Point anchor) {
    this.anchor = anchor;
  }
}
