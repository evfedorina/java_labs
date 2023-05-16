import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Main extends JFrame {

    private JComboBox<String> difficultyComboBox;
    private Clip menuMusicClip;
    private static Clip gameMusicClip;

    Main() {
        super("Menu");
        playMenuMusic();
        setSize(512, 512);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JPanel menuPanel = new JPanel();
        menuPanel.setBounds(0, 0, getWidth(), getHeight());
        menuPanel.setLayout(null);
        menuPanel.setBackground(new Color(0, 0, 0, 0));
        add(menuPanel);

        ImageIcon backgroundImage = new ImageIcon("giphy.gif");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        add(backgroundLabel);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(getWidth() / 2 - 150, getHeight() / 2 + 120, 300, 30);
        menuPanel.add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Завершение программы
            }
        });


        JButton gameButton = new JButton("START GAME");
        gameButton.setBounds(getWidth() / 2 - 100, getHeight() / 2 - 35, 200, 70);
        gameButton.setBackground(new Color(255, 255, 255, 100));
        gameButton.setFont(new Font("Arial", 2, 20));

        menuPanel.add(gameButton);
        gameButton.addActionListener(new ActionListener() {
            boolean visible = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                stopMenuMusic(); // Остановка музыки меню
                String difficulty = (String) difficultyComboBox.getSelectedItem();
                int dHealth;
                int dDist;
                if (difficulty.equals("Newbee")) {
                    dHealth = 1000;
                    dDist = 50;
                } else if (difficulty.equals("Normal Person")) {
                    dHealth = 500;
                    dDist = 100;
                } else {
                    dHealth = 250;
                    dDist = 150;
                }
                new Game(Main.this, dHealth, dDist);
                playGameMusic();
            }
        });

        String[] difficultyOptions = {"Newbee", "Normal Person", "Acid man"};
        difficultyComboBox = new JComboBox<>(difficultyOptions);
        difficultyComboBox.setBounds(getWidth() / 2 - 100, getHeight() / 2 + 40, 200, 30);
        difficultyComboBox.setVisible(false);
        menuPanel.add(difficultyComboBox);

        JButton selectDifficultyButton = new JButton("Select Difficulty Level");
        selectDifficultyButton.setBounds(getWidth() / 2 - 150, getHeight() / 2 + 80, 300, 30);
        menuPanel.add(selectDifficultyButton);
        selectDifficultyButton.addActionListener(new ActionListener() {
            boolean visible = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                difficultyComboBox.setVisible(!visible);
                visible = !visible;
            }
        });


        setVisible(true);
    }

    public void playMenuMusic() {
        try {
            menuMusicClip = AudioSystem.getClip();
            menuMusicClip.open(AudioSystem.getAudioInputStream(new File("MenuMusic.wav")));
            menuMusicClip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopMenuMusic() {
        if (menuMusicClip != null && menuMusicClip.isRunning()) {
            menuMusicClip.stop();
            menuMusicClip.close();
        }
    }

    public void playGameMusic() {
        try {
            Main.gameMusicClip = AudioSystem.getClip();
            Main.gameMusicClip.open(AudioSystem.getAudioInputStream(new File("GameMusic.wav")));
            Main.gameMusicClip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stopGameMusic() {
        if (Main.gameMusicClip != null && Main.gameMusicClip.isRunning()) {
            Main.gameMusicClip.stop();
            Main.gameMusicClip.close();
        }
    }


    public static void main(String[] args) {
        new Main();
    }
}
