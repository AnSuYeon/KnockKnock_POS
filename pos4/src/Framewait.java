import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import database.waitDAO;
import database.waitDTO;

public class Framewait extends JFrame {

   private JPanel contentPane;
   private JTable table;
   
   public int waitnum;
   
   ArrayList<waitDTO> list = new ArrayList<waitDTO>();
   ArrayList<String> list_id = new ArrayList<String>();
   static ArrayList<waitDTO> arr = new ArrayList<waitDTO>();
   
   Vector<String> waitColumn;
   DefaultTableModel model;
   Object waitcode[] = new Object[3];
   
   waitDAO waitdao;
   waitDTO waitdto;
   String name;

   public Framewait() {
   
      waitdao = new waitDAO();
      waitdto = new waitDTO();
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 500, 700);
      setUndecorated(true);
      setLocation(1150,50);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);

      JPanel panel = new JPanel();
      panel.setBackground(new Color(255, 165, 0));
      panel.setBounds(0, 0, 500, 33);
      contentPane.add(panel);
      panel.setLayout(null);

      JLabel lblKnockKnockWait = new JLabel("Knock Knock WAIT");
      lblKnockKnockWait.setForeground(Color.WHITE);
      lblKnockKnockWait.setFont(new Font("한컴 고딕", Font.BOLD, 20));
      lblKnockKnockWait.setBounds(12, 0, 218, 31);
      panel.add(lblKnockKnockWait);

      JLabel closeLabel = new JLabel("X");
      closeLabel.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
            Framewait.this.dispose();
         }

         @Override
         public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            closeLabel.setForeground(Color.RED);
         }

         @Override
         public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            closeLabel.setForeground(Color.black);
         }
      });
      closeLabel.setHorizontalAlignment(SwingConstants.CENTER);
      closeLabel.setForeground(Color.BLACK);
      closeLabel.setFont(new Font("한컴 고딕", Font.BOLD, 24));
      closeLabel.setBounds(470, -3, 16, 33);
      panel.add(closeLabel);

      waitColumn = new Vector<String>();
      waitColumn.addElement("waitnum");
      waitColumn.addElement("people");
      waitColumn.addElement("cli_name");
      
      model = new DefaultTableModel(waitColumn, 0);
      this.loadTable();
      
      table = new JTable(model);
      table.setBounds(12, 70, 474, 523);
      getContentPane().add(table);
           table.addMouseListener(new MouseListener() {
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			   int row = table.getSelectedRow();
			   TableModel data = table.getModel();
			   name = (String)data.getValueAt(row,2);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
    	  
      });
      contentSet();

      JButton delButton = new JButton("호출");
      delButton.setFont(new Font("한컴 고딕", Font.BOLD, 25));
      delButton.setBounds(33, 628, 433, 42);
      delButton.addMouseListener(new MouseAdapter() {

         @Override
         public void mouseClicked(MouseEvent e) {
            model = (DefaultTableModel) table.getModel();
            int row = table.getSelectedRow();
            if (row < 0)
               return;
            model.removeRow(row);
			waitdao.call(name);
         }
      });
      getContentPane().add(delButton);
      contentPane.add(delButton);
      
      JLabel lblNewLabel = new JLabel("대기번호");
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setForeground(new Color(255, 165, 0));
      lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
      lblNewLabel.setBounds(10, 40, 156, 25);
      contentPane.add(lblNewLabel);
      
      JLabel label = new JLabel("인원수");
      label.setHorizontalAlignment(SwingConstants.CENTER);
      label.setForeground(new Color(255, 165, 0));
      label.setFont(new Font("굴림", Font.BOLD, 20));
      label.setBounds(171, 40, 156, 25);
      contentPane.add(label);
      
      JLabel lblId = new JLabel("손님 ID");
      lblId.setHorizontalAlignment(SwingConstants.CENTER);
      lblId.setForeground(new Color(255, 165, 0));
      lblId.setFont(new Font("굴림", Font.BOLD, 20));
      lblId.setBounds(330, 40, 156, 25);
      contentPane.add(lblId);

      
      setVisible(true);
   }
   
   public void loadTable() {
	  
      list = waitdao.getPeople();
      int i =0 ;
      for (waitnum = 0; waitnum < list.size() ; waitnum++) {
         
         waitcode[0] = Integer.toString(i+1);
         waitcode[1] = list.get(waitnum).getPeople();
         waitcode[2] = list.get(waitnum).getCli_name();
         i++;
         model.addRow(waitcode);
      }
      list.clear();
   }
   
   
   public void contentSet() {
      
      String people = null;
      String cli_name = null;

      waitdto.setPeople(people);
      waitdto.setCli_name(cli_name);
   }

}
