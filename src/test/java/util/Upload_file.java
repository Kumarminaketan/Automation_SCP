package util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Upload_file {

	public void uploadfie() throws InterruptedException, AWTException
	{
	
	Latest_Modified_file f=new Latest_Modified_file();
	Thread.sleep(2000);
	Robot r = new Robot();
	StringSelection s = new StringSelection(f.filepath().getAbsolutePath());
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
	r.keyPress(KeyEvent.VK_CONTROL);
	Thread.sleep(1000);
	r.keyPress(KeyEvent.VK_V);
	Thread.sleep(1000);
	r.keyRelease(KeyEvent.VK_V);
	r.keyRelease(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(1000);
	System.out.println("clicked on the download template successfully");
}
}
