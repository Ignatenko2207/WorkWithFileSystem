package ua.com.qalight.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;

import ua.com.qalight.entity.User;

public class FileManipulator {

	public static byte[] readFile(String filePath) {
		byte[] out = null;
		File file = new File(filePath);

		try {
			out = Files.readAllBytes(file.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return out;
	}

	public static User readObject(String filePath) {
		User user = null;

		try (	FileInputStream fis = new FileInputStream(filePath);
				ObjectInputStream ois = new ObjectInputStream(fis) ){

				user = (User) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public static void writeObject(String filePath, User user) {
		
		try (FileOutputStream fos = new FileOutputStream(filePath);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(user);
			oos.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void writeBytesToFile(String filePath, byte[] bytes) {

		File file = new File(filePath);

		try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
			fileOutputStream.write(bytes);
			fileOutputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void copyFile(String sourcePath, String targetPath) {

		byte[] bytes = readFile(sourcePath);
		
		writeBytesToFile(targetPath, bytes);
	}

	public static final String DIRECTORY_PATH = System.getProperty("user.dir") + System.getProperty("file.separator")
			+ "files" + System.getProperty("file.separator");

	private static final String FILE_NAME = "text.txt";

	public static String readTextFromFile() {
		String out = "";
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		try {
			fileReader = new FileReader(DIRECTORY_PATH + FILE_NAME);
			bufferedReader = new BufferedReader(fileReader);

			String line = "";

			while ((line = bufferedReader.readLine()) != null) {
				out += line + "\n";
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return out;
	}

	public static void writeTextToFile(String textToFile, boolean append) {

		try (FileWriter fileWriter = new FileWriter(DIRECTORY_PATH + FILE_NAME, append)) {

			fileWriter.write(textToFile);
			fileWriter.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void copyFile(String pathToCopyFile) {
		String textFromFile = readTextFromFile();

		try (FileWriter fileWriter = new FileWriter(pathToCopyFile)) {

			fileWriter.write(textFromFile);
			fileWriter.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String readTextFromFile(String pathToFile) {
		String out = "";
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		try {
			fileReader = new FileReader(pathToFile);
			bufferedReader = new BufferedReader(fileReader);

			String line = "";

			while ((line = bufferedReader.readLine()) != null) {
				out += line + "\n";
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return out;
	}

}
