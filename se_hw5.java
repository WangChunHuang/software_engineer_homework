import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //�ޥγB�z�ƥ�event�M��

public class se_hw5 extends JFrame{
	/*
	 * 2016/6/2
	 * 
	 * */
	
	/* PARITY��true�ɪ�ܥ����A�Y���骺�P���@��P����*/
	private static final boolean PARITY = true;
	static int price_adult, price_child, num_adult, num_child, result = 0;
	
	/*�ŧi����*/
	JLabel label_adult = new JLabel("���H : ");	
	JLabel label_child = new JLabel("�p�� : ");	
	JTextField textField_adult = new JTextField();	
	JTextField textField_child = new JTextField();	
	JButton button_cal = new JButton("�p����B");
	JLabel label_price = new JLabel();
	
	public se_hw5(){
		
		/* PARITY��true�ɪ�ܥ����A�j�H268���B�p��120���A
		 * ��PARITY��false�ɡA�j�H368���B�p��150���A�A�[��10%�A�ȶO�ҥH�j�H405���B�p��165��*/
		if(PARITY){
			price_adult = 268;
			price_child = 120;
		}else{
			price_adult = 405;
			price_child = 165;
		}
		
		/*���U�p����B���s��Ĳ�o���ƥ�*/
		button_cal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//System.out.println(textField_adult.getText());
				
				/*���p���`�X*/
				num_adult = Integer.parseInt(textField_adult.getText());
				num_child = Integer.parseInt(textField_child.getText());
				result = (num_adult*price_adult) + (num_child*price_child);
				
				/*�T�H�P��@�H�K�O�A�p�G�ĤT�H�i���p�ġA�h��p�ħK�O*/
				//System.out.println((num_adult+num_child)/3);
				if(((num_adult+num_child)/3)>num_child){
					/*�p�G�i�K�O���H�ƶW�L�p�ĤH�ơA�h�ѤU���[�j�H�K�O*/
					result = result - (num_child)*price_child;
					result = result - (((num_adult+num_child)/3)-num_child)*price_adult;
				}else{
					/*�_�h�N�O���^�X�Ӥp�ħK�O�Y�i*/
					result = result - ((num_adult+num_child)/3)*price_child;
				}
				
				/*�p�G10�H�H�W�P��B�`���A��95��*/
				if((num_adult+num_child)>10){
					float temp = (float)result*(float)0.95;
					result = Math.round(temp);
				}
				
				/*�⵲�G��ܨ���ҤW*/
				label_price.setText(Integer.toString(result));
			}
		});
		
		Container cp = getContentPane(); //���o���e����
		/*GridLayout����*/
		cp.setLayout(new GridLayout(3, 2, 10, 10));
		/*�[�J����*/
		cp.add(label_adult);
		cp.add(textField_adult);
		cp.add(label_child);
		cp.add(textField_child);
		cp.add(button_cal);
		cp.add(label_price);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200); //�]�w�����ج[�j�p
		setVisible(true); //��ܵ����ج[
	}
	
	public static void main(String args[]) {
		new se_hw5(); //�ŧi�����ج[����
	}

}