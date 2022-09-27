package com.lockedme;

import java.io.File;

public class LockedMeBo {
	public void displayFilesInAscendingOrder(String directoryPath)
	{
		try {
			File f = new File(directoryPath);
			File files[] =f.listFiles();
			for(File fileEntry : files)
			{
				if(fileEntry.isFile())
					System.out.println(fileEntry.getName());
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	

	public void addFile(String fileName, String directoryPath)
	{
		try {
			File directory = new File(directoryPath);
			if(directory.isDirectory()) 
			{	
				File f = new File(directoryPath + "/" + fileName); //to fetch the desired directory.
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
	
	public void deleteFile(String fileName, String directoryPath)
	{
		boolean isDeleted = false;
		boolean isExisted = false;
		try {
			File f = new File(directoryPath);
			File files[] = f.listFiles();
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
}
