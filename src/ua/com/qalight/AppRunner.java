package ua.com.qalight;

import ua.com.qalight.entity.User;
import ua.com.qalight.service.FileManipulator;

public class AppRunner {

	public static void main(String[] args) {
		
		String path = System.getProperty("user.dir") + System.getProperty("file.separator")
		+ "files" + System.getProperty("file.separator") + "user.csv";

		User user = new User();
		
		user.setUserName("Alex");
		user.setUserSurname("Ignatenko");

		FileManipulator.writeObject(path, user);
		
		User userFromFile = FileManipulator.readObject(path);
		
		System.out.println(userFromFile.getUserSurname());
	}
}
