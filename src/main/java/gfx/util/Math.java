package gfx.util;

public class Math {
  
  public static int fastfloor(double num) {
    int xi = (int) num;
    return num < xi ? xi - 1 : xi;
  }
}
