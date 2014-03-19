package adins.ace.taps.module;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ExtractPhoto {
	/* extract image in project resources to byte[] */
	public static byte[] extractBytes(String ImageName){
		File fnew = null;
		fnew = new File(ImageName);
		BufferedImage bufferedImage;
		byte[] res = null;
		try {
			bufferedImage = ImageIO.read(fnew);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(bufferedImage, "png", baos);
			res = baos.toByteArray();
		} catch (IOException e) {
			
		}		
		return res;
	}
}
