package com.ProHotspot.MaterialUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

class MaterialButtonUI extends BasicButtonUI {
   public void installUI(JComponent c) {
      super.installUI(c);
      AbstractButton button = (AbstractButton)c;
      button.setOpaque(false);
      button.setBorder(BorderFactory.createEmptyBorder(5, 17, 5, 17));
   }

   public void paint(Graphics g, JComponent c) {
      AbstractButton b = (AbstractButton)c;
      this.paintBackground(g, b);
      super.paint(g, c);
   }

   private void paintBackground(Graphics g, JComponent c) {
      Dimension size = c.getSize();
      Graphics2D g2 = (Graphics2D)g;
      g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
      g.setColor(c.getBackground());
      g.fillRoundRect(0, 0, size.width, size.height, 5, 5);
   }
}
