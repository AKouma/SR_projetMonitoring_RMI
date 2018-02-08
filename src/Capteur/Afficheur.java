package Capteur;

import javax.swing.JFrame;
import javax.swing.JLabel;

import interFace.AlgoDiffusion;
import interFace.Capteur;
import interFace.ObserverDeCapteur;
import interFace.Subject;

/**
  * @author Aboubacar
 * @author Salifou
 *
 */
public class Afficheur extends JLabel implements ObserverDeCapteur {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
 * Consructeur
 * @param Val
 */
	public Afficheur(String defaul) {
      super(defaul);
	}
	
	
	@Override
	/**
	 * Mise � jour de l'afficheur
	 */
	public void Update(Capteur cap) {
    AlgoDiffusion algorithme = cap.getAlgoDiffusion();
     if(algorithme instanceof DiffusionAtomique) {
    	 int value = cap.getValue();
    	 this.setText(String.valueOf(value));
    	 ((DiffusionAtomique) algorithme).release();
     }
     else if(algorithme instanceof DiffusionParEpoque) {
    	 int value = cap.getValue();
    	 this.setText(String.valueOf(value));
    	 
     }
     else if(algorithme instanceof DiffusionSequentielle) {
    	 int value;
    	((DiffusionSequentielle) algorithme).acquire();
    	 if(((DiffusionSequentielle) algorithme).lecture()) {
    		 value = cap.getValue();
    		 ((DiffusionSequentielle) algorithme).setVal(value);
   	 }
    	 
     }
    	    
    
	}

	@Override
	public void update(Subject Capteur) {
		// TODO Auto-generated method stub
		
	
	}
	 public static void main(String[] args) {
		 
	 }

}
