import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class background extends JFrame{
	public static final int serialVersionUID=1;
	public static void main(String[] args) {
		background bkg = new background();
		
	}
	public background() {
		JButton btn;
		String file = System.getProperty("user.home") + "/.lockbackground";
		String config = System.getProperty("user.home")+"/.lockconf";
		File g = new File(file);
		if(g.exists()) {} else {g.mkdir();}
		File[] f = g.listFiles();
		File conf = new File(config);
		if(conf.exists()) {} else {
			try {
			conf.createNewFile();
			}catch (IOException eb) {
				JOptionPane.showMessageDialog(null, eb.toString());
			}};
		JFrame bkgfr = new JFrame();
		JPanel bkgpa = new JPanel(new BorderLayout());
		JPanel bkgls = new JPanel();
		BoxLayout lay = new BoxLayout(bkgls, BoxLayout.PAGE_AXIS);
		bkgls.setLayout(lay);
		for (File f1 : f) {
			btn = new JButton(f1.getName());
			btn.setBackground(Color.WHITE);
			btn.setFocusable(false);
			btn.setBorder(null);
			btn.setBorder(BorderFactory.createEmptyBorder(3, 3, 10, 10));
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String f2 = f1.getAbsolutePath();
					conf.delete();
					try {
						FileWriter fw = new FileWriter(conf);
						fw.write(f2);
						fw.close();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, e.toString());
					}
				}
			});
			bkgls.add(btn);
			
			
		}
		bkgls.setBackground(Color.white);
		bkgpa.add(bkgls);
		bkgpa.add(new JLabel("Chọn hình nền"), BorderLayout.NORTH);
		bkgpa.setBackground(Color.white);
		bkgfr.setTitle("Đổi hình nền");
		bkgfr.setContentPane(bkgpa);
		bkgfr.setDefaultCloseOperation(EXIT_ON_CLOSE);
		bkgfr.setSize(800,600);
		bkgfr.setVisible(true);
		
	}

}
