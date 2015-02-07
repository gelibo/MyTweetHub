/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;
/**
 *
 * @author Dominic
 */

public class TwitterAppGui extends JFrame {
	public TwitterAppGui() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TwitterAppGui.class.getResource("twitter47.png")));
    	setTitle("MyTweetHub - Making Twitter Simple");
        initComponents();
        setLocationRelativeTo(null);
    }
    private static JTextField Pintxtbox;
        
    private static String tokenSecret;

    protected static int Access;
    
    protected static String Error;

	protected static int FavouriteCnt;

	protected static int FollowersCnt;

    protected static int FollowingCnt;
    
    protected static URL ProfilePic; 
    
	protected static String token;
	
	protected static int TweetCnt;
	
	protected static Twitter twitter2;
	
	protected static String Username;
	
	protected static String Name;


	public static int getAccess() {
		return Access;
	}
    public static int getFollowerCnt() {
		return FollowersCnt;
	}
    public static int getFollowersCnt() {
		return FavouriteCnt;
	}

    public static int getFollowingCnt() {
		return FollowingCnt;
	}
    public static JTextField getPintxtbox() {
		return Pintxtbox;
	}
    public static URL getProfilePic() {
		return ProfilePic;
	}
    public static int getTweetCnt() {
		return TweetCnt;
	}
    public static String getUsername() {
		return Username;
	}
    public String getName() {
		return Name;
	}
    public static AccessToken loadAccessToken(long useId){
    	return new AccessToken(token, tokenSecret);
      }
    public static void main(String args[]) throws IOException { 
    	new TwitterAppGui().login();
   			
    }
    public static void setFavouriteCnt(int favouriteCnt) {
		FavouriteCnt = favouriteCnt;
	}
    public static void setFollowersCnt(int followersCnt) {
		FollowersCnt = followersCnt;
	}
    public static void setFollowingCnt(int followingCnt) {
		FollowingCnt = followingCnt;
	}
    public static void setPintxtbox(JTextField pintxtbox) {
		Pintxtbox = pintxtbox;
	}
    public static void setProfilePic(URL string) {
		ProfilePic = string;
	}
    public static void setUsername(String username) {
		Username = username;
	}
    public void setName(String name) {
		Name = name;
	}
    public static void storeAccessToken(long useId, AccessToken accessToken){
    	token = accessToken.getToken();
    	tokenSecret = accessToken.getTokenSecret();
      }
    private static void setTweetCount(int statusesCount) {
		TweetCnt= statusesCount;
		
	}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel BackgroundLbl;

	private JButton LoginBtn;

	private JLabel PinLbl;

	/**
     * Creates new form TwitterAppGui
     */
	AccessToken accessToken;

	public JLabel getPinLbl() {
		return PinLbl;
	}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
 
    public void initComponents() {
    	   try  
    	   {    
    	     BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;     
    	   }   
    	   catch ( Exception e )   
    	   {    
    		   
    	   } 
        PinLbl = new JLabel();
        LoginBtn = new JButton();
        LoginBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Pintxtbox = new JTextField();
        BackgroundLbl = new JLabel();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMinimumSize(new java.awt.Dimension(330, 450));
        setResizable(false);
        getContentPane().setLayout(null);
        PinLbl.setForeground(new java.awt.Color(255, 255, 255));
        PinLbl.setText("Enter PIN:");
        getContentPane().add(PinLbl);
        PinLbl.setBounds(140, 270, 70, 14);

        LoginBtn.setText("Login");
        LoginBtn.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.normal));
        LoginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });
        getContentPane().add(LoginBtn);
        LoginBtn.setBounds(120, 340, 90, 20);
        getContentPane().add(Pintxtbox);
        Pintxtbox.setBounds(110, 300, 110, 20);
        
        BackgroundLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Twitte2r.png"))); 
        BackgroundLbl.setText("");
        getContentPane().add(BackgroundLbl);
        BackgroundLbl.setBounds(0, 0, 330, 420);

        pack();
    }

	public void setPinLbl(JLabel pinLbl) {
		PinLbl = pinLbl;
	}

	private TwitterFactory login() throws IOException { {
    	/* Credentials */
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("ESoHneDi1gq2mN2FFXtjxxqOu")
                .setOAuthConsumerSecret("6do1ZnVHmlXk8YDiyVHhYN3mXt5asTU73XYvkW20rCplZfloCD");
          
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TwitterAppGui().setVisible(true);
            }
        });
        
        try {
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();
             
            try {
                System.out.println("-----");
 
                // get request token.
                // this will throw IllegalStateException if access token is already available
                // this is oob, desktop client version
                RequestToken requestToken = twitter.getOAuthRequestToken();
 
                System.out.println("Got request token.");
                System.out.println("Request token: " + requestToken.getToken());
                System.out.println("Request token secret: " + requestToken.getTokenSecret());
                System.out.println("|-----");
 
                AccessToken accessToken = null;

                /* Opens up the URL in default browser set be user */
                try 
                {
                    Desktop.getDesktop().browse(new URL(requestToken.getAuthorizationURL()).toURI());
                }           
                catch (Exception e) {}
                
                while (null == accessToken) {
                	
                    //System.out.print("Enter the PIN(if available) and hit enter after you granted access.[PIN]:");                    
                    //String pin = br.readLine();
                    String pin;
                    pin = getPintxtbox().getText();
                    
                    try {
                        if (pin.length() > 0) {
                            accessToken = twitter.getOAuthAccessToken(requestToken, pin);
                        } else {
                            accessToken = twitter.getOAuthAccessToken(requestToken);
                        }
                    } catch (TwitterException te) {
                        if (401 == te.getStatusCode()) {
                           // System.out.println("Unable to get the access token.");
                        } else {
                            te.printStackTrace();
                        }
                    }
                }
                storeAccessToken(twitter.verifyCredentials().getId(), accessToken);
                System.out.println("|-----");
                System.out.println("Got access token.");
                System.out.println("Access token: " + accessToken.getToken());
                System.out.println("Access token secret: " + accessToken.getTokenSecret());
                System.out.println("|-----");
                
                 
            } catch (IllegalStateException ie) {
                // access token is already available, or consumer key/secret is not set.
                if (!twitter.getAuthorization().isEnabled()) {
                    System.out.println("OAuth consumer key/secret is not set.");
                    System.exit(-1);
                }
            }
            setTwitter2(twitter);
            User user = twitter.showUser(twitter.getId());
            setUsername(twitter.getScreenName());
            setFavouriteCnt(user.getFavouritesCount());
            setFollowersCnt(user.getFollowersCount());
            setFollowingCnt(user.getFriendsCount());
            setProfilePic(new URL(user.getProfileImageURL()));
            setTweetCount(user.getStatusesCount());
            setName(user.getName());
            setAccess(1);
            System.out.println(user.getMiniProfileImageURL());
            
   
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
        }
        
    }
	return null;
    }
	
	private static Twitter getTwitter2() {
		return twitter2;
	}
	private static void setTwitter2(Twitter twitter2) {
		TwitterAppGui.twitter2 = twitter2;
	}

	private void LoginBtnActionPerformed(ActionEvent evt) {
    	if (Access == 0){
    		System.out.println(Error);
    	}
    	else if (Access == 1) {
	    	this.dispose();
	    	new Application().setVisible(true);
    	}

    }

	private void setAccess(int i) {
		Access = i;
		
	}
	
	
}
