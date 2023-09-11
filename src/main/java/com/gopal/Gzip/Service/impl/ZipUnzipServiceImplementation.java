package com.gopal.Gzip.Service.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.gopal.Gzip.Service.ZipUnzipService;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;

@Service
public class ZipUnzipServiceImplementation implements ZipUnzipService {

	@Override
	public void zipFileOrFolder(String zipFilePath, String sourceFilePath, String password) throws IOException{
		// TODO Auto-generated method stub
		File folderName = new File(sourceFilePath);
		ZipFile zipFile = new ZipFile(zipFilePath);
	    
	    
	    if(password != null ) {
	    	zipFile.setPassword(password.toCharArray());

		    ZipParameters zp = new ZipParameters();
		    zp.setCompressionLevel(CompressionLevel.ULTRA);
			zp.setCompressionMethod(CompressionMethod.DEFLATE);
			zp.setEncryptFiles(true);
			zp.setEncryptionMethod(EncryptionMethod.AES);
			zp.setAesKeyStrength(AesKeyStrength.KEY_STRENGTH_256);
			zipFileOrFolderWithPassword(zipFile,folderName,zp);
			
	    }else {
	    	
	    	zipFileOrFolder(zipFile,folderName);
	    }
	    
	}
	

	public void zipFileOrFolderWithPassword(ZipFile zipFile, File folderName,ZipParameters zp) throws IOException{
		
		if(folderName.isDirectory())
    		zipFile.addFolder(folderName,zp);
    	else
    		zipFile.addFile(folderName,zp);
		
		zipFile.close();
		
	}
	
	public void zipFileOrFolder(ZipFile zipFile, File folderName) throws IOException {
		
		if(folderName.isDirectory())
    		zipFile.addFolder(folderName);
    	else
    		zipFile.addFile(folderName);
		
		zipFile.close();
	}

	@Override
	public void unZipFileOrFolder(String destinationPath, String sourceFilePath, String password) throws IOException {
		// TODO Auto-generated method stub
		
		ZipFile zipFile = new ZipFile(sourceFilePath);
        if (zipFile.isEncrypted()) {
            zipFile.setPassword(password.toCharArray());
        }
        zipFile.extractAll(destinationPath);
        
        zipFile.close();
		
	}

}
