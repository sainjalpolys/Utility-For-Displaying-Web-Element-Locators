package mypackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ultimate {

	private JFrame frame;
	private JTextField tf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ultimate window = new ultimate();
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
	public ultimate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 204, 153));
		frame.setBounds(100, 100, 590, 392);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("URL");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 26));
		lblNewLabel.setBounds(31, 79, 70, 43);
		frame.getContentPane().add(lblNewLabel);
		
		tf = new JTextField();
		tf.setFont(new Font("Calibri", Font.PLAIN, 26));
		tf.setText("http://");
		tf.setBounds(111, 81, 431, 39);
		frame.getContentPane().add(tf);
		tf.setColumns(10);
		
		JButton btnNewButton = new JButton("Chrome");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
	                WebDriver driver;
	                  // Launch ChromeDriver
	                  driver = new ChromeDriver();
	                  
	                   // fetches & parses HTML        
	                   String url = tf.getText();
	                   Document document = null;
	                    try {
	                        document = Jsoup.connect(url).get();
	                    } catch (IOException e1) {
	                        // TODO Auto-generated catch block
	                        e1.printStackTrace();
	                    } 
	                   
	                   driver.get(tf.getText());
	                   
	                   
	                   
	            
	                   
	                   
	                   

	                    DesiredCapabilities dc = new DesiredCapabilities();
	                    dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
	                    
	               
	                 
	                 

	                
	                
	                   
	                      
	                    JavascriptExecutor jse = ((JavascriptExecutor)driver);
	                String sc = null;
	                jse.executeScript("document.getElementsByTagName('body')[0].addEventListener('click', function(event){console.log(event.target);var y=window.prompt('Enter Locator (name , class , id , xpath , tagname , css )'); if(y.localeCompare('id')==0 ||y.localeCompare('class')==0||y.localeCompare('name')==0) {window.alert(event.target.getAttribute(y));}else if (y.localeCompare('xpath')==0){if (event.target && event.target.id) {\r\n" + 
	    	        		" var pathnew=event.target.nodeName.toLowerCase() + '[@id=\"' + event.target.id + '\"]';\r\n" + 
	    	        		"		} else if(event.target && event.target.getAttribute('name')){\r\n" +  
	    	        		"		var pathnew=event.target.nodeName.toLowerCase() + '[@name=\"' + event.target.getAttribute('name') + '\"]';\r\n" + 
	    	        		"		}else if(event.target && event.target.getAttribute('type')){\r\n" + 
	    	        		"		var pathnew=event.target.nodeName.toLowerCase() + '[@type=\"' + event.target.getAttribute('type') + '\"]';\r\n" + 
	    	        		"		}else if(event.target && event.target.getAttribute('href')){\r\n" + 
	    	        		"		var pathnew=event.target.nodeName.toLowerCase() + '[@href=\"' + event.target.getAttribute('href') + '\"]';\r\n" + 
	    	        		"		}else if(event.target && event.target.getAttribute('src')){\r\n" + 
	    	        		"		var pathnew=event.target.nodeName.toLowerCase() + '[@src=\"' + event.target.getAttribute('src') + '\"]';\r\n" + 
	    	        		"		} else{var pathnew=event.target.nodeName.toLowerCase()} alert(pathnew); } else if(y.localeCompare('css')==0) {if(event.target && event.target.getAttribute('class') &&event.target.getAttribute('name') && event.target.getAttribute('type')){\r\n" + 
	    	        		"       var cspath=event.target.nodeName.toLowerCase()+event.target.getAttribute('class') + '[name=\"' + event.target.getAttribute('name') + '\"]'+ '[type=\"' + event.target.getAttribute('type') + '\"]';\r\n" + 
	    	        		"		}else if(event.target && event.target.getAttribute('class') &&event.target.getAttribute('name') ){\r\n" + 
	    	        		"		var cspath=event.target.nodeName.toLowerCase()+event.target.getAttribute('class') + '[name=\"' + event.target.getAttribute('name') + '\"]';\r\n" + 
	    	        		"		} else if (event.target && event.target.id) {\r\n" + 
	    	        		"		var cspath=event.target.nodeName.toLowerCase() + '#' + event.target.id ;\r\n" + 
	    	        		"		}else if(event.target && event.target.getAttribute('class')){\r\n" + 
	    	        		"		var cspath=event.target.nodeName.toLowerCase() + '.' + event.target.getAttribute('class') ;\r\n" + 
	    	        		"		}else if(event.target && event.target.getAttribute('name')){\r\n" + 
	    	        		"		var cspath=event.target.nodeName.toLowerCase() + '.' + event.target.getAttribute('name') ;\r\n" + 
	    	        		"		} else {var cspath=event.target.nodeName.toLowerCase()}  alert(cspath); } else if(y.localeCompare('tagname')==0) {var tagname=event.target.nodeName.toLowerCase(); alert(tagname);} else {alert('Sorry Invalid Locator!');}event.preventDefault();event.stopPropagation();});"); 
	        
             
	                
	                
	                
	                  WebDriverWait wait = new WebDriverWait(driver, 1000);
	                  wait.until(ExpectedConditions.alertIsPresent());
	                 try
	                  {
	                  Alert alert = driver.switchTo().alert();
	                
	                   sc= alert.getText();
	                 
	                  }
	                   
	                 
	                    catch(NoAlertPresentException noe) {
	                
	                        System.out.println("NO ALERT FOUND ");
	                    }
	              
	                   
	                        

	                   
	                   
	                   
	                   
	                   
	                   
	                   
	                
	                   
	                   
	                   
	                   
	                   
	                   

















	
	        
	 
				
				
				
				
				
			}
		});
		btnNewButton.setBackground(new Color(204, 102, 102));
		btnNewButton.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 26));
		btnNewButton.setBounds(115, 195, 145, 63);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Firefox");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				 System.setProperty("webdriver.gecko.driver", "C:/geckodriver15/geckodriver.exe");
	                WebDriver driver;
	                  // Launch ChromeDriver
	                  driver = new FirefoxDriver();
	                  
	                   // fetches & parses HTML        
	                   String url = tf.getText();
	                   Document document = null;
	                    try {
	                        document = Jsoup.connect(url).get();
	                    } catch (IOException e1) {
	                        // TODO Auto-generated catch block
	                        e1.printStackTrace();
	                    } 
	                   
	                   driver.get(tf.getText());
	                   
	                   
	                   
	                
	                   
	                   
	                   
	                   
	                   

	                    DesiredCapabilities dc = new DesiredCapabilities();
	                    dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
	                    
	               
	                 
	                 

	                
	                
	                   
	                      
	                    JavascriptExecutor jse = ((JavascriptExecutor)driver);
	                String sc = null;
	                jse.executeScript("document.getElementsByTagName('body')[0].addEventListener('click', function(event){console.log(event.target);var y=window.prompt('Enter Locator (name , class , id , xpath , tagname , css )'); if(y.localeCompare('id')==0 ||y.localeCompare('class')==0||y.localeCompare('name')==0) {window.alert(event.target.getAttribute(y));}else if (y.localeCompare('xpath')==0){if (event.target && event.target.id) {\r\n" + 
	    	        		" var pathnew=event.target.nodeName.toLowerCase() + '[@id=\"' + event.target.id + '\"]';\r\n" + 
	    	        		"		} else if(event.target && event.target.getAttribute('name')){\r\n" +  
	    	        		"		var pathnew=event.target.nodeName.toLowerCase() + '[@name=\"' + event.target.getAttribute('name') + '\"]';\r\n" + 
	    	        		"		}else if(event.target && event.target.getAttribute('type')){\r\n" + 
	    	        		"		var pathnew=event.target.nodeName.toLowerCase() + '[@type=\"' + event.target.getAttribute('type') + '\"]';\r\n" + 
	    	        		"		}else if(event.target && event.target.getAttribute('href')){\r\n" + 
	    	        		"		var pathnew=event.target.nodeName.toLowerCase() + '[@href=\"' + event.target.getAttribute('href') + '\"]';\r\n" + 
	    	        		"		}else if(event.target && event.target.getAttribute('src')){\r\n" + 
	    	        		"		var pathnew=event.target.nodeName.toLowerCase() + '[@src=\"' + event.target.getAttribute('src') + '\"]';\r\n" + 
	    	        		"		} else{var pathnew=event.target.nodeName.toLowerCase()} alert(pathnew); } else if(y.localeCompare('css')==0) {if(event.target && event.target.getAttribute('class') &&event.target.getAttribute('name') && event.target.getAttribute('type')){\r\n" + 
	    	        		"       var cspath=event.target.nodeName.toLowerCase()+event.target.getAttribute('class') + '[name=\"' + event.target.getAttribute('name') + '\"]'+ '[type=\"' + event.target.getAttribute('type') + '\"]';\r\n" + 
	    	        		"		}else if(event.target && event.target.getAttribute('class') &&event.target.getAttribute('name') ){\r\n" + 
	    	        		"		var cspath=event.target.nodeName.toLowerCase()+event.target.getAttribute('class') + '[name=\"' + event.target.getAttribute('name') + '\"]';\r\n" + 
	    	        		"		} else if (event.target && event.target.id) {\r\n" + 
	    	        		"		var cspath=event.target.nodeName.toLowerCase() + '#' + event.target.id ;\r\n" + 
	    	        		"		}else if(event.target && event.target.getAttribute('class')){\r\n" + 
	    	        		"		var cspath=event.target.nodeName.toLowerCase() + '.' + event.target.getAttribute('class') ;\r\n" + 
	    	        		"		}else if(event.target && event.target.getAttribute('name')){\r\n" + 
	    	        		"		var cspath=event.target.nodeName.toLowerCase() + '.' + event.target.getAttribute('name') ;\r\n" + 
	    	        		"		} else {var cspath=event.target.nodeName.toLowerCase()}  alert(cspath); } else if(y.localeCompare('tagname')==0) {var tagname=event.target.nodeName.toLowerCase(); alert(tagname);} else {alert('Sorry Invalid Locator!');}event.preventDefault();event.stopPropagation();});"); 
	        
             
	                
	                
	                
	                  WebDriverWait wait = new WebDriverWait(driver, 1000);
	                  wait.until(ExpectedConditions.alertIsPresent());
	                 try
	                  {
	                  Alert alert = driver.switchTo().alert();
	                
	                   sc= alert.getText();
	                 
	                  }
	                   
	                 
	                    catch(NoAlertPresentException noe) {
	                
	                        System.out.println("NO ALERT FOUND ");
	                    }
				
			
				
				
				
			}
		});
		btnNewButton_1.setBackground(new Color(153, 153, 153));
		btnNewButton_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 26));
		btnNewButton_1.setBounds(361, 195, 130, 63);
		frame.getContentPane().add(btnNewButton_1);
	}
}