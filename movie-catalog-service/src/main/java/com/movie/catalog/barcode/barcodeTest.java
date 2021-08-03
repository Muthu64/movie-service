package com.movie.catalog.barcode;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import org.krysalis.barcode4j.HumanReadablePlacement;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.impl.upcean.EAN13Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

public class barcodeTest
{
    public static BufferedImage generateEAN13BarcodeImage(String barcodeText)
    {
        Code128Bean barcodeGenerator = new Code128Bean();
        //EAN13Bean barcodeGenerator = new EAN13Bean();
        BitmapCanvasProvider canvas = new BitmapCanvasProvider(160, BufferedImage.TYPE_BYTE_BINARY, false, 0);

        barcodeGenerator.setMsgPosition( HumanReadablePlacement.HRP_NONE);
        barcodeGenerator.generateBarcode(canvas, barcodeText);
        return canvas.getBufferedImage();
    }
    public static void main( String[] args ) throws IOException
    {
        BufferedImage bufferedImage =generateEAN13BarcodeImage( "saravanan is a good boy" );
        File outputfile = new File("barcode.png");
        //ImageIO.write(bufferedImage, "png", outputfile);

        BufferedImage bufferedImageRead = ImageIO.read( outputfile );

        System.out.println(" successfully written image");
    }
}
