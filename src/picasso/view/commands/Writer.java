package picasso.view.commands;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import picasso.model.Pixmap;
import picasso.util.FileCommand;
import picasso.view.Frame;

/**
 * Save the chosen file.
 * 
 * @author Robert C Duvall
 */
public class Writer extends FileCommand<Pixmap> {
	
	static BufferedImage image; 
			
	public Writer() {
		super(JFileChooser.SAVE_DIALOG);
	}

	public void execute(Pixmap target) {
		String fileName = getFileName();
		System.out.println("writer: " + fileName);
		
		if (fileName != null) {
//			target.write(fileName);
			try {
				image = target.myImage;
				ImageIO.write(image, ".png", new File(fileName));
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
