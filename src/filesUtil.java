import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.io.BufferedReader;

public class filesUtil {

	// To Read the values of text File
	public static String readTextFile(String fileName) throws IOException {
		String content = new String(Files.readAllBytes(Paths.get(fileName)));
		return content;
	}

	// To Read the values of text File
	public static List<String> readTextFilesByLines(String fileName)
			throws IOException {
		List<String> lines = Files.readAllLines(Paths.get(fileName));
		return lines;
	}

	// To Read the values of text File
	public static void writeToTextFile(String filename, String content)
			throws IOException {
		Files.write(Paths.get(filename), content.getBytes(),
				StandardOpenOption.CREATE);
	}

	// Return the feedback value for every input
	public static String returnFeedbackLine(BufferedReader br) {
		String sCurrentLine = null;
		String fbStack = null;
		try {
			// br = new BufferedReader(new FileReader(
			// "C:\\Hackathon\\InputFile\\file.txt"));
			// While loop to print the value of the text file
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.print("\n" + sCurrentLine);
				if (fbStack != null) {
					fbStack += "\n" + sCurrentLine;
				} else {
					fbStack = sCurrentLine;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return fbStack;
		}
		return fbStack;
	}

	public static void writeOutput(String outputPath, String resultOp) throws IOException {

		try {
			File file = new File(outputPath);
			file.createNewFile();
			String verify, putData = null;

			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(resultOp);
			bw.flush();
			bw.close();
//			FileReader fr = new FileReader(file);
//			BufferedReader br = new BufferedReader(fr);
//			while (br.readLine() != null) {
//				verify = br.readLine();
//				if (verify != null) {
////					putData = verify.replaceAll("here", "there");
//					putData = "1/n0/n-1/n";
//					bw.write(putData);
//				}
//			}
//			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
