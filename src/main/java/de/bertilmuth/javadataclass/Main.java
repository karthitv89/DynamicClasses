package de.bertilmuth.javadataclass;

import de.bertilmuth.javadataclass.generate.JavaDataClassGenerator;
import de.bertilmuth.javadataclass.model.ClassSpecification;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		readConfigCsvFile();

		// Generate Java source files from the class specifications
		JavaDataClassGenerator javaDataClassGenerator = new JavaDataClassGenerator();
		File temporaryDirectory = Files.createTempDirectory("JAVADATACLASS_").toFile();
		javaDataClassGenerator.generateJavaSourceFiles(readConfigCsvFile(), temporaryDirectory);

		System.out.println("Successfully generated files to: " );
	}

	private static List<ClassSpecification> readConfigCsvFile() {
		List<ClassSpecification> records = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File("config.csv"));) {
			while (scanner.hasNextLine()) {
				String[] confStrArray = scanner.nextLine().split(";");
				records.add(new ClassSpecification(confStrArray[0], confStrArray[1], confStrArray[2]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return records;
	}
}
