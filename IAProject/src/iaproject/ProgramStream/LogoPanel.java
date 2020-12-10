
//package iaproject.ProgramStream;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class LogoPanel extends JPanel {
    
    private BufferedImage gstsLogo;
    private int widthOfImage;
    private int heightOfImage;
    
    public LogoPanel(int w, int h) throws URISyntaxException {
        widthOfImage = w;
        heightOfImage = h;
        try{
            URI uri = new URI("GSTS logo.png");
            URL imageurl = getClass().getResource("/images/imagename");
            InputStream in = Model.class.getClassLoader().getResourceAsStream("/data.sav");
        	gstsLogo = ImageIO.read(in.getInputStream());
           // gstsLogo = ImageIO.read(Model.class.getClassLoader().getResourceAsStream("GSTS logo.png"));
            //gstsLogo = ImageIO.read(new File(getClass().getResourceAsStream("GSTS logo.png").toURI()));
        } catch(IOException ex){
            //Throw error to console
            System.err.println();
            System.out.println(ex.getMessage());
        }
        
    }
    
          public BufferedImage resize(BufferedImage img, int newW, int newH) { 
            Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
            BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

            Graphics2D g2d = dimg.createGraphics();
            g2d.drawImage(tmp, 0, 0, null);
            g2d.dispose();

            return dimg;
        }  
    
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        g.drawImage(resize(gstsLogo, widthOfImage,heightOfImage), 0, 0, this);
    }
    
}
