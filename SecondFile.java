import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class sec extends JFrame{
	public JRadioButton head;
	public JRadioButton joint;
	public JRadioButton single;
	public ButtonGroup tax;
	public JButton calc;
	public JTextField field;
	public JTextField field2;
	public JPanel panel;
	public JPanel panel2;
	public JPanel panel3;
	public JPanel panel4;
	public JPanel panel5;
	public JPanel panel6;
	public double num1;
	public double num2;
	public double num3;
	public int bo;
	public int ba;
	public int be;
	public int bi;
	public int ya;
	public int x;
	public char a;
	
	public static double bu;
	public int g;
	public boolean q;
	public boolean i;
	public sec(){
		super("Federal Income Tax Calculator");
		panel5 = new JPanel();
		field2 = new JTextField();
		field2.setPreferredSize(new Dimension(150, 60));
		field2.setEditable(false);
		JLabel lab = new JLabel();
		panel5.add(lab);
		add(panel5);
		lab.setText("Federal Income Tax Calculator");
		lab.setFont(new Font("Serif", Font.BOLD, 20));
		setLayout(new GridBagLayout());
		
		panel = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		JLabel label = new JLabel();
		label.setText("1. Select How You Will File Your Taxes");
		panel.add(label);
		
		JLabel label2 = new JLabel();
		label2.setText("2. Enter Your Income In The Box On The Left");
		panel.add(label2);
		JLabel label3 = new JLabel();
		label3.setText("3. Click Calculate");
		panel.add(label3);
		JLabel label4 = new JLabel();
		label4.setText("4. Your Federal Tax Will Be Displayed on the Right");
		
		panel.add(label4);
		
		head = new JRadioButton("Head of Household");
		panel2.add(head);
		head.addItemListener(
			new ItemListener(){
				public void itemStateChanged(ItemEvent e){
					if(e.getStateChange() == ItemEvent.SELECTED){
						bo = 1;
					}
				}
			}
		);
		joint = new JRadioButton("Jointly with Spouse");
		panel2.add(joint);
		joint.addItemListener(
			new ItemListener(){
				public void itemStateChanged(ItemEvent e){
					if(e.getStateChange() == ItemEvent.SELECTED){
						bo = 2;
					}
				}
			}
		);
		single = new JRadioButton("Single");
		panel2.add(single);
		
		single.addItemListener(
			new ItemListener(){
				public void itemStateChanged(ItemEvent e){
					if(e.getStateChange() == ItemEvent.SELECTED){
						bo = 3;
					}
				}
			}
		);
		tax = new ButtonGroup();
		tax.add(head);
		tax.add(joint);
		tax.add(single);
		add(panel, grid);
		grid.gridy = 2;
		add(panel2, grid);
		field = new JTextField();
		field.setPreferredSize(new Dimension(150, 60) );
		field.setEditable(true);
		field.setText("0");
		field.addKeyListener(
				new KeyListener(){

					@Override
					public void keyPressed(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void keyTyped(KeyEvent e) {
						char y = e.getKeyChar();

						if(e.getKeyCode() == e.VK_ENTER){
							i = true;
						}
						if((Character.isLetter(y)) && e.isAltDown()){
							e.consume();
						}
						
					}
					
					
				}
				
				
				
		);
		
		
		JLabel lu = new JLabel("$");
		JLabel li = new JLabel("$");
		panel3.add(lu);
		panel3.add(field);
		calc = new JButton("Calculate");
		Icon img = new ImageIcon("cal.png");
		panel3.add(calc);
		calc.setPreferredSize(new Dimension(120, 60));
		calc.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(e.getSource() == calc || i == true){
						if(field.getText().length()>0 || i == true){
							
							try{
								num1 = Double.parseDouble(field.getText());
									
							}catch(Exception f){
								field2.setText("Invalid Input");
							}
							
							bi = 0;
							if(num1<0){
								field2.setText("Invalid Input");
							}
							if(bo == 1 || i == true ){
								try{
								
									num1 = Double.parseDouble(field.getText());
									bi = 1;
								}catch(Exception f){
									field2.setText("Invalid Input");
								}
							
							if(bi == 1 || i == true){
								if(num1<=13600){
									bu = 0;
									
								}else if (num1>13600 && num1<=51800){
									bu = Math.round((num1-(13600+18000))*12)/100.0 + 1360;
									if(bu<0){
										bu = 0;	
									}
								}else if (num1>51800 && num1<=82500){
									bu = Math.round((num1-(51800+18000))*22)/100.0 + 5944;
									if(bu<0){
										bu = 0;
									}
								}else if (num1>82500 && num1<=157500){
									bu = Math.round((num1-82500-18000)*24)/100.0 + 12698;
									if(bu<0){
										bu = 0;
									}
								}else if (num1>157500 && num1<=200000){
									bu = Math.round((num1-157500-18000)*32)/100.0 + 30698;
								}else if (num1>200000 && num1<=500000){
									bu = Math.round((num1-200000-18000)*35)/100.0 + 44298 ;
								}else if (num1>500000){
									bu = Math.round((num1-500000-18000)*37)/100.0 + 149298;
								}
								bu = Math.round(bu*100)/100.0;
								g = (int) bu;
								if(g == bu){
									field2.setText(Integer.toString(g));
								}else{
									field2.setText(Double.toString(bu));
								}
								}
							}
							}if (bo == 3 || i == true){
								try{
								
									num1 = Double.parseDouble(field.getText());
									bi = 1;
								}catch(Exception f){
									field2.setText("Invalid Input");
								}
								
								if(bi == 1 || i == true){
								if(num1<=9525){
									bu = 0;
									
								}else if (num1>9525 && num1<=38700){
									bu = Math.round((num1-9525-12000)*12)/100.0 + 952.5;
								}else if (num1>38700 && num1<=82500){
									bu = Math.round((num1-38700-12000)*22)/100.0 + 3501;
									if(bu<0){
										bu = 0;
									}
								}else if (num1>82500 && num1<=157500){
									bu = Math.round((num1-82500-12000)*24)/100.0 + 13137;
									if(bu<0){
										bu = 0;
									}
								}else if (num1>157500 && num1<=200000){
									bu = Math.round((num1-157500-12000)*32)/100.0 + 31137;
								}else if (num1>200000 && num1<=500000){
									bu = Math.round((num1-200000-12000)*35)/100.0 + 44737;
								}else if (num1>500000){
									bu = Math.round((num1-500000-12000)*37)/100.0 + 149737;
								}
								bu = Math.round(bu*100)/100.0;
								g = (int) bu;
								if(g == bu){
									field2.setText(Integer.toString(g));
								}else{
									field2.setText(Double.toString(bu));
								}
								}
							}else if (bo == 2 || i == true){
								try{
								
									num1 = Double.parseDouble(field.getText());
									bi = 1;
								}catch(Exception f){
									field2.setText("Invalid Input");
								}
								
								if(bi == 1){
								if(num1<=19050){
									bu = 0;
									
								}else if (num1>19050 && num1<=77400){
									bu = Math.round((num1-19050-24000)*22)/100.0 + 1905;
								}else if (num1>77400 && num1<=165000){
									bu = Math.round((num1-77400-24000)*22)/100.0 + 8907;
									if(bu<0){
										bu = 0;
									}
								}else if (num1>165000 && num1<=315000){
									bu = Math.round((num1-165000-24000)*24)/100.0 + 19272;
									if(bu<0){
										bu = 0;
									}
								}else if (num1>315000 && num1<=400000){
									bu = Math.round((num1-315000-24000)*32)/100.0 + 55272;
								}else if (num1>400000 && num1<=600000){
									bu = Math.round((num1-400000-24000)*35)/100.0 + 82472;
								}else if (num1>600000){
									bu = Math.round((num1-600000-24000)*37)/100.0 + 152472;
								}
								bu = Math.round(bu*100)/100.0;
								g = (int) bu;
								if(g == bu){
									field2.setText(Integer.toString(g));
								}else{
									field2.setText(Double.toString(bu));
								}
								}
							}
						}
					}
				
				
			}
		);
		panel3.add(li);
		panel3.add(field2);
		add(panel3);
		JLabel la = new JLabel("DISCLAIMER: This calculator may not state your exact federal income tax. It will just provide a good estimate.");
		la.setFont(new Font(null, Font.PLAIN, 8));
		panel6 = new JPanel();
		panel6.add(la);
		panel4 = new JPanel();
		panel4.add(panel5);
		panel4.add(panel);
		panel4.add(panel2);
		panel4.add(panel3);
		panel4.add(panel6);
		panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
		panel4.add(Box.createVerticalGlue());
		add(panel4);

	}
	
}
