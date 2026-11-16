package uebungen.exceptions;

import javax.swing.*;

public class ConvertBinaryTest
{
  public ConvertBinaryTest()
  {
      try {
          System.out.println("10111011 ist " + BinaryStringToNumber.parseBinary("10111011"));
          String s = "10511011";
          System.out.println(s + " ist " + BinaryStringToNumber.parseBinary(s));
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null,e.getMessage());
        //System.out.println(e.getMessage());
      }
  }
  public static void main(String[] args)
  {

    ConvertBinaryTest ConvertingBinary = new ConvertBinaryTest();

  }
}
