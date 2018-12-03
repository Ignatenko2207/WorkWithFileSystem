package ua.com.qalight.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FileManipulatorTest {

	private static String textInFile;

	@BeforeAll
	static void setBeforeAll() {
		textInFile = FileManipulator.readTextFromFile();
	}

	@Test
	void testSaveAndReadText() {
		String testText = "abracadabra";
		FileManipulator.writeTextToFile(testText, false);
		
		String textFromFile = FileManipulator.readTextFromFile();
		
		assertEquals("abracadabra\n", textFromFile);
	}

	@Test
	void testCopyTextFile() {
		
		String testText = "abracadabra";
		String pathToCopyFile = FileManipulator.DIRECTORY_PATH + "textCopy.txt";
		
		FileManipulator.writeTextToFile(testText, false);
		
		FileManipulator.copyFile(pathToCopyFile);
		
		String textFromFile = FileManipulator.readTextFromFile(pathToCopyFile);
		
		assertEquals("abracadabra\n", textFromFile);
		
		File file = new File(pathToCopyFile);
		file.delete();
	}

	@AfterAll
	static void setAfterAll() {
		FileManipulator.writeTextToFile(textInFile, false);
	}
}