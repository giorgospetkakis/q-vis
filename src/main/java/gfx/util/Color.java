package gfx.util;

public class Color {

  private float red;
  private float green;
  private float blue;
  private float alpha;
  
  //TODO: Add constructor for preset colors
  
  /**
   * Custom color constructor. Alpha is preset to 1.
   * @param red The red value, 0-1
   * @param green The green value, 0-1
   * @param blue The blue value 0-1
   */
  public Color(float red, float green, float blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
    this.alpha = 1;
  }
  
  /**
   * Custom color constructor with alpha.
   * @param red The red value, 0-1
   * @param green The green value, 0-1
   * @param blue The blue value 0-1
   * @param alpha The alpha value 0-1
   */
  public Color(float red, float green, float blue, float alpha) {
    this.red = red;
    this.green = green;
    this.blue = blue;
    this.alpha = alpha;
  }
  
  /**
   * Default color constructor. Defaults to black.
   */
  public Color() {
    this.red = 0;
    this.green = 0;
    this.blue = 0;
  }
  
  public float getRed() {
    return red;
  }
  
  public void setRed(float red) {
    this.red = red;
  }
  
  public float getGreen() {
    return green;
  }
  
  public void setGreen(float green) {
    this.green = green;
  }
  
  public float getBlue() {
    return blue;
  }
  
  public void setBlue(float blue) {
    this.blue = blue;
  }
  
  public float getAlpha() {
    return alpha;
  }
  
  public void setAlpha(float alpha) {
    this.alpha = alpha;
  }
}
