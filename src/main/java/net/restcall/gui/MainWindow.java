package net.restcall.gui;

import javax.swing.JFrame;

import net.restcall.consts.RcConsts;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	public MainWindow() {
		super("RestCall ver." + RcConsts.version);
		setSize(700, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
