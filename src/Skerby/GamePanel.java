package Skerby;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {

	/*
	 * for loop game.
	 */
	private Timer time;

	/*
	 * import image background.
	 */ // new ImageIcon(this.getClass().getResource("/Image/roll1.png"));
	// private Image background = new
	// ImageIcon("src/Skerby/Images/Background/bglevel1.png").getImage();
	private Image background = (new ImageIcon(this.getClass().getResource("/Images/Background/bglevel1.png")))
			.getImage();

	private Player player;
	private Camera camera;
	private CoinsManager cm;
	private EnemyManager em;
	private GameStateManager gsm;
	// add
	private FireballManager fbm;
	private ItemsManager im;
	private ScoreManager sm;

	// private BlockManager bm;

	public GamePanel() {
		setFocusable(true);
		player = new Player(100);
		camera = new Camera(0, 0);
		cm = new CoinsManager();
		// bm = new BlockManager();
		// add
		fbm = new FireballManager();
		im = new ItemsManager();

		em = new EnemyManager(); // oneRound
		gsm = new GameStateManager();
		addKeyListener(new KeyInput(player));
		time = new Timer(10, this);
		time.start();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(camera.getX(), camera.getY()); // start camera

		// add
		for (int i = 0; i <= 11800; i += 5900) {
			g2d.drawImage(background, i, -30, null);
		}

		gsm.render(g2d);
		player.render(g2d);

		cm.render(g2d);
		em.render(g2d);
		// bm.render(g2d);
		// add
		fbm.render(g2d);
		im.render(g2d);

		g2d.translate(-camera.getX(), -camera.getY()); // end camera
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Fluo_Gums", Font.BOLD, 20));
		g2d.drawString("Score : " + player.getScore(), 510, 30);
		g2d.drawString(EnterYourName.yourName, 0, 50);
		g2d.drawRect(0, 0, 500, 32);
		g2d.setColor(Color.decode("#404040"));
		g2d.fillRect(0, 0, 500, 32);
		g2d.setColor(Color.PINK);
		g2d.fillRect(0, 0, player.getPlayerHP() * 5, 32);

		if (player.getPlayerHP() <= 0 || ((player.getX() >= 17518 && player.getX() <= 17535)
				&& (player.getY() >= 328 && player.getY() <= 346))) {
			// fixbug
			ScoreManager.recordScore();
			Player.score = 0;
		
			for (int i = 0; i < cm.coinsList.size();) {
				cm.coinsList.remove(i);
			}
			for (int i = 0; i < em.enemyList.size();) {
				em.enemyList.remove(i);
			}
			// add
			for (int i = 0; i < im.itemsList.size();) {
				im.itemsList.remove(i);
			}
			time.stop();
			g2d.setColor(Color.RED);
			g2d.setFont(new Font("Angsana New", Font.BOLD, 64));
			g2d.drawString("GAME OVER", 180, 240);
			Game.dieP = new DiePanel();
			Game.dieP.setVisible(true);
			Game.window.dispose();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();
		camera.update(player);
		em.update();
		fbm.update();

		repaint();
	}

}
