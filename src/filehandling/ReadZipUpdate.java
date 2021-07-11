package filehandling;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ReadZipUpdate {
	public static void main(String[] args) {
		String zipFilePath = "/Users/503132605/Desktop/temp.zip";
		String zipOut ="/Users/503132605/Desktop/test.zip";
		String str[] = {"empc-pdm.power.ge.com","Ldap.power.ge.com"};
		String target[]={"secure-qa-empc-pdm.navsys.ad","Ldap.navsys.ad"};
		updateFile(zipFilePath,zipOut,str,target);
	}

	private static void updateFile(String zipFilePath,String zipOut, String []str, String target[]) {
		 ZipOutputStream zos;
		 
		 
		try{
			ZipFile zipFile = new ZipFile(zipFilePath);
			zos = new ZipOutputStream(new FileOutputStream(zipOut));
			Enumeration entries = zipFile.entries();	
			
			while (entries.hasMoreElements()) {
	             ZipEntry entry = (ZipEntry) entries.nextElement();
	             if(!entry.isDirectory()){
		             System.out.println(entry.getName());
		             zos.putNextEntry(new ZipEntry(entry.getName()));
		             InputStream is = zipFile.getInputStream(entry);
		             
		             byte [] buf = new byte[1024];
		             int len;
		             while((len = (is.read(buf))) > 0) {   
		                 String s = new String(buf).replaceAll("key", "secretKey");
		                 if(s.contains("secret")){
		                	 buf =   s.replace("secret", "so secret").getBytes();
		                 }
		                 zos.write(buf, 0, (len < buf.length) ? len : buf.length);
		                 System.out.println(s);
		             }
		            
		             zos.closeEntry();	           
		              
				}
			}
			
			zos.close();
			zipFile.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

}
