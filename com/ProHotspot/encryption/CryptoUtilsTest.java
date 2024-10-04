package com.ProHotspot.encryption;

import java.io.File;

public class CryptoUtilsTest {
   public static void main(String[] args) {
   }

   public static void encFile(String fname, String key) {
      File inputFile = new File(fname);
      File encryptedFile = new File(fname + ".encrypted");
      inputFile.deleteOnExit();

      try {
         CryptoUtils.encrypt(key, inputFile, encryptedFile);
      } catch (CryptoException var5) {
         System.out.println(var5.getMessage());
         var5.printStackTrace();
      }

   }

   public static void decFile(String fname, String key) {
      File encryptedFile = new File(fname + ".encrypted");
      File decryptedFile = new File(fname + ".decrypted");
      decryptedFile.deleteOnExit();

      try {
         CryptoUtils.decrypt(key, encryptedFile, decryptedFile);
      } catch (CryptoException var5) {
         System.out.println(var5.getMessage());
         var5.printStackTrace();
      }

   }

   public static boolean checkLicense(String f1, String f2) {
      return false;
   }
}
