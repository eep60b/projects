package com.etlsolutions.javafx.data;

import com.etlsolutions.javafx.system.CustomLevelErrorRuntimeExceiption;
import com.etlsolutions.javafx.system.ProjectManager;
import com.etlsolutions.javafx.system.SettingConstants;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import org.apache.log4j.Logger;

/**
 *
 * @author zc
 */
public class ImageLinkGenerator {

    private static final ImageLinkGenerator INSTANCE = new ImageLinkGenerator();

    private ImageLinkGenerator() {
    }

    public static final ImageLinkGenerator getInstance() {
        return INSTANCE;
    }

    public ImageLink generateImageLink(String link, String information) {

        BufferedImage originalImage;

        try {
            originalImage = ImageIO.read(new File(link));

        } catch (IOException ex) {

            Logger.getLogger(getClass()).error(ex);
            throw new CustomLevelErrorRuntimeExceiption("The image can not be read at " + link);
        }
        
        int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
        
        BufferedImage resizedImage = new BufferedImage(SettingConstants.DEFAULT_IMG_WIDTH, SettingConstants.DEFAULT_IMG_HEIGHT, type);
	Graphics2D g = resizedImage.createGraphics();
	g.drawImage(originalImage, 0, 0, SettingConstants.DEFAULT_IMG_WIDTH, SettingConstants.DEFAULT_IMG_HEIGHT, null);
	g.dispose();	
	g.setComposite(AlphaComposite.Src);

	g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        String openImageDirectoryPath = ProjectManager.getInstance().getConfiguration().getOpenImageDirectoryPath();
       
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        String newPath = openImageDirectoryPath + File.separator + format.format(date) + ".jpg";
        
        try { 
            ImageIO.write(resizedImage, "jpg", new File(newPath));
        } catch (IOException ex) {
            Logger.getLogger(getClass()).error(ex);
            throw new CustomLevelErrorRuntimeExceiption("Failed to save the image at " + newPath);            
        }
        
        return new ImageLink(newPath, information);
    }
}
