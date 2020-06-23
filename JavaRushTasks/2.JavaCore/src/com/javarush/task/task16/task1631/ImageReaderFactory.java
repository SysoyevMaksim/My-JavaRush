package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

import java.io.BufferedReader;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageType){
        if (imageType == ImageTypes.BMP){
            return new BmpReader();
        }
        if (imageType == ImageTypes.JPG){
            return new JpgReader();
        }
        if (imageType == ImageTypes.PNG){
            return new PngReader();
        }
        throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
