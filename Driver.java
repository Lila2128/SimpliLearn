package com.lockedme;
import java.util.Scanner;

public class Driver {
	
	public static void main(String [] args) {

		String directoryName = null;
		String FileName;
		
		LockedMeBo bo = new LockedMeBo();
		
//		fetching data from user.
		Scanner sc = new Scanner(System.in);
		
//		displaying --------------WELCOME SCREEN------------------------
		System.out.println("Welcome to LockedMe.com");
		System.out.println("Check out our Products listings.");
		System.out.println("\n");
		int ch, ch1;
		
//--------------------------------start of user interaction information-----------------------------------------
		do
		{
			System.out.println("1. Fetch List of files");
			System.out.println("2. To Edit your files");
			System.out.println("3. Exit from the application");
			System.out.println("Please Enter your choice");
			ch = sc.nextInt();
			if (ch < 3)
				directoryName = readDirectoryName(sc);
			
			switch(ch) {
			case 1: 
//	---------------------------------to arrange files in ascending order.----------------------
				bo.displayFilesInAscendingOrder(directoryName);
				System.out.println("\n");
				break;
			case 2:
//	-----------------------------------Start of business level operations---------------------------------------
				do
				{
					System.out.println("1. Add File to the Directory");
					System.out.println("2. Remove file from Directory");
					System.out.println("3. Searching a file in Directory");
					System.out.println("4. Return to the main context");
					System.out.println(" Enter your choice");
					ch1 = sc.nextInt();
					switch(ch1)
					{
					case 1:
						FileName =readFileName(sc);
						bo.addFile(FileName, directoryName);
						System.out.println("\n");
						break;
					case 2:
						FileName = readFileName(sc);
						bo.deleteFile(FileName, directoryName);
						System.out.println("\n");
						break;
					case 3:
						FileName = readFileName(sc);
						bo.searchFile(FileName, directoryName);
						System.out.println("\n");
						break;
					}
				}while(ch1<=3);
			}
		}while(ch <= 2);
	}

//	end of the Operations.
	
//	Fetching File Name from the user.
	private static String readFileName(Scanner sc) {
		System.out.println("enter the file name to edit");
		sc.nextLine();
		String filename = sc.nextLine();
		return filename;
	}
	
//	Fetching Directory Name from the user.
	private static String readDirectoryName(Scanner sc) {
		System.out.println("Enter the Directory name you want to edit from.");
		sc.nextLine();
		String directoryName = sc.nextLine();
		return directoryName;
	}

}
