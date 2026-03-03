/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JLayeredPane;

/**This class contains a custom extension of {@link JLayeredPane}
 * that allows displaying an image as its background
 * @author csd5153 Sofia Koulouraki
 */
public class JLayeredPaneExtension extends JLayeredPane {

    /**the image to be displayed as the background of this pane
     * */
      Image image;

      /**
       * Constucts a new {@code JLayeredPaneExtension} with the specified
       * image as background
       * @param img The image to be set as the background*/
        public JLayeredPaneExtension(Image img) {
            image=img;
        }

        /**
         * Overrides the {@link javax.swing.JComponent#paintComponent(Graphics)}
         * method to paint the image as the background
         * @param g The {@link Graphics} context in which to paint*/
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }
    }