import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import opennlp.tools.sentdetect.SentenceModel;

	
	
public class readText {

	public static void main(String[] args) throws IOException {
		
		String resultOp = null;
		String path = "C:\\WorkSpace\\sample\\src\\HackathonInput.txt"; 
		readText obj = new readText();
		SentenceModel model = null;
		
		String sTotFb = obj.generateString(path);
		String[] StotFbVal = sTotFb.split("\n");
		
		   
	//Loop to segregate the individual input words and validate for sentiment
		for (String indval:StotFbVal) {
			resultOp = null;
			String[] indWord = indval.split(" ");
			for (String eachWord:indWord) {
				String positiveAdj = sentimentalwords.returnPositiveLine();
				String negativeAdj = sentimentalwords.returnNegativeLine();
				if (positiveAdj.contains(eachWord)){
					if (resultOp != null) {
						resultOp += "\n" + " Positive";
					} else {
						resultOp = " Positive";
					}
				} else if (negativeAdj.contains(eachWord)) {
					if (resultOp != null) {
						resultOp += "\n" + " negative";
					} else {
						resultOp = " negative";
					}
				} else {
					if (resultOp != null) {
						resultOp += "\n" + " neutral";
					} else {
						resultOp = " neutral";
					}
				}
		}
			String resultpl = "\n" + resultOp;
		}
		
		//Write result
		filesUtil.writeOutput("C:\\WorkSpace\\sample\\src\\Rockers_Out.txt", resultOp);
	}

	public String generateString(String path) throws IOException {
		System.out.print(System.getProperty("user.dir"));
		BufferedReader br = null;
		String sCurrentLine = null;
		
		br = new BufferedReader(new FileReader(path));
		String StotFb = filesUtil.returnFeedbackLine(br);
		System.out.print("\n\n\n" + StotFb);
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return StotFb;
	}

}
