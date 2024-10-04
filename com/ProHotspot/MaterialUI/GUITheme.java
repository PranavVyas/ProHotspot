package com.ProHotspot.MaterialUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.border.Border;

public class GUITheme {
   private Color inactiveTextbox;
   private Color activeTextbox;
   private Color textboxText;
   private Color card;
   private Color menuSelectionText;
   private Color menuSelectionBackground;
   private Color menuDisabledText;
   private Color borderlessButtonText;
   private Color inactiveBorderlessButtonBackground;
   private Color activeBorderlessButtonBackground;
   private Color borderedButtonText;
   private Color inactiveBorderedButtonBackground;
   private Color activeBorderedButtonBackground;
   private Border menuBorder;
   private Border defaultBorder;
   private static final Font ITALIC = getFont("Roboto-Italic.ttf");
   private static final Font LIGHT = getFont("Roboto-Light.ttf");
   private static final Font BOLD = getFont("Roboto-Medium.ttf");
   private static final Font REGULAR = getFont("Roboto-Regular.ttf");
   private static final Font THIN = getFont("Roboto-Thin.ttf");
   private static final Font THIN_ITALIC = getFont("RobotoCondensed-LightItalic.ttf");
   public static final GUITheme LIGHT_THEME;
   public static final GUITheme DARK_THEME;

   static {
      LIGHT_THEME = new GUITheme(new Color(230, 230, 230), new Color(220, 220, 220), Color.BLACK, Color.WHITE, Color.BLACK, new Color(230, 230, 230), new Color(0, 0, 0, 100), new Color(33, 150, 243), Color.WHITE, new Color(240, 240, 240), Color.WHITE, new Color(245, 0, 87), new Color(255, 64, 129));
      DARK_THEME = new GUITheme(new Color(90, 90, 90), new Color(120, 120, 120), Color.WHITE, new Color(75, 75, 75), Color.WHITE, new Color(90, 90, 90), new Color(255, 255, 255, 100), Color.WHITE, new Color(75, 75, 75), new Color(100, 100, 100), Color.WHITE, new Color(0, 150, 136), new Color(38, 166, 154));
   }

   public Color getInactiveTextbox() {
      return this.inactiveTextbox;
   }

   public Color getActiveTextbox() {
      return this.activeTextbox;
   }

   public Color getTextboxText() {
      return this.textboxText;
   }

   public Color getCard() {
      return this.card;
   }

   public Color getMenuSelectionText() {
      return this.menuSelectionText;
   }

   public Color getMenuSelectionBackground() {
      return this.menuSelectionBackground;
   }

   public Color getMenuDisabledText() {
      return this.menuDisabledText;
   }

   public Color getBorderlessButtonText() {
      return this.borderlessButtonText;
   }

   public Color getInactiveBorderlessButtonBackground() {
      return this.inactiveBorderlessButtonBackground;
   }

   public Color getActiveBorderlessButtonBackground() {
      return this.activeBorderlessButtonBackground;
   }

   public Color getBorderedButtonText() {
      return this.borderedButtonText;
   }

   public Color getInactiveBorderedButtonBackground() {
      return this.inactiveBorderedButtonBackground;
   }

   public Color getActiveBorderedButtonBackground() {
      return this.activeBorderedButtonBackground;
   }

   public Border getMenuBorder() {
      return this.menuBorder;
   }

   public Border getDefaultBorder() {
      return this.defaultBorder;
   }

   public Font getItalic() {
      return ITALIC;
   }

   public Font getLight() {
      return LIGHT;
   }

   public Font getBold() {
      return BOLD;
   }

   public Font getRegular() {
      return REGULAR;
   }

   public Font getThin() {
      return THIN;
   }

   public Font getThinItalic() {
      return THIN_ITALIC;
   }

   private static Font getFont(String fileName) {
      try {
         return Font.createFont(0, new FileInputStream(new File("fonts//" + fileName))).deriveFont(14.0F);
      } catch (IOException var2) {
         System.out.println(fileName + " not found. set font directory in GUITheme class, getFont (), line 129");
         return null;
      } catch (FontFormatException var3) {
         System.out.println(fileName + " FontFormatException occurred");
         return null;
      }
   }

   private GUITheme(Color inactiveTextbox, Color activeTextbox, Color textboxText, Color card, Color menuSelectionText, Color menuSelectionBackground, Color menuDisabledText, Color borderlessButtonText, Color inactiveBorderlessButtonBackground, Color activeBorderlessButtonBackground, Color borderedButtonText, Color inactiveBorderedButtonBackground, Color activeBorderedButtonBackground) {
      this.menuBorder = new DropShadowBorder(Color.BLACK, 0, 5, 0.3F, 12, true, true, true, true);
      this.defaultBorder = new DropShadowBorder(Color.BLACK, 5, 5, 0.3F, 12, true, true, true, true);
      this.inactiveTextbox = inactiveTextbox;
      this.activeTextbox = activeTextbox;
      this.textboxText = textboxText;
      this.card = card;
      this.menuSelectionText = menuSelectionText;
      this.menuSelectionBackground = menuSelectionBackground;
      this.menuDisabledText = menuDisabledText;
      this.borderlessButtonText = borderlessButtonText;
      this.inactiveBorderlessButtonBackground = inactiveBorderlessButtonBackground;
      this.activeBorderlessButtonBackground = activeBorderlessButtonBackground;
      this.borderedButtonText = borderedButtonText;
      this.inactiveBorderedButtonBackground = inactiveBorderedButtonBackground;
      this.activeBorderedButtonBackground = activeBorderedButtonBackground;
   }
}
