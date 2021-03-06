package Video;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Test {

	public static void main(String[] args) throws Exception
    {
        /////////////////////////////
        //////  CONFIGURATION  //////
        /////////////////////////////

        // Zone de la prise de vue
        Rectangle screenRect = new Rectangle(100,100,1000,800);

        // Temps en secondes de la vidéo
        int duree = 5;

        // Nombres d'images par seconde
        int frequence = 60;

        // Début des noms de fichiers (ils seront complétés par _{indice}.png)
        File prefix = new File("./img");

        /////////////////////////////

        Robot robot = new Robot();

        int max = duree*frequence; // nombre d'images au total
        long delai = 1000/frequence; // temps d'attentes entre deux images (en ms)

        // tableau d'enregistrement des images
        BufferedImage[] images = new BufferedImage[max];

        System.out.println("Début des captures d'images.");

        for (int i=0; i<max; i++)
        {
            // capture de l'image
            images[i] = robot.createScreenCapture(screenRect);

            // attente entre deux images à capturer
            Thread.sleep(delai);
        }

        System.out.println("Fin des captures d'images.");

        // nom générique des images
        String format = String.format("%s_%%0%dd.png", prefix.getAbsolutePath(),String.valueOf(max).length());
        System.out.println("Début d'enregistrement des images --> "+format);

        for (int i=0; i<max; i++)
        {
            // nom spécifique de l'image
            String file = String.format(format, i);

            // enregistrement de l'image
            ImageIO.write(images[i],"png",new File(file));
        }

        System.out.println("Fin d'enregistrement des images.");
    }

}
