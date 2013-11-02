/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package preparer.application;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import preparer.data.NormalizedDataPair;

/**
 *
 * @author Meng
 */
public class Application {
    
    public static void main(String[] args){
        
        Controller preparer = Controller.getInstance();
        
        while (true) {
            
            System.out.print("Please Enter Stock Code: ");
            Scanner input = new Scanner(System.in);
            String code = input.next();

            if(code.equalsIgnoreCase("Q")){
                System.exit(0);
            }
            
            List<Map<String, Object>> base = Controller.getInstance().clean(code);
            preparer.prepareForTraining(code, base);
        }        
    }
    
    public static NormalizedDataPair prepareForPrediction(String code, List<Map<String, Object>> data){
        return Controller.getInstance().prepareForPrediction(code, data);
    }
        
    public static void validate(String code, List<NormalizedDataPair> normalizationResult){
        Controller.getInstance().validate(code, normalizationResult);
    }

    public static List<Map<String, Object>> predict(String code, NormalizedDataPair predictionNormalized){
        return Controller.getInstance().predict(code, predictionNormalized);
    }    
}
