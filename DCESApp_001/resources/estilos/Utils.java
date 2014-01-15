package estilos;

import net.rim.device.api.math.Fixed32;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.EncodedImage;

public class Utils {
	// Resize a bitmap proportionally (shrink or enlarge) by a  ratio factor 
	static public Bitmap getScaledBitmapImage(String imagename, double ratio)
    {
        
        EncodedImage image = EncodedImage.getEncodedImageResource(imagename); 
        
        int currentWidthFixed32 = Fixed32.toFP(image.getWidth());
        int currentHeightFixed32 = Fixed32.toFP(image.getHeight());
         
        double w = (double) image.getWidth() * ratio; 
        double h = (double)image.getHeight() * ratio;
        int width = (int) w;
        int height = (int) h;
                
        int requiredWidthFixed32 = Fixed32.toFP(width);
        int requiredHeightFixed32 = Fixed32.toFP(height);
        
        int scaleXFixed32 = Fixed32.div(currentWidthFixed32, requiredWidthFixed32);
        int scaleYFixed32 = Fixed32.div(currentHeightFixed32, requiredHeightFixed32);
        
        image = image.scaleImage32(scaleXFixed32, scaleYFixed32);
        
        return image.getBitmap();
    }
	
	// Resize a bitmap proportionally  (shrink or enlarge) to make it fit a maxX x maxY rectangle
    static public Bitmap getFitBitmapImage(String imagename, int maxX, int maxY)
    {
        
        EncodedImage image = EncodedImage.getEncodedImageResource(imagename); 
        
        int currentWidthFixed32 = Fixed32.toFP(image.getWidth());
        int currentHeightFixed32 = Fixed32.toFP(image.getHeight());
         
		//double ratio = (double)ratioX / (double) ratioY;
		double rx = (double) image.getWidth() / (double)maxX; 
		double ry = (double) image.getHeight() / (double)maxY;
		double r = 0;
		if (rx > ry) r = rx; else r= ry;
		double w = (double) image.getWidth() / r; 
		double h = (double) image.getHeight() / r;
		   
		int width = (int) w;
		int height = (int) h;
                
		int requiredWidthFixed32 = Fixed32.toFP(width);
		int requiredHeightFixed32 = Fixed32.toFP(height);
		
		int scaleXFixed32 = Fixed32.div(currentWidthFixed32, requiredWidthFixed32);
		int scaleYFixed32 = Fixed32.div(currentHeightFixed32, requiredHeightFixed32);
		
		image = image.scaleImage32(scaleXFixed32, scaleYFixed32);
		
		return image.getBitmap();
    }  
}
