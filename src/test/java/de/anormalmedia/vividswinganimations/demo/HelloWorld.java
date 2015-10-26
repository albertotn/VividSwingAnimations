package de.anormalmedia.vividswinganimations.demo;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import de.anormalmedia.vividswinganimations.api.Moveable;
import de.anormalmedia.vividswinganimations.bounds.LocationAnimation;
import de.anormalmedia.vividswinganimations.listener.AnimationAdapter;
import de.anormalmedia.vividswinganimations.runner.SequentialAnimationRunner;

public class HelloWorld {

    private JFrame frame;
    private MoveableButton btnTestButton;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		try {
		    HelloWorld window = new HelloWorld();
		    window.frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the application.
     */
    public HelloWorld() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 450, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);

	JPanel panel = new JPanel();
	panel.setBorder(new LineBorder(new Color(0, 0, 0)));
	panel.setBounds(10, 43, 414, 172);
	frame.getContentPane().add(panel);
	panel.setLayout(null);

	btnTestButton = new MoveableButton("Test");
	btnTestButton.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    }
	});
	btnTestButton.setBounds(10, 69, 89, 23);
	panel.add(btnTestButton);

	JButton btnRun = new JButton("Start");
	btnRun.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		animate();
	    }

	});
	btnRun.setBounds(335, 227, 89, 23);
	frame.getContentPane().add(btnRun);

	JLabel lblPressStartTo = new JLabel(
		"Press Start to see helloWorld animation");
	lblPressStartTo.setBounds(10, 10, 200, 23);
	frame.getContentPane().add(lblPressStartTo);
    }

    private class MoveableButton extends JButton implements Moveable {

	public MoveableButton(String title) {
	    super(title);
	}

	@Override
	public double getLocationX() {
	    return getX();
	}

	@Override
	public void setLocationX(double x) {
	    setLocation((int) x, getY());
	}

	@Override
	public double getLocationY() {
	    return getY();
	}

	@Override
	public void setLocationY(double y) {
	    setLocation(getX(), (int) y);
	}

    }

    private void animate() {
	SequentialAnimationRunner defaultAnimator = new SequentialAnimationRunner();
	LocationAnimation locationAnimation = new LocationAnimation(
		btnTestButton, btnTestButton.getLocationX() + 100,
		btnTestButton.getLocationY());
	locationAnimation.addAnimationListener(new AnimationAdapter() {

	    @Override
	    public void animationStarted() {
		System.out.println("Animation started");
	    }

	    @Override
	    public void animationUpdated() {
		System.out.println("Animation updated");
	    }

	    @Override
	    public void animationFinished() {
		System.out.println("Animation finished");
		if (btnTestButton.getLocationX() > 350) {
		    btnTestButton.setLocationX(0);
		}
	    }

	});

	defaultAnimator.addAnimation(locationAnimation);

	defaultAnimator.start();

    }
}
