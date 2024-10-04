package com.ProHotspot.MaterialUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.RoundRectangle2D.Double;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.ImageObserver;
import java.awt.image.Kernel;
import java.util.HashMap;
import java.util.Map;
import javax.swing.UIManager;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;

public class DropShadowBorder extends AbstractBorder implements Border {
   private static final Map<Integer, Map<DropShadowBorder.Position, BufferedImage>> CACHE = new HashMap();
   private Color lineColor;
   private int lineWidth;
   private int shadowSize;
   private float shadowOpacity;
   private int cornerSize;
   private boolean showTopShadow;
   private boolean showLeftShadow;
   private boolean showBottomShadow;
   private boolean showRightShadow;

   public DropShadowBorder() {
      this(UIManager.getColor("Control"), 1, 5);
   }

   public DropShadowBorder(Color lineColor, int lineWidth, int shadowSize) {
      this(lineColor, lineWidth, shadowSize, 0.5F, 12, false, false, true, true);
   }

   public DropShadowBorder(Color lineColor, int lineWidth, boolean showLeftShadow) {
      this(lineColor, lineWidth, 5, 0.5F, 12, false, showLeftShadow, true, true);
   }

   public DropShadowBorder(Color lineColor, int lineWidth, int shadowSize, float shadowOpacity, int cornerSize, boolean showTopShadow, boolean showLeftShadow, boolean showBottomShadow, boolean showRightShadow) {
      this.lineColor = lineColor;
      this.lineWidth = lineWidth;
      this.shadowSize = shadowSize;
      this.shadowOpacity = shadowOpacity;
      this.cornerSize = cornerSize;
      this.showTopShadow = showTopShadow;
      this.showLeftShadow = showLeftShadow;
      this.showBottomShadow = showBottomShadow;
      this.showRightShadow = showRightShadow;
   }

   public void paintBorder(Component c, Graphics graphics, int x, int y, int width, int height) {
      Map<DropShadowBorder.Position, BufferedImage> images = this.getImages((Graphics2D)null);
      Graphics2D g2 = (Graphics2D)graphics;
      g2.setColor(this.lineColor);
      Point topLeftShadowPoint = null;
      if (this.showLeftShadow || this.showTopShadow) {
         topLeftShadowPoint = new Point();
         if (this.showLeftShadow && !this.showTopShadow) {
            topLeftShadowPoint.setLocation(x, y + this.shadowSize);
         } else if (this.showLeftShadow && this.showTopShadow) {
            topLeftShadowPoint.setLocation(x, y);
         } else if (!this.showLeftShadow && this.showTopShadow) {
            topLeftShadowPoint.setLocation(x + this.shadowSize, y);
         }
      }

      Point bottomLeftShadowPoint = null;
      if (this.showLeftShadow || this.showBottomShadow) {
         bottomLeftShadowPoint = new Point();
         if (this.showLeftShadow && !this.showBottomShadow) {
            bottomLeftShadowPoint.setLocation(x, y + height - this.shadowSize - this.shadowSize);
         } else if (this.showLeftShadow && this.showBottomShadow) {
            bottomLeftShadowPoint.setLocation(x, y + height - this.shadowSize);
         } else if (!this.showLeftShadow && this.showBottomShadow) {
            bottomLeftShadowPoint.setLocation(x + this.shadowSize, y + height - this.shadowSize);
         }
      }

      Point bottomRightShadowPoint = null;
      if (this.showRightShadow || this.showBottomShadow) {
         bottomRightShadowPoint = new Point();
         if (this.showRightShadow && !this.showBottomShadow) {
            bottomRightShadowPoint.setLocation(x + width - this.shadowSize, y + height - this.shadowSize - this.shadowSize);
         } else if (this.showRightShadow && this.showBottomShadow) {
            bottomRightShadowPoint.setLocation(x + width - this.shadowSize, y + height - this.shadowSize);
         } else if (!this.showRightShadow && this.showBottomShadow) {
            bottomRightShadowPoint.setLocation(x + width - this.shadowSize - this.shadowSize, y + height - this.shadowSize);
         }
      }

      Point topRightShadowPoint = null;
      if (this.showRightShadow || this.showTopShadow) {
         topRightShadowPoint = new Point();
         if (this.showRightShadow && !this.showTopShadow) {
            topRightShadowPoint.setLocation(x + width - this.shadowSize, y + this.shadowSize);
         } else if (this.showRightShadow && this.showTopShadow) {
            topRightShadowPoint.setLocation(x + width - this.shadowSize, y);
         } else if (!this.showRightShadow && this.showTopShadow) {
            topRightShadowPoint.setLocation(x + width - this.shadowSize - this.shadowSize, y);
         }
      }

      Rectangle topShadowRect;
      if (this.showLeftShadow) {
         topShadowRect = new Rectangle(x, (int)(topLeftShadowPoint.getY() + (double)this.shadowSize), this.shadowSize, (int)(bottomLeftShadowPoint.getY() - topLeftShadowPoint.getY() - (double)this.shadowSize));
         g2.drawImage(((BufferedImage)images.get(DropShadowBorder.Position.LEFT)).getScaledInstance(topShadowRect.width, topShadowRect.height, 2), topShadowRect.x, topShadowRect.y, (ImageObserver)null);
      }

      if (this.showBottomShadow) {
         topShadowRect = new Rectangle((int)(bottomLeftShadowPoint.getX() + (double)this.shadowSize), y + height - this.shadowSize, (int)(bottomRightShadowPoint.getX() - bottomLeftShadowPoint.getX() - (double)this.shadowSize), this.shadowSize);
         g2.drawImage(((BufferedImage)images.get(DropShadowBorder.Position.BOTTOM)).getScaledInstance(topShadowRect.width, topShadowRect.height, 2), topShadowRect.x, topShadowRect.y, (ImageObserver)null);
      }

      if (this.showRightShadow) {
         topShadowRect = new Rectangle(x + width - this.shadowSize, (int)(topRightShadowPoint.getY() + (double)this.shadowSize), this.shadowSize, (int)(bottomRightShadowPoint.getY() - topRightShadowPoint.getY() - (double)this.shadowSize));
         g2.drawImage(((BufferedImage)images.get(DropShadowBorder.Position.RIGHT)).getScaledInstance(topShadowRect.width, topShadowRect.height, 2), topShadowRect.x, topShadowRect.y, (ImageObserver)null);
      }

      if (this.showTopShadow) {
         topShadowRect = new Rectangle((int)topLeftShadowPoint.getX() + this.shadowSize, y, (int)(topRightShadowPoint.getX() - topLeftShadowPoint.getX() - (double)this.shadowSize), this.shadowSize);
         g2.drawImage(((BufferedImage)images.get(DropShadowBorder.Position.TOP)).getScaledInstance(topShadowRect.width, topShadowRect.height, 2), topShadowRect.x, topShadowRect.y, (ImageObserver)null);
      }

      if (this.showLeftShadow || this.showTopShadow) {
         g2.drawImage((BufferedImage)images.get(DropShadowBorder.Position.TOP_LEFT), (BufferedImageOp)null, (int)topLeftShadowPoint.getX(), (int)topLeftShadowPoint.getY());
      }

      if (this.showLeftShadow || this.showBottomShadow) {
         g2.drawImage((BufferedImage)images.get(DropShadowBorder.Position.BOTTOM_LEFT), (BufferedImageOp)null, (int)bottomLeftShadowPoint.getX(), (int)bottomLeftShadowPoint.getY());
      }

      if (this.showRightShadow || this.showBottomShadow) {
         g2.drawImage((BufferedImage)images.get(DropShadowBorder.Position.BOTTOM_RIGHT), (BufferedImageOp)null, (int)bottomRightShadowPoint.getX(), (int)bottomRightShadowPoint.getY());
      }

      if (this.showRightShadow || this.showTopShadow) {
         g2.drawImage((BufferedImage)images.get(DropShadowBorder.Position.TOP_RIGHT), (BufferedImageOp)null, (int)topRightShadowPoint.getX(), (int)topRightShadowPoint.getY());
      }

   }

   private Map<DropShadowBorder.Position, BufferedImage> getImages(Graphics2D g2) {
      Map<DropShadowBorder.Position, BufferedImage> images = (Map)CACHE.get(this.shadowSize);
      if (images == null) {
         images = new HashMap();
         int rectWidth = this.cornerSize + 1;
         RoundRectangle2D rect = new Double(0.0D, 0.0D, (double)rectWidth, (double)rectWidth, (double)this.cornerSize, (double)this.cornerSize);
         int imageWidth = rectWidth + this.shadowSize * 2;
         BufferedImage image = new BufferedImage(imageWidth, imageWidth, 2);
         Graphics2D buffer = (Graphics2D)image.getGraphics();
         buffer.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
         buffer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
         buffer.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
         buffer.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
         buffer.setColor(new Color(0.0F, 0.0F, 0.0F, this.shadowOpacity));
         buffer.translate(this.shadowSize, this.shadowSize);
         buffer.fill(rect);
         float blurry = 1.0F / (float)(this.shadowSize * this.shadowSize);
         float[] blurKernel = new float[this.shadowSize * this.shadowSize];

         for(int i = 0; i < blurKernel.length; ++i) {
            blurKernel[i] = blurry;
         }

         ConvolveOp blur = new ConvolveOp(new Kernel(this.shadowSize, this.shadowSize, blurKernel));
         BufferedImage targetImage = new BufferedImage(imageWidth, imageWidth, 2);
         ((Graphics2D)targetImage.getGraphics()).drawImage(image, blur, -(this.shadowSize / 2), -(this.shadowSize / 2));
         int x = 1;
         int y = 1;
         int w = this.shadowSize;
         int h = this.shadowSize;
         ((Map)images).put(DropShadowBorder.Position.TOP_LEFT, targetImage.getSubimage(x, y, w, h));
         x = 1;
         w = this.shadowSize;
         int h = 1;
         ((Map)images).put(DropShadowBorder.Position.LEFT, targetImage.getSubimage(x, h, w, h));
         x = 1;
         w = this.shadowSize;
         h = this.shadowSize;
         ((Map)images).put(DropShadowBorder.Position.BOTTOM_LEFT, targetImage.getSubimage(x, rectWidth, w, h));
         int x = this.cornerSize + 1;
         int w = 1;
         h = this.shadowSize;
         ((Map)images).put(DropShadowBorder.Position.BOTTOM, targetImage.getSubimage(x, rectWidth, w, h));
         w = this.shadowSize;
         h = this.shadowSize;
         ((Map)images).put(DropShadowBorder.Position.BOTTOM_RIGHT, targetImage.getSubimage(rectWidth, rectWidth, w, h));
         int y = this.cornerSize + 1;
         w = this.shadowSize;
         h = 1;
         ((Map)images).put(DropShadowBorder.Position.RIGHT, targetImage.getSubimage(rectWidth, y, w, h));
         y = 1;
         w = this.shadowSize;
         h = this.shadowSize;
         ((Map)images).put(DropShadowBorder.Position.TOP_RIGHT, targetImage.getSubimage(rectWidth, y, w, h));
         x = this.shadowSize;
         y = 1;
         w = 1;
         h = this.shadowSize;
         ((Map)images).put(DropShadowBorder.Position.TOP, targetImage.getSubimage(x, y, w, h));
         buffer.dispose();
         image.flush();
      }

      return (Map)images;
   }

   public Insets getBorderInsets(Component c) {
      int top = 4 + (this.showTopShadow ? this.lineWidth + this.shadowSize : this.lineWidth);
      int left = 4 + (this.showLeftShadow ? this.lineWidth + this.shadowSize : this.lineWidth);
      int bottom = 4 + (this.showBottomShadow ? this.lineWidth + this.shadowSize : this.lineWidth);
      int right = 4 + (this.showRightShadow ? this.lineWidth + this.shadowSize : this.lineWidth);
      return new Insets(top, left, bottom, right);
   }

   public boolean isBorderOpaque() {
      return true;
   }

   public boolean isShowTopShadow() {
      return this.showTopShadow;
   }

   public boolean isShowLeftShadow() {
      return this.showLeftShadow;
   }

   public boolean isShowRightShadow() {
      return this.showRightShadow;
   }

   public boolean isShowBottomShadow() {
      return this.showBottomShadow;
   }

   public int getLineWidth() {
      return this.lineWidth;
   }

   public Color getLineColor() {
      return this.lineColor;
   }

   public int getShadowSize() {
      return this.shadowSize;
   }

   public float getShadowOpacity() {
      return this.shadowOpacity;
   }

   public int getCornerSize() {
      return this.cornerSize;
   }

   private static enum Position {
      TOP,
      TOP_LEFT,
      LEFT,
      BOTTOM_LEFT,
      BOTTOM,
      BOTTOM_RIGHT,
      RIGHT,
      TOP_RIGHT;
   }
}
