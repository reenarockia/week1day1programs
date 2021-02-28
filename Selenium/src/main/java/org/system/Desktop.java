package org.system;

public class Desktop extends Computer {
	public void desktopSize() {
		System.out.println("Desktop Size:1200PX");
	}
	public static void main(String[] args) {
		Desktop myDesktop=new Desktop();
		myDesktop.desktopSize();
		myDesktop.computerModel();
		
	}

}
