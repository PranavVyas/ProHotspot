package com.ProHotspot.MaterialUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.UIManager;

public class MaterialButton extends JButton {
   private MaterialUIMovement animate;
   private static Color clr = new Color(51, 153, 255);
   private static Color hghclr = new Color(0, 51, 255);
   private static Color fgrclr = new Color(255, 255, 255);

   private void configureSettings(Color background, Color foreground, Color hover) {
      this.setBackground(background);
      this.setForeground(foreground);
      this.animate = new MaterialUIMovement(hover, 5, 33);
      this.animate.add(this);
      this.setFocusPainted(false);
      this.setUI(new MaterialButtonUI());
   }

   public MaterialButton(String text) {
      this(text.toUpperCase(), clr, fgrclr, hghclr);

      try {
         Font f = Font.createFont(0, new FileInputStream(new File("fonts//Roboto-Bold.ttf"))).deriveFont(14.0F);
         this.setFont(f);
      } catch (FileNotFoundException var3) {
         var3.printStackTrace();
      } catch (FontFormatException var4) {
         var4.printStackTrace();
      } catch (IOException var5) {
         var5.printStackTrace();
      }

   }

   public MaterialButton(Icon icon) {
      this(icon, clr, UIManager.getColor("Button.foreground"), UIManager.getColor("Button.highlight"));
   }

   public MaterialButton(Icon icon, Color background, Color foreground, Color hover) {
      super(icon);
      this.configureSettings(background, foreground, hover);
   }

   public MaterialButton(String text, Color background, Color foreground, Color hover) {
      super(text);
      this.configureSettings(background, foreground, hover);
   }
}
