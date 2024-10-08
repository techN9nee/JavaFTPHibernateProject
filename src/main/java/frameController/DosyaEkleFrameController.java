package frameController;

import controller.DosyaController;
import view.DosyaEkleView;

public class DosyaEkleFrameController {

	private DosyaEkleView dosyaEkleView;
	private DosyaController dosyaController;

	public DosyaEkleFrameController(DosyaEkleView view) {
		this.dosyaController = new DosyaController();
		this.dosyaEkleView = view;
		initController();
	}

	public void initController() {
		dosyaEkleView.btnDosyaEkle().addActionListener(e -> dosyaController.dosyaSecVeKaydet());

	}
}
