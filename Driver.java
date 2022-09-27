package com.lockedme;

import java.util.Scanner;

public class Driver {
	
	public static void main(String [] args) {
//		final String ROOT_DIRECTORY_PATH ="E://Java_Practice//Test_Files";
		String directoryName;
		String FileName;
		
		LockedMeBo bo = new LockedMeBo();
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Welcome to LockedMe.com");
		System.out.println("Check out our Products listings.");
		System.out.println("\n");
		int ch, ch1;
		do
		{
			System.out.println("1. Fetch List of files");
			System.out.println("2. To Edit your files");
			System.out.println("3. Exit from the application");
			System.out.println("Please Enter your choice");
			ch = sc.nextInt();
			directoryName = readDirectoryName(sc);
			switch(ch) {
			case 1: 
				
				bo.displayFilesInAscendingOrder(directoryName);
				break;
			case 2:
				do
				{
					System.out.println("1. Add File to the Directory");
					System.out.println("2. Remove file from Directory");
					System.out.println("3. Searching a file in Directory");
					System.out.println(" Enter your choice");
					ch1 = sc.nextInt();
					switch(ch1)
					{
					case 1:
						FileName =readFileName(sc);
						bo.addFile(FileName, directoryName);
						break;
					case 2:
						FileName = readFileName(sc);
						bo.deleteFile(FileName, directoryName);
						break;
					case 3:
						FileName = readFileName(sc);
						bo.searchFile(FileName, directoryName);
						break;
					}
				}while(ch1<=3);
			}
		}while(ch < 3);
	}

	private static String readFileName(Scanner sc) {
		System.out.println("enter the file name to edit");
		sc.nextLine();
		String filename = sc.nextLine();
		return filename;
	}
	
	private static String readDirectoryName(Scanner sc) {
		System.out.println("Enter the Directory name you want to edit from.");
		sc.nextLine();
		String directoryName = sc.nextLine();
		return directoryName;
	}

}
