/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 *
 * @author ezgi
 */
public class İmageProcessing {

    /**
     * @param args the command line arguments
     */
    private static BufferedImage resim, renkliresim, gaussianelma, ananas,
            gaussianananas, ananas_eksi_gaussians, grielma, grielmavertical, çilek, temizçilekler, elma;

    public static void main(String[] args) throws IOException {

        //  File ananas_eksi_gaussian = new File(System.getProperty("user.dir") + "\\src\\imageprocessing\\substractpic.jpg");
        // ananas_eksi_gaussians = ImageIO.read(ananas_eksi_gaussian);
/* File original_f = new File(System.getProperty("user.dir") + "\\src\\imageprocessing\\elma.jpg");
        resim = ImageIO.read(original_f);
         File gaussianresim = new File(System.getProperty("user.dir") + "\\src\\imageprocessing\\Gaussian.jpg");
        gaussianelma = ImageIO.read(gaussianresim);
        File grielmaverticals = new File(System.getProperty("user.dir") + "\\src\\imageprocessing\\Grielmavertical.jpg");
        grielmavertical = ImageIO.read(grielmaverticals);
                File gaussianana = new File(System.getProperty("user.dir") + "\\src\\imageprocessing\\Gaussianananas.jpg");
        gaussianananas = ImageIO.read(gaussianana);
         File anans = new File(System.getProperty("user.dir") + "\\src\\imageprocessing\\ananas260.jpg");
        ananas = ImageIO.read(anans);
        File grielmacık = new File(System.getProperty("user.dir") + "\\src\\imageprocessing\\elmaGrayscale.jpg");
        grielma = ImageIO.read(grielmacık);
        
         */
        //get_pixel(resim, 150, 150);
        // set_pixel(resim, 150, 150, 255, 255, 255);
        //Shiftrgb(resim, 100, 0, 0, 0);//başlangıç rgb değerleri resimden bağımsız olarak (0,0,0) a initialize edildi 
        //çünkü rgb sadece rgb de ki kaydırma sonunda alınan değeri göstermek için kullanıldı.
        // makeGray(resim);
        // copyImage(resim); //Set edilmiş resmi elmacopy de görebilirsiniz 150,150 koordinatına beyaz bir nokta koyuldu.
        // resizeimageneighbour(resim);
        // resizeimagebilinear(ananas);
        // Neighbour_resize(ananas, 520, 520);
        //elma 130 130
        //  BufferedImage a = getFilteredImage(grielma,emboss,1);
        //File lenna = new File(System.getProperty("user.dir") + "\\src\\imageprocessing\\Grielmaembossfilters.jpg");
        // ImageIO.write(a, "jpg", lenna);
        // substactBufferedImage(ananas,resim) ;
        // BufferedImage added= addBufferedImage(ananas,resim);
        // File lenn = new File(System.getProperty("user.dir") + "\\src\\imageprocessing\\addedpicture.jpg");
        //ImageIO.write(added, "jpg", lenn);
        //substractpicture(ananas,gaussianananas,0,0,0);
        // addpicture(gaussianananas,ananas_eksi_gaussians,0,0,0);
        // addpicture(resim, gaussianananas, 0, 0, 0);
        // File çilekler = new File(System.getProperty("user.dir") + "\\src\\imageprocessing\\elma.jpg");
        //  çilek = ImageIO.read(çilekler);
        /*BufferedImage added= gaussian_noise(temizçilekler,15,50);
        File lenn = new File(System.getProperty("user.dir") + "\\src\\imageprocessing\\Gussiannoisefilter.jpg");
        ImageIO.write(added, "jpg", lenn);*/
        File temizçilek = new File(System.getProperty("user.dir") + "\\src\\imageprocessing\\Gussiannoisefilter.jpg");
        temizçilekler = ImageIO.read(temizçilek);
        File elmacık = new File(System.getProperty("user.dir") + "\\src\\imageprocessing\\elma.jpg");
        elma = ImageIO.read(elmacık);

        // SaltPepper( temizçilekler);
        //  Clearsalt(temizçilekler);
       // periNoiseHoriz(elma, 40);
        periodicNoiseVertical(elma,40);

    }

    public static void SaltPepper(BufferedImage im) throws IOException {
        String copyPath = System.getProperty("user.dir") + "\\src\\imageprocessing\\clearsaltyyygrey.png";
        BufferedImage res = new BufferedImage(im.getWidth(), im.getHeight(), BufferedImage.TYPE_INT_RGB);

        File file = new File(copyPath);
        int tuzsayısı = (im.getHeight()) * (im.getWidth()) / 25;

        for (int i = 0; i < tuzsayısı; i++) {
            im.setRGB((int) (Math.random() * im.getWidth()), (int) (Math.random() * im.getHeight()), 0xffffff);
            im.setRGB((int) (Math.random() * im.getWidth()), (int) (Math.random() * im.getHeight()), 0x000000);
        }
        ImageIO.write(im, "png", file);

    }

    public static void Clearsalt(BufferedImage im) throws IOException {
        //i use this code for clear salt noise and gaussian noise  

        String copyPath = System.getProperty("user.dir") + "\\src\\imageprocessing\\cleargussiannoise.jpg";
        BufferedImage res = new BufferedImage(im.getWidth(), im.getHeight(), BufferedImage.TYPE_INT_RGB);
        File file = new File(copyPath);

        Color[] pixel = new Color[9];
        int[] R = new int[9];
        int[] B = new int[9];
        int[] G = new int[9];
        for (int i = 1; i < im.getWidth() - 1; i++) {
            for (int j = 1; j < im.getHeight() - 1; j++) {
                pixel[0] = new Color(im.getRGB(i - 1, j - 1));
                pixel[1] = new Color(im.getRGB(i - 1, j));
                pixel[2] = new Color(im.getRGB(i - 1, j + 1));
                pixel[3] = new Color(im.getRGB(i, j + 1));
                pixel[4] = new Color(im.getRGB(i + 1, j + 1));
                pixel[5] = new Color(im.getRGB(i + 1, j));
                pixel[6] = new Color(im.getRGB(i + 1, j - 1));
                pixel[7] = new Color(im.getRGB(i, j - 1));
                pixel[8] = new Color(im.getRGB(i, j));
                for (int k = 0; k < 9; k++) {
                    R[k] = pixel[k].getRed();
                    B[k] = pixel[k].getBlue();
                    G[k] = pixel[k].getGreen();
                }
                Arrays.sort(R);
                Arrays.sort(G);
                Arrays.sort(B);
                im.setRGB(i, j, new Color(R[4], B[4], G[4]).getRGB());
            }
        }
        ImageIO.write(im, "jpg", file);

    }

    public static BufferedImage gaussian_noise(BufferedImage img, double mean, double std_variance) {
        BufferedImage noise_img = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

        Random random = new Random();
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                int gray = (int) (random.nextGaussian() * std_variance + mean);
                gray += img.getRGB(i, j) & 0xff;
                if (gray < 0) {
                    gray = 0;
                }
                if (gray > 255) {
                    gray = 255;
                }
                int rgb = ((gray * 256) + gray) * 256 + gray;

                noise_img.setRGB(i, j, rgb);
            }
        }
        return noise_img;
    }

    public static void periNoiseHoriz(BufferedImage im, int period) throws IOException {

        String copyPath = System.getProperty("user.dir") + "\\src\\imageprocessing\\horizontalperiodicnoise.jpg";
        BufferedImage res = new BufferedImage(im.getWidth(), im.getHeight(), BufferedImage.TYPE_INT_RGB);
        File file = new File(copyPath);
        for (int m = 0; m < im.getWidth(); m++) {
            for (int n = 0; n < im.getHeight(); n++) {
                Color color = new Color(im.getRGB(m, n));
                if (n % period < period / 2) {
                    color = color.brighter();
                } else {
                    color = color.darker();
                }
                im.setRGB(m, n, color.getRGB());
            }
        }
        ImageIO.write(im, "jpg", file);
    }


public static void periodicNoiseVertical(BufferedImage im, int period) throws IOException{
        String copyPath = System.getProperty("user.dir") + "\\src\\imageprocessing\\verticalperiodicnoise.jpg";
        BufferedImage res = new BufferedImage(im.getWidth(), im.getHeight(), BufferedImage.TYPE_INT_RGB);
        File file = new File(copyPath);
        for(int m=0; m<im.getWidth(); m++){
            for(int n=0; n<im.getHeight(); n++){
                Color ca = new Color(im.getRGB(m, n));
                if(m%period<period/2) ca =ca.brighter();
                else ca=ca.darker();
                im.setRGB(m, n, ca.getRGB());
            }
        }
        ImageIO.write(im, "jpg", file);
    }

}




/*
    public static void set_pixel(BufferedImage im, int x, int y, int r, int g, int b) throws IOException {

        BufferedImage setlenmişresim = new BufferedImage(resim.getWidth(), resim.getHeight(), BufferedImage.TYPE_INT_RGB);
        Color col = new Color(r, g, b);
        resim.setRGB(x, y, col.getRGB());
        Color settedcolor = new Color(im.getRGB(x, y));
        System.out.println("RGB= " + settedcolor.getRed() + "," + settedcolor.getGreen() + "," + settedcolor.getBlue() + " // pixel at " + x + "," + y);

    }

    public static void copyImage(BufferedImage im) throws IOException {
        String copyPath = System.getProperty("user.dir") + "\\src\\imageprocessing\\elmacopy.jpg";
        BufferedImage kopyaresim = new BufferedImage(resim.getWidth(), resim.getHeight(), BufferedImage.TYPE_INT_RGB);
        File file = new File(copyPath);
        for (int x = 0; x < im.getWidth(); x++) {
            for (int y = 0; y < im.getHeight(); y++) {
                kopyaresim.setRGB(x, y, im.getRGB(x, y));

            }
        }
        ImageIO.write(kopyaresim, "jpg", file);

    }

    public static Color get_pixel(BufferedImage im, int x, int y) {
        if (im.getHeight() < y || im.getWidth() < x) {
            System.err.println("ERROR, image out of Bound");
            return null;
        } else {
            Color a = new Color(im.getRGB(x, y));
            System.out.println("RGB= " + a.getRed() + "," + a.getGreen() + "," + a.getBlue() + " // pixel at " + x + "," + y);
            return a;
        }

    }

  

    public static void makeGray(BufferedImage im) throws IOException {
        String copyPath = System.getProperty("user.dir") + "\\src\\imageprocessing\\elmaGrayscale.jpg";
        BufferedImage grielma = new BufferedImage(resim.getWidth(), resim.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        File file = new File(copyPath);
        Graphics g = grielma.getGraphics();
        g.drawImage(resim, 0, 0, null);
        ImageIO.write(grielma, "jpg", file);

    }
 public static void Shiftrgb(BufferedImage im, int shift, int r, int g, int b) throws IOException {
        String copyPath = System.getProperty("user.dir") + "\\src\\imageprocessing\\elmashiftrg.jpg";
        BufferedImage shiftresim = new BufferedImage(im.getWidth(), im.getHeight(), BufferedImage.TYPE_INT_RGB);
        File file = new File(copyPath);

        for (int x = 0; x < im.getWidth(); x++) {

            for (int y = 0; y < im.getHeight(); y++) {

                if (y < im.getHeight() && x < im.getWidth()) {

                    Color a = new Color(im.getRGB(x, y));
                    r = a.getRed() + shift;
                    g = a.getGreen() + shift;
                    b = a.getBlue() + shift;
                    Color newcol = new Color(sol(r), sol(g), sol(b));
                    shiftresim.setRGB(x, y, newcol.getRGB());

                }
            }
        }
        ImageIO.write(shiftresim, "jpg", file);

  
    public static int sol(int x) {
        if (x < 0) {
            return 0;
        } else if (x > 255) {
            return 255;
        } else {
            return x;
        }
    }

    
}*/
 /*2.ÖDEVVV  /////////////////////////////////////////////////////////////////////////////////////////////////*/
 /*public static int solar(int x){
         //sobel filtrelemelerinde divisionby zero hatası almamamak için yazdım
         //solar fonksiyonunda resmi önce vertical edge ile okuturken return değeri 4 olarak ayarlanmalı 
         //verticaldan horizontal resim elde ederken (sobel)return değeri 2 olarak ayarlanmalı
         if(x==0){
             return 3;
         }else
             return x;
         }*/
 /*

    public static void resizeimageneighbour(BufferedImage im) throws IOException {
        String copyPath = System.getProperty("user.dir") + "\\src\\imageprocessing\\elmaresizeneighbour.jpg";
        BufferedImage resizedimage = new BufferedImage(520, 520, BufferedImage.TYPE_INT_ARGB);
        File file = new File(copyPath);
        Graphics2D g2 = resizedimage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        g2.drawImage(resim, 0, 0, 520, 520, null);
        g2.dispose();
        ImageIO.write(resizedimage, "jpg", file);

    }

    public static void resizeimagebilinear(BufferedImage im) throws IOException {
        String copyPath = System.getProperty("user.dir") + "\\src\\imageprocessing\\ananasresizebilinear.jpg";
        BufferedImage resizedimage = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
        File file = new File(copyPath);
        Graphics2D g2 = resizedimage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(ananas, 0, 0, 500, 500, null);
        g2.dispose();
        ImageIO.write(resizedimage, "jpg", file);

    }
public static void Neighbour_resize(BufferedImage im, int w, int h) throws IOException {
        //sadece resmi 2x 4x... büyültürken işe yarıyor
        String copyPath = System.getProperty("user.dir") + "\\src\\imageprocessing\\ananasBigsize.jpg";
        BufferedImage copypath = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        File file = new File(copyPath);
        int go = w / im.getWidth();// genişlik oranı
        int yo = h / im.getHeight();//yükseklik oranı 

        for (int x = 0; x < w - 1; x += go) {
            for (int i = 0; i < go; i++) {
                for (int y = 0; y < h - 1; y += yo) {
                    for (int k = 0; k < yo; k++) {

                        copypath.setRGB(x + i, y + k, im.getRGB(x / go, y / yo));
                    }
                }
            }
        }
        ImageIO.write(copypath, "jpg", file);
    }

 */
 /*/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
 /*  public static final int[][] filter9 = {{1, 1, 1},
    {1, 1, 1},
    {1, 1, 1}
    };
    public static final int[][] sharpen = {{-1/9, -1/9, -1/9},
    {-1/9, 1, -1/9},
    {-1/9, -1/9, -1/9}
    };
    public static final int[][] Highpass = {{0, -1/4, 0},
    {-1/4,+2,-1/4},
    {0, -1/4, 0}
    };
    
    public static final int[][] gaussian = {{1, 2, 1},
    {2,4,2},
    {1, 2, 1}
    };
     public static final int[][] emboss ={
    {-2, 0, 0},
    {0, 1, 0},
    {0, 0, 2}};
  /*public static final int[][] emboss ={
    {0, +1, 0},
    {0, 0, 0},
    {0, -1, 0}}; 
    // vertical ve horizontal edge filitreleri sobel filtresinde kullanıldı. 
      public static final int[][] vertical = {{-1, 2, -1},
    {-1, 2, -1},
    {-1, 2, -1}
    };
        public static final int[][] horizontal = {{-1, -1, -1},
    {2, 2, 2},
    {-1, -1, -1}
    };
 */
 /*/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
 /* public static BufferedImage getFilteredImage(BufferedImage givenImage, int[][] filter, int iterationNum) throws IOException {

        int count = 0;
        while (count < iterationNum) {

            for (int y = 1; y + 1 < givenImage.getHeight(); y++) {
                for (int x = 1; x + 1 < givenImage.getWidth(); x++) {
                    Color tempColor = getFilteredValue(givenImage, y, x, filter);
                    givenImage.setRGB(x, y, tempColor.getRGB());

                }
            }
            count++;
        }

        return givenImage;
    }

    private static Color getFilteredValue(final BufferedImage givenImage, int y, int x, int[][] filter) {
        int r = 0, g = 0, b = 0;
        for (int j = -1; j <= 1; j++) {
            for (int k = -1; k <= 1; k++) {

                r += (filter[1 + j][1 + k] * (new Color(givenImage.getRGB(x + k, y + j))).getRed());
                g += (filter[1 + j][1 + k] * (new Color(givenImage.getRGB(x + k, y + j))).getGreen());
                b += (filter[1 + j][1 + k] * (new Color(givenImage.getRGB(x + k, y + j))).getBlue());
            }

        }
        r = r / solar(sum(filter));
        g = g / solar(sum(filter));
        b = b / solar(sum(filter));
        return new Color(sol(r), sol(g), sol(b));
    }

    private static int sum(int[][] filter) {
        int sum = 0;
        for (int y = 0; y < filter.length; y++) {
            for (int x = 0; x < filter[y].length; x++) {
                sum += filter[y][x];
            }
        }
        return sum;
    }
        
 */
 /*/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/

 /*
    public static void addpicture(BufferedImage img1,BufferedImage img2 , int r, int g, int b) throws IOException {
        String copyPath = System.getProperty("user.dir") + "\\src\\imageprocessing\\addedpicture.jpg";
        BufferedImage addedresim = new BufferedImage(resim.getWidth(), resim.getHeight(), BufferedImage.TYPE_INT_RGB);
        File file = new File(copyPath);

        for (int x = 0; x < img1.getWidth(); x++) {

            for (int y = 0; y < img1.getHeight(); y++) {

                if (y < img1.getHeight() && x < img1.getWidth()) {

                    Color a = new Color(img1.getRGB(x, y));
                    Color ba = new Color(img2.getRGB(x, y));
                    r = a.getRed() + ba.getRed();
                    g = a.getGreen() + ba.getGreen();
                    b = a.getBlue() + ba.getBlue();
                    Color newcol = new Color(sol(r), sol(g), sol(b));
                    addedresim.setRGB(x, y, newcol.getRGB());

                }
            }
        }
        ImageIO.write(addedresim, "jpg", file);
     
    }
    
 */
 /*/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/

 /*
      public static void substractpicture(BufferedImage img1,BufferedImage img2 , int r, int g, int b) throws IOException {
        String copyPath = System.getProperty("user.dir") + "\\src\\imageprocessing\\substractpics.jpg";
        BufferedImage substract = new BufferedImage(resim.getWidth(), resim.getHeight(), BufferedImage.TYPE_INT_RGB);
        File file = new File(copyPath);

        for (int x = 0; x < img1.getWidth(); x++) {

            for (int y = 0; y < img1.getHeight(); y++) {

                if (y < img1.getHeight() && x < img1.getWidth()) {

                    Color a = new Color(img1.getRGB(x, y));
                    Color ba = new Color(img2.getRGB(x, y));
                    r = a.getRed() - ba.getRed();
                    g = a.getGreen() - ba.getGreen();
                    b = a.getBlue() - ba.getBlue();
                    Color newcol = new Color(sol(r), sol(g), sol(b));
                    substract.setRGB(x, y, newcol.getRGB());

                }
            }
        }
        ImageIO.write(substract, "jpg", file);
     
    }
     
 */ //simdilik çalışmıyor:(}
// final int THRESHOLD = 7;

/*      public static BufferedImage addBufferedImage(BufferedImage img1,
      BufferedImage img2) {
    int offset = 2;
    int width = img1.getWidth() + img2.getWidth() + offset;
    int height = Math.max(img1.getHeight(), img2.getHeight()) + offset;
    BufferedImage newImage = new BufferedImage(width, height,
    BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = newImage.createGraphics();
    Color oldColor = g2.getColor();
    g2.setPaint(Color.BLACK);
    g2.fillRect(0, 0, width, height);
    g2.setColor(oldColor);
    g2.drawImage(img1, null, 0, 0);
    g2.drawImage(img2, null, img1.getWidth() + offset, 0);
    g2.dispose();
    kenarınaresim ekleme*/
 /*    public static void substactBufferedImage(BufferedImage img1,
      BufferedImage img2) throws IOException {
        String copyPath = System.getProperty("user.dir") + "\\src\\imageprocessing\\substractresim.jpg";
       
        File file = new File(copyPath);
        
        BufferedImage image3 = new BufferedImage(img1.getWidth(), img1.getHeight(), BufferedImage.TYPE_INT_ARGB);
        int color;
        for(int x = 0; x < img1.getWidth(); x++)
            for(int y = 0; y < img1.getHeight(); y++) {
                color = Math.abs(img2.getRGB(x, y) - img2.getRGB(x, y));                
                image3.setRGB(x, y, color);
            }
        ImageIO.write(image3, "jpg",  file);

        
        
        
        
        
        
        
    }*/
