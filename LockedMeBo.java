package com.lockedme;
import java.io.File;

public class LockedMeBo {
//	Start of displaying Files in ascending order and sorting them using bubble sort.
	
	public void displayFilesInAscendingOrder(String directoryPath)
	{
		try {
			File f = new File(directoryPath);
			File files[] =f.listFiles();
			sort(files, files.length);
			for(File fileEntry : files)
			{
				if(fileEntry.isFile())
					System.out.println(fileEntry.getName());
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	private void sort(File[] files, int n) {
		int x, j, swaps;
		File temp;
		for(x=n-2; x>=0; x--) {
			swaps =0;
			for(j=0; j<= x; j++) {
				if(files[j].getName().compareTo(files[j+1].getName())>0)
					{
					temp = files[j];
					files[j]= files[j+1];
					files[j+1]=temp;
					swaps++;
					}
			}
			if(swaps==0)
				break;
		}
		
	} 
//End of SORTING and ARRANGING files.
	
//	Start of ADDING a file to the directory path.
	public void addFile(String fileName, String directoryPath)
	{
		try {
			File directory = new File(directoryPath);
			if(directory.isDirectory()) 
			{	
				File f = new File(directoryPath + "/" + fileName); //to fetch the desired directory and file from user.
				if(!f.exists()) {
					f.createNewFile();
					System.out.println("File successfully created");
				}
				else {
					System.out.println("File already exists");
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//End of ADDING a file.
	
//	Start of DELETING file.
	public void deleteFile(String fileName, String directoryPath)
	{
		boolean isDeleted = false;
		boolean isExisted = false;
		try {
			File f = new File(directoryPath); //fetching the directory of the files.
			File files[] = f.listFiles(); //assigning files to an array to search for the desired file.
			for (File fileEntry : files) {
				if(fileEntry.getName().equals(fileName)) {
					isExisted= true;
					if(fileEntry.delete())
						isDeleted=true;
				}
			}
			if(isExisted && isDeleted)
				System.out.println("File deleted successfully");
			else
				System.out.println("File does not exist to delete");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	End of DELETING files.

//	start of SEARCH file.
	
	public void searchFile(String fileName, String directoryPath)
	{ 
		boolean isExisted = false;
		try {
			File f = new File(directoryPath);
			File files[] = f.listFiles();
			
			for(File fileEntry : files) {
				if (fileEntry.isFile()) {
					if(fileEntry.getName().equals(files))
						isExisted = true;
				}
			}
			if(isExisted)
				System.out.println("File exists");
			else
				System.out.println("File doesnot exists");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
//	End of SEARCH file.
	
}
