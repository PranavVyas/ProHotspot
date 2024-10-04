package com.ProHotspot.Instruction;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Function3 {
   public static void Checkbox(boolean res) {
      File file = new File("GenInfo");
      if (!file.exists()) {
         try {
            file.createNewFile();
         } catch (IOException var6) {
            var6.printStackTrace();
         }
      }

      PrintWriter out;
      if (res) {
         try {
            out = new PrintWriter("GenInfo");
            out.println("Firsttime tip : false");
            out.close();
         } catch (FileNotFoundException var5) {
            var5.printStackTrace();
         }
      } else {
         try {
            out = new PrintWriter("GenInfo");
            out.println("Firsttime tip : true");
            out.close();
         } catch (FileNotFoundException var4) {
            var4.printStackTrace();
         }
      }

   }
}
