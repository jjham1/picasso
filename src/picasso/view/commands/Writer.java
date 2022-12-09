package picasso.view.commands;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import picasso.model.Pixmap;
import picasso.util.FileCommand;

/**
 * Save the chosen file.
 * 
 * @author Robert C Duvall
 */
public class Writer extends FileCommand<Pixmap> {
	public Writer() {
		super(JFileChooser.SAVE_DIALOG);
	}

	public void execute(Pixmap target) {
		String fileName = getFileName();
		System.out.println("writer: " + fileName);
		
		if (fileName != null) {
//			target.write(fileName);
			try {
				ImageIO.write(target.BufferedImage, "jpg", new File(fileName));
			} catch (IOException e) {
				e.printStackTrace();
			}

//			  try {
//				    File file = new File(fileName);
//				    
//				    // if file doesnt exists, then create it
//				    if (!file.exists()) {
//				      file.createNewFile();
//				    }
//
//				    FileWriter fw = new FileWriter(file.getAbsoluteFile());
//				    BufferedWriter bw = new BufferedWriter(fw);
//				    bw.write(content);
//				    bw.close();
//				    
//				  } catch (IOException e) {
//				    e.printStackTrace();
//				  }
//
		}
	}
}
