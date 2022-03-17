package Classes;

import javax.swing.ImageIcon;

public class Component {
    String name;
    ImageIcon image;

    public Component () {
        name = "default";
        image = new ImageIcon("Images/default.jpg");
    }

    public Component (String name) {
        this.name = name;

        image = new ImageIcon("Images/default.jpg");
    }

    public Component (String name, String fileName) {
        this.name = name;
        image = new ImageIcon(fileName);
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName () {
        return this.name;
   }

    public void setImageFileName (String fileName) {
        image = new ImageIcon(fileName);
    }

   public ImageIcon getImage () {
       return this.image;
   }
}