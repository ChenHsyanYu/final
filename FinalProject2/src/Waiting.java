
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 public class Waiting extends JFrame{
	  private JLabel number ;
	  private JLabel time ;
	  private JPanel allPanel;
	  private OrderPage orderPage;
	  private OrderStore store;
	  private Menu menu;
	  public Waiting(OrderStore store,Order order, Menu menu) {
		  this.store = store;
		  this.menu = menu;
		  
		  number = new JLabel("您的訂單編號:"+store.getArrayList());
		  time = new JLabel("等待時間:"+store.getTime(order));
		  allPanel = new JPanel();
		  allPanel.add(number);
		  allPanel.add(time);
		  createButton();
		  
  }
	  public JPanel getContentPane() {
		  return allPanel;
	  }
	  
	  public void createButton() {
		  JButton btnOrder = new JButton("繼續點餐");
		  allPanel.add(btnOrder);
		  btnOrder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					orderPage = new OrderPage(menu,store);
					JPanel panel = orderPage.getContentPane();
					menu.changePanel(panel);
				}
			});
	  }
 }