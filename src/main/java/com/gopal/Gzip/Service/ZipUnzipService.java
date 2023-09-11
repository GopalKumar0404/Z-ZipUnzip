package com.gopal.Gzip.Service;

import java.io.IOException;


public interface ZipUnzipService {

	public void zipFileOrFolder(String zipFilePath, String sourceFilePath, String Password) throws IOException;
	public void unZipFileOrFolder(String destinationPath, String sourceFilePath, String Password) throws IOException;
}
