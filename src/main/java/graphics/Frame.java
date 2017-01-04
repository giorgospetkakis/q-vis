package graphics;

import graphics.Color.ColorPreset;

public class Frame {
  
  Color[][] pixels;
  Color fill;
  
  public Frame(Color[][] pixels) {
    this.pixels = pixels;
  }
  
  public Frame(Color fill) {
    this.fill = fill;
  }
  
  public Frame() {
    this.fill = new Color(ColorPreset.BLACK);
  }
}
