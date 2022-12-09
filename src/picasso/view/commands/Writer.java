package picasso.view.commands;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
		
		if (fileName != null) {
//			target.write(fileName);
			  try {
				    File file = new File(fileName);
				    // if file doesnt exists, then create it
				    if (!file.exists()) {
				      file.createNewFile();
				    }

				    FileWriter fw = new FileWriter(file.getAbsoluteFile());
				    BufferedWriter bw = new BufferedWriter(fw);
				    bw.write(content);
				    bw.close();
				    
				  } catch (IOException e) {
				    e.printStackTrace();
				  }

		}
	}
}
