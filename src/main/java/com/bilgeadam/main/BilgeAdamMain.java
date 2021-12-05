package com.bilgeadam.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.bilgeadam.controller.BilgeAdamController;
import com.bilgeadam.entity.BilgeAdamEntity;

public class BilgeAdamMain {
	
	public static void main(String[] args) throws IOException {
		
		// file upload
		// nio
		// String metin = new String(Files.readAllBytes(Paths.get("maticpunk.css")));
		byte[] picture = Files.readAllBytes(Paths.get("maticpunk.jpg"));
		// EticaretEntity eticaretEntity = new EticaretEntity();
		BilgeAdamEntity bilgeAdamEntity = new BilgeAdamEntity();
		bilgeAdamEntity.setEmail("bilgeadam@bilge.adam.com.tr88");
		bilgeAdamEntity.setPassword("2432423");
		bilgeAdamEntity.setPrice(200.2);
		bilgeAdamEntity.setSpecificValue("ekleme yapılıyor -33");
		// bilgeAdamEntity.setBigData("Deneme");
		bilgeAdamEntity.setBigData(picture);
		
		BilgeAdamController bilgeAdamController = new BilgeAdamController();
		bilgeAdamController.create(bilgeAdamEntity);
	}
	
}
