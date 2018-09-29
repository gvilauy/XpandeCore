package org.xpande.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * Clase de métodos staticos referidos a funcionalidades de archivos.
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 12/27/17.
 */
public final class FileUtils {


    /***
     * Metodo para copiar un archivo desde una ubicación-nombre a otra ubicación-nombre.
     * Xpande. Created by Gabriel Vila on 12/27/17.
     * @param sourceFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFile(File sourceFile, File destFile) throws IOException {

        if (!destFile.exists()) {
            destFile.createNewFile();
        }

        FileChannel origen = null;
        FileChannel destino = null;

        try {
            origen = new FileInputStream(sourceFile).getChannel();
            destino = new FileOutputStream(destFile).getChannel();

            long count = 0;
            long size = origen.size();

            while ((count += destino.transferFrom(origen, count, size - count)) < size)
                ;
        }

        finally {
            if (origen != null) {
                origen.close();
            }
            if (destino != null) {
                destino.close();
            }
        }
    }

}
