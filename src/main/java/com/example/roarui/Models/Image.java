package com.example.roarui.Models;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image extends Media {
    public static final String SIZE_UNIT = "Kilobytes";

    private int height;

    private int width;

    public Image(File file) throws IOException {
        this.file = file;
        this.height = processHeight();
        this.width = processWidth();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int processHeight() throws IOException {
        BufferedImage bImg = ImageIO.read(file);
        return bImg.getHeight();
    }

    public int processWidth() throws IOException {
        BufferedImage bImg = ImageIO.read(file);
        return bImg.getWidth();
    }
}
