package com.gopal.Gzip.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gopal.Gzip.Service.ZipUnzipService;

@RestController
@RequestMapping("/zip-unzip")
public class ZipUnzipController {

	@Autowired
	private ZipUnzipService zipUnzipService;

	@PostMapping("/zip")
	public void zipFileOrFolder(@RequestParam("sourcePath") String sourcePath,
			@RequestParam("zipFilePath") String zipFilePath,
			@RequestParam(value = "password", required = false) String password) throws IOException {
		System.out.println(String.valueOf(password));
		zipUnzipService.zipFileOrFolder(zipFilePath, sourcePath, password);

	}

	@PostMapping("/unzip")
	public void unzipFile(@RequestParam("zipFilePath") String zipFilePath,
			@RequestParam("destinationPath") String destinationPath,
			@RequestParam(value = "password", required = false) String password) throws IOException {
		zipUnzipService.unZipFileOrFolder(destinationPath, zipFilePath, password);
	}
}
