package logical;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.UIManager;
import weka.classifiers.evaluation.output.prediction.PlainText;
import visual.Principal;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.M5P;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.instance.RemoveWithValues;
import weka.classifiers.functions.LinearRegression;
import weka.classifiers.functions.Logistic;
import weka.classifiers.meta.AdaBoostM1;

public class Weka {
	
	private Evaluation gloE;
	private Classifier gloC;
	
	
	public static void main(String[] args) throws FileNotFoundException, Exception {
		Principal prin = new Principal();
        prin.setVisible(true);
        
        try { 
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
	public String log() throws Exception {
		DataSource source = new DataSource("data.arff");
        Instances tSet = source.getDataSet();
        tSet.setClassIndex(tSet.numAttributes()-1);
        Classifier cls = new AdaBoostM1();
        Evaluation eval = new Evaluation(tSet);
        eval.crossValidateModel(cls, tSet, 10, new Random(1));
        
        String resultado="";
        resultado += "Accuracy Estimada: "+Double.toString(eval.pctCorrect())+ "\n";
        
        Classifier clst = new AdaBoostM1();
        clst.buildClassifier(tSet);
        Evaluation eval2 = new Evaluation(tSet);
        eval2.evaluateModel(clst, tSet);
        setGloE(eval2);
        setGloC(clst);
        
        
        
        
        resultado+="*********************************\n";
        resultado+="Actual" +"\t"+ "AdaBoost Predijo\n";
        resultado+="*********************************\n";

        for (int i = 0; i < tSet.numInstances(); i++) {
                Instance nInstance = tSet.instance(i);
                double predJ48 = clst.classifyInstance(nInstance);

                resultado += tSet.classAttribute().value((int) tSet.instance(i).classValue())+"\t" +  tSet.classAttribute().value((int) predJ48) + "\n";
        }
        
        resultado += eval2.toSummaryString("\nResumen\n**************\n", false);
        resultado += "\nAccuracy Estimada: "+Double.toString(eval.pctCorrect())+ "\n";
        
		return clst.toString() + resultado;
	}
	
	public String Compare(String t1, String t2) throws Exception {
		
		DataSource source = new DataSource("data.arff");
        Instances tSet = source.getDataSet();
        for (int i = tSet.numInstances()-1; i>=0; i--) {
            Instance nInstance = tSet.instance(i);
            
            if(!(nInstance.toString().contains(t1))) {
            		tSet.delete(i);
            		
            	
        }
            
        }
        
        DataSource sources = new DataSource("data.arff");
        Instances tSets = sources.getDataSet();
        for (int i = tSets.numInstances()-1; i>=0; i--) {
            Instance nInstance = tSets.instance(i);
            
            if(!(nInstance.toString().contains(t2))) {
            		tSets.delete(i);
            		
            	
        }
            
        }
        int men = 0;
        if(tSets.numInstances()<tSet.numInstances()) {
        	men = tSets.numInstances();
        }else {
        	men = tSet.numInstances();
        }
        
        Instances mix = source.getDataSet();
        
        mix.delete();
        	
        for(int i =0; i<men; i++) {
        	Instance n = tSets.instance(i);
        	Instance m = tSet.instance(i);
        	mix.add(n);
        	mix.add(m);
        	
        }
        
       
        mix.setClassIndex(mix.numAttributes()-1);
        
        String resultado="";
        
        
        Classifier clst = new AdaBoostM1();
        clst.buildClassifier(mix);
        Evaluation eval2 = new Evaluation(mix);
        eval2.evaluateModel(clst, mix);
        
        
        
        
        resultado+="*********************************\n";
        resultado+="Actual" +"\t"+ "AdaBoost Predijo\n";
        resultado+="*********************************\n";

        for (int i = 0; i < mix.numInstances(); i++) {
                Instance nInstance = mix.instance(i);
                double predJ48 = clst.classifyInstance(nInstance);

                resultado += mix.classAttribute().value((int) mix.instance(i).classValue())+"\t" +  mix.classAttribute().value((int) predJ48) + "\n";
        }
        
        resultado += eval2.toSummaryString("\nResumen\n**************\n", false);
        
        
		
        
		int c1 = count_Words(tSet.toString());
        int c2 = count_Words(tSets.toString());
        
		if(c1>c2) {
			resultado+= "\n"+ "El ganador sera: " + t1;
		}else {
			resultado+= "\n"+"El ganador sera: " + t2;

		}
		
		return clst.toString() + resultado;
	}


	public Evaluation getGloE() {
		return gloE;
	}


	public void setGloE(Evaluation gloE) {
		this.gloE = gloE;
	}
	
	 public static int count_Words(String str)
	    {
		 int i = 0;
		 Pattern p = Pattern.compile("win");
		 Matcher m = p.matcher( str );
		 while (m.find()) {
		     i++;
		 }
		return i;
	    }


	public Classifier getGloC() {
		return gloC;
	}


	public void setGloC(Classifier gloC) {
		this.gloC = gloC;
	}
	
}
