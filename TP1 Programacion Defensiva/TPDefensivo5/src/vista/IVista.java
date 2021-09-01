package vista;

import java.awt.event.ActionListener;

public interface IVista 
{
	void setActionListener(ActionListener actionListener);
	void iniciarJuego();
	String getTextField();
	void setTextField(String str);
	void showErrorMsg1();
	void showErrorMsg2();
	void showHint(String str);
	void showFinalizadoMsg();
	void showPerdioMsg(int number);
	void showGanoMsg(int number);
	void enableIniciarJuego();
	void updateLabel(String str);

}
