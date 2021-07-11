package filehandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileModificationProgram {

	static void modifyFile(String filePath) {
		File fileToBeModified = new File(filePath);

		String oldContent = "";

		BufferedReader reader = null;

		FileWriter writer = null;

		try {
			reader = new BufferedReader(new FileReader(fileToBeModified));

			String line = reader.readLine();
			boolean flag = true;
			while (line != null) {
				for (int i = 0; i < line.length() - 3 && flag; i++) {
					if (line.substring(i, i + 3).equals("SET")) {
						String s[] = line.split("=");
						String ch = s[1].substring(0,2);						
						int val = Integer.parseInt(s[1].substring(2));
						line = line.substring(0,s[0].length())+"="+ch+(++val);
						flag = false;
					}
				}
				oldContent = oldContent + line + System.lineSeparator();
				line = reader.readLine();
			}
			writer = new FileWriter(fileToBeModified);

			writer.write(oldContent);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// Closing the resources

				reader.close();

				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		modifyFile("/Users/503132605/Desktop/WC_Command.bat");

		System.out.println("done");
	}
}