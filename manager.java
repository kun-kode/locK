import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.io.File;

public class manager extends JFrame{
	public final static int serialVersionUID=1;
 public static void main(String[] args) {
	manager man = new manager();
}
 public manager() {
	 String file = System.getProperty("user.home");
	 File f = new File(file + "/.passwd".trim());
	 JFrame manframe = new JFrame();
	 JPanel manpanel = new JPanel();
	 BoxLayout lay = new BoxLayout(manpanel, BoxLayout.PAGE_AXIS);
	 manpanel.setLayout(lay);
	 JButton btndel  = new JButton("Đổi mật khẩu");
	 btndel.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			f.delete();
			JOptionPane.showMessageDialog(null, "Khởi động lại phần mềm đổi mật khẩu");
			System.exit(0);
		}
	});
	 JButton btnbak = new JButton("Hình nền");
	 btnbak.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			background bkg = new background();
					}
	});
	 manpanel.add(new JLabel("Cài đặt"));
	 manpanel.add(btndel);
	 manpanel.add(btnbak);
	 manframe.add(manpanel);
	 manframe.setTitle("Trình cài đặt");
	 manframe.setSize(800,600);
	 manframe.setContentPane(manpanel);
	 manframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
	 manframe.pack();
	 manframe.setVisible(true);
 }
}
