package gfx.layers;

import gfx.geometry.Point;

/**
 * The most basic type of layer, a single solid color.
 * @author giorgospetkakis
 *
 */
public class Solid extends Layer {

  public Solid(int width, int height, Point anchor) {
    super(width, height, anchor);
  }
  
}
