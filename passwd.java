import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class passwd extends JFrame{
public static final int serialVersionUID=1;
 public static void main(String[] args) {
	passwd pass = new passwd();
}
 public passwd() {
	 
	 String file = System.getProperty("user.home");
	 File f = new File(file + "/.passwd".trim());
	 JFrame frame = new JFrame();
	 JFrame fr = new JFrame();
	 JPanel panel = new JPanel(new BorderLayout());
	 
	 JTextField txt = new JTextField();
	 
	 JPanel pansouth= new JPanel();
	 BoxLayout ly = new BoxLayout(pansouth, BoxLayout.PAGE_AXIS);
	 pansouth.setLayout(ly);
	 
	 JLabel lockscreen = new JLabel();
	 File config = new File(System.getProperty("user.home") + "/.lockconf".trim());
	 if (config.exists()) {
		 try {
			 Scanner sc = new Scanner(config);
			 if(sc.hasNextLine()) {
				 ImageIcon icon = new ImageIcon(String.valueOf(sc.nextLine()));
				 lockscreen.setIcon(icon);
			 }
			 sc.close();
		 } catch (IOException ea){
			JOptionPane.showMessageDialog(null, ea.toString()); 
		 }
	 }
	 
	String status1 = "Trạng thái: ";
	 JTextField status = new JTextField(status1);
	 status.setHorizontalAlignment(SwingConstants.CENTER);
	 status.setMaximumSize(new Dimension(500, 25));
	 status.setEditable(false);
	 
	 JPanel panel1 = new JPanel(new GridLayout(1, 3, 20, 50));
	 
	 JButton btn = new JButton("Thoát");
	 btn.setFocusable(false);
	 btn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(1);
		}
	});
	 JButton enter = new JButton("Nhập mật khẩu");
	 enter.setFocusable(false);
	 enter.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String pass = txt.getText();
			try {
			Scanner scanner = new Scanner(f);
			if (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if(line.equals(pass)) {
					System.exit(0);
				} else {
					status.setText(status1 + "Sai mật khẩu");
				}
				scanner.close();
			}
			} catch(IOException e1) {
				status.setText(status1 + e1.toString());
				}
			}
	});

	 JButton newfile = new JButton("Đặt mật khẩu");
	 newfile.setFocusable(false);
	 newfile.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				FileWriter fw = new FileWriter(f);
				String pass = txt.getText();
				f.createNewFile();
				fw.write(pass);
				fw.close();
				frame.dispose();
				JOptionPane.showMessageDialog(null, "Thoát cửa sổ này đi :p");
				System.exit(0);
			}catch(IOException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, e1.toString());
			}
		}
	});
	 JButton btnset1 = new JButton("Cài đặt");
	 btnset1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String pass = txt.getText();
			try {
				Scanner scanner = new Scanner(f);
				if (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					if(line.equals(pass)) {
						   frame.dispose();
						   fr.dispose();
						   manager man = new manager();
					} else {
						status.setText(status1 + "Sai mật khẩu");
					}
					scanner.close();
				}
				} catch(IOException e1) {
					status.setText(status1 + e1.toString());
					
					}
		
		}

	});
	 
	 pansouth.add(txt);
	 pansouth.add(status);
	 if(f.exists()) {
		 panel.add(new JLabel("Nhập mật khẩu"), BorderLayout.NORTH);
		 panel1.add(enter);
		 panel1.add(btnset1);
		 panel.add(pansouth);
		 panel.add(panel1, BorderLayout.SOUTH);
		 fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
		 fr.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		 fr.setContentPane(lockscreen);
		 fr.setUndecorated(true);
		 fr.setVisible(true);
		 fr.setAlwaysOnTop(true);
	 } 
	 else {
		 panel.add(new JLabel("Nhập mật khẩu mới"), BorderLayout.NORTH);
		 panel.add(txt);
		 panel1.add(newfile);
		 panel1.add(btn);
		panel.add(panel1, BorderLayout.SOUTH);
	 }
	 
	 frame.setUndecorated(true);
	 frame.setContentPane(panel);
	 frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	 frame.setResizable(false);
	 frame.setTitle("Nhập mật khẩu");
	 frame.setSize(400,125);
	 frame.setVisible(true);
	 frame.setLocationRelativeTo(null);
	 frame.setAlwaysOnTop(true);
	 
 
 }
}
