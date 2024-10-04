package com.ProHotspot.MaterialUI;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MaterialUISwingDemo {
   public static void main(String[] args) {
      MaterialLookAndFeel ui = new MaterialLookAndFeel(GUITheme.LIGHT_THEME);

      try {
         UIManager.setLookAndFeel(ui.getName());
      } catch (UnsupportedLookAndFeelException var4) {
      } catch (ClassNotFoundException var5) {
      } catch (InstantiationException var6) {
      } catch (IllegalAccessException var7) {
      }

      JFrame frame = new JFrame("Material Design UI for Swing by atharva washimkar");
      frame.setMinimumSize(new Dimension(300, 300));
      JButton button = new MaterialButton("TEST");
      frame.add(button, "West");
      frame.setVisible(true);
   }
}
