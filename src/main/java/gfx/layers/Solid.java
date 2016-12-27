package gfx.layers;

import gfx.geometry.Point;
import gfx.util.Color;

/**
 * The most basic type of layer, a single solid color.
 * @author giorgospetkakis
 *
 */
public class Solid extends Layer {
  
  Color solidColor;

  public Solid(int width, int height, Point anchor) {
    super(width, height, anchor);
  }
  
}
