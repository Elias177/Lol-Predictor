package visual;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logical.Weka;

import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private JPanel contentPane;
	public Weka wek = new Weka();
	ButtonGroup algos = new ButtonGroup();
	JComboBox<String> cbData;
	JTextArea textArea = new JTextArea();
	
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Principal() throws Exception {
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				String result = "";
				try {
					result = wek.log();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        textArea.setText(result);
			}
		});
		setBackground(new Color(0, 25, 37));
		
		String result = "";
		try {
			result = wek.log();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        textArea.setText(result);
		
		setTitle("League Predictor");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/xNLs83T.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setLayout(null);
		panel.setBounds(0, 0, 880, 405);
		contentPane.add(panel);
		panel.setBackground(new Color(0,25,37));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(227, 0, 646, 382);
		panel.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		textArea.setRows(5);
		textArea.setColumns(20);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 25, 37));
		panel_1.setBounds(0, 0, 228, 392);
		panel.add(panel_1);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBorder(new LineBorder(new Color(255, 215, 0)));
		btnExit.setIcon(new ImageIcon(Principal.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
		btnExit.setBounds(10, 340, 102, 41);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		panel_1.setLayout(null);
		panel_1.add(btnExit);
		
		JPanel panel_2 = new JPanel();
		panel_2.setVisible(false);
		panel_2.setBackground(new Color(0, 25, 37));
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(255, 215, 0)), "Team Prediction", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 215, 0)));
		panel_2.setBounds(10, 7, 208, 151);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JComboBox cbTeam1 = new JComboBox();
		cbTeam1.setModel(new DefaultComboBoxModel(new String[] {"<Select Team>", "'Kingzone DragonX'", "'KSV Esports'", "'Kongdoo Monster'", "MVP", "YouthCREW", "'HWA Gaming'", "'Afreeca Freecs'", "'KT Rolster'", "'SK Telecom T1'", "'ROX Tigers'", "'BBQ Olivers'", "'Fenerbahce Esports'", "'Dark Passage'", "'Jin Air Green Wings'", "'OpTic Academy'", "'Team Liquid Academy'", "'FlyQuest Academy'", "'TSM Academy'", "'CLG Academy'", "'100 Thieves Academy'", "'Golden Guardians Academy'", "'Cloud9 Academy'", "'Echo Fox Academy'", "'Clutch Gaming Academy'", "'G2 Esports'", "Misfits", "H2K", "Vitality", "'Unicorns of Love'", "'Giants Gaming'", "Roccat", "'Schalke 04'", "Fnatic", "Splyce", "'Team Liquid'", "'Team SoloMid'", "'100 Thieves'", "'OpTic Gaming'", "'Clutch Gaming'", "'Golden Guardians'", "'Echo Fox'", "FlyQuest", "'Counter Logic Gaming'", "Cloud9", "'J Team'", "'MAD Team'", "'Hong Kong Attitude'", "'AHQ e-Sports Club'", "'INTZ e-Sports Club'", "'Vivo Keyd'", "'CNB e-Sports Club'", "'KaBuM e-Sports'", "'paiN Gaming'", "'Team One e-Sports'", "'Red Canids'", "'ProGaming Esports'", "SuperMassive", "'Royal Bandits e-sports'", "Galakticos", "'Team AURORA'", "'Team WE'", "'Bilibili Gaming'", "'Vici Gaming'", "'Snake Esports'", "'EDward Gaming'", "'Funplus Phoenix'", "OMG", "'Invictus Gaming'", "'Royal Never Give Up'", "'JD Gaming'", "'LGD Gaming'", "'Rogue Warriors'", "'Topsports Gaming'", "'Suning Gaming'", "'Machi 17'", "'Flash Wolves'", "'Team Afro'", "G-Rex"}));
		cbTeam1.setBounds(10, 20, 188, 30);
		panel_2.add(cbTeam1);
		
		JComboBox cbTeam2 = new JComboBox();
		cbTeam2.setModel(new DefaultComboBoxModel(new String[] {"<Select Team>", "'Kingzone DragonX'", "'KSV Esports'", "'Kongdoo Monster'", "MVP", "YouthCREW", "'HWA Gaming'", "'Afreeca Freecs'", "'KT Rolster'", "'SK Telecom T1'", "'ROX Tigers'", "'BBQ Olivers'", "'Fenerbahce Esports'", "'Dark Passage'", "'Jin Air Green Wings'", "'OpTic Academy'", "'Team Liquid Academy'", "'FlyQuest Academy'", "'TSM Academy'", "'CLG Academy'", "'100 Thieves Academy'", "'Golden Guardians Academy'", "'Cloud9 Academy'", "'Echo Fox Academy'", "'Clutch Gaming Academy'", "'G2 Esports'", "Misfits", "H2K", "Vitality", "'Unicorns of Love'", "'Giants Gaming'", "Roccat", "'Schalke 04'", "Fnatic", "Splyce", "'Team Liquid'", "'Team SoloMid'", "'100 Thieves'", "'OpTic Gaming'", "'Clutch Gaming'", "'Golden Guardians'", "'Echo Fox'", "FlyQuest", "'Counter Logic Gaming'", "Cloud9", "'J Team'", "'MAD Team'", "'Hong Kong Attitude'", "'AHQ e-Sports Club'", "'INTZ e-Sports Club'", "'Vivo Keyd'", "'CNB e-Sports Club'", "'KaBuM e-Sports'", "'paiN Gaming'", "'Team One e-Sports'", "'Red Canids'", "'ProGaming Esports'", "SuperMassive", "'Royal Bandits e-sports'", "Galakticos", "'Team AURORA'", "'Team WE'", "'Bilibili Gaming'", "'Vici Gaming'", "'Snake Esports'", "'EDward Gaming'", "'Funplus Phoenix'", "OMG", "'Invictus Gaming'", "'Royal Never Give Up'", "'JD Gaming'", "'LGD Gaming'", "'Rogue Warriors'", "'Topsports Gaming'", "'Suning Gaming'", "'Machi 17'", "'Flash Wolves'", "'Team Afro'", "G-Rex"}));
		cbTeam2.setBounds(10, 80, 188, 30);
		panel_2.add(cbTeam2);
		
		JLabel lblNewLabel = new JLabel("VS");
		lblNewLabel.setForeground(new Color(255, 215, 0));
		lblNewLabel.setBounds(91, 51, 26, 30);
		panel_2.add(lblNewLabel);
		
		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t1 = cbTeam1.getSelectedItem().toString();
				String t2 =  cbTeam2.getSelectedItem().toString();
				try {
					String r = wek.Compare(t1, t2);
					textArea.setText(r);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnGo.setBounds(10, 121, 60, 23);
		panel_2.add(btnGo);
		
		JButton btnTeamPrediction = new JButton("Create Model");
		btnTeamPrediction.setBounds(10, 169, 208, 56);
		panel_1.add(btnTeamPrediction);
		btnTeamPrediction.setBorder(new LineBorder(new Color(255, 215, 0)));
		//btnTeamPrediction.setBounds(10, 28, 208, 56);
		btnTeamPrediction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.setVisible(true);
				String result = "";
				try {
					result = wek.log();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        textArea.setText(result);
			}
		});
		
	}
}
