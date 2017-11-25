package Skerby;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener{
	
	/*
	 * for loop game.
	 */
	private Timer time;
	
	/*
	 * import image background.
	 */
	private Image background = new ImageIcon("Images/Background/bglevel1.png").getImage();
	private Player player;
	private Camera camera;
	private CoinsManager cm;
	private EnemyManager em;
	private GameStateManager gsm;
	
//	private BlockManager bm;
	
	public GamePanel(){
		setFocusable(true);
		player = new Player();
		camera = new Camera(0, 0);
		cm = new CoinsManager();
//		bm = new BlockManager();
		em = new EnemyManager();
		gsm = new GameStateManager();
		addKeyListener(new KeyInput(player));
		time = new Timer(10, this);
		time.start();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(camera.getX(), camera.getY()); //start camera
		
		g2d.drawImage(background, 0, -30, null);
                gsm.render(g2d);
		player.render(g2d);
		em.render(g2d);
		cm.render(g2d);
//		bm.render(g2d);
		
		g2d.translate(-camera.getX(), -camera.getY()); //end camera
		
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Fluo_Gums", Font.BOLD, 20));
		g2d.drawString("Score : " + player.getScore(), 510, 30);
                
		g2d.drawString(EnterYourName.yourName, 0, 50);
		g2d.drawRect(0, 0, 500, 32);
		g2d.setColor(Color.decode("#404040"));
		g2d.fillRect(0, 0, 500, 32);
		g2d.setColor(Color.PINK);
		g2d.fillRect(0, 0, player.getPlayerHP()*5, 32);
                
                
		if (player.getPlayerHP() == 0){
			time.stop();
			g2d.setColor(Color.RED);
			g2d.setFont(new Font("Angsana New", Font.BOLD, 64));
			g2d.drawString("GAME OVER", 180, 240);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();
		camera.update(player);
//		em.update();
		repaint();
	}

}
