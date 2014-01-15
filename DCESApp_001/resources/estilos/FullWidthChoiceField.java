package estilos;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.ObjectChoiceField;
import net.rim.device.api.util.Arrays;

public class FullWidthChoiceField extends ObjectChoiceField {

      private Object[] _choices;  // cached for convenience
      private int _orientation;   // track device orientation

      public void setChoices(Object[] choices) {
         // TODO: this pixel value may need some tweaking!
         final int HBUFFER_PX = 62;
         int desiredWidth = (Display.getWidth()) - getPaddingLeft() - getPaddingRight()
               - getMarginLeft() - getMarginRight() - HBUFFER_PX;
         Font font = getFont();         
         int advanceOfOneSpace = font.getAdvance(' ');

         for (int c = 0; c < choices.length; c++) {  
            String trimmedChoice = ((String)choices[c]).trim();
            // how wide is the text for this choice?          
            int advance = font.getAdvance(trimmedChoice);
            int numSpacesToPad = Math.max(0, (desiredWidth - advance) / advanceOfOneSpace);
            char[] pad = new char[numSpacesToPad];
            Arrays.fill(pad, ' ');
            choices[c] = new String(pad) + trimmedChoice;  // pad to left of choice
         }

         _choices = choices;
         super.setChoices(choices);
      }

      // only needed if your app supports rotation!
      protected void layout(int width, int height) {
         super.layout(width, height);
         if (_orientation != Display.getOrientation()) {
            // orientation change -> we must readjust the choice field
            _orientation = Display.getOrientation();
            UiApplication.getUiApplication().invokeLater(new Runnable() {
               public void run() {
                  setChoices(_choices);               
               }
            });
         }
      }           
   }