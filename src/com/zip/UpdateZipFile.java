package com.zip;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class UpdateZipFile {

	public static void main(String[] args) {
		 String zipFilePath = "/Users/503132605/Desktop/File.zip";
		 String destDir = "/Users/503132605/Desktop/test.zip";
		 String str[] = {"key","secret"};
		 String target[]={"publicKey","publicSecret"};  
	     readUpdateZip(zipFilePath, destDir,str,target);
	}

	private static void readUpdateZip(String zipFilePath, String destDir,String str[],String target[]) {
		ZipOutputStream zos;
		 try {
	            
	            ZipFile file = new ZipFile(zipFilePath);
	            zos = new ZipOutputStream(new FileOutputStream(destDir));
	            Enumeration entries =  file.entries();
	            
	            while(entries.hasMoreElements()){
	            	ZipEntry entry = (ZipEntry) entries.nextElement();
	                
	                System.out.println("File Name : "+entry);
	                if(!entry.isDirectory()){
			             
			             zos.putNextEntry(new ZipEntry(entry.getName()));
			             InputStream is = file.getInputStream(entry);
			             
			             byte [] buf = new byte[1024];
			             int len;
			             while((len = (is.read(buf))) > 0) {   
			                 String s = new String(buf);
			                 for(int i=0; i<str.length-1; i++){
			                	 s = s.replace(str[0], target[0]);
			                 }
			                 buf =   s.replace(str[str.length-1], target[target.length-1]).getBytes();
			                 
			                 zos.write(buf, 0, (len < buf.length) ? len : buf.length);
			             }	            			                    
			              
					}	
	                zos.closeEntry();
	               }
	            
	            
	            zos.close();
	            file.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

}
