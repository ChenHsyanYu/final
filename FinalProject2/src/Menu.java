import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Menu {
	private JFrame frame;
	private JLabel label;
	private JPanel panel,panel2;
	private Login login;
	private OrderPage orderPage;
	private Menu menu;
	private OrderStore store;
	
	
	public Menu() {
		store = new OrderStore();
		menu = this;
		perpareGUI();
		login = new Login(menu,store);
	}
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.showMenu();
	}
	
	public void perpareGUI() {
		frame = new JFrame("點餐系統");
		frame.setSize(800,600);
		panel = new JPanel();
		label = new JLabel("點選左上方進入點餐系統");
		
		panel.add(label);
		frame.add(panel);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setVisible(true);
	}
	
	public void showMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu bossMenu = new JMenu("boss");
		JMenu userMenu = new JMenu("user");
		
		JMenuItem bossLogin = new JMenuItem("Login");
		JMenuItem userLogin = new JMenuItem("Login");
		JMenuItem userOrder = new JMenuItem("continue order");
		
		bossLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//跳出老闆登入頁面
				//code
			}
		});
		
		userLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//跳出使用者登入頁面
				login.reset();
				login.setVisible(true);
				login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
				
			}
		});
		
//		userOrder.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				orderPage = new OrderPage(menu,store);
//				JPanel panel = orderPage.getContentPane();
//				changePanel(panel);
//			}
//		});
		
		
		bossMenu.add(bossLogin);
		userMenu.add(userLogin);
		userMenu.add(userOrder);
		menuBar.add(bossMenu);
		menuBar.add(userMenu);
		
		frame.setJMenuBar(menuBar);
		frame.setVisible(true);
	}
	
	public void changePanel(JPanel panel) {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panel);
	}
}
