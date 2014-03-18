package adins.ace.taps.module;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

import org.apache.struts.upload.FormFile;

import adins.ace.taps.configuration.App;

public class PhotoResizeModule {
	private static final int IMG_WIDTH = Integer.parseInt(App.getConfiguration("img_width"));
	private static final int IMG_HEIGHT = Integer.parseInt(App.getConfiguration("img_height"));

	public PhotoResizeModule() {
	}

	private static BufferedImage resizeImage(BufferedImage originalImage,
			int type) {
		BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT,
				type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
		g.dispose();
		return resizedImage;
	}

	public byte[] setResizePhoto(FormFile filepct, String filePathUpload) {
		byte[] result = null;
		try {
			File folder = new File(filePathUpload);
			if (!folder.exists()) {
				folder.mkdir();
			}
			String fileName = filepct.getFileName();
			if (!("").equals(fileName)) {
				File newFile = new File(filePathUpload, fileName);

				if (!newFile.exists()) {
					FileOutputStream fos = new FileOutputStream(newFile);
					fos.write(filepct.getFileData());
					fos.flush();
					fos.close();
				}
			}
			File file = new File(filePathUpload + "/" + filepct.getFileName());

			BufferedImage originalImage = ImageIO.read(file);
			int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB
					: originalImage.getType();

			BufferedImage resizeImageJpg = resizeImage(originalImage, type);

			// converting buffered image to byte array
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(resizeImageJpg, "jpg", baos);
			baos.flush();

			result = baos.toByteArray();
			baos.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

}
