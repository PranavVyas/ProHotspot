package com.ProHotspot.MaterialUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.Timer;

public class MaterialUIMovement {
   private Color fadeColor;
   private int steps;
   private int interval;
   private Map<Color, List<Color>> backgroundColors = new HashMap();

   private List<Color> getColors(Color background) {
      List<Color> o = (List)this.backgroundColors.get(background);
      if (o != null) {
         return o;
      } else {
         List<Color> colors = new ArrayList(this.steps + 1);
         colors.add(background);
         int rDelta = (background.getRed() - this.fadeColor.getRed()) / this.steps;
         int gDelta = (background.getGreen() - this.fadeColor.getGreen()) / this.steps;
         int bDelta = (background.getBlue() - this.fadeColor.getBlue()) / this.steps;
         int aDelta = (background.getAlpha() - this.fadeColor.getAlpha()) / this.steps;

         for(int i = 1; i < this.steps; ++i) {
            int rValue = background.getRed() - i * rDelta;
            int gValue = background.getGreen() - i * gDelta;
            int bValue = background.getBlue() - i * bDelta;
            int aValue = background.getAlpha() - i * aDelta;
            colors.add(new Color(rValue, gValue, bValue, aValue));
         }

         colors.add(this.fadeColor);
         this.backgroundColors.put(background, colors);
         return colors;
      }
   }

   public MaterialUIMovement(Color fadeColor, int steps, int interval) {
      this.fadeColor = fadeColor;
      this.steps = steps;
      this.interval = interval;
   }

   public MaterialUIMovement add(JComponent component) {
      List<Color> colors = this.getColors(component.getBackground());
      new MaterialUIMovement.MaterialUITimer(colors, component, this.interval);
      return this;
   }

   private class MaterialUITimer implements MouseListener, ActionListener {
      private List<Color> colors;
      private JComponent component;
      private Timer timer;
      private int alpha;
      private int increment;

      public void mousePressed(MouseEvent me) {
         this.alpha = MaterialUIMovement.this.steps;
         this.increment = -1;
         this.timer.start();
         this.alpha = 0;
         this.increment = 1;
         this.timer.start();
      }

      public void mouseReleased(MouseEvent me) {
      }

      public void mouseClicked(MouseEvent me) {
      }

      public void mouseExited(MouseEvent me) {
         this.alpha = MaterialUIMovement.this.steps;
         this.increment = -1;
         this.timer.start();
      }

      public void mouseEntered(MouseEvent me) {
         this.alpha = 0;
         this.increment = 1;
         this.timer.start();
      }

      public void actionPerformed(ActionEvent e) {
         this.alpha += this.increment;
         this.component.setBackground((Color)this.colors.get(this.alpha));
         if (this.alpha == MaterialUIMovement.this.steps || this.alpha == 0) {
            this.timer.stop();
         }

      }

      MaterialUITimer(List<Color> colors, JComponent component, int interval) {
         this.colors = colors;
         this.component = component;
         component.addMouseListener(this);
         this.timer = new Timer(interval, this);
      }
   }
}
