import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //引用處理事件的event套件

/*software engineer homework 5 */
public class se_hw5 extends JFrame{
	/*
	 * 2016/6/2
	 * 
	 * */
	
	/* PARITY為true時表示平價，即平日的星期一到星期五*/
	private static final boolean PARITY = true;
	static int price_adult, price_child, num_adult, num_child, result = 0;
	
	/*宣告元件*/
	JLabel label_adult = new JLabel("成人 : ");	
	JLabel label_child = new JLabel("小孩 : ");	
	JTextField textField_adult = new JTextField();	
	JTextField textField_child = new JTextField();	
	JButton button_cal = new JButton("計算金額");
	JLabel label_price = new JLabel();
	
	public se_hw5(){
		
		/* PARITY為true時表示平價，大人268元、小孩120元，
		 * 而PARITY為false時，大人368元、小孩150元，再加收10%服務費所以大人405元、小孩165元*/
		if(PARITY){
			price_adult = 268;
			price_child = 120;
		}else{
			price_adult = 405;
			price_child = 165;
		}
		
		/*按下計算金額按鈕時觸發的事件*/
		button_cal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//System.out.println(textField_adult.getText());
				
				/*先計算總合*/
				num_adult = Integer.parseInt(textField_adult.getText());
				num_child = Integer.parseInt(textField_child.getText());
				result = (num_adult*price_adult) + (num_child*price_child);
				
				/*三人同行一人免費，如果第三人可為小孩，則算小孩免費*/
				//System.out.println((num_adult+num_child)/3);
				if(((num_adult+num_child)/3)>num_child){
					/*如果可免費的人數超過小孩人數，則剩下的蒜大人免費*/
					result = result - (num_child)*price_child;
					result = result - (((num_adult+num_child)/3)-num_child)*price_adult;
				}else{
					/*否則就是扣回幾個小孩免費即可*/
					result = result - ((num_adult+num_child)/3)*price_child;
				}
				
				/*如果10人以上同行、總價再打95折*/
				if((num_adult+num_child)>10){
					float temp = (float)result*(float)0.95;
					result = Math.round(temp);
				}
				
				/*把結果顯示到標籤上*/
				label_price.setText(Integer.toString(result));
			}
		});
		
		Container cp = getContentPane(); //取得內容面版
		/*GridLayout布局*/
		cp.setLayout(new GridLayout(3, 2, 10, 10));
		/*加入元件*/
		cp.add(label_adult);
		cp.add(textField_adult);
		cp.add(label_child);
		cp.add(textField_child);
		cp.add(button_cal);
		cp.add(label_price);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200); //設定視窗框架大小
		setVisible(true); //顯示視窗框架
	}
	
	public static void main(String args[]) {
		new se_hw5(); //宣告視窗框架物件
	}

}
