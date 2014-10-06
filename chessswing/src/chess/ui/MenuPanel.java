package chess.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ch.position.Position;

public class MenuPanel extends JPanel {

	public MenuPanel() {
		// TODO Auto-generated constructor stub

		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("Меню");
		JMenuItem fileNew = new JMenuItem("Новая игра");
		fileNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				//restart();
				

			}
		});
		JMenuItem fileExit = new JMenuItem("Выход");
		file.add(fileNew);
		file.add(fileExit);

		JMenu help = new JMenu("Помощь");
		
		JMenuItem about = new JMenuItem("О игре");
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				JOptionPane.showMessageDialog(null,"Chess");

			}
		});
		help.add(about);

		menuBar.add(file);

		menuBar.add(help);

		setLayout(new GridLayout());

		//setLayout(new BorderLayout());

		add(menuBar);

	}
	private void restart() {
        StringBuilder cmd = new StringBuilder();
          cmd.append(System.getProperty("java.home") + File.separator + "bin" + File.separator + "java ");
          for (String jvmArg : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
              cmd.append(jvmArg + " ");
          }
          cmd.append("-cp ").append(ManagementFactory.getRuntimeMXBean().getClassPath()).append(" ");
          cmd.append(Window.class.getName()).append(" ");

          try {
              Runtime.getRuntime().exec(cmd.toString());
          } catch (IOException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }
          System.exit(0);
  }

}
