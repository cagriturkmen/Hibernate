package com.bilgeadam.enumx;

import com.bilgeadam.controller.PencilController;

public class PencilMain {
	public static void main(String[] args) {
		PencilEntity entity = new PencilEntity();
		entity.setPencilBrand("Faber-Castell");
		entity.setPencilName("Benim kalemim");
		entity.setPencilType(EPencil.Pilot);
		
		PencilController pencilController = new PencilController();
		pencilController.create(entity);
	}
}
