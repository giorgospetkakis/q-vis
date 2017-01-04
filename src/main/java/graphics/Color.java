package graphics;

/**
 * A faster color class.
 * 
 * @author giorgospetkakis
 *
 */
public class Color {
  
  /**
   * A selection of custom colors.
   * BLACK, WHITE, RED, GREEN, BLUE, THALO BLUE, SKY BLUE
   * CREAM, VIOLET, LIME, GOLD.
   * @author giorgospetkakis
   *
   */
  public enum ColorPreset {
    BLACK("#000000"),
    WHITE("#ffffff"),
    
    RED("ff0000"),
    GREEN("00ff00"),
    BLUE("0000ff"),
    
    THALO("#390083"),
    SKY("3fb8ee"),
    CREAM("fff0f5"),
    VIOLET("c9bcf0"),
    LIME("68ec02"),
    GOLD("ffd700");
    
    public String hexCode;
    private ColorPreset(String hex) {
      this.hexCode = hex;
    }
  }
  
  public double red;
  public double blue;
  public double green;
  public double alpha;
  
  /**
   * 
   * @param red
   * @param green
   * @param blue
   */
  public Color(double red, double green, double blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }
  
  /**
   * 
   * @param red
   * @param green
   * @param blue
   * @param alpha
   */
  public Color(double red, double green, double blue, double alpha) {
    this.red = red;
    this.green = green;
    this.blue = blue;
    this.alpha = alpha;
  }
  
   /**
    * 
    * @param preset
    */
  public Color(ColorPreset preset) {
    red = Integer.parseInt(preset.hexCode.substring(0, 2)) / 255.0;
    green = Integer.parseInt(preset.hexCode.substring(2, 4)) / 255.0;
    blue = Integer.parseInt(preset.hexCode.substring(4)) / 255.0;
  }
}
